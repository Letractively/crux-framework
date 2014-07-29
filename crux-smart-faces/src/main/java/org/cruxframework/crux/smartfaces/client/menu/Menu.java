/*
 * Copyright 2014 cruxframework.org.
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
package org.cruxframework.crux.smartfaces.client.menu;

import org.cruxframework.crux.core.client.collection.FastList;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;
import org.cruxframework.crux.core.client.screen.Screen;
import org.cruxframework.crux.smartfaces.client.panel.BasePanel;
import org.cruxframework.crux.smartfaces.client.panel.SelectablePanel;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAnimation;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;

/**
 * A cross device menu
 * @author Samuel Almeida Cardoso (samuel@cruxframework.org)
 * @author Claudio Holanda (claudio.junior@cruxframework.org)
 * @author Thiago da Rosa de Bustamante
 *
 */
public class Menu extends Composite implements HasAnimation, HasEnabled 
{
	private static final String SPACE = " ";
	
	public static enum LargeType
	{
		VERTICAL_TREE("VerticalTree", STYLE_FACES_VERTICAL + SPACE + STYLE_FACES_TREE),
		VERTICAL_SLIDE("VerticalSlider", STYLE_FACES_VERTICAL + SPACE + STYLE_FACES_SLIDE),
		VERTICAL_ACCORDION("VerticalAccordion", STYLE_FACES_VERTICAL + SPACE + STYLE_FACES_ACCORDION),
		VERTICAL_DROPDOWN("VerticalDropdown", STYLE_FACES_VERTICAL + SPACE + STYLE_FACES_DROPDOWN),
		HORIZONTAL_ACCORDION("HorizontalAccordion", STYLE_FACES_HORIZONTAL + SPACE + STYLE_FACES_ACCORDION),
		HORIZONTAL_DROPDOWN("HorizontalDropdown", STYLE_FACES_HORIZONTAL + SPACE + STYLE_FACES_DROPDOWN);
		
		String friendlyName;
		String styleName;
		LargeType(String friendlyName, String styleName)
		{
			this.friendlyName = friendlyName;
			this.styleName = styleName;	
		}
		
		@Override
		public String toString() 
		{
			return friendlyName;
		}
		
		public static LargeType getByName(String friendlyName)
		{
			for(LargeType type : LargeType.values())
			{
				if(type.friendlyName != null && type.friendlyName.equals(friendlyName))
				{
					return type;
				}
			}
			return null;
		}
	}
	
	public static enum SmallType
	{
		VERTICAL_TREE("VerticalTree", STYLE_FACES_VERTICAL + SPACE + STYLE_FACES_TREE),
		VERTICAL_SLIDE("VerticalSlider", STYLE_FACES_VERTICAL + SPACE + STYLE_FACES_SLIDE),
		VERTICAL_ACCORDION("VerticalAccordion", STYLE_FACES_VERTICAL + SPACE + STYLE_FACES_ACCORDION),
		HORIZONTAL_ACCORDION("HorizontalAccordion", STYLE_FACES_HORIZONTAL + SPACE + STYLE_FACES_ACCORDION);
		
		String friendlyName;
		String styleName;
		SmallType(String friendlyName, String styleName)
		{
			this.friendlyName = friendlyName;
			this.styleName = styleName;
		}
		
		@Override
		public String toString() 
		{
			return friendlyName;
		}
		
		public static SmallType getByName(String friendlyName)
		{
			for(SmallType type : SmallType.values())
			{
				if(type.friendlyName != null && type.friendlyName.equals(friendlyName))
				{
					return type;
				}
			}
			return null;
		}
	}
	
	public    static final String STYLE_FACES_MENU = "facesMenu";
	protected static final String STYLE_FACES_SLIDE = "facesMenu-slide";
	protected static final String STYLE_FACES_DROPDOWN = "facesMenu-dropdown";
	protected static final String STYLE_FACES_TREE = "facesMenu-tree";
	protected static final String STYLE_FACES_ACCORDION = "facesMenu-accordion";
	protected static final String STYLE_FACES_HORIZONTAL = "facesMenu-horizontal";
	protected static final String STYLE_FACES_VERTICAL = "facesMenu-vertical";
	protected static final String STYLE_FACES_OPEN = "facesMenu-open";
	protected static final String STYLE_FACES_HAS_CHILDREN = "facesMenu-hasChildren";
	protected static final String STYLE_FACES_EMPTY = "facesMenu-empty";
	protected static final String STYLE_FACES_LI = "facesMenu-li";
	protected static final String STYLE_FACES_UL = "facesMenu-ul";
	protected static final String STYLE_AUX_DIV = "facesMenu-trigger";
	
	private boolean enabled = true;
	private MenuItem root;
	private MenuPanel menuPanel = new MenuPanel();
	
	public Menu(LargeType largeType, SmallType smallType)
	{
		initWidget(menuPanel);
		root = new MenuItem(null);
		menuPanel.add(root);
		root.setMenu(this);
		setStyleName(getBaseStyleName());
		
		if(largeType != null &&
			(Screen.getCurrentDevice().equals(Device.largeDisplayArrows)
			 || 
			 Screen.getCurrentDevice().equals(Device.largeDisplayMouse)
			 ||
			 Screen.getCurrentDevice().equals(Device.largeDisplayTouch))
		  )
		{
			renderLargeType(largeType);
		} else if(smallType != null &&
				(Screen.getCurrentDevice().equals(Device.smallDisplayArrows)
				 ||
				 Screen.getCurrentDevice().equals(Device.smallDisplayTouch))
				)
		{
			renderSmallType(smallType);
		} else
		{
			throw new RuntimeException(
					"Cannot instantiate type :<" + this.getClass().getName() + ">. Menu not switable to this device.");
		}
	}

	public Menu(LargeType largeType)
	{
		this(largeType, null);
	}
	
	public Menu(SmallType smallType)
	{
		this(null, smallType);
	}

	public String getBaseStyleName()
	{
		return STYLE_FACES_MENU;
	}

	@Override
	public boolean isAnimationEnabled() 
	{
		return false;
	}

	@Override
	public void setAnimationEnabled(boolean enable) 
	{
	}

	@Override
	public boolean isEnabled() 
	{
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) 
	{
		this.enabled = enabled;
		
		FastList<MenuItem> itemsWithEnabledProperty = MenuUtils.findHasEnabledInMenu(root);
		
		if(itemsWithEnabledProperty != null)
		{
			for(int i=0; i<itemsWithEnabledProperty.size();i++)
			{
				((HasEnabled) itemsWithEnabledProperty.get(i).getItemWidget()).setEnabled(enabled);
			}
		}
	}

	public void clear() 
	{
		if(this.root != null)
		{
			this.root.clear();
		}
	}

	/**
	 * Renders the large menu.
	 */
	public void renderLargeType(LargeType largeType) 
	{
		removeAllLargeTypes();
		addStyleName(largeType.styleName);
	}
	
	/**
	 * Renders the small menu.
	 */
	public void renderSmallType(SmallType smallType) 
	{
		removeAllSmallTypes();
		addStyleName(smallType.styleName);
	}
	
	private void removeAllLargeTypes()
	{
		for(LargeType type : LargeType.values())
		{
			removeStyleName(type.styleName);
		}
	}
	
	private void removeAllSmallTypes()
	{
		for(SmallType type : SmallType.values())
		{
			removeStyleName(type.styleName);
		}
	}

	/**
	 * Adds a root item.
	 * @return the inserted item. 
	 */
	public MenuItem addItem(Widget w) 
	{
		return root.addItem(w);
	}

	/**
	 * Adds a label root item.
	 * @return the inserted item. 
	 */
	public MenuItem addItem(String labelText) 
	{
		return root.addItem(labelText);
	}
	
	/**
	 * Adds a html root item.
	 * @return the inserted item. 
	 */
	public MenuItem addItem(SafeHtml html) 
	{
		return root.addItem(html);
	}

	/**
	 * Adds a label item.
	 * @return the inserted item. 
	 */
	public MenuItem addItem(MenuItem placeToInsert, String labelText) 
	{
		if(placeToInsert == null)
		{
			placeToInsert = this.root;
		}
		return placeToInsert.addItem(labelText);
	}
	
	/**
	 * Adds a label item.
	 * @return the inserted item. 
	 */
	public MenuItem addItem(MenuItem placeToInsert, SafeHtml html) 
	{
		if(placeToInsert == null)
		{
			placeToInsert = this.root;
		}
		return placeToInsert.addItem(html);
	}

	public MenuItem addItem(MenuItem placeToInsert, Widget w) 
	{
		if(placeToInsert == null)
		{
			placeToInsert = this.root;
		}
		return placeToInsert.addItem(w);
	}

	public MenuItem getItem(int index)
	{
		return root.getItem(index);
	}
	
	public MenuItem getItem(String path)
	{
		return root.getItem(path);
	}
	
	public int getItemCount()
	{
		return root.getItemCount();
	}
	
	public int indexOf(MenuItem item)
	{
		return root.indexOf(item);
	}
	
	public boolean removeItem(int index)
	{
		return root.removeItem(index);
	}
	
	public void openAll() 
	{
		MenuUtils.addOrRemoveClass(STYLE_FACES_OPEN, true, MenuUtils.getAllMenuItems(this.root));
	}

	public void open(MenuItem menuItem) 
	{
		if(menuItem == null)
		{
			return;
		}
		
		menuItem.open();
	}

	public void closeAll() 
	{
		MenuUtils.addOrRemoveClass(STYLE_FACES_OPEN, false, MenuUtils.getAllMenuItems(this.root));
	}

	public void close(MenuItem menuItem) 
	{
		if(menuItem == null)
		{
			return;
		}
		
		menuItem.close();
	}

	protected void adopt(MenuItem item)
	{
		menuPanel.adopt(item);
	}
	
	protected void orphan(MenuItem item)
	{
		menuPanel.orphan(item);
	}
	
	protected static class MenuPanel extends BasePanel
	{

		protected MenuPanel()
        {
	        super("nav");
        }
		
		@SuppressWarnings("deprecation")
		protected void add(MenuItem item)
		{
		    DOM.appendChild(getElement(), item.getElement());
		}	

		protected void adopt(MenuItem item)
		{
			SelectablePanel itemPanel = item.getItemPanel();
			if (itemPanel != null)
			{
			    getChildren().add(itemPanel);
				adopt(itemPanel);
			}
		}
		
		@SuppressWarnings("deprecation")
		protected void orphan(MenuItem item)
		{
			SelectablePanel itemPanel = item.getItemPanel();
			if (itemPanel != null)
			{
				DOM.removeChild(getElement(), item.getElement());
			    getChildren().remove(itemPanel);
				orphan(itemPanel);
			}
		}
	}
}
