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
package br.com.sysmap.crux.core.client.event.bind;

import br.com.sysmap.crux.core.client.event.Event;
import br.com.sysmap.crux.core.client.event.EventFactory;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.HasErrorHandlers;
import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;

/**
 * Helper Class for load events binding
 * @author Thiago Bustamante
 */
public class LoadEvtBind extends EvtBind 
{
	public static void bindLoadEvent(Element element, HasLoadHandlers widget, final String componentId)
	{
		final Event eventLoad = getComponentEvent(element, EventFactory.EVENT_LOAD);
		if (eventLoad != null)
		{
			widget.addLoadHandler(new LoadHandler()
			{
				@Override
				public void onLoad(LoadEvent event) 
				{
					EventFactory.callEvent(eventLoad, componentId);
				}
			});
		}
	}

	public static void bindErrorEvent(Element element, HasErrorHandlers widget, final String componentId)
	{
		final Event eventError = getComponentEvent(element, EventFactory.EVENT_ERROR);
		if (eventError != null)
		{
			widget.addErrorHandler(new ErrorHandler()
			{
				@Override
				public void onError(ErrorEvent event) 
				{
					EventFactory.callEvent(eventError, componentId);
				}
			});
		}
	}
}
