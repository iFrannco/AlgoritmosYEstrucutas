package tp05;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp05.estructuras.MinHeap;

public class Main {
    public static void main(String[] args) {
        ListaGenerica<Integer> listaGenerica = new ListaEnlazadaGenerica<>();
        listaGenerica.agregarFinal(15);
        listaGenerica.agregarFinal(10);
        listaGenerica.agregarFinal(20);
        listaGenerica.agregarFinal(17);
        listaGenerica.agregarFinal(8);
        listaGenerica.agregarFinal(25);
        listaGenerica.agregarFinal(5);

        // [15, 10, 20, 17, 8, 25, 5]

        MinHeap<Integer> minHeap = new MinHeap<>(listaGenerica);
        minHeap.imprimir();


    }
}
