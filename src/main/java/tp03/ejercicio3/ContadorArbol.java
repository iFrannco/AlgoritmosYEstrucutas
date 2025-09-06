package tp03.ejercicio3;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp03.estructuras.ArbolBinario;

public class ContadorArbol {
    ArbolBinario<Integer> arbol;

    public ContadorArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ListaGenerica<Integer> numerosPares() {
        return recorridoPostOrden(this.arbol);
    }

    private ListaGenerica<Integer> recorridoPreOrden(ArbolBinario<Integer> arbol) {
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        if (arbol.tieneHijoIzquierdo()) {
            ListaGenerica<Integer> resultadosHijoIzq = recorridoPreOrden(arbol.getHijoIzquierdo());
            for (int i = 1; i <= resultadosHijoIzq.tamanio(); i++) {
                resultado.agregarFinal(resultadosHijoIzq.elemento(i));
            }
        }
        if (arbol.getDato() % 2 == 0) {
            resultado.agregarFinal(arbol.getDato());
        }
        if (arbol.tieneHijoDerecho()) {
            ListaGenerica<Integer> resultadosHijoDer = recorridoPreOrden(arbol.getHijoDerecho());
            for (int i = 1; i <= resultadosHijoDer.tamanio(); i++) {
                resultado.agregarFinal(resultadosHijoDer.elemento(i));
            }
        }

        return resultado;
    }

    private ListaGenerica<Integer> recorridoPostOrden(ArbolBinario<Integer> arbol) {
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();

        if (arbol.tieneHijoIzquierdo()) {
            ListaGenerica<Integer> resultadosHijoIzq = recorridoPreOrden(arbol.getHijoIzquierdo());
            for (int i = 1; i <= resultadosHijoIzq.tamanio(); i++) {
                resultado.agregarFinal(resultadosHijoIzq.elemento(i));
            }
        }
        if (arbol.tieneHijoDerecho()) {
            ListaGenerica<Integer> resultadosHijoDer = recorridoPreOrden(arbol.getHijoDerecho());
            for (int i = 1; i <= resultadosHijoDer.tamanio(); i++) {
                resultado.agregarFinal(resultadosHijoDer.elemento(i));
            }
        }

        if (arbol.getDato() % 2 == 0) {
            resultado.agregarFinal(arbol.getDato());
        }

        return resultado;
    }
}
