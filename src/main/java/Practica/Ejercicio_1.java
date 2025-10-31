package Practica;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class Ejercicio_1 {
    public ListaGenerica<String> buscarCamino(Grafo<String> ciudades, String origen, String destino, String
            pasandoPor) {

        ListaGenerica<Vertice<String>> listaVertices = ciudades.listaDeVertices();
        listaVertices.comenzar();
        Vertice<String> verticeorigen = null;
        int encontrado = 0;
        while (!listaVertices.fin() && encontrado != 2) {
            Vertice<String> verticeActual = listaVertices.proximo();
            if (verticeActual.dato().equals(origen)) {
                encontrado++;
                verticeorigen = verticeActual;
            } else if (verticeActual.dato().equals(destino)) {
                encontrado++;
            }
        }

        if (encontrado != 2) return new ListaEnlazadaGenerica<>();

        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        boolean[] enCamino = new boolean[listaVertices.tamanio() + 1];
        boolean existeCamino = dfsRecursivo(ciudades, camino, verticeorigen, destino, enCamino, pasandoPor);


        return existeCamino ? camino : new ListaEnlazadaGenerica<>();
    }

    private boolean dfsRecursivo(Grafo<String> grafo,
                                 ListaGenerica<String> camino,
                                 Vertice<String> nodoActual,
                                 String destino, boolean[] enCamino,
                                 String pasandoPor) {

        // en lugar de tener una lista de visitados, si forma parte de los nodos del camino, lo evito.
        if (enCamino[nodoActual.getPosicion()]) {
            return false;
        }

        enCamino[nodoActual.getPosicion()] = true;
        camino.agregarFinal(nodoActual.dato());

        if (nodoActual.dato().equals(destino)) {
            if (camino.incluye(pasandoPor)) {
                return true;
            } else {
                camino.eliminarEn(camino.tamanio());
                enCamino[nodoActual.getPosicion()] = false;
                return false;
            }
        }

        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(nodoActual);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> arista = adyacentes.proximo();
            Vertice<String> verticeTemp = arista.verticeDestino();
            if (dfsRecursivo(grafo, camino, verticeTemp, destino, enCamino, pasandoPor)) {
                return true;
            }

        }
        // quitar de la lista porque recorri sus adyacentes y no es el camino correcto.
        // ademas lo marco como que no forma parte del camino, para usarlo quizas en otro camino distino
        camino.eliminarEn(camino.tamanio());
        enCamino[nodoActual.getPosicion()] = false;
        return false;
    }
}
