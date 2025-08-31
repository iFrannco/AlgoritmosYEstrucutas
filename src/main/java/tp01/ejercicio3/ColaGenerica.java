package tp01.ejercicio3;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;

public class ColaGenerica<T> {
    private ListaGenerica<T> datos;

    public ColaGenerica() {
        this.datos = new ListaEnlazadaGenerica<>();
    }

    public void encolar(T elem) {
        datos.agregarFinal(elem);
    }

    public T desencolar() {
        T primero = datos.elemento(1);
        datos.eliminarEn(1);
        return primero;
    }

    public T tope() {
        return datos.elemento(1);
    }

    public boolean esVacia() {
        return datos.esVacia();
    }


}
