<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <title>Liste des pays</title>
      </head>
      <body>
        Liste des pays
        <table>
          <xsl:for-each select="/countries/element">
            <button onclick="window.location.href = 'https://w3docs.com';">
              <xsl:value-of select="translations/fr"/>
              <img height="20" width="20">
                <xsl:attribute name="src">
                  <xsl:value-of select="flag"/>
                </xsl:attribute>
              </img>
            </button>
            <p/>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
