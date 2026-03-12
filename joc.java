import java.util.Scanner;

public class joc {

    static Scanner e = new Scanner(System.in);

    private personatge jugador1;
    private personatge jugador2;

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
            System.out.println("3. Sortir");
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
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }

        } while (op != 3);
    }

    public void CrearPersonatge() {

        System.out.println("--- Jugador 1 ---");
        jugador1 = crearUn();

        System.out.println("--- Jugador 2 ---");
        jugador2 = crearUn();

        arma espasa = new arma("Espasa", arma.TipusA.espasa, false, 30);
        arma basto = new arma("Bastó màgic", arma.TipusA.basto, true, 50);

        jugador1.afegirArma(espasa);
        jugador1.afegirArma(basto);

        jugador2.afegirArma(espasa);
        jugador2.afegirArma(basto);

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

    private double[] manual() {
    double[] stats = new double[6];
    String[] noms = {"Força", "Destresa", "Constitució", "Intel·ligència", "Saviesa", "Carisma"};

    for (int i = 0; i < 6; i++) {
        double v;
        do {
            System.out.print(noms[i] + " (5-20): ");
            v = llegirInt();
        } while (v < 5 || v > 20);
        stats[i] = v;
    }
    return stats;
    }

    private double[] automatic() {
    double[] stats = new double[6];
    for (int i = 0; i < 6; i++) {
        stats[i] = (int)(Math.random() * 16) + 5; // 5-20
    }
    return stats;
    }

    private int llegirInt() {
    while (!e.hasNextInt()) {
        e.next();
        System.out.print("Número: ");
    }
    int x = e.nextInt();
    e.nextLine();
    return x;
}
}