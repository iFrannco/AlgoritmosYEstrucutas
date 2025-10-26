package tp06.estructuras;

/**
 * Representa una Vertice de un grafo.
 *
 *
 */
public interface Vertice<T> {

    public T dato();

    public void setDato(T dato);

    public int getPosicion();

    void setPosicion(int i);
}
