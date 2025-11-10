package pruebas;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp03.estructuras.ArbolBinarioDeBusqueda;

public class Main {
    public static void main(String[] args) {
        // imprimir un arbol de menor a mayor y de mayor a menor
        ArbolBinarioDeBusqueda<Integer> nodo15 = new ArbolBinarioDeBusqueda<>(15);
        ArbolBinarioDeBusqueda<Integer> nodo9 = new ArbolBinarioDeBusqueda<>(9);
        ArbolBinarioDeBusqueda<Integer> nodo20 = new ArbolBinarioDeBusqueda<>(20);
        ArbolBinarioDeBusqueda<Integer> nodo6 = new ArbolBinarioDeBusqueda<>(6);
        ArbolBinarioDeBusqueda<Integer> nodo14 = new ArbolBinarioDeBusqueda<>(14);
        ArbolBinarioDeBusqueda<Integer> nodo17 = new ArbolBinarioDeBusqueda<>(17);
        ArbolBinarioDeBusqueda<Integer> nodo64 = new ArbolBinarioDeBusqueda<>(64);
        ArbolBinarioDeBusqueda<Integer> nodo13 = new ArbolBinarioDeBusqueda<>(13);
        ArbolBinarioDeBusqueda<Integer> nodo26 = new ArbolBinarioDeBusqueda<>(26);
        ArbolBinarioDeBusqueda<Integer> nodo72 = new ArbolBinarioDeBusqueda<>(72);

        nodo15.agregarHijoIzquierdo(nodo9);
        nodo15.agregarHijoDerecho(nodo20);

        nodo9.agregarHijoIzquierdo(nodo6);
        nodo9.agregarHijoDerecho(nodo14);

        nodo20.agregarHijoIzquierdo(nodo17);
        nodo20.agregarHijoDerecho(nodo64);

        nodo14.agregarHijoIzquierdo(nodo13);

        nodo64.agregarHijoIzquierdo(nodo26);
        nodo64.agregarHijoDerecho(nodo72);

        System.out.println("longitud en aristas: " + nodo15.longitudAristas());
        ListaGenerica<Integer> resultado = nodo15.caminoMasLargoNodos();
        for (int i = 1; i <= resultado.tamanio(); i++) {
            System.out.println(resultado.elemento(i));
        }

        System.out.println("----------------------------------");
        System.out.println("Agregar a un arbol");

        ArbolBinarioDeBusqueda<Integer> arbol1 = new ArbolBinarioDeBusqueda<>();
        arbol1.agregar(8);
        arbol1.agregar(3);
        arbol1.agregar(10);
        arbol1.agregar(14);
        arbol1.agregar(13);
        arbol1.agregar(1);
        arbol1.agregar(6);
        arbol1.agregar(4);
        arbol1.agregar(7);

        System.out.println("el mayor de los menores: " + arbol1.buscarMayorDeLosMenores(arbol1).getDato());
    }
}
