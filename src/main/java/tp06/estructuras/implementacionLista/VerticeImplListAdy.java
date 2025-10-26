package tp06.estructuras.implementacionLista;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.estructuras.Arista;
import tp06.estructuras.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {
    private ListaGenerica<Arista<T>> adyacentes;
    private T dato;
    private int posision;

    public VerticeImplListAdy(T dato) {
        this.dato = dato;
    }

    @Override
    public T dato() {
        return null;
    }

    @Override
    public void setDato(T dato) {

    }

    @Override
    public int getPosicion() {
        return 0;
    }

    @Override
    public void setPosicion(int i) {

    }
}
