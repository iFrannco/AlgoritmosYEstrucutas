package tp02.estructuras;


import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;

import java.util.HashMap;
import java.util.Map;

public class ArbolGeneral<T> {

    private T dato;

    private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

    public ArbolGeneral(T dato) {
        this.dato = dato;
    }

    public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
        this(dato);
        if (hijos == null)
            this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
        else
            this.hijos = hijos;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public ListaGenerica<ArbolGeneral<T>> getHijos() {
        return this.hijos;
    }

    public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
        if (hijos == null)
            this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
        else
            this.hijos = hijos;
    }

    public void agregarHijo(ArbolGeneral<T> unHijo) {

        this.getHijos().agregarFinal(unHijo);
    }

    public boolean esHoja() {

        return !this.tieneHijos();
    }

    public boolean tieneHijos() {
        return !this.hijos.esVacia();
    }

    public boolean esVacio() {
        return this.dato == null && !this.tieneHijos();
    }


    public void eliminarHijo(ArbolGeneral<T> hijo) {
        if (this.tieneHijos()) {
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
            if (hijos.incluye(hijo))
                hijos.eliminar(hijo);
        }
    }

    public ListaEnlazadaGenerica<T> preOrden() {
        return null;
    }

    public Integer altura() {
        if (this.esHoja() || esVacio()) {
            return 0;
        } else {
            int maxAlturaHijos = 0;
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
            while (!hijos.fin()) {
                ArbolGeneral<T> hijo = hijos.proximo();
                int alturaHijo = hijo.altura();
                if (alturaHijo > maxAlturaHijos) {
                    maxAlturaHijos = alturaHijo;
                }
            }
            hijos.comenzar();
            return maxAlturaHijos + 1;  // sumo el nodo intermedio
        }
    }


    public Integer nivel(T dato) {
        if (this.esVacio()) {
            return -1;
        }

        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();

        cola.encolar(this);
        niveles.encolar(0); // raíz en nivel 0

        while (!cola.esVacia()) {
            ArbolGeneral<T> actual = cola.desencolar();
            int nivelActual = niveles.desencolar();

            if (actual.getDato().equals(dato)) {
                return nivelActual;
            }

            ListaGenerica<ArbolGeneral<T>> hijos = actual.getHijos();
            while (!hijos.fin()) {
                ArbolGeneral<T> hijo = hijos.proximo();
                cola.encolar(hijo);
                niveles.encolar(nivelActual + 1);
            }
            hijos.comenzar();
        }

        return -1; // no encontrado
    }


    public Boolean esAncestro(T a, T b) {
        ArbolGeneral<T> buscarA = buscarDato(a);
        if (buscarA == null) {
            return false;
        }
        return buscarA.buscarDato(b) != null;

    }

    public ArbolGeneral<T> buscarDato(T a) {
        if (!this.esVacio()) {
            if (this.dato == a) {
                return this;
            }
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();

            while (!hijos.fin()) {
                ArbolGeneral<T> hijo = hijos.proximo();
                ArbolGeneral<T> resultado = hijo.buscarDato(a);
                if (resultado != null) {
                    hijos.comenzar(); // ver si esto no rompe nada
                    return resultado;
                }
            }
        }
        return null;
    }

    public Boolean esArbolLleno() {
        if (!tieneHijos()) {
            return true;
        }

        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
        cola.encolar(this);
        int cantHijosRaiz = this.getHijos().tamanio();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();
        niveles.encolar(0);
        ListaGenerica<Integer> nivelesHojas = new ListaEnlazadaGenerica<>();

        while (!cola.esVacia()) {
            ArbolGeneral<T> nodoActual = cola.desencolar();
            Integer nivelActual = niveles.desencolar();
            if (nodoActual.esHoja()) {
                nivelesHojas.agregarFinal(nivelActual);
            } else if (nodoActual.getHijos().tamanio() != cantHijosRaiz) {
                return false;
            }
            ListaGenerica<ArbolGeneral<T>> hijos = nodoActual.getHijos();
            while (!hijos.fin()) {
                cola.encolar(hijos.proximo());
                niveles.encolar(nivelActual + 1);
            }
            hijos.comenzar();
        }

        // Compruebo si todas las hojas estan al mismo nivel (si sus niveles son iguales)
        if (!nivelesHojas.esVacia()) {
            int primerElemento = nivelesHojas.proximo();
            for (int i = 1; i < nivelesHojas.tamanio(); i++) {
                if (nivelesHojas.elemento(i) != primerElemento) {
                    return false;
                }
            }
        }

        return true;
    }

    public Boolean esArbolCompleto() {
        return false;
    }

    public int grado() {

        if (esHoja()) {
            return 0;
        }

        ListaGenerica<ArbolGeneral<T>> hijos = getHijos();
        int gradoMaximo = hijos.tamanio();
        while (!hijos.fin()) {
            int gradoHijo = hijos.proximo().grado();
            if (gradoHijo > gradoMaximo) {
                gradoMaximo = gradoHijo;
            }
        }
        hijos.comenzar();

        return gradoMaximo;
    }

    public Integer ancho() {

        if (this.esVacio()) {
            return 0;
        }

        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();
        cola.encolar(this);
        niveles.encolar(0);

        Map<Integer, Integer> cantidadPorNivel = new HashMap<>();

        while (!cola.esVacia()) {
            ArbolGeneral<T> tope = cola.desencolar();
            int nivelActual = niveles.desencolar();

            if (!cantidadPorNivel.containsKey(nivelActual)) {
                cantidadPorNivel.put(nivelActual, 1);
            } else {
                Integer cantidadActual = cantidadPorNivel.get(nivelActual);
                cantidadPorNivel.replace(nivelActual, cantidadActual + 1);
            }

            ListaGenerica<ArbolGeneral<T>> hijos = tope.getHijos();
            while (!hijos.fin()) {
                cola.encolar(hijos.proximo());
                niveles.encolar(nivelActual + 1);
            }
            hijos.comenzar();
        }

        int mayorCantidadNodos = 0;

        for (Map.Entry<Integer, Integer> nivel : cantidadPorNivel.entrySet()) {
            Integer cantidadNodosNivel = nivel.getValue();
            if (cantidadNodosNivel > mayorCantidadNodos) {
                mayorCantidadNodos = cantidadNodosNivel;
            }

        }
        return mayorCantidadNodos;
    }
}