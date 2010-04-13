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
package br.com.sysmap.crux.widgets.client.paging;

import br.com.sysmap.crux.core.client.declarative.TagAttributeDeclaration;
import br.com.sysmap.crux.core.client.declarative.TagAttributesDeclaration;
import br.com.sysmap.crux.core.client.declarative.TagEventDeclaration;
import br.com.sysmap.crux.core.client.declarative.TagEventsDeclaration;
import br.com.sysmap.crux.core.client.screen.InterfaceConfigException;
import br.com.sysmap.crux.core.client.screen.Screen;
import br.com.sysmap.crux.core.client.screen.ScreenLoadEvent;
import br.com.sysmap.crux.core.client.screen.ScreenLoadHandler;
import br.com.sysmap.crux.core.client.screen.WidgetFactory;
import br.com.sysmap.crux.widgets.client.WidgetMessages;
import br.com.sysmap.crux.widgets.client.event.paging.PageEvtBind;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gess� S. F. Daf� - <code>gessedafe@gmail.com</code>
 */
public abstract class AbstractPagerFactory<T extends AbstractPager> extends WidgetFactory<T>
{
	private WidgetMessages messages = GWT.create(WidgetMessages.class);
	
	/**
	 * @see br.com.sysmap.crux.core.client.screen.WidgetFactory#instantiateWidget(com.google.gwt.dom.client.Element, java.lang.String)
	 */
	public T instantiateWidget(Element elem, String widgetId) throws InterfaceConfigException
	{
		return createPagerInstance();
	}

	/**
	 * Creates a new instance of the Pager
	 * @return
	 */
	protected abstract T createPagerInstance();

	@Override
	@TagAttributesDeclaration({
		@TagAttributeDeclaration("pageable"),
		@TagAttributeDeclaration(value="enabled", type=Boolean.class)
	})
	public void processAttributes(WidgetFactoryContext<T> context) throws InterfaceConfigException
	{
		super.processAttributes(context);
	
		Element element = context.getElement();
		final T widget = context.getWidget();
		final String pageableId = element.getAttribute("_pageable");
		final String strEnabled = element.getAttribute("_enabled");
		
		addScreenLoadedHandler(
				
			new ScreenLoadHandler()
			{
				public void onLoad(ScreenLoadEvent screenLoadEvent)
				{					
					Widget pageable = null;
					if(pageableId != null)
					{
						pageable = Screen.get(pageableId);
					}
					
					if(pageable != null)
					{
						widget.setPageable((Pageable) pageable);
						if(strEnabled != null && strEnabled.length() > 0)
						{
							widget.setEnabled(Boolean.parseBoolean(strEnabled));
						}
					}
					else
					{
						throw new RuntimeException(messages.pagerNoPageableSet()); 
					}							
				}				
			}		
		);
	}
	
	@Override
	@TagEventsDeclaration({
		@TagEventDeclaration("onPage")
	})
	public void processEvents(WidgetFactoryContext<T> context) throws InterfaceConfigException
	{
		Element element = context.getElement();
		T widget = context.getWidget();
		PageEvtBind.bindEvent(element, widget);
		super.processEvents(context);
	}
}