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
package br.com.sysmap.crux.advanced.client.dialog;

import br.com.sysmap.crux.advanced.client.event.dialog.CancelHandler;
import br.com.sysmap.crux.advanced.client.event.dialog.OkHandler;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Thiago da Rosa de Bustamante <code>tr_bustamante@yahoo.com.br</code>
 *
 */
public class Popup extends Widget implements HasCloseHandlers<Popup>
{
	public static final String DEFAULT_STYLE_NAME = "crux-Popup" ;
	private static ConfirmController confirmController = null;
	private String title;
	private String message;
	private String styleName;
	protected static Popup popup;
	
	/**
	 * 
	 */
	public Popup()
	{
		setElement(DOM.createSpan());
	}

	public HandlerRegistration addCloseHandler(CloseHandler<Popup> handler)
	{
		return addHandler(handler, CloseEvent.getType());
	}	

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getStyleName()
	{
		return styleName;
	}

	public void setStyleName(String styleName)
	{
		this.styleName = styleName;
	}

	/**
	 * 
	 */
	public void show()
	{
		if (confirmController == null)
		{
			confirmController = new ConfirmController(); 
		}
		popup = this;
	//	confirmController.showConfirm(new ConfirmData(title, message, styleName!=null?styleName:DEFAULT_STYLE_NAME));
	}
	
	/**
	 * 
	 * @param title
	 * @param message
	 * @param okCall
	 * @param cancelCall
	 */
	public static void show(String title, String message, OkHandler okHandler, CancelHandler cancelHandler)
	{
		show(title, message, okHandler, cancelHandler, DEFAULT_STYLE_NAME);
	}
	
	/**
	 * 
	 * @param title
	 * @param message
	 * @param okCall
	 * @param cancelCall
	 * @param styleName
	 */
	public static void show(String title, String message, OkHandler okHandler, CancelHandler cancelHandler, String styleName)
	{
/*		Popup confirm = new Popup(); 
		confirm.setTitle(title);
		confirm.setMessage(message);
		confirm.setStyleName(styleName);
		if (okHandler != null)
		{
			confirm.addOkHandler(okHandler);
		}
		if (cancelHandler != null)
		{
			confirm.addCancelHandler(cancelHandler);
		}
		confirm.show();*/
	}
}
