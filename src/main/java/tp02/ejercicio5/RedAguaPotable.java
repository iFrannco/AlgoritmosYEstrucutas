package tp02.ejercicio5;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp02.estructuras.ArbolGeneral;

public class RedAguaPotable {
    private ArbolGeneral<String> redDeCaños;

    public RedAguaPotable(ArbolGeneral<String> redDeCaños) {
        this.redDeCaños = redDeCaños;
    }

    public double minimoCaudal(double caudal) {
        return calcularMinimo(redDeCaños, caudal);

    }

    public double calcularMinimo(ArbolGeneral<String> arbol, double caudal) {
        if (!arbol.tieneHijos()) {
            return caudal;
        }
        double minCaudal = caudal;
        ListaGenerica<ArbolGeneral<String>> hijos = arbol.getHijos();
        while (!hijos.fin()) {
            double minActual = calcularMinimo(hijos.proximo(), caudal / arbol.getHijos().tamanio());
            if (minActual < minCaudal) {
                minCaudal = minActual;
            }
        }
        hijos.comenzar();
        return minCaudal;
    }

}
