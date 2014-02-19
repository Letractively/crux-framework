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
package br.com.sysmap.crux.gwt.rebind;

import br.com.sysmap.crux.core.client.utils.EscapeUtils;
import br.com.sysmap.crux.core.rebind.screen.widget.AttributeProcessor;
import br.com.sysmap.crux.core.rebind.screen.widget.ViewFactoryCreator.SourcePrinter;
import br.com.sysmap.crux.core.rebind.screen.widget.WidgetCreator;
import br.com.sysmap.crux.core.rebind.screen.widget.WidgetCreatorContext;
import br.com.sysmap.crux.core.rebind.screen.widget.declarative.DeclarativeFactory;
import br.com.sysmap.crux.core.rebind.screen.widget.declarative.TagAttribute;
import br.com.sysmap.crux.core.rebind.screen.widget.declarative.TagAttributeDeclaration;
import br.com.sysmap.crux.core.rebind.screen.widget.declarative.TagAttributes;
import br.com.sysmap.crux.core.rebind.screen.widget.declarative.TagAttributesDeclaration;

import com.google.gwt.user.client.ui.NamedFrame;


/**
 * Represents a NamedFrameFactory DeclarativeFactory
 * @author Thiago Bustamante
 *
 */
@DeclarativeFactory(id="namedFrame", library="gwt", targetWidget=NamedFrame.class)
@TagAttributesDeclaration({
	@TagAttributeDeclaration(value="name", required=true)
})	
@TagAttributes({
	@TagAttribute(value="url", processor=NamedFrameFactory.URLAttributeParser.class)
})
public class NamedFrameFactory extends WidgetCreator<WidgetCreatorContext>
{
	@Override
	public void instantiateWidget(SourcePrinter out, WidgetCreatorContext context)
	{
		String className = NamedFrame.class.getCanonicalName();
		out.println(className + " " + context.getWidget()+" = new "+className+"("+EscapeUtils.quote(context.readWidgetProperty("name"))+");");
	}	
	
	/**
	 * @author Thiago da Rosa de Bustamante
	 *
	 */
	public static class URLAttributeParser extends AttributeProcessor<WidgetCreatorContext>
	{

		public URLAttributeParser(WidgetCreator<?> widgetCreator)
        {
	        super(widgetCreator);
        }

		@Override
        public void processAttribute(SourcePrinter out, WidgetCreatorContext context, String attributeValue)
        {
			String widget = context.getWidget();
			out.println(widget+".setUrl(Screen.appendDebugParameters("+EscapeUtils.quote(attributeValue)+"));");
        }
	}
	
	@Override
    public WidgetCreatorContext instantiateContext()
    {
	    return new WidgetCreatorContext();
    }
}