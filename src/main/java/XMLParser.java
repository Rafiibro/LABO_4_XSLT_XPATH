import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.*;

public class XMLParser {

    private List<Pays> listPays = new ArrayList<>();

    XMLParser(String path) {

        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(path);
        try {
            Document document = saxBuilder.build(xmlFile);
            Element rootElement = document.getRootElement();

            List listCountries = rootElement.getChildren("element");

            for (int iCountry = 0; iCountry < listCountries.size(); ++iCountry) {

                Element country = (Element) listCountries.get(iCountry);
                Pays p = new Pays();
                p.setPopulation(Integer.parseInt(country.getChild("population").getValue()));
                p.setNom(country.getChild("translations").getChild("fr").getValue());
                p.setCapitale(country.getChild("capital").getValue());
                p.setContinent(country.getChild("region").getValue());
                p.setSousContinent(country.getChild("subregion").getValue());
                p.setDrapeau(country.getChild("flag").getValue());
                if (!country.getChild("area").hasAttributes()) {
                    p.setSuperficie(Double.parseDouble(country.getChild("area").getValue()));
                }
                List langues = country.getChild("languages").getChildren("element");
                for (int iLangue = 0; iLangue < langues.size(); ++iLangue) {
                    Element langue = (Element) langues.get(iLangue);
                    p.addLangues(langue.getChild("name").getValue());
                }
                listPays.add(p);
            }
        }

        catch (IOException io) {
            System.out.println(io.getMessage());
        }

        catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

    }

    public List<Pays> getListPays() {
        return listPays;
    }

    public static void main(String[] args) {
        XMLParser x = new XMLParser("/Users/rafael.dacunhag/Desktop/SER/LABO_4_XSLT_XPATH/src/main/java/countries.xml");
    }
}
