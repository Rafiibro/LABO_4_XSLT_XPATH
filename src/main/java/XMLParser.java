import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.*;

class XMLParser {

    XMLParser(File xmlFile) {

        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(xmlFile);
            Element rootElement = document.getRootElement();

            List listCountries = rootElement.getChildren("element");

            for (Object listCountry : listCountries) {

                Element country = (Element) listCountry;
                InterfaceRecherchePays.addContinent(country.getChild("region").getValue());
                List langues = country.getChild("languages").getChildren("element");
                for (Object o : langues) {
                    Element langue = (Element) o;
                    InterfaceRecherchePays.addLangue(langue.getChild("name").getValue());
                }
            }
        }

        catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
        }

    }

}
