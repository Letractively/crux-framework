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
package br.com.sysmap.crux.widgets.client.wizard;

import java.io.Serializable;



/**
 * @author Thiago da Rosa de Bustamante -
 *
 */
public class WizardCommandEvent<T extends Serializable> extends StepEvent<WizardCommandHandler<T>, T> 
{
	/**
	 * 
	 */
	protected WizardCommandEvent(WizardProxy<T> wizardProxy)
	{
		super(wizardProxy);
	}

	/**
	 * @return
	 */
	public static <T extends Serializable> Type<WizardCommandHandler<T>> getType(WizardCommandHandler<T> handler)
	{
		return new Type<WizardCommandHandler<T>>();
	}

	/**
	 * @param <I>
	 * @param source
	 * @return
	 */
	public static <T extends Serializable> WizardCommandEvent<T> fire(HasWizardCommandHandlers<T> source, WizardProxy<T> proxy)
	{
		WizardCommandEvent<T> event = new WizardCommandEvent<T>(proxy);
		source.fireEvent(event);
		return event;
	}

	@Override
	protected void dispatch(WizardCommandHandler<T> handler)
	{
		handler.onCommand(this);
	}

	@Override
	public Type<WizardCommandHandler<T>> getAssociatedType()
	{
		return new Type<WizardCommandHandler<T>>();
	}
}
