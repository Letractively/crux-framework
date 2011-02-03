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

import br.com.sysmap.crux.core.client.utils.StringUtils;
import br.com.sysmap.crux.core.i18n.MessagesFactory;
import br.com.sysmap.crux.core.rebind.CruxGeneratorException;
import br.com.sysmap.crux.core.rebind.widget.ViewFactoryCreator.SourcePrinter;
import br.com.sysmap.crux.core.rebind.widget.creator.children.WidgetChildProcessor;
import br.com.sysmap.crux.core.rebind.widget.creator.children.WidgetChildProcessor.AnyWidget;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagAttributeDeclaration;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagAttributesDeclaration;
import br.com.sysmap.crux.core.rebind.widget.declarative.TagChildAttributes;

import com.google.gwt.user.client.ui.DockLayoutPanel.Direction;

class DockLayoutPanelContext extends AbstractLayoutPanelContext
{
	String left;
	String top;
	Direction direction;
	Double size = -1.0;
}

/**
 * @author Thiago da Rosa de Bustamante
 *
 */
public abstract class AbstractDockLayoutPanelFactory<C extends DockLayoutPanelContext> 
	  extends AbstractLayoutPanelFactory<C>
{
	
	@TagChildAttributes(minOccurs="0", maxOccurs="unbounded", tagName="cell")
	@TagAttributesDeclaration({
		@TagAttributeDeclaration(value="direction", type=Direction.class, defaultValue="CENTER"),
		@TagAttributeDeclaration(value="size", type=Double.class)
	})
	public static abstract class AbstractDockLayoutPanelProcessor<C extends DockLayoutPanelContext> 
	                       extends WidgetChildProcessor<C> 
	{
		@Override
		public void processChildren(SourcePrinter out, C context) throws CruxGeneratorException 
		{
			context.direction = getDirection(context.readChildProperty("direction"));
			String sizeStr = context.readChildProperty("size");
			if (StringUtils.isEmpty(sizeStr))
			{
				context.size = -1.0;
			}
			else
			{
				context.size = Double.parseDouble(sizeStr);
			}
		}

		private Direction getDirection(String direction)
		{
			Direction result;
			if (!StringUtils.isEmpty(direction))
			{
				result = Direction.valueOf(direction);
			}
			else
			{
				result = Direction.CENTER;
			}
			return result;
		}
	}
	
	
	@TagChildAttributes(type=AnyWidget.class)
	public static class AbstractDockPanelWidgetProcessor<C extends DockLayoutPanelContext> extends WidgetChildProcessor<C> 
	{
		GWTMessages messages = MessagesFactory.getMessages(GWTMessages.class);
		
		@Override
		public void processChildren(SourcePrinter out, C context) throws CruxGeneratorException 
		{
			String childWidget = getWidgetCreator().createChildWidget(out, context.getChildElement());
			
			
			if (!context.direction.equals(Direction.CENTER) && context.size == -1)
			{
				throw new CruxGeneratorException(messages.dockLayoutPanelRequiredSize(context.getWidgetId()));
			}
			
			if (context.animationDuration > 0)
			{
				processAnimatedChild(context, childWidget, context.direction, context.size);
			}
			else
			{
				processChild(context, childWidget, context.direction, context.size);
			}
		}

		/**
		 * @param context
		 * @param childWidget
		 * @param direction
		 * @param size
		 */
		protected void processAnimatedChild(C context, String childWidget, Direction direction, double size)
		{
			context.addChildWithAnimation(processChild(context, childWidget, direction, size));
		}

		/**
		 * 
		 * @param context
		 * @param childWidget
		 * @param direction
		 * @param size
		 */
		protected String processChild(C context, String childWidget, Direction direction, double size)
		{
			String rootWidget = context.getWidget();
			
			String result;
			if (direction.equals(Direction.CENTER))
			{
				result = rootWidget+".add("+childWidget+");";	
			}
			else if (direction.equals(Direction.EAST))
			{
				result = rootWidget+".addEast("+childWidget+", "+size+");";
			}
			else if (direction.equals(Direction.NORTH))
			{
				result = rootWidget+".addNorth("+childWidget+", "+size+");";
			}
			else if (direction.equals(Direction.SOUTH))
			{
				result = rootWidget+".addSouth("+childWidget+", "+size+");";				
			}
			else if (direction.equals(Direction.WEST))
			{
				result = rootWidget+".addWest("+childWidget+", "+size+");";
			}
			else if (direction.equals(Direction.LINE_START))
			{
				result = rootWidget+".addLineStart("+childWidget+", "+size+");";
			}
			else if (direction.equals(Direction.LINE_END))
			{
				result = rootWidget+".addLineEnd("+childWidget+", "+size+");";
			}
			else
			{
				result = "";
			}
			return result;
		}
	}
}
