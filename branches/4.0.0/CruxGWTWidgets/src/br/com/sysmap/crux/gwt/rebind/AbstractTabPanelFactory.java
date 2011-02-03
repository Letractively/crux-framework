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

import org.json.JSONObject;

import br.com.sysmap.crux.core.client.utils.EscapeUtils;
import br.com.sysmap.crux.core.client.utils.StringUtils;
import br.com.sysmap.crux.core.rebind.CruxGeneratorException;
import br.com.sysmap.crux.core.rebind.widget.AttributeProcessor;
import br.com.sysmap.crux.core.rebind.widget.ViewFactoryCreator.SourcePrinter;
import br.com.sysmap.crux.core.rebind.widget.WidgetCreatorContext;
import br.com.sysmap.crux.core.rebind.widget.creator.HasAnimationFactory;
import br.com.sysmap.crux.core.rebind.widget.creator.HasBeforeSelectionHandlersFactory;
import br.com.sysmap.crux.core.rebind.widget.creator.HasSelectionHandlersFactory;
import br.com.sysmap.crux.core.rebind.widget.creator.children.WidgetChildProcessor;
import br.com.sysmap.crux.core.rebind.widget.creator.children.WidgetChildProcessor.AnyWidget;
import br.com.sysmap.crux.core.rebind.widget.creator.children.WidgetChildProcessor.HTMLTag;
import br.com.sysmap.crux.core.rebind.widget.creator.event.ClickEvtBind;
import br.com.sysmap.crux.core.rebind.widget.creator.event.KeyDownEvtBind;
import br.com.sysmap.crux.core.rebind.widget.creator.event.KeyPressEvtBind;
import br.com.sysmap.crux.core.rebind.widget.creator.event.KeyUpEvtBind;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagAttribute;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagAttributeDeclaration;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagAttributes;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagAttributesDeclaration;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagChildAttributes;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagEventDeclaration;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagEventsDeclaration;

import com.google.gwt.user.client.ui.TabBar.Tab;

class TabPanelContext extends WidgetCreatorContext
{

	public JSONObject tabElement;
	public String title;
	public boolean isHTMLTitle;
	public String titleWidget;
	
	public void clearAttributes()
    {
	    isHTMLTitle = false;
	    title = null;
	    titleWidget = null;
	    tabElement = null;
    }
	
}

/**
 * Factory for TabPanel widgets
 * @author Thiago da Rosa de Bustamante
 */
@TagAttributes({
	@TagAttribute(value="visibleTab", type=Integer.class, processor=AbstractTabPanelFactory.VisibleTabAttributeParser.class)
})
public abstract class AbstractTabPanelFactory extends CompositeFactory<TabPanelContext> 
       implements HasAnimationFactory<TabPanelContext>, 
                  HasBeforeSelectionHandlersFactory<TabPanelContext>, HasSelectionHandlersFactory<TabPanelContext>
{
	/**
	 * @author Thiago da Rosa de Bustamante
	 *
	 */
	public static class VisibleTabAttributeParser extends AttributeProcessor<TabPanelContext>
	{
		public void processAttribute(SourcePrinter out, TabPanelContext context, final String propertyValue)
        {
			String widget = context.getWidget();
			printlnPostProcessing(widget+".selectTab("+Integer.parseInt(propertyValue)+");");
        }
	}	

	@TagChildAttributes(minOccurs="0", maxOccurs="unbounded", tagName="tab" )
	@TagAttributesDeclaration({
		@TagAttributeDeclaration(value="tabEnabled", type=Boolean.class, defaultValue="true"),
		@TagAttributeDeclaration(value="tabWordWrap", type=Boolean.class, defaultValue="true")
	})
	@TagEventsDeclaration({
		@TagEventDeclaration("onClick"),
		@TagEventDeclaration("onKeyUp"),
		@TagEventDeclaration("onKeyDown"),
		@TagEventDeclaration("onKeyPress")
	})
	public static abstract class AbstractTabProcessor extends WidgetChildProcessor<TabPanelContext> 
	{
		@Override
		public void processChildren(SourcePrinter out, TabPanelContext context) throws CruxGeneratorException
		{
			context.tabElement = context.getChildElement();
		}
	}

	@TagChildAttributes(tagName="tabText", type=String.class)
	public static abstract class AbstractTextTabProcessor extends WidgetChildProcessor<TabPanelContext>
	{
		@Override
		public void processChildren(SourcePrinter out, TabPanelContext context) throws CruxGeneratorException 
		{
			context.title = getWidgetCreator().getDeclaredMessage(ensureTextChild(context.getChildElement(), true));
			context.isHTMLTitle = false;
		}
	}
	
	@TagChildAttributes(tagName="tabHtml", type=HTMLTag.class)
	public static abstract class AbstractHTMLTabProcessor extends WidgetChildProcessor<TabPanelContext>
	{
		@Override
		public void processChildren(SourcePrinter out, TabPanelContext context) throws CruxGeneratorException 
		{
			context.title = ensureHtmlChild(context.getChildElement(), true);
			context.isHTMLTitle = true;
		}
	}
	
	@TagChildAttributes(type=AnyWidget.class)
	public static abstract class AbstractWidgetTitleProcessor extends WidgetChildProcessor<TabPanelContext> 
	{
		@Override
		public void processChildren(SourcePrinter out, TabPanelContext context) throws CruxGeneratorException
		{
			context.titleWidget = getWidgetCreator().createChildWidget(out, context.getChildElement());
		}
	}
	
	@TagChildAttributes(type=AnyWidget.class)
	public static abstract class AbstractWidgetContentProcessor extends WidgetChildProcessor<TabPanelContext> 
	{
		@Override
		public void processChildren(SourcePrinter out, TabPanelContext context) throws CruxGeneratorException
		{
			String widget = getWidgetCreator().createChildWidget(out, context.getChildElement());
			String tabWidget = context.getWidget();
			
			if (context.titleWidget != null)
			{
				out.println(tabWidget+".add("+widget+", "+context.titleWidget+");");
			}
			else
			{
				out.println(tabWidget+".add("+widget+", "+EscapeUtils.quote(context.title)+", "+context.isHTMLTitle+");");
			}
			updateTabState(out, context);
		}
		
		private void updateTabState(SourcePrinter out, TabPanelContext context)
		{
			String enabled = context.tabElement.optString("enabled");
			String widget = context.getWidget();

			if (enabled != null && enabled.length() >0)
			{
				out.println(widget+".getTabBar().setTabEnabled("+widget+".getTabBar().getTabCount()-1, "+Boolean.parseBoolean(enabled)+");");
			}
			
			String currentTab = getWidgetCreator().createVariableName("currentTab");
			out.println(Tab.class.getCanonicalName()+" "+currentTab+" = "+widget+".getTabBar().getTab("+widget+".getTabBar().getTabCount()-1);");
			
			String wordWrap = context.tabElement.optString("wordWrap");
			if (wordWrap != null && wordWrap.trim().length() > 0)
			{
				out.println(currentTab+".setWordWrap("+Boolean.parseBoolean(wordWrap)+");");
			}

			String clickEvt = context.tabElement.optString(clickEvtBind.getEventName());
			if (!StringUtils.isEmpty(clickEvt))
			{
				clickEvtBind.processEvent(out, clickEvt, currentTab, null);
			}
			String keyUpEvt = context.tabElement.optString(keyUpEvtBind.getEventName());
			if (!StringUtils.isEmpty(keyUpEvt))
			{
				keyUpEvtBind.processEvent(out, keyUpEvt, currentTab, null);
			}
			String keyPressEvt = context.tabElement.optString(keyPressEvtBind.getEventName());
			if (!StringUtils.isEmpty(keyPressEvt))
			{
				keyPressEvtBind.processEvent(out, keyPressEvt, currentTab, null);
			}
			String keyDownEvt = context.tabElement.optString(keyDownEvtBind.getEventName());
			if (!StringUtils.isEmpty(keyDownEvt))
			{
				keyDownEvtBind.processEvent(out, keyDownEvt, currentTab, null);
			}

			context.clearAttributes();
		}	
		private static ClickEvtBind clickEvtBind = new ClickEvtBind();
		private static KeyUpEvtBind keyUpEvtBind = new KeyUpEvtBind();
		private static KeyPressEvtBind keyPressEvtBind = new KeyPressEvtBind();
		private static KeyDownEvtBind keyDownEvtBind = new KeyDownEvtBind();
	}
	
	@Override
	public TabPanelContext instantiateContext()
	{
	    return new TabPanelContext();
	}
}
