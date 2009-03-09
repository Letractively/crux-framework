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
package br.com.sysmap.crux.core.server.screen;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import au.id.jericho.lib.html.Attribute;
import au.id.jericho.lib.html.Attributes;
import au.id.jericho.lib.html.Element;
import br.com.sysmap.crux.core.i18n.MessagesFactory;
import br.com.sysmap.crux.core.server.ServerMessages;

public class ComponentParserImpl implements ComponentParser
{
	private static final Log logger = LogFactory.getLog(ComponentParserImpl.class);
	private ServerMessages messages = (ServerMessages)MessagesFactory.getMessages(ServerMessages.class);

	@Override
	public void parse(Component component, Object element) 
	{
		Element elem = (Element) element;
		
		Attributes attrs =  elem.getAttributes();
		for (Object object : attrs) 
		{
			Attribute attr = (Attribute)object;
			String attrName = attr.getName();
			
			if (attrName.equals("id") || attrName.equals("_type"))
			{
				continue;
			}
			
			if (attrName.startsWith("_on"))
			{
				setEvent(component, attrName, attr.getValue());
			}
			else if (attrName.equals("_class"))
			{
				setProperty(component, "className", attr.getValue());
			}
			else
			{
				setProperty(component, attrName.substring(1), attr.getValue());
			}
		}
	}
	
	protected void setProperty(Component component, String propName, String value)
	{
		try 
		{
			BeanUtils.copyProperty(component, propName, value);
		} 
		catch (Throwable e) 
		{
			if (logger.isDebugEnabled()) logger.debug(messages.componentParserImplComponentPropertyError(propName, component.getId()));
		} 
	}

	protected void setEvent(Component component, String evtName, String value)
	{
		Event event = EventFactory.getEvent(evtName, value);
		
		if (event != null)
		{
			component.addEvent(event);
		}
	}
	
}
