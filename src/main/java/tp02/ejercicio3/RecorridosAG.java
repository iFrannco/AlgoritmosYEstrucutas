package tp02.ejercicio3;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;

public class RecorridosAG {

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden
            (ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        if (!a.esVacio()) {
            if (!(a.getDato() % 2 == 0) && a.getDato() > n) {
                resultado.agregarFinal(a.getDato());
            }
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            while (!hijos.fin()) {
                ListaGenerica<Integer> numeros = numerosImparesMayoresQuePreOrden(hijos.proximo(), n);
                for (int i = 1; i <= numeros.tamanio(); i++) {
                    resultado.agregarFinal(numeros.elemento(i));
                }
            }
            hijos.comenzar();
        }
        return resultado;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden
            (ArbolGeneral<Integer> a, Integer n) {
        if (a.esVacio()) return null;
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();
        ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();

        if (!hijos.fin()) {
            ListaGenerica<Integer> numeros = numerosImparesMayoresQueInOrden(hijos.proximo(), n);
            for (int i = 1; i <= numeros.tamanio(); i++) {
                resultado.agregarFinal(numeros.elemento(i));
            }
        }

        if (!(a.getDato() % 2 == 0) && a.getDato() > n) {
            resultado.agregarFinal(a.getDato());
        }

        while (!hijos.fin()) {
            ListaGenerica<Integer> numeros2 = numerosImparesMayoresQueInOrden(hijos.proximo(), n);
            for (int i = 1; i <= numeros2.tamanio(); i++) {
                resultado.agregarFinal(numeros2.elemento(i));
            }
        }
        hijos.comenzar();
        return resultado;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden
            (ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        if (!a.esVacio()) {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            while (!hijos.fin()) {
                ListaGenerica<Integer> numeros = numerosImparesMayoresQuePostOrden(hijos.proximo(), n);
                for (int i = 1; i <= numeros.tamanio(); i++) {
                    resultado.agregarFinal(numeros.elemento(i));
                }
            }
            if (!(a.getDato() % 2 == 0) && a.getDato() > n) {
                resultado.agregarFinal(a.getDato());
            }
            hijos.comenzar();
        }
        return resultado;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles
            (ArbolGeneral<Integer> a, Integer n) {

        if (a.esVacio()) {
            return null;
        }

        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        cola.encolar(a);
        niveles.encolar(0); // raíz en nivel 0

        while (!cola.esVacia()) {
            ArbolGeneral<Integer> actual = cola.desencolar();
            int nivelActual = niveles.desencolar();

            if (!(actual.getDato() % 2 == 0) && actual.getDato() > n) {
                resultado.agregarFinal(actual.getDato());
            }

            ListaGenerica<ArbolGeneral<Integer>> hijos = actual.getHijos();
            while (!hijos.fin()) {
                cola.encolar(hijos.proximo());
                niveles.encolar(nivelActual + 1);
            }
            hijos.comenzar();
        }

        return resultado;

    }

}
