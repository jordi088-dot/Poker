public class Carta {
    private int numero;
    static final String[] PALOS = {"♠", "♥", "♦", "♣"};
    private String palo;

    public Carta(int numero, String palo){
        this.numero = numero;
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        String s = "";
        if (numero == 11) {
            s = "J";
        } else if (numero == 12) {
            s = "Q";
        } else if (numero == 13) {
            s = "K";
        } else {
          s += numero;
        }
        s += " de " + palo;
        return s;
    }
}