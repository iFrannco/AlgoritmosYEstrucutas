package tp06.estructuras.implementacionLista;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;

public class GrafoImplListAdy<T> implements Grafo<T> {
    private ListaGenerica<Vertice<T>> vertices;

    public GrafoImplListAdy() {
        this.vertices = new ListaEnlazadaGenerica<>();
    }

    @Override
    public void agregarVertice(Vertice<T> v) {

    }

    @Override
    public void eliminarVertice(Vertice<T> v) {

    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {

    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {

    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {

    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        return false;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return 0;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return null;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        return null;
    }

    @Override
    public Vertice<T> vetice(int posicion) {
        return null;
    }
}
