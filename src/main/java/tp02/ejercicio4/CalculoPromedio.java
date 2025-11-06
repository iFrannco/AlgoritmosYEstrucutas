package tp02.ejercicio4;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;

import java.util.HashMap;

public class CalculoPromedio {

    public int promedioMaximoNivel(ArbolGeneral<AreaEmpresa> arbol) {
        // recorrer por nivel
        // anotar el nivel
        // sumar el nivel a un mapa
        // el mapa deberia tener el nivel y una lista de valores.
        // recorrer el mapa para saber el promedio de cada nivel
        // retornar el mayor promedio (guardar el primero e irlo comparando con el resto)

        int mayorPromedio = 0;

        if (!arbol.esVacio()) {
            HashMap<Integer, ListaGenerica<Integer>> mapa = new HashMap<>();
            ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
            ColaGenerica<Integer> niveles = new ColaGenerica<>();
            cola.encolar(arbol);
            niveles.encolar(0);

            while (!cola.esVacia()) {
                ArbolGeneral<AreaEmpresa> actual = cola.desencolar();
                int nivelActual = niveles.desencolar();

                // si el nivel no existe en el mapa, agregalo
                if (!mapa.containsKey(nivelActual)) {
                    mapa.put(nivelActual, new ListaEnlazadaGenerica<>());
                }

                // agregar el nodo actual en la lista correspondiente al nivel
                ListaGenerica<Integer> valores = mapa.get(nivelActual);
                valores.agregarFinal(actual.getDato().getTardanza_mensaje());

                ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = actual.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.encolar(hijos.proximo());
                    niveles.encolar(nivelActual + 1);
                }

            }

            // sumar los elementos de la lista, promediarlos y ver cual es el mayor.

            // por cada nivel guardado en el mapa, tomar su lista
            for (ListaGenerica<Integer> listaValores : mapa.values()) {
                // definir un acumulador
                int acumulador = 0;

                // por cada elemento en la lista, sumarlo al contador
                listaValores.comenzar();
                while (!listaValores.fin()) {
                    acumulador = +listaValores.proximo();
                }

                // si el promedio de este nivel es mayor al promedio encontrado, intercambiarlo
                if (acumulador / listaValores.tamanio() > mayorPromedio) {
                    mayorPromedio = acumulador / listaValores.tamanio();
                }
            }

        }

        return mayorPromedio;
    }
}
