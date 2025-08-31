package tp01.ejercicio4;

import tp01.ejercicio3.PilaGenerica;

public class TestBalanceo {

    public boolean estaBalanceado(String palabra) {
        if (palabra == null) return false;
        if (palabra.isBlank()) return true;

        PilaGenerica<Character> pilaDeControl = new PilaGenerica<>();

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (esDeApertura(c)) {
                pilaDeControl.apilar(c);
            } else if (esDeCierre(c)) {
                if (pilaDeControl.esVacia()) {
                    return false; // cierre sin apertura
                }
                if (!mismoSimbolo(pilaDeControl.tope(), c)) {
                    return false; // tipos no coinciden
                }
                pilaDeControl.desapilar();
            }
        }

        return pilaDeControl.esVacia();
    }

    private boolean mismoSimbolo(char apertura, char cierre) {
        return (apertura == '{' && cierre == '}') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '(' && cierre == ')');
    }

    private boolean esDeCierre(char c) {
        return c == '}' || c == ')' || c == ']';
    }

    private boolean esDeApertura(char c) {
        return c == '{' || c == '(' || c == '[';
    }
}
