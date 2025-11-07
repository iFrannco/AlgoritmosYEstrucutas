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

    private double calcularMinimo(ArbolGeneral<String> arbol, double caudal) {
        if (arbol.esHoja()) {
            return caudal;
        }
        ListaGenerica<ArbolGeneral<String>> hijos = arbol.getHijos();
        hijos.comenzar();
        double minActual = caudal;
        while (!hijos.fin()) {
            double min = calcularMinimo(hijos.proximo(), caudal / hijos.tamanio());
            if (min < minActual) {
                minActual = min;
            }
        }

        return minActual;

    }

}
