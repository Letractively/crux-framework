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

import br.com.sysmap.crux.core.rebind.widget.creator.children.ChoiceChildProcessor;
import br.com.sysmap.crux.core.rebind.widget.creator.children.WidgetChildProcessor;
import br.com.sysmap.crux.core.rebind.widget.declarative.DeclarativeFactory;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagChild;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagChildAttributes;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagChildren;

import com.google.gwt.user.client.ui.DecoratedTabPanel;

/**
 * Factory for DecoratedTabPanel widgets
 * @author Thiago da Rosa de Bustamante
 */
@DeclarativeFactory(id="decoratedTabPanel", library="gwt", targetWidget=DecoratedTabPanel.class)
@TagChildren({
	@TagChild(DecoratedTabPanelFactory.TabProcessor.class)
})	
public class DecoratedTabPanelFactory extends AbstractTabPanelFactory
{
	@TagChildren({
		@TagChild(TabTitleProcessor.class), 
		@TagChild(TabWidgetProcessor.class)
	})	
	public static class TabProcessor extends AbstractTabProcessor {}
	
	@TagChildAttributes(minOccurs="0")
	@TagChildren({
		@TagChild(TextTabProcessor.class),
		@TagChild(HTMLTabProcessor.class),
		@TagChild(WidgetTitleTabProcessor.class)
	})		
	public static class TabTitleProcessor extends ChoiceChildProcessor<TabPanelContext> {}
	
	public static class TextTabProcessor extends AbstractTextTabProcessor {}
	
	public static class HTMLTabProcessor extends AbstractHTMLTabProcessor {}
	
	@TagChildAttributes(tagName="tabWidget")
	@TagChildren({
		@TagChild(WidgetTitleProcessor.class)
	})	
	public static class WidgetTitleTabProcessor extends WidgetChildProcessor<TabPanelContext> {}

	public static class WidgetTitleProcessor extends AbstractWidgetTitleProcessor {}
	
	@TagChildAttributes(tagName="panelContent")
	@TagChildren({
		@TagChild(WidgetContentProcessor.class)
	})	
	public static class TabWidgetProcessor extends WidgetChildProcessor<TabPanelContext> {}

	public static class WidgetContentProcessor extends AbstractWidgetContentProcessor {}	
}
