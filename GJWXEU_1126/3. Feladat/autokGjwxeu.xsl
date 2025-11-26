<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>
  
  <xsl:template match="/autok">
    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Autók rendszámai</title>
      </head>
      <body>
        <h2>Autók rendszámai</h2>
        
        <ul>
          <xsl:for-each select="auto">
            <li>
              <xsl:value-of select="@rsz"/>
            </li>
          </xsl:for-each>
        </ul>
        
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>