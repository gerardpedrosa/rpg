import java.util.Scanner;

public class joc {
    
    static Scanner e = new Scanner(System.in);
    public static void main(String[] args){
        joc p = new joc();
        p.menu();
    }

    static void menu(){
        String jugador1;
        String jugador2;

        demanrJugadors(jugador1, jugador2);
    }

    static String demanrJugadors (String jugador1, String jugador2){ {

        System.out.println("Registrar Jugadors");
        System.out.println("Jugador 1:");
        jugador1 = e.nextLine();
        System.out.println("Jugador 2:");
        jugador2 = e.nextLine();

        return jugador1 + " vs " + jugador2;
    }

    
}
