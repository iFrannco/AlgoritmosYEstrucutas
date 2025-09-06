package tp03.ejercicio3;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp03.estructuras.ArbolBinario;

public class Main {
    public static void main(String[] args) {
        ArbolBinario<Integer> nodo1 = new ArbolBinario<>(1);
        ArbolBinario<Integer> nodo2 = new ArbolBinario<>(2);
        ArbolBinario<Integer> nodo3 = new ArbolBinario<>(3);
        ArbolBinario<Integer> nodo4 = new ArbolBinario<>(4);
        ArbolBinario<Integer> nodo5 = new ArbolBinario<>(5);
        ArbolBinario<Integer> nodo6 = new ArbolBinario<>(6);
        ArbolBinario<Integer> nodo7 = new ArbolBinario<>(7);

        nodo1.agregarHijoIzquierdo(nodo2);
        nodo1.agregarHijoDerecho(nodo3);

        nodo2.agregarHijoIzquierdo(nodo4);
        nodo2.agregarHijoDerecho(nodo5);

        nodo3.agregarHijoIzquierdo(nodo6);
        nodo3.agregarHijoDerecho(nodo7);

        ContadorArbol contadorArbol = new ContadorArbol(nodo1);

        ListaGenerica<Integer> resultado = contadorArbol.numerosPares();
        for (int i = 1; i <= resultado.tamanio(); i++) {
            System.out.println(resultado.elemento(i));
        }
    }
}
