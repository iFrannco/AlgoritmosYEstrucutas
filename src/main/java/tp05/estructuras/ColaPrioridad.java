package tp05.estructuras;

public interface ColaPrioridad<T> {
    boolean esVacia();

    void eliminar();

    boolean agregar(T elemento);

    T tope();
}
