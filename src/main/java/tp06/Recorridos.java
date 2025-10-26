package tp06;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class Recorridos<T> {
    public ListaGenerica<T> dfs(Grafo<T> grafo) {

        // crear una lista de vertices visitados
        // recorrer los vertices, solo si estos no estan visitados ejecutar
        // el metodo recursivo para visitar sus nodos adyacentes.
        // dentro del metodo recursivo tambien verifico si se visito
        // ya que pude haberlo visitado desde fuera.

        ListaGenerica<T> resultado = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<T>> visitados = new ListaEnlazadaGenerica<>();
        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();

        vertices.comenzar();

        while (!vertices.fin()) {
            Vertice<T> vertice = vertices.proximo();
            if (!visitados.incluye(vertice)) {
                dfsRecursivo(grafo, visitados, resultado, vertice);
            }
        }

        return resultado;
    }

    private void dfsRecursivo(Grafo<T> grafo, ListaGenerica<Vertice<T>> visitados, ListaGenerica<T> resultado, Vertice<T> vertice) {

        visitados.agregarFinal(vertice);
        resultado.agregarFinal(vertice.dato());
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<T> arista = adyacentes.proximo();
            Vertice<T> verticeTemp = arista.verticeDestino();
            if (!visitados.incluye(verticeTemp)) {
                dfsRecursivo(grafo, visitados, resultado, verticeTemp);
            }
        }
    }


    public ListaGenerica<T> bfs(Grafo<T> grafo) {
        return null;
    }
}
