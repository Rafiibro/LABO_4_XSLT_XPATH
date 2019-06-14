<?xml version = "1.0" encoding = "UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output
            method="html"
            encoding="UTF-8"
            indent="yes"
    />
    <xsl:template match="/">
        <html>
            <head>
                <title>Lab4 SER XSLT XPATH</title>
                <!-- Bootstrap stylesheet and javascript -->
                <script src="../js/jquery-3.4.1.min.js"/>
                <script src="../js/bootstrap.min.js"/>
                <link rel="stylesheet" href="../css/bootstrap.min.css"/>
            </head>
            <body>
                <xsl:for-each
                        select="/countries/element">
                    <!-- Button trigger modal -->
                    <button style="height:30px;width:250px" type="button" class="btn btn-primary" data-toggle="modal">
                        <xsl:attribute name="data-target">
                            #<xsl:value-of select="./translations/fr"/>
                        </xsl:attribute>
                        <p>
                            <xsl:value-of select="./translations/fr"/>
                            <img height="20" width="25" style="float: right;">
                                <xsl:attribute name="src">
                                    <xsl:value-of select="flag"/>
                                </xsl:attribute>
                            </img>
                        </p>
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <xsl:attribute name="id">
                            <xsl:value-of select="./translations/fr"/>
                        </xsl:attribute>
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">
                                        <xsl:value-of select="./translations/fr"/>
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        x
                                    </button>
                                </div>
                                <p>
                                    <img height="150" width="210" style="float: left;">
                                        <xsl:attribute name="src">
                                            <xsl:value-of select="flag"/>
                                        </xsl:attribute>
                                    </img>
                                    Capital :
                                    <xsl:value-of select="./capital"/>
                                    <br/>
                                    Population :
                                    <xsl:value-of select="./population"/> habitants
                                    <br/>
                                    Superficie :
                                    <xsl:value-of select="./area"/> km2
                                    <br/>
                                    Continent :
                                    <xsl:value-of select="./region"/>
                                    <br/>
                                    Sous-Continent :
                                    <xsl:value-of select="./subregion"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    Langues parlées
                                    <br/>
                                    <ul>
                                        <xsl:for-each select="./languages/element/name">
                                            <li>
                                                <xsl:value-of select="."/>
                                                <br/>
                                            </li>
                                        </xsl:for-each>
                                    </ul>
                                </p>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>