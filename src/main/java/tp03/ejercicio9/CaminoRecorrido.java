package tp03.ejercicio9;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp03.estructuras.ArbolBinarioDeBusqueda;

public class CaminoRecorrido {

    public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> arbol, int valor) {

        if (!arbol.esVacio()) {
            ListaGenerica<Integer> resultado = null;
            if (valor == arbol.getDato()) {
                return new ListaEnlazadaGenerica<Integer>();
            } else if (valor < arbol.getDato()) {
                if (arbol.tieneHijoIzquierdo()) {
                    resultado = caminoRecorrido(arbol.getHijoIzquierdo(), valor);
                    if (resultado != null) {
                        resultado.agregarFinal(arbol.getDato());
                    }
                }
            } else {
                if (arbol.tieneHijoDerecho()) {
                    resultado = caminoRecorrido(arbol.getHijoDerecho(), valor);
                    if (resultado != null) {
                        resultado.agregarFinal(-arbol.getDato());
                    }
                }
            }

            return resultado;
        }
        return null;

    }

}
