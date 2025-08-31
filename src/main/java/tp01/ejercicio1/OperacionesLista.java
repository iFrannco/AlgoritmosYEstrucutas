package tp01.ejercicio1;

import tp01.ejercicio1.estructuras.ListaDeEnteros;

public class OperacionesLista {
    public void imprimirSentidoInverso(ListaDeEnteros lista) {
        if (!lista.esVacia() && !lista.fin()) {
            int proximo = lista.proximo();
            imprimirSentidoInverso(lista);
            System.out.println(proximo);
        }
    }
}
