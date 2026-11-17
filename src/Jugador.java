public class Jugador {
    private String nombreJugador;
    private Carta[] cartas;
    private int numCartas;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        numCartas = 0;
        cartas = new Carta[20];
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = null;
        }
    }

    public void recibirCarta(Carta carta) {
        cartas[numCartas] = carta;
        numCartas++;
    }

    public int getPuntuacion() {
        int puntos = 0;
        for (int j = 0; j < numCartas; j++) {
            int numero = cartas[j].getNumero();
            if (numero >= 2 && numero <= 10) {
                puntos += numero;
            } else {
                if (numero >= 11) {
                    puntos += 10;
                } else { //AS
                    puntos += 11;
                    if (puntos > 21) {
                        puntos -= 10;
                    }
                }
            }
        }
        return puntos;
    }

    @Override
    public String toString() {
        String s = nombreJugador + ": ";
        boolean first = true;
        for (int i = 0; i < numCartas; i++) {
            if (first) {
                s += cartas[i];
                first = false;
            } else {
                s += ", " + cartas[i];
            }

        }
        return s;
    }
}
