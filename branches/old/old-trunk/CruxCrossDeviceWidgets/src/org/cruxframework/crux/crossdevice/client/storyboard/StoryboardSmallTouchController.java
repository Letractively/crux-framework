package org.cruxframework.crux.crossdevice.client.storyboard;

import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive;
import org.cruxframework.crux.core.client.screen.eventadapter.TapEventAdapter;
import org.cruxframework.crux.core.client.utils.StringUtils;
import org.cruxframework.crux.core.client.utils.StyleUtils;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

@Controller("storyboardSmallTouchController")
public class StoryboardSmallTouchController extends StoryboardSmallController
{
	@Override
	public Widget getWidget(int index)
	{
		return ((FocusPanel)((TapEventAdapter)storyboard.getWidget(index)).getWidget()).getWidget();
	}
	
	@Override
	protected Widget createClickablePanelForCell(Widget widget)
	{
		FocusPanel panel = new FocusPanel();
		final TapEventAdapter adapter = new TapEventAdapter(panel);
		panel.add(widget);
		panel.setStyleName("item");
		if (!StringUtils.isEmpty(itemHeight))
		{
			panel.setHeight(itemHeight);
		}
		
		if (!StringUtils.isEmpty(itemWidth))
		{
			panel.setWidth(itemWidth);
		}

		panel.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				int index = storyboard.getWidgetIndex(adapter);
			    SelectionEvent.fire(StoryboardSmallTouchController.this, index);
			}
		});
		return adapter;
	}

	@Override
	protected void applyWidgetDependentStyleNames()
	{
		StyleUtils.addStyleDependentName(getElement(), DeviceAdaptive.Size.small.toString());
		StyleUtils.addStyleDependentName(getElement(), DeviceAdaptive.Input.touch.toString());
	}
}