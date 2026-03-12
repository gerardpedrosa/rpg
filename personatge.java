import java.lang.reflect.Array;
import java.util.ArrayList;

public class personatge {

    private String nom;
    private int edat;
    private Race raca;

    private double salut;
    private double mana;
    private double forca;
    private double destresa;
    private double constitucio;
    private double inteligencia;
    private double saviesa;
    private double carisma;

    private ArrayList<arma> armes;
    private Arma armaEquipada;

    public personatge(String nom, int edat, Race raca) {

        this.nom = nom;
        this.edat = edat;
        this.raca = raca;
        this.armes = new ArrayList<arma>();
    }

    public double atacar() {
        if (armaEquipada != null) {
            return forca + armaEquipada.getDany();
        }
        return forca;
    }

    public void defensar(double dany) {
        salut -= dany - constitucio;
        if (salut < 0) {
            salut = 0;
        }
    }

    public void equiparArma(Arma a) {
        armaEquipada = a;
    }

    public void afegirArma(Arma a) {
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

    public enum Race {
        huma, elf, orc, nan;
    }
}