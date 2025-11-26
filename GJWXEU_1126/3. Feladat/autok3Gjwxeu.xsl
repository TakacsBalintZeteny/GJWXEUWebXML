<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>
  
  <xsl:template match="/autok">
    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>30000 Ft-nál drágább autók száma</title>
      </head>
      <body>
        
        <h2>30000 Ft-nál drágább autók száma</h2>
        
        <p>
          Drágább mint 30000 Ft:  
          <b>
            <xsl:value-of select="count(auto[ar &gt; 30000])"/>
          </b>
          darab
        </p>
        
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>