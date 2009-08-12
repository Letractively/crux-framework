<!--
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
 *-->
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:crux="http://www.sysmap.com.br/crux/basic-widgets/1.0"
	xmlns:html="http://www.w3.org/1999/xhtml"
	exclude-result-prefixes="#all">

	

	<xsl:template name="suggestBox" match="crux:suggestBox">
	
		<xsl:element name="span" namespace="http://www.w3.org/1999/xhtml">

			<xsl:call-template name="widgetAttributes"/>
			
			<xsl:if test="string-length(@popupStyleName) > 0">
				<xsl:attribute name="_popupStyleName" select="@popupStyleName"/>
			</xsl:if>
			
			<xsl:if test="string-length(@limit) > 0">
				<xsl:attribute name="_limit" select="@limit"/>
			</xsl:if>
			
			<xsl:if test="string-length(@autoSelectEnabled) > 0">
				<xsl:attribute name="_autoSelectEnabled" select="@autoSelectEnabled"/>
			</xsl:if>
									
			<xsl:value-of select="' '"/>

		</xsl:element> 

	</xsl:template>

</xsl:stylesheet>