<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
      
  <xsl:output encoding="UTF-8" indent="yes" method="html"/>
      
  <xsl:template match="/">
            
    <html>
                  
      <head>
                        
        <title>Lab4 SER XSLT XPATH</title>
                        
        <!-- Bootstrap stylesheet and javascript -->
                        
        <script src="../js/jquery-3.4.1.min.js"/>
                        
        <script src="../js/bootstrap.min.js"/>
                        
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
                    
      </head>
                  
      <body>
                        
        <xsl:for-each select="/countries/element[region=&quot;Europe&quot;]">
                              
          <!-- Button trigger modal -->
                              
          <button class="btn btn-primary" data-toggle="modal" style="height:30px;width:250px" type="button">
                                    
            <xsl:attribute name="data-target">
                                          #
              <xsl:value-of select="./translations/fr"/>
                                      
            </xsl:attribute>
                                    
            <p>
                                          
              <xsl:value-of select="./translations/fr"/>
                                          
              <img height="20" style="float: right;" width="25">
                                                
                <xsl:attribute name="src">
                                                      
                  <xsl:value-of select="flag"/>
                                                  
                </xsl:attribute>
                                            
              </img>
                                      
            </p>
                                
          </button>
                              
          <!-- Modal -->
                              
          <div aria-hidden="true" aria-labelledby="exampleModalLabel" class="modal fade" role="dialog" tabindex="-1">
                                    
            <xsl:attribute name="id">
                                          
              <xsl:value-of select="./translations/fr"/>
                                      
            </xsl:attribute>
                                    
            <div class="modal-dialog" role="document">
                                          
              <div class="modal-content">
                                                
                <div class="modal-header">
                                                      
                  <h5 class="modal-title" id="exampleModalLabel">
                                                            
                    <xsl:value-of select="./translations/fr"/>
                                                        
                  </h5>
                                                      
                  <button aria-label="Close" class="close" data-dismiss="modal" type="button">
                                        x
                                    </button>
                                                  
                </div>
                                                
                <p>
                                                      
                  <img height="150" style="float: left;" width="210">
                                                            
                    <xsl:attribute name="src">
                                                                  
                      <xsl:value-of select="flag"/>
                                                              
                    </xsl:attribute>
                                                        
                  </img>
                                                      Capital :
                                    
                  <xsl:value-of select="./capital"/>
                                                      
                  <br/>
                                                      Population :
                                    
                  <xsl:value-of select="./population"/>
                   habitants
                                    
                  <br/>
                                                      Superficie :
                                    
                  <xsl:value-of select="./area"/>
                   km2
                                    
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
                                                      
                  <button class="btn btn-secondary" data-dismiss="modal" type="button">Fermer</button>
                                                  
                </div>
                                            
              </div>
                                      
            </div>
                                
          </div>
                          
        </xsl:for-each>
                    
      </body>
              
    </html>
        
  </xsl:template>
  
</xsl:stylesheet>
