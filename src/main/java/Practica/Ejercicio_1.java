package Practica;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class Ejercicio_1 {

    public ListaGenerica<String> buscarCamino(Grafo<String> ciudades, String origen, String destino, String pasandoPor) {
        if (!ciudades.esVacio()) {
            // Verifico la existencia de la ciudad origen y destino
            ListaGenerica<Vertice<String>> verticesCiudades = ciudades.listaDeVertices();
            verticesCiudades.comenzar();
            int ciudadesEncontradas = 0;
            Vertice<String> verticeOrigen = null;
            while (!verticesCiudades.fin() && !(ciudadesEncontradas == 2)) {
                Vertice<String> v = verticesCiudades.proximo();
                if (v.dato().equals(origen)) {
                    verticeOrigen = v;
                    ciudadesEncontradas++;
                } else if (v.dato().equals(destino)) {
                    ciudadesEncontradas++;
                }
            }

            if (ciudadesEncontradas != 2) return new ListaEnlazadaGenerica<String>();

            boolean[] visitados = new boolean[verticesCiudades.tamanio() + 1];
            ListaGenerica<String> caminoPosible = new ListaEnlazadaGenerica<>();
            ListaGenerica<ListaGenerica<String>> listaDeCaminos = new ListaEnlazadaGenerica<>();

            dfs(ciudades, listaDeCaminos, caminoPosible, visitados, verticeOrigen, destino);

            // teniendo los caminos posibles, si alguno cumple con la condicion de pasar por la ciudad de interes, lo retorno.
            // si no, retorno el primero, y si no hay ningun camino retorno una lista vacia.

            if (!listaDeCaminos.esVacia()) {
                listaDeCaminos.comenzar();
                while (!listaDeCaminos.fin()) {
                    ListaGenerica<String> listaActual = listaDeCaminos.proximo();
                    if (listaActual.incluye(pasandoPor)) {
                        return listaActual;
                    }
                }
                listaDeCaminos.comenzar();
                return listaDeCaminos.proximo();
            }
        }

        return new ListaEnlazadaGenerica<>();
    }

    private void dfs(Grafo<String> grafo, ListaGenerica<ListaGenerica<String>> listaDeCaminos,
                     ListaGenerica<String> caminoPosible, boolean[] visitados, Vertice<String> vertice,
                     String destino) {

        visitados[vertice.getPosicion()] = true;
        caminoPosible.agregarFinal(vertice.dato());

        if (vertice.dato().equals(destino)) {
            listaDeCaminos.agregarFinal(copiar(caminoPosible));
        } else {
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vertice);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Arista<String> arista = adyacentes.proximo();
                Vertice<String> v = arista.verticeDestino();
                if (!visitados[v.getPosicion()]) {
                    dfs(grafo, listaDeCaminos, caminoPosible, visitados, v, destino);
                }
            }
        }

        // ya sea porque encontro un camino valido o porque llego al final de los adyacentes, se quita el nodo actual
        // y se vuelve en la recursion para buscar otro camino.
        caminoPosible.eliminarEn(caminoPosible.tamanio());
        visitados[vertice.getPosicion()] = false;

    }

    private ListaGenerica<String> copiar(ListaGenerica<String> original) {
        ListaGenerica<String> copia = new ListaEnlazadaGenerica<>();
        original.comenzar();
        while (!original.fin()) {
            copia.agregarFinal(original.proximo());
        }

        return copia;
    }

}
