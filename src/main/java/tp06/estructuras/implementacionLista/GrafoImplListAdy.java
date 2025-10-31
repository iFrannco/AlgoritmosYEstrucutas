package tp06.estructuras.implementacionLista;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.AristaImpl;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class GrafoImplListAdy<T> implements Grafo<T> {
    private ListaGenerica<Vertice<T>> vertices;

    public GrafoImplListAdy() {
        this.vertices = new ListaEnlazadaGenerica<>();
    }

    @Override
    public void agregarVertice(Vertice<T> v) {
        if (!vertices.incluye(v)) {
            v.setPosicion(vertices.tamanio() + 1);
            vertices.agregarFinal(v);
        }
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        // recorrer las listas de adyacencia eliminando el vertice
        vertices.comenzar();
        while (!vertices.fin()) {
            VerticeImplListAdy<T> verticeActual = (VerticeImplListAdy<T>) vertices.proximo();
            ListaGenerica<Arista<T>> listaDeAdyacentes = verticeActual.obtenerAdyacentes();
            listaDeAdyacentes.comenzar();
            while (!listaDeAdyacentes.fin()) {
                Arista<T> arista = listaDeAdyacentes.proximo();
                if (arista.verticeDestino().dato().equals(v.dato())) {
                    listaDeAdyacentes.eliminar(arista);
                }
            }
        }

        // eliminar el vertice de la lista
        vertices.eliminar(v);

    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        // si es un grafo dirigido
        // añado el destino a la lista de adyacentes del origen.

        if (vertices.incluye(origen) && vertices.incluye(destino)) {
            ListaGenerica<Arista<T>> listaAdyacentes = ((VerticeImplListAdy<T>) origen).obtenerAdyacentes();
            listaAdyacentes.agregarFinal(new AristaImpl<>(destino, 0));
        }
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        if (vertices.incluye(origen) && vertices.incluye(destino)) {
            ListaGenerica<Arista<T>> listaAdyacentes = ((VerticeImplListAdy<T>) origen).obtenerAdyacentes();
            listaAdyacentes.agregarFinal(new AristaImpl<>(destino, peso));
        }
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        if (vertices.incluye(origen) && vertices.incluye(destino)) {
            ListaGenerica<Arista<T>> listaAdyacentes = ((VerticeImplListAdy<T>) origen).obtenerAdyacentes();
            listaAdyacentes.comenzar();
            int encontrado = 0;
            while (!listaAdyacentes.fin() && encontrado == 0) {
                Arista<T> aristaActual = listaAdyacentes.proximo();
                if (aristaActual.verticeDestino().dato().equals(destino.dato())) {
                    listaAdyacentes.eliminar(aristaActual);
                    encontrado = 1;
                }
            }
        }
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        ListaGenerica<Arista<T>> adyacentes = ((VerticeImplListAdy<T>) origen).obtenerAdyacentes();
        adyacentes.comenzar();

        while (!adyacentes.fin()) {
            Arista<T> aristaActual = adyacentes.proximo();
            if (aristaActual.verticeDestino().dato().equals(destino.dato())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        int peso = 0;

        ListaGenerica<Arista<T>> listaAdyacentes = ((VerticeImplListAdy<T>) origen).obtenerAdyacentes();
        listaAdyacentes.comenzar();
        int encontrado = 0;
        while (!listaAdyacentes.fin() && encontrado == 0) {
            Arista<T> aristaActual = listaAdyacentes.proximo();
            if (aristaActual.verticeDestino().dato().equals(destino.dato())) {
                peso = aristaActual.peso();
                encontrado = 1;
            }
        }

        return peso;
    }

    @Override
    public boolean esVacio() {
        return this.vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return this.vertices;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        ListaGenerica<Arista<T>> resultado = new ListaEnlazadaGenerica<>();
        vertices.comenzar();
        int encontrado = 0;
        while (!vertices.fin() && encontrado == 0) {
            VerticeImplListAdy<T> verticeActual = (VerticeImplListAdy<T>) vertices.proximo();
            if (verticeActual.equals(v)) {
                resultado = verticeActual.obtenerAdyacentes();
                encontrado = 1;
            }
        }
        return resultado;
    }

    @Override
    public Vertice<T> vetice(int posicion) {
        vertices.comenzar();
        while (vertices.fin()) {
            Vertice<T> verticeActual = vertices.proximo();
            if (verticeActual.getPosicion() == posicion) {
                return verticeActual;
            }
        }
        return null;
    }
}
