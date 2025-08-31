package tp02;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;

public class RecorridoArboles {

    public <T> void preOrden(ArbolGeneral<T> arbol) {
        if (!arbol.esVacio()) {
            System.out.println(arbol.getDato());
            ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();

            while (!hijos.fin()) {
                preOrden(hijos.proximo());
            }
            hijos.comenzar();
        }
    }

    public <T> void postOrden(ArbolGeneral<T> arbusto) {
        if (!arbusto.esVacio()) {
            ListaGenerica<ArbolGeneral<T>> hijos = arbusto.getHijos();

            while (!hijos.fin()) {
                postOrden(hijos.proximo());
            }
            hijos.comenzar();
            System.out.println(arbusto.getDato());
        }
    }

    public <T> void inOrden(ArbolGeneral<T> bosque) {

        if (bosque.esVacio()) return;

        ListaGenerica<ArbolGeneral<T>> hijos = bosque.getHijos();

        if (!hijos.fin()) {
            inOrden(hijos.proximo());
        }

        System.out.println(bosque.getDato());

        while (!hijos.fin()) {
            inOrden(hijos.proximo());
        }
        hijos.comenzar();
    }

    public <T> void porNiveles(ArbolGeneral<T> arbol) {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
        cola.encolar(arbol);

        while (!cola.esVacia()) {
            ArbolGeneral<T> tope = cola.desencolar();
            System.out.println(tope.getDato());
            ListaGenerica<ArbolGeneral<T>> hijos = tope.getHijos();
            while (!hijos.fin()) {
                cola.encolar(hijos.proximo());
            }
            hijos.comenzar();
        }
    }

    public ListaGenerica<String> separarPorNiveles(ArbolGeneral<String> arbol) {

        ListaGenerica<String> resultado = new ListaEnlazadaGenerica<>();
        ColaGenerica<ArbolGeneral<String>> cola = new ColaGenerica<>();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();
        niveles.encolar(0);
        niveles.encolar(0);
        cola.encolar(arbol);

        while (!cola.esVacia()) {
            int nivelAnterior = niveles.desencolar();
            int nivelActual = niveles.tope();

            ArbolGeneral<String> nodoActual = cola.desencolar();
            if (nivelAnterior != nivelActual) {
                resultado.agregarFinal("|");
            }

            resultado.agregarFinal(nodoActual.getDato());

            ListaGenerica<ArbolGeneral<String>> hijos = nodoActual.getHijos();
            while (!hijos.fin()) {
                cola.encolar(hijos.proximo());
                niveles.encolar(nivelActual + 1);
            }
            hijos.comenzar();
        }

        return resultado;

    }


}
