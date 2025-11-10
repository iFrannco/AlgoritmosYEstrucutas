package Practica;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;

public class Ejercicio_2 {
    public void contarDescendientes(ArbolGeneral<String> arbolGenealogico) {
        ColaGenerica<ArbolGeneral<String>> cola = new ColaGenerica<>();
        cola.encolar(arbolGenealogico);

        while (!cola.esVacia()) {
            ArbolGeneral<String> elem = cola.desencolar();
            ListaGenerica<ArbolGeneral<String>> hijos = elem.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                cola.encolar(hijos.proximo());
            }
            if (!cola.esVacia()) {
                System.out.print(elem.getDato() + "(" + hijos.tamanio() + "), ");
            } else {
                System.out.print(elem.getDato() + "(" + hijos.tamanio() + ")");
            }
        }
    }

}
