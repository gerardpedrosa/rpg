import java.util.ArrayList;
import java.util.Scanner;

public class joc {

    static Scanner e = new Scanner(System.in);

    private personatge jugador1;
    private personatge jugador2;
    private ArrayList<arma> armesDisponibles = new ArrayList<>();

    public static void main(String[] args) {
        joc j = new joc();
        j.Menu();
    }

    public void Menu() {
        
        int op;

        do {
            System.out.println("=== MENÚ ===");
            System.out.println("1. Crear personatges");
            System.out.println("2. Jugar combat");
            System.out.println("3. Crear arma");
            System.out.println("4. Sortir");
            op = llegirInt();

            switch (op) {
                case 1:
                    CrearPersonatge();
                    break;
                case 2:
                    if (jugador1 == null || jugador2 == null) {
                        System.out.println("Primer crea els personatges.");
                    } else {
                        //jugar();
                    }
                    break;
                case 3:
                    crearArma();
                    break;
                case 4:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }

        } while (op != 4);
    }   


    public void CrearPersonatge() {

        if (armesDisponibles.isEmpty()) {
            System.out.println("No hi ha armes creades. Crea'n alguna primer.");
            return;
        }

        System.out.println("--- Jugador 1 ---");
        jugador1 = crearUn();

        System.out.println("Armes disponibles:");
        for (int i = 0; i < armesDisponibles.size(); i++) {
            System.out.println(i + " - " + armesDisponibles.get(i).getNom());
        }
        System.out.println("Tria dues armes:");
        jugador1.afegirArma(armesDisponibles.get(llegirInt()));
        jugador1.afegirArma(armesDisponibles.get(llegirInt()));

        System.out.println("--- Jugador 2 ---");
        jugador2 = crearUn();

        System.out.println("Armes disponibles:");
        for (int i = 0; i < armesDisponibles.size(); i++) {
            System.out.println(i + " - " + armesDisponibles.get(i).getNom());
        }
        System.out.println("Tria dues armes:");
        jugador2.afegirArma(armesDisponibles.get(llegirInt()));
        jugador2.afegirArma(armesDisponibles.get(llegirInt()));

        System.out.println("Personatges creats.");
    }

    public personatge crearUn() {

    System.out.print("Nom: ");
    String nom = e.nextLine();

    System.out.print("Edat: ");
    int edat = llegirInt();

    System.out.println("Raça: 1-Huma 2-Elf 3-Orc 4-Nan");
    int r = llegirInt();
    personatge.Race raca = personatge.Race.huma;
    if (r == 2) raca = personatge.Race.elf;
    if (r == 3) raca = personatge.Race.orc;
    if (r == 4) raca = personatge.Race.nan;

    System.out.println("Punts: 1-Manual 2-Automatic");
    int op = llegirInt();

    double[] stats;
    if (op == 1) stats = manual();
    else stats = automatic();

    return new personatge(nom, edat, raca, stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    public double[] manual() {
    double[] stats = new double[6];
    String[] noms = {"Força", "Destresa", "Constitució", "Intel·ligència", "Saviesa", "Carisma"};

    for (int i = 0; i < 6; i++) {
    double valor;
    do {
        System.out.print(noms[i] + " (5-20): ");
        valor = llegirInt();
    } while (valor < 5 || valor > 20);
    stats[i] = valor;
    }

    return stats;
    }

    public double[] automatic() {
    double[] stats = new double[6];
    for (int i = 0; i < 6; i++) {
        stats[i] = (int)(Math.random() * 16) + 5; // 5-20
    }
    return stats;
    }

    public void crearArma() {

    System.out.print("Nom de l'arma: ");
    String nom = e.nextLine();

    System.out.println("Tipus: 1-Espasa 2-Destral 3-Bastó 4-Arc");
    int t = llegirInt();

    arma.TipusA tipus = arma.TipusA.espasa;
    if (t == 2) tipus = arma.TipusA.destral;
    if (t == 3) tipus = arma.TipusA.basto;
    if (t == 4) tipus = arma.TipusA.arc;

    System.out.println("És màgica? 1-Sí 2-No");
    boolean magia = (llegirInt() == 1);

    double dany;
    do {
        System.out.print("Dany base (1-35): ");
        dany = llegirInt();
    } while (dany < 1 || dany > 35);

    arma nova = new arma(nom, tipus, magia, dany);
    armesDisponibles.add(nova);

    System.out.println("Arma creada correctament!");
    }

    public int llegirInt() {
    int num = 0;
    boolean ok = false;

    while (!ok) {
        try {
            num = Integer.parseInt(e.nextLine());
            ok = true;
        } catch (Exception ex) {
            System.out.println("Error. Escriu un número.");
        }
    }

    return num;
    }

}