<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>
  
  <xsl:key name="varos" match="auto" use="tulaj/varos" />
  
  <xsl:template match="/autok">
    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Autók városonként</title>
      </head>
      <body>
        
        <h2>Városonkénti autódarabszám és összár</h2>
        
        <table border="1" cellpadding="6">
          <tr>
            <th>Város</th>
            <th>Autók darabszáma</th>
            <th>Összár (Ft)</th>
          </tr>

          <xsl:for-each select="auto[generate-id() = generate-id(key('varos', tulaj/varos)[1])]">
            <tr>
              <td>
                <xsl:value-of select="tulaj/varos"/>
              </td>
              
              <td>
                <xsl:value-of select="count(key('varos', tulaj/varos))"/>
              </td>
              
              <td>
                <xsl:variable name="autos" select="key('varos', tulaj/varos)"/>
                <xsl:value-of select="sum($autos/ar)"/>
              </td>
            </tr>
          </xsl:for-each>
          
        </table>
        
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>