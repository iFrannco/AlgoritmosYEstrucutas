package tp03.ejercicio5;

import tp01.ejercicio3.ColaGenerica;
import tp03.estructuras.ArbolBinario;

public class ProfundidadDeArbolBinario {
    ArbolBinario<Integer> arbol;

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p) {
        // recorrdo en profundidad
        // sumo a un contador si se encuentra dentro del nivel

        ColaGenerica<ArbolBinario<Integer>> valores = new ColaGenerica<>();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();

        valores.encolar(arbol);
        niveles.encolar(0);

        int resultado = 0;

        while (!valores.esVacia()) {
            ArbolBinario<Integer> valorActual = valores.desencolar();
            int nivelActual = niveles.desencolar();

            if (p < 0 || nivelActual > p) {
                break;
            }
            if (nivelActual == p) {
                resultado += valorActual.getDato();
            }

            if (valorActual.tieneHijoIzquierdo()) {
                valores.encolar(valorActual.getHijoIzquierdo());
                niveles.encolar(nivelActual + 1);
            }
            if (valorActual.tieneHijoDerecho()) {
                valores.encolar(valorActual.getHijoDerecho());
                niveles.encolar(nivelActual + 1);
            }
        }
        return resultado;
    }
}
