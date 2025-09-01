package tp02.estructuras;

import tp01.ejercicio2.estructuras.ListaGenerica;

public class Main {
    public static void main(String[] args) {
        ArbolGeneral<String> nodo1 = new ArbolGeneral<>("a");
        ArbolGeneral<String> nodo2 = new ArbolGeneral<>("b");
        ArbolGeneral<String> nodo3 = new ArbolGeneral<>("c");
        ArbolGeneral<String> nodo4 = new ArbolGeneral<>("d");
        ArbolGeneral<String> nodo5 = new ArbolGeneral<>("e");
        ArbolGeneral<String> nodo6 = new ArbolGeneral<>("f");
        ArbolGeneral<String> nodo7 = new ArbolGeneral<>("g");

        nodo1.agregarHijo(nodo2);
        nodo1.agregarHijo(nodo3);
        nodo2.agregarHijo(nodo4);
        nodo2.agregarHijo(nodo5);
        nodo3.agregarHijo(nodo6);
        nodo3.agregarHijo(nodo7);

        long inicio = System.nanoTime();
        ListaGenerica<String> lista = nodo1.preOrden();
        long fin = System.nanoTime();
        System.out.println("Tiempo: " + (fin - inicio) + " ns");
        for (int i = 1; i <= lista.tamanio(); i++) {
            System.out.println(lista.elemento(i));
        }

    }
}
