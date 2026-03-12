import java.lang.reflect.Array;
import java.util.ArrayList;

public class personatge {

    private String nom;
    private int edat;
    private Race raca;

    //caracteristiques generals
    private double salut;
    private double mana;

    //caracteristiques especifiques
    private double forca;
    private double destresa;
    private double constitucio;
    private double inteligencia;
    private double saviesa;
    private double carisma;
    private int ultimate;

    private ArrayList<arma> armes;
    private arma armaEquipada;

    public personatge(String nom, int edat, Race raca) {
        
        this.nom = nom;
        this.edat = edat;
        this.raca = raca;
        this.armes = new ArrayList<arma>();
    }

    public double atacar(){

    double dany;

    if(armaEquipada == null){
        dany = forca;
    }
    else if(!armaEquipada.getMagia()){
        dany = forca * (1 + armaEquipada.getDany()/100);
    }
    else{
        dany = armaEquipada.getDany() * inteligencia / 100;
    }

    ultimate++;

    dany = usarUltimate(dany);

    return dany;
}

    public void defensar(double dany) {
        salut -= dany - constitucio;
    }

    public void equiparArma(arma a) {
        armaEquipada = a;
    }

    public void afegirArma(arma a) {
        armes.add(a);
    }

    public void regenerarVida() {
        salut += constitucio * 0.5;
    }

    public void regenerarMana() {
        mana += inteligencia * 0.5;
    }

    public boolean esquivar() {
        return Math.random() * 100 < destresa;
    }

    public void rebreDany(double dany) {
        defensar(dany);   
    }

    public double usarUltimate(double dany){

    for(int i = 0; i < ultimate; i++){
        if(i == 3){
            dany = dany * 2;
            ultimate = 0;
        }
    }

    return dany;
    }

    public enum Race {
        huma, elf, orc, nan;
    }
}