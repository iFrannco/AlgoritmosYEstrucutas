package Practica;

import tp03.estructuras.ArbolBinarioDeBusqueda;

public class Resolucion {

    public static void main(String args[]) {
        ArbolBinarioDeBusqueda<Persona> p1 = new ArbolBinarioDeBusqueda<>(new Persona("2"));
        ArbolBinarioDeBusqueda<Persona> p2 = new ArbolBinarioDeBusqueda<>(new Persona("1"));
        ArbolBinarioDeBusqueda<Persona> p3 = new ArbolBinarioDeBusqueda<>(new Persona("3"));

        p1.agregarHijoIzquierdo(p2);
        p1.agregarHijoDerecho(p3);

        Persona personaBuscada = buscarPorDNI(p1, new Persona("2"));

        System.out.print(personaBuscada);
    }

    public static Persona buscarPorDNI(ArbolBinarioDeBusqueda<Persona> arbol, Persona personaBuscada) {
        Persona persona = null;

        if (!arbol.esVacio()) {
            int cmp = personaBuscada.compareTo(arbol.getDato());
            if (cmp == 0) {
                persona = personaBuscada;
            } else if (cmp < 0) {
                // me dio menor a cero porque la persona que estoy buscando es menor a lo que hay en ese nodo
                // por lo que tengo que ir por la izquierda
                if (arbol.tieneHijoIzquierdo()) {
                    persona = buscarPorDNI(arbol.getHijoIzquierdo(), personaBuscada);
                }

            } else {
                if (arbol.tieneHijoDerecho()) {
                    persona = buscarPorDNI(arbol.getHijoDerecho(), personaBuscada);
                }
            }
        }
        return persona;
    }

}
