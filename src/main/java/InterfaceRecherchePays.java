import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class InterfaceRecherchePays extends JFrame {

    private JPanel panelRecherche = new JPanel(new FlowLayout());

    private JComboBox<String> continents = new JComboBox();
    private JComboBox<String> langages = new JComboBox();
    private JButton createXSL = new JButton("Générer XSL");
    private JTextField superficieMin = new JTextField(5);
    private JTextField superficieMax = new JTextField(5);

    private static LinkedList<String> cont = new LinkedList<String>();
    private static LinkedList<String> lang = new LinkedList<String>();

    public InterfaceRecherchePays(File xmlFile) {


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

        createXSL.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                // Création des fichiers XSL selon ce qui est demandé

                /** A compléter... **/
                String query = "//element[";
                if(!continents.getSelectedItem().equals("...")){
                    query += "region=\"" + continents.getSelectedItem().toString() + "\" and ";
                }
                if(!langages.getSelectedItem().equals("...")){
                    query += "languages/element/name=\"" + langages.getSelectedItem().toString() + "\" and ";
                }
                if(!superficieMin.getText().equals("")){
                    query += "area >= " + superficieMin.getText() + " and ";
                }
                if(!superficieMax.getText().equals("")){
                    query += "area <= " + superficieMax.getText() + " and ";
                }

                if(query.length() == 10){
                    query = query.substring(0, 9);
                }else{
                    query = query.substring(0, query.length() -5);
                    query += "]";
                }

                System.out.println(query);

                new XSLCreator(query);



            }

        });

        /**
         * A compléter : Remplissage des listes de recherche (avec les continents et les langues parlées dans l'ordre alphabétique)
         */


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
            if(isIn.equals(s)) return true;
        return false;
    }

    public static void addContinent(String continent){
        if(!isInList(continent, cont)){
            cont.add(continent);
        }
    }

    public static void addLangue(String langue){
        if(!isInList(langue, lang)){
            lang.add(langue);
        }
    }

    public static void main(String ... args) {

        new InterfaceRecherchePays(new File("countries.xml"));

    }

}
