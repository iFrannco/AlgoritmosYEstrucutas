package Practica;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;

public class Ejercicio_5 {
    public String generarFrase(ArbolGeneral<String> arbol) {
        StringBuilder resultado = new StringBuilder();
        resultado.append('"');
        if (!arbol.esVacio()) {
            ColaGenerica<ArbolGeneral<String>> cola = new ColaGenerica<>();
            cola.encolar(arbol);
            while (!cola.esVacia()) {
                ArbolGeneral<String> elem = cola.desencolar();

                ListaGenerica<ArbolGeneral<String>> hijos = elem.getHijos();
                for (int i = 1; i <= hijos.tamanio(); i++) {
                    cola.encolar(hijos.elemento(i));
                }

                if (!cola.esVacia()) {
                    resultado.append(elem.getDato() + " ");
                } else {
                    resultado.append(elem.getDato());
                }
            }
        }
        resultado.append(".\"");
        return resultado.toString();
    }
}
