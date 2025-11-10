package Practica;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class Ejercicio_6 {

    public ListaEnlazadaGenerica<String> aeropuertosAlternativos(Grafo<String> mapaAereo, String aeropuertoDestino) {

        ListaEnlazadaGenerica<String> resultado = new ListaEnlazadaGenerica<>();
        ColaGenerica<Vertice<String>> cola = new ColaGenerica<>();
        ColaGenerica<Integer> nivel = new ColaGenerica<>();
        ListaEnlazadaGenerica<String> visitados = new ListaEnlazadaGenerica<>();

        //buscar el destino
        ListaGenerica<Vertice<String>> aeropuertos = mapaAereo.listaDeVertices();
        Vertice<String> verticeDestino = null;
        aeropuertos.comenzar();
        while (!aeropuertos.fin()) {
            Vertice<String> verticeTemp = aeropuertos.proximo();
            if (verticeTemp.dato().equals(aeropuertoDestino)) {
                verticeDestino = verticeTemp;
            }
        }

        if (verticeDestino == null) return resultado;

        cola.encolar(verticeDestino);
        nivel.encolar(1);

        while (!cola.esVacia()) {
            Vertice<String> verticeActual = cola.desencolar();
            int nivelActual = nivel.desencolar();

            if (nivelActual > 2) {
                break;
            }

            visitados.agregarFinal(verticeActual.dato());
            ListaGenerica<Arista<String>> adyacentes = mapaAereo.listaDeAdyacentes(verticeActual);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Vertice<String> adyacenteTemp = adyacentes.proximo().verticeDestino();
                if (!visitados.incluye(adyacenteTemp.dato())) {
                    resultado.agregarFinal(adyacenteTemp.dato());
                    cola.encolar(adyacenteTemp);
                    nivel.encolar(nivelActual + 1);
                    visitados.agregarFinal(adyacenteTemp.dato());
                }
            }
        }

        return resultado;

    }
}
