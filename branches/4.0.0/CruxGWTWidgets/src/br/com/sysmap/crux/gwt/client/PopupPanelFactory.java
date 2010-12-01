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
package br.com.sysmap.crux.gwt.client;

import br.com.sysmap.crux.core.client.declarative.DeclarativeFactory;
import br.com.sysmap.crux.core.client.declarative.TagAttribute;
import br.com.sysmap.crux.core.client.declarative.TagAttributes;
import br.com.sysmap.crux.core.client.screen.InterfaceConfigException;
import br.com.sysmap.crux.core.client.screen.WidgetFactoryContext;
import br.com.sysmap.crux.core.client.screen.factory.HasAnimationFactory;
import br.com.sysmap.crux.core.client.screen.factory.HasCloseHandlersFactory;
import br.com.sysmap.crux.core.client.screen.parser.CruxMetaDataElement;

import com.google.gwt.user.client.ui.PopupPanel;


/**
 * Represents a PopupPanelFactory
 * @author Thiago Bustamante
 *
 */
@DeclarativeFactory(id="popupPanel", library="gwt", attachToDOM=false)
public class PopupPanelFactory extends PanelFactory<PopupPanel, WidgetFactoryContext>
       implements HasAnimationFactory<PopupPanel, WidgetFactoryContext>, HasCloseHandlersFactory<PopupPanel, WidgetFactoryContext>
{

	@Override
	public PopupPanel instantiateWidget(CruxMetaDataElement element, String widgetId) 
	{
		return new PopupPanel();
	}
	
	@Override
	@TagAttributes({
		@TagAttribute(value="previewingAllNativeEvents", type=Boolean.class),
		@TagAttribute(value="autoHideOnHistoryEventsEnabled", type=Boolean.class),
		@TagAttribute("glassStyleName"),
		@TagAttribute(value="glassEnabled", type=Boolean.class),
		@TagAttribute(value="modal", type=Boolean.class),
		@TagAttribute(value="autoHide", type=Boolean.class, property="autoHideEnabled")
	})
	public void processAttributes(WidgetFactoryContext context) throws InterfaceConfigException
	{
		super.processAttributes(context);
	}
}
