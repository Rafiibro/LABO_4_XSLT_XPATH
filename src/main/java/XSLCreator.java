import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XSLCreator {
    public XSLCreator(String query){

        // Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //<xsl:for-each select="query" >

        try {
            // Etape 2 : création d'un parseur
            final DocumentBuilder builder = factory.newDocumentBuilder();

            // Etape 3 : création d'un Document
            final Document document = builder.newDocument();

            // Etape 4 : création de l'Element racine
            final Element root = document.createElement("xsl:template match\"\"");
            document.appendChild(root);

            final Element html = document.createElement("html");
            root.appendChild(html);

            final Element head = document.createElement("head");
            html.appendChild(head);

            final Element title = document.createElement("title");
            title.appendChild(document.createTextNode("Liste des pays"));
            head.appendChild(title);

            final Element body = document.createElement("body");
            body.appendChild(document.createTextNode("Liste des pays"));
            html.appendChild(body);

            // Etape 5 : création du tableau
            final Element tableau = document.createElement("table");
            body.appendChild(tableau);

            //Element 6 : création des lignes
            final Element xslForEach = document.createElement("xsl:for-each select=\"" + query  + "\"");
            tableau.appendChild(xslForEach);

            final Element p1 = document.createElement("p");
            xslForEach.appendChild(p1);

            final Element flagPays = document.createElement("xsl:value-of select=\"flag\"");
            p1.appendChild(flagPays);

            final Element p2 = document.createElement("p");
            xslForEach.appendChild(p2);

            final Element nomPays = document.createElement("xsl:value-of select=\"name\"");
            p2.appendChild(nomPays);

            // Etape 7 : finalisation
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource source        = new DOMSource(document);
            final StreamResult sortie     = new StreamResult(new File("src/main/java/transformation.xsl"));

            //prologue
            transformer.setOutputProperty(OutputKeys.VERSION,    "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING,   "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            //formatage
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            //sortie
            transformer.transform(source, sortie);
        }
        catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
