package tp01.ejercicio3;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;

public class PilaGenerica<T> {

    private ListaGenerica<T> datos;

    public PilaGenerica() {
        this.datos = new ListaEnlazadaGenerica<>();
    }

    public void apilar(T elem) {
        datos.agregarInicio(elem);
    }

    public T desapilar() {
        T tope = datos.elemento(1);
        datos.eliminarEn(1);
        return tope;
    }

    public T tope() {
        return datos.elemento(1);
    }

    public boolean esVacia() {
        return datos.esVacia();
    }
}
