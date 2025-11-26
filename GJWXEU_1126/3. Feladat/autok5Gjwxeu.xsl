<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>
  
  <xsl:key name="tipusok" match="auto" use="tipus" />
  
  <xsl:template match="/autok">
    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Autótípusok darabszáma</title>
      </head>
      <body>
        
        <h2>Autótípusok és példányaik száma (csökkenő sorrendben)</h2>
        
        <ul>
          <xsl:for-each select="auto[generate-id() = generate-id(key('tipusok', tipus)[1])]">
            <xsl:sort select="count(key('tipusok', tipus))" data-type="number" order="descending"/>
            
            <li>
              <xsl:value-of select="tipus"/>:
              <xsl:value-of select="count(key('tipusok', tipus))"/> db
            </li>
          </xsl:for-each>
        </ul>
        
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>