package Practica;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class Ejercicio_Extra_2<T> {

    public ListaEnlazadaGenerica<Vertice<T>> verticesMayorA(Grafo<T> grafo, int cantVertices) {

        if (grafo.esVacio()) return new ListaEnlazadaGenerica<>();

        // crear una lista de vertices resultantes.
        ListaEnlazadaGenerica<Vertice<T>> resultado = new ListaEnlazadaGenerica<>();

        // recorrer la lista de vertices del grafo, y comprobar si cumple la condicion
        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        while (!vertices.fin()) {
            Vertice<T> verticeActual = vertices.proximo();
            if (grafo.listaDeAdyacentes(verticeActual).tamanio() > cantVertices) {
                resultado.agregarFinal(verticeActual);
            }
        }

        return resultado;
    }
}
