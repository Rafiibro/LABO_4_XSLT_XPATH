import java.util.LinkedList;
import java.util.List;

public class Pays {
    private LinkedList<String> langues; //Balise languages -> element -> name
    private int superficie; //Balise area
    private int population; //Balise population
    private String nom; //Balise translations -> fr
    private String drapeau; //Balise flag
    private String capitale; //Balise capital
    private String continent; //Balise region
    private String sousContinent; //Balise subregion

    public Pays(){
        langues = new LinkedList<String>();
    }

    public List<String> getLangues(){
        return langues;
    }

    public void addLangues(String s){
        langues.add(s);
    }

    public int getSuperficie(){
        return superficie;
    }

    public void setSuperficie(int i){
        superficie = i;
    }

    public int getPopulation(){
        return population;
    }

    public void setPopulation(int i){
        population = i;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String s){
        nom = s;
    }

    public String getDrapeau(){
        return drapeau;
    }

    public void setDrapeau(String s){
        drapeau = s;
    }

    public String getCapitale(){
        return capitale;
    }

    public void setCapitale(String s){
        capitale = s;
    }

    public String getContinent(){
        return continent;
    }

    public void setContinent(String s){
        continent = s;
    }

    public String getSousContinent(){
        return sousContinent;
    }

    public void setSousContinent(String s){
        sousContinent = s;
    }

}