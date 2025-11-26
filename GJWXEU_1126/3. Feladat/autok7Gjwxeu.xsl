<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
  
  <xsl:template match="/autok">
    <rendszamokArak>
      <xsl:for-each select="auto">
        <xsl:sort select="ar" data-type="number" order="ascending"/>
        
        <auto>
          <rendszam><xsl:value-of select="@rsz"/></rendszam>
          <ar><xsl:value-of select="ar"/></ar>
        </auto>
        
      </xsl:for-each>
    </rendszamokArak>
  </xsl:template>
  
</xsl:stylesheet>