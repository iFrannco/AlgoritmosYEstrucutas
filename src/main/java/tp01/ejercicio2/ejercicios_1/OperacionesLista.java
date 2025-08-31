package tp01.ejercicio2.ejercicios_1;

import tp01.ejercicio2.estructuras.ListaGenerica;

public class OperacionesLista {
    public <T> void imprimirSentidoInverso(ListaGenerica<T> lista) {
        if (!lista.fin()) {
            T temp = lista.proximo();
            imprimirSentidoInverso(lista);
            System.out.println(temp);
        }
    }
}
