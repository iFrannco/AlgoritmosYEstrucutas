package tp02.ejercicio4;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;

import java.util.HashMap;
import java.util.Map;

public class CalculoPromedio {

    private static int getMayorPromedio(Map<Integer, ListaGenerica<Integer>> mapa) {
        int mayorPromedio = 0;

        for (Map.Entry<Integer, ListaGenerica<Integer>> nivel : mapa.entrySet()) {
            ListaGenerica<Integer> elementos = nivel.getValue();
            int suma = 0;
            int promedioNivel;
            while (!elementos.fin()) {
                suma += elementos.proximo();
            }
            promedioNivel = suma / elementos.tamanio();
            if (promedioNivel > mayorPromedio) {
                mayorPromedio = promedioNivel;
            }

        }
        return mayorPromedio;
    }

    public int promedioMaximoNivel(ArbolGeneral<AreaEmpresa> arbol) {
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();
        cola.encolar(arbol);
        niveles.encolar(0);

        Map<Integer, ListaGenerica<Integer>> nodosPorNivel = new HashMap<>();


        while (!cola.esVacia()) {
            ArbolGeneral<AreaEmpresa> tope = cola.desencolar();
            int nivelActual = niveles.desencolar();

            if (!nodosPorNivel.containsKey(nivelActual)) {
                nodosPorNivel.put(nivelActual, new ListaEnlazadaGenerica<>());
            }
            nodosPorNivel.get(nivelActual).agregarFinal(tope.getDato().getTardanza_mensaje());

            ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = tope.getHijos();
            while (!hijos.fin()) {
                cola.encolar(hijos.proximo());
                niveles.encolar(nivelActual + 1);
            }
            hijos.comenzar();
        }

        return getMayorPromedio(nodosPorNivel);
    }
}
