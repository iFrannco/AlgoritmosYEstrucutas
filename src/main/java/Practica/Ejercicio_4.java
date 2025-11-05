package Practica;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class Ejercicio_4 {

    public boolean recorridoMaratonValido(Grafo<String> posibleRecorrido, String largada) {

        ListaGenerica<Vertice<String>> calles = posibleRecorrido.listaDeVertices();
        Vertice<String> verticeLargada = null;
        calles.comenzar();
        while (!calles.fin()) {
            Vertice<String> actual = calles.proximo();
            if (actual.dato().equals(largada)) {
                verticeLargada = actual;
            }
        }

        if (verticeLargada == null) return false;

        boolean[] enCamino = new boolean[posibleRecorrido.listaDeVertices().tamanio() + 1];
        int profundidad = 0;

        return dfs(posibleRecorrido, verticeLargada, largada, enCamino, profundidad);

    }

    private boolean dfs(Grafo<String> posibleRecorrido, Vertice<String> verticeActual,
                        String largada, boolean[] enCamino, int profundidad) {

        enCamino[verticeActual.getPosicion()] = true;


        ListaGenerica<Arista<String>> adyacentes = posibleRecorrido.listaDeAdyacentes(verticeActual);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> aristaTemp = adyacentes.proximo();
            Vertice<String> verticeTemp = aristaTemp.verticeDestino();
            if (verticeTemp.dato().equals(largada) && profundidad >= 2) {
                return true;
            }
            if (!enCamino[verticeTemp.getPosicion()]) {
                return dfs(posibleRecorrido, verticeTemp, largada, enCamino, profundidad + 1);
            }
        }

        enCamino[verticeActual.getPosicion()] = false;
        return false;
    }
}
