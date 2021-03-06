import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

class XSLCreator {

    XSLCreator(String query) {

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            final DocumentBuilder builder = factory.newDocumentBuilder();

            final Document document = builder.parse(new File("src/main/java/exportfile/template.xsl"));

            XPath xp = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", document, XPathConstants.NODESET);

            for (int i=0; i < nl.getLength(); ++i) {
                Node node = nl.item(i);
                node.getParentNode().removeChild(node);
            }

            final Element doc = document.getDocumentElement();

            final Node template = doc.getChildNodes().item(1);
            final Node html = template.getChildNodes().item(0);
            final Node body = html.getChildNodes().item(1);
            final Node forEach = body.getChildNodes().item(0);
            Node nn = forEach.getAttributes().item(0);
            nn.setNodeValue(query);

            // Etape 7 : finalisation
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource source        = new DOMSource(document);
            final StreamResult sortie     = new StreamResult(new File("src/main/java/exportfile/transformation.xsl"));

            //prologue
            transformer.setOutputProperty(OutputKeys.VERSION,    "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING,   "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            //formatage
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            //sortie
            transformer.transform(source, sortie);

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}