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
package br.com.sysmap.crux.ext.server.component;

/**
 * A TextArea Component
 * @author Thiago Bustamante
 *
 */
public class TextArea extends FocusComponent
{
	protected int rows;

	public int getRows() 
	{
		return rows;
	}

	public void setRows(int rows) 
	{
		if (isCheckChanges() && this.rows != rows)
		{
			dirty = true;
		}
		this.rows = rows;
	}
}
