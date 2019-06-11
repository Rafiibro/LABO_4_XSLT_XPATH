import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.*;

public class XMLParser {

    XMLParser(File xmlFile) {

        SAXBuilder saxBuilder = new SAXBuilder();

        try {
            Document document = saxBuilder.build(xmlFile);
            Element rootElement = document.getRootElement();

            List listCountries = rootElement.getChildren("element");

            for (int iCountry = 0; iCountry < listCountries.size(); ++iCountry) {

                Element country = (Element) listCountries.get(iCountry);
                InterfaceRecherchePays.addContinent(country.getChild("region").getValue());
                List langues = country.getChild("languages").getChildren("element");
                for (int iLangue = 0; iLangue < langues.size(); ++iLangue) {
                    Element langue = (Element) langues.get(iLangue);
                    InterfaceRecherchePays.addLangue(langue.getChild("name").getValue());
                }
            }
        }

        catch (IOException io) {
            System.out.println(io.getMessage());
        }

        catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }
}
