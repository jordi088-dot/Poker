import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carta c = new Carta(13, "♥");
        System.out.println(c);

        Mazo mazo = new Mazo(2);
        System.out.println(mazo);
        mazo.barajar();
        System.out.println(mazo);
        System.out.println("Carta extra: " + mazo.extraerCarta());
        Jugador jugador1 = new Jugador("Miguel");
        for (int i = 0; i < 4; i++) {
            jugador1.recibirCarta(mazo.extraerCarta());
        }
        System.out.println(jugador1);
        System.out.println(jugador1.getPuntuacion());
        mazo.barajar();
        System.out.println(mazo);
        Jugador jugador2 = new Jugador("Pablo");
        for (int j = 0; j < 2; j++) {
            jugador2.recibirCarta(mazo.extraerCarta());
        }
        System.out.println(jugador2);
        System.out.println(jugador2.getPuntuacion());
        System.out.println();
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            System.out.println(jugador2);
            System.out.println("Puntuación: " + jugador2.getPuntuacion());
            if (jugador2.getPuntuacion() > 21) {
                System.out.println("Has perdido!");
                gameOver = true;
            } else if (jugador2.getPuntuacion() == 21){
                gameOver = true;
                System.out.println("YOU WIN!!!");
            } else {
                System.out.println("¿Otra carta? (S/N)");
                String respuesta = input.nextLine().toUpperCase();
                if (respuesta.equals("S")) {
                    jugador2.recibirCarta(mazo.extraerCarta());
                    System.out.println(jugador2.getPuntuacion());
                } else {
                    System.out.println("Te plantas!");
                    gameOver = true;
                }
            }
        }
    }
}
