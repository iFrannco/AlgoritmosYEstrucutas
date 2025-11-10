package tp03.ejercicio9;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp03.estructuras.ArbolBinarioDeBusqueda;

public class Main {
    public static void main(String[] args) {
        ArbolBinarioDeBusqueda<Integer> nodo100 = new ArbolBinarioDeBusqueda<>(100);
        ArbolBinarioDeBusqueda<Integer> nodo20 = new ArbolBinarioDeBusqueda<>(20);
        ArbolBinarioDeBusqueda<Integer> nodo300 = new ArbolBinarioDeBusqueda<>(300);
        ArbolBinarioDeBusqueda<Integer> nodo4 = new ArbolBinarioDeBusqueda<>(4);
        ArbolBinarioDeBusqueda<Integer> nodo30 = new ArbolBinarioDeBusqueda<>(30);
        ArbolBinarioDeBusqueda<Integer> nodo150 = new ArbolBinarioDeBusqueda<>(150);
        ArbolBinarioDeBusqueda<Integer> nodo25 = new ArbolBinarioDeBusqueda<>(25);
        ArbolBinarioDeBusqueda<Integer> nodo40 = new ArbolBinarioDeBusqueda<>(40);
        ArbolBinarioDeBusqueda<Integer> nodo23 = new ArbolBinarioDeBusqueda<>(23);

        nodo100.agregarHijoIzquierdo(nodo20);
        nodo100.agregarHijoDerecho(nodo300);

        nodo20.agregarHijoIzquierdo(nodo4);
        nodo20.agregarHijoDerecho(nodo30);

        nodo300.agregarHijoIzquierdo(nodo150);

        nodo30.agregarHijoIzquierdo(nodo25);
        nodo30.agregarHijoDerecho(nodo40);

        nodo25.agregarHijoIzquierdo(nodo23);

        System.out.println("--------------------------");
        System.out.println("recorrido");

        ListaGenerica<Integer> resultado = nodo100.caminoRecorrido(nodo25);
        resultado.comenzar();
        while (!resultado.fin()) {
            System.out.println(resultado.proximo());
        }
    }
}
