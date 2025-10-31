package tp06.estructuras.implementacionLista;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {
    private ListaGenerica<Arista<T>> adyacentes;
    private T dato;
    private int posision;

    public VerticeImplListAdy(T dato) {
        this.dato = dato;
        this.adyacentes = new ListaEnlazadaGenerica<>();
    }

    @Override
    public T dato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getPosicion() {
        return this.posision;
    }

    @Override
    public void setPosicion(int i) {
        this.posision = i;
    }

    public ListaGenerica<Arista<T>> obtenerAdyacentes() {
        return this.adyacentes;
    }
}
