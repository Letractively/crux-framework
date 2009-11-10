/*
 * Copyright 2009 Sysmap Solutions Software e Consultoria Ltda.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.sysmap.crux.tools.htmltags;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.TransformerFactoryImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

import br.com.sysmap.crux.core.client.declarative.DeclarativeFactory;
import br.com.sysmap.crux.core.client.declarative.TagChild;
import br.com.sysmap.crux.core.client.declarative.TagChildAttributes;
import br.com.sysmap.crux.core.client.declarative.TagChildren;
import br.com.sysmap.crux.core.client.screen.InterfaceConfigException;
import br.com.sysmap.crux.core.client.screen.WidgetFactory;
import br.com.sysmap.crux.core.client.screen.WidgetFactory.WidgetFactoryContext;
import br.com.sysmap.crux.core.client.screen.children.WidgetChildProcessor;
import br.com.sysmap.crux.core.client.screen.children.WidgetChildProcessorContext;
import br.com.sysmap.crux.core.i18n.MessagesFactory;
import br.com.sysmap.crux.core.rebind.screen.config.WidgetConfig;
import br.com.sysmap.crux.core.server.Environment;
import br.com.sysmap.crux.tools.htmltags.template.TemplatesPreProcessor;
import br.com.sysmap.crux.tools.htmltags.util.StreamUtils;

/**
 * Generates HTML output based on Crux widget tags
 * @author Gess� Daf� <code>gessedafe@gmail.com</code>
 */
public class CruxToHtmlTransformer
{
	// Makes it easier to read the output files
	private static boolean forceIndent = false;
	private static String outputCharset = "ISO-8859-1";

	private static final Log log = LogFactory.getLog(CruxToHtmlTransformer.class);
	private static HTMLTagsMessages messages = (HTMLTagsMessages)MessagesFactory.getMessages(HTMLTagsMessages.class);
	private static Transformer transformer = null;
	private static DocumentBuilder documentBuilder = null;

	private static List<CruxXmlPreProcessor> preProcessors;
	private static final Lock lock = new ReentrantLock();


	/**
	 * Executes the transformation
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 * @throws InterfaceConfigException 
	 */
	public static void generateHTML(String filePath, OutputStream out) throws InterfaceConfigException
	{
		init();
		
		try
		{
			ByteArrayOutputStream buff = new ByteArrayOutputStream();
			Document source = loadCruxPage(filePath);
			transformer.transform(new DOMSource(source), new StreamResult(buff));
			String result = new String(buff.toByteArray(), "UTF-8");
			result = handleHtmlDocument(source, result);
			StreamUtils.write(new ByteArrayInputStream(result.getBytes()), out, false);
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Makes it easier to read the output files
	 * @param force
	 */
	public static void setForceIndent(boolean force)
	{
		forceIndent = force;
	}

	/**
	 * @param outputCharset
	 */
	public static void setOutputCharset(String charset)
	{
		outputCharset = charset;
	}	

	/**
	 * Initializes the static resources
	 */
	private static void init()
	{
		if (transformer == null)
		{
			lock.lock();

			if (transformer == null)
			{
				try
				{
					TransformerFactory tfactory = new TransformerFactoryImpl();
					InputStream is = generateHtmlTagsXSLT();
					transformer = tfactory.newTransformer(new StreamSource(is));
					DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
					builderFactory.setNamespaceAware(true);
					builderFactory.setIgnoringComments(true);
					
					documentBuilder = builderFactory.newDocumentBuilder();
					initializePreProcessors();
				}
				catch (Throwable e)
				{
					log.error(messages.transformerErrorCreatingTransformer(e.getMessage()), e);
				}
				finally
				{
					lock.unlock();
				}
			}
		}
	}

	/**
	 * 
	 */
	private static void initializePreProcessors()
	{
		preProcessors = new ArrayList<CruxXmlPreProcessor>();
		preProcessors.add(new TemplatesPreProcessor());
	}

	/**
	 * If source contains DOCTYPE declaration, inserts it in the result.
	 * Removes the XMLNS declaration from the root tag
	 * @param result
	 * @param result2 
	 */
	private static String handleHtmlDocument(Document source, String result)
	{
		DocumentType doctype = source.getDoctype();
		
		if (doctype != null)
		{
			result = "<!DOCTYPE " + doctype.getName() + ">\n" + result;
		}
		
		int htmlTagBegin = result.toUpperCase().indexOf("<HTML");

		if(htmlTagBegin >= 0)
		{
			int htmlTagEnd = result.indexOf(">", htmlTagBegin);
			result = result.substring(0, htmlTagBegin) + "<html>" + result.substring(htmlTagEnd + 1);
		}
		
		return result;
	}

	/**
	 * Generate the XSLT file based on template crux-ui.template.xslt, importing all files with extension .crux.xslt.
	 * @return
	 */
	private static InputStream generateHtmlTagsXSLT()
	{
		InputStream templateIs = CruxToHtmlTransformer.class.getResourceAsStream("/META-INF/crux-ui.template.xslt");
		if (templateIs == null)
		{
			throw new HTMLTagsTransformerException(messages.transformerTemplateNotFound());
		}
		try
		{
			String template = StreamUtils.readAsUTF8(templateIs);
			String allWidgets = generateWidgetsList();
			String referencedWidgets = generateReferenceWidgetsList();
			template = template.replace("${allWidgets}", allWidgets);
			template = template.replace("${referencedWidgets}", referencedWidgets);
			template = template.replace("${indent}", mustIndent() ? "yes" : "no");
			template = template.replace("${charset}", outputCharset);
			
			if (log.isDebugEnabled())
			{
				log.debug("Generated XSLT:\n" +template);
			}

			return new ByteArrayInputStream(template.getBytes("UTF-8"));
		}
		catch (IOException e)
		{
			throw new HTMLTagsTransformerException(messages.transformerErrorReadingTemplate(e.getMessage()),e);
		}
	}

	/**
	 * 
	 * @return
	 */
	private static String generateReferenceWidgetsList()
	{
		StringBuilder widgetList = new StringBuilder();
		Set<String> registeredLibraries = WidgetConfig.getRegisteredLibraries();
		for (String library : registeredLibraries)
		{
			Set<String> factories = WidgetConfig.getRegisteredLibraryFactories(library);
			for (String widget : factories)
			{
				Class<?> clientClass = WidgetConfig.getClientClass(library, widget);
				try
				{
					Method method = clientClass.getMethod("processChildren", new Class[]{WidgetFactoryContext.class});
					generateReferenceWidgetsListFromTagChildren(widgetList, method.getAnnotation(TagChildren.class), 
																		library, widget, new HashSet<Class<?>>());
				}
				catch (NoSuchMethodException e)
				{
					log.error(messages.transformerErrorGeneratingWidgetsReferenceList(), e);
				}
			}
		}
		
		return widgetList.toString();
	}

	/**
	 * 
	 * @param widgetList 
	 * @param tagChildren
	 * @param parentLibrary
	 */
	private static void generateReferenceWidgetsListFromTagChildren(StringBuilder widgetList, TagChildren tagChildren, 
																    String parentLibrary, String parentWidget, Set<Class<?>> added)
	{
		if (tagChildren != null)
		{
			for (TagChild child : tagChildren.value())
			{
				Class<? extends WidgetChildProcessor<?>> processorClass = child.value();
				if (!added.contains(processorClass))
				{
					added.add(processorClass);
					TagChildAttributes childAttributes = processorClass.getAnnotation(TagChildAttributes.class);
					if (childAttributes!= null)
					{
						if (WidgetFactory.class.isAssignableFrom(childAttributes.type()))
						{
							DeclarativeFactory declarativeFactory = childAttributes.type().getAnnotation(DeclarativeFactory.class);
							if (declarativeFactory != null)
							{
								widgetList.append(","+parentLibrary+"_"+parentWidget+"_"+childAttributes.tagName()+",|"+
													  declarativeFactory.library()+"_"+declarativeFactory.id()+"|");
							}
						}
					}
					
					try
					{
						Method method = processorClass.getMethod("processChildren", new Class[]{WidgetChildProcessorContext.class});
						generateReferenceWidgetsListFromTagChildren(widgetList, method.getAnnotation(TagChildren.class), 
																	parentLibrary, parentWidget, added);
					}
					catch (Exception e)
					{
						log.error(messages.transformerErrorGeneratingWidgetsList(), e);
					}
				}
			}
		}				
	}
	
	/**
	 * 
	 */
	private static String generateWidgetsList() throws IOException
	{
		StringBuilder widgetList = new StringBuilder(",");
		Set<String> registeredLibraries = WidgetConfig.getRegisteredLibraries();
		for (String library : registeredLibraries)
		{
			Set<String> factories = WidgetConfig.getRegisteredLibraryFactories(library);
			for (String widget : factories)
			{
				widgetList.append(library+"_"+widget+",");				
			}
		}
		
		return widgetList.toString();
	}

	/**
	 * @return
	 */
	private static boolean mustIndent()
	{
		return !Environment.isProduction() || forceIndent;
	}

	/**
	 * Loads Crux page
	 * @param fileName
	 * @return
	 * @throws InterfaceConfigException
	 */
	private static Document loadCruxPage(String filePath) throws InterfaceConfigException
	{
		try
		{
			Document document = documentBuilder.parse(new File(filePath));
			return preprocess(document);
		}
		catch (Exception e)
		{
			throw new InterfaceConfigException(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * @param doc
	 * @return
	 */
	private static Document preprocess(Document doc)
	{
		for (CruxXmlPreProcessor preProcessor : preProcessors)
		{
			doc = preProcessor.preprocess(doc);
		}
		
		return doc;
	}
}