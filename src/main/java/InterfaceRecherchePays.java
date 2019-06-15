import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class InterfaceRecherchePays extends JFrame {

    private JComboBox<String> continents = new JComboBox<>();
    private JComboBox<String> langages = new JComboBox<>();
    private JTextField superficieMin = new JTextField(5);
    private JTextField superficieMax = new JTextField(5);

    private static LinkedList<String> cont = new LinkedList<>();
    private static LinkedList<String> lang = new LinkedList<>();

    InterfaceRecherchePays(File xmlFile) {


        new XMLParser(xmlFile);

        continents.addItem("...");
        langages.addItem("...");

        Collections.sort(cont);
        Collections.sort(lang);

        for(String continent : cont){
            continents.addItem(continent);
        }

        for(String langage : lang){
            langages.addItem(langage);
        }

        JButton createXSL = new JButton("Générer XSL");
        createXSL.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                // Création des fichiers XSL selon ce qui est demandé

                String query = "/countries/element[";
                if(!Objects.equals(continents.getSelectedItem(), "...")){
                    query += "region=\"" + Objects.requireNonNull(continents.getSelectedItem()).toString() + "\" and ";
                }
                if(!Objects.equals(langages.getSelectedItem(), "...")){
                    query += "languages/element/name=\"" + Objects.requireNonNull(langages.getSelectedItem()).toString() + "\" and ";
                }
                if(!superficieMin.getText().equals("")){
                    query += "area >= " + superficieMin.getText() + " and ";
                }
                if(!superficieMax.getText().equals("")){
                    query += "area <= " + superficieMax.getText() + " and ";
                }

                if(query.length() == 19){
                    query = query.substring(0, 18);
                }else{
                    query = query.substring(0, query.length() -5);
                    query += "]";
                }

                new XSLCreator(query);
            }

        });

        /*
          A compléter : Remplissage des listes de recherche (avec les continents et les langues parlées dans l'ordre alphabétique)
         */


        JPanel panelRecherche = new JPanel(new FlowLayout());
        panelRecherche.add(new JLabel("Choix d'un continent"));
        panelRecherche.add(continents);

        panelRecherche.add(new JLabel("Choix d'une langue"));
        panelRecherche.add(langages);

        panelRecherche.add(new JLabel("Superficie minimume"));
        panelRecherche.add(superficieMin);

        panelRecherche.add(new JLabel("Superficie maximum"));
        panelRecherche.add(superficieMax);

        panelRecherche.add(createXSL);

        add(panelRecherche, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Interface de recherche de pays");


    }

    private static boolean isInList(String s, LinkedList<String> l){
        for(String isIn : l)
            if(isIn.equals(s)) return false;
        return true;
    }

    static void addContinent(String continent){
        if(isInList(continent, cont)){
            cont.add(continent);
        }
    }

    static void addLangue(String langue){
        if(isInList(langue, lang)){
            lang.add(langue);
        }
    }

    public static void main(String ... args) {

        new InterfaceRecherchePays(new File("exportfile/countries.xml"));

    }

}
