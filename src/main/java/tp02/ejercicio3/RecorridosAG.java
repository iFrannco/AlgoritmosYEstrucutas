package tp02.ejercicio3;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;

public class RecorridosAG {

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden
            (ArbolGeneral<Integer> a, Integer n) {

        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();
        recorrerPreOrdenYAgregarALista(a, n, resultado);

        return resultado;
    }

    private void recorrerPreOrdenYAgregarALista(ArbolGeneral<Integer> arbol, int n,
                                                ListaGenerica<Integer> resultado) {

        if (!arbol.esVacio()) {
            if (!(arbol.getDato() % 2 == 0) && arbol.getDato() > n) {
                resultado.agregarFinal(arbol.getDato());
            }
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                recorrerPreOrdenYAgregarALista(hijos.proximo(), n, resultado);
            }
        }
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden
            (ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        if (!a.esVacio()) {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            if (!hijos.esVacia()) {
                ListaGenerica<Integer> resHijoIzq = numerosImparesMayoresQueInOrden(
                        hijos.proximo(), n);
                resHijoIzq.comenzar();
                while (!resHijoIzq.fin()) {
                    resultado.agregarFinal(resHijoIzq.proximo());
                }

            }
            if (!(a.getDato() % 2 == 0) && a.getDato() > n) {
                resultado.agregarFinal(a.getDato());
            }
            while (!hijos.fin()) {
                ListaGenerica<Integer> resHijosDer = numerosImparesMayoresQueInOrden(
                        hijos.proximo(), n);
                resHijosDer.comenzar();
                while (!resHijosDer.fin()) {
                    resultado.agregarFinal(resHijosDer.proximo());
                }
            }

        }

        return resultado;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden
            (ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        if (!a.esVacio()) {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                ListaGenerica<Integer> extras = numerosImparesMayoresQuePostOrden(
                        hijos.proximo(), n);
                extras.comenzar();
                while (!extras.fin()) {
                    resultado.agregarFinal(extras.proximo());
                }
            }
            if (!(a.getDato() % 2 == 0) && a.getDato() > n) {
                resultado.agregarFinal(a.getDato());
            }
        }

        return resultado;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles
            (ArbolGeneral<Integer> a, Integer n) {

        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        if (!a.esVacio()) {
            ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
            cola.encolar(a);
            while (!cola.esVacia()) {
                ArbolGeneral<Integer> elemento = cola.desencolar();
                if (!(elemento.getDato() % 2 == 0) && elemento.getDato() > n) {
                    resultado.agregarFinal(elemento.getDato());
                }
                ListaGenerica<ArbolGeneral<Integer>> hijos = elemento.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.encolar(hijos.proximo());
                }
            }
        }
        return resultado;

    }

}
