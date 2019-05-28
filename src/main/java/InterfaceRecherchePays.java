import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public class InterfaceRecherchePays extends JFrame {

    private LinkedList<Pays> pays;

    private JPanel panelRecherche = new JPanel(new FlowLayout());

    private JComboBox<String> continents = new JComboBox();
    private JComboBox<String> langages = new JComboBox();
    private JButton createXSL = new JButton("Générer XSL");
    private JTextField superficieMin = new JTextField(5);
    private JTextField superficieMax = new JTextField(5);

    public InterfaceRecherchePays(File xmlFile) {

        pays = new LinkedList<Pays>();

        createXSL.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                // Création des fichiers XSL selon ce qui est demandé

                /** A compléter... **/

            }

        });

        /**
         * A compléter : Remplissage des listes de recherche (avec les continents et les langues parlées dans l'ordre alphabétique)
         */

        setLayout(new BorderLayout());
        LinkedList<String> conts = new LinkedList<String>();
        LinkedList<String> langues = new LinkedList<String>();
        for(Pays p : pays){
            if(!isInList(p.getContinent(), conts)){
                conts.add(p.getContinent());
            }
            for(String lang : p.getLangues()){
                if(!isInList(lang, langues)){
                    conts.add(lang);
                }
            }
        }

        for(String cont : conts){
            continents.addItem(cont);
        }

        for(String langue : langues){
            langages.addItem(langue);
        }

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

    private boolean isInList(String s, LinkedList<String> l){
        for(String isIn : l)
            if(isIn.equals(s)) return true;
        return false;
    }

    public static void main(String ... args) {

        new InterfaceRecherchePays(new File("countries.xml"));

    }

}
