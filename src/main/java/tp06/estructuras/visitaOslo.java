package tp06.estructuras;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;

public class visitaOslo {

    // El origen es el ayuntamiento (hardcodeado desde aca)
    ListaGenerica<String> paseoEnBici(Grafo<String> lugares,
                                      String destino, int maxTiempo,
                                      ListaGenerica<String> restringidos) {

        // Buscar en vertice = Ayuntamiento
        ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
        Vertice<String> origen = null;
        vertices.comenzar();
        while (!vertices.fin()) {
            Vertice<String> v = vertices.proximo();
            if (v.dato().equals("Ayuntamiento")) {
                origen = v;
                break;
            }
        }

        if (origen == null) {
            return new ListaEnlazadaGenerica<>();
        }

        boolean[] enCamino = new boolean[vertices.tamanio() + 1];
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        boolean existeCamino = dfsRecursivo(lugares, camino, origen, destino, enCamino, maxTiempo, 0, restringidos);

        return existeCamino ? camino : new ListaEnlazadaGenerica<>();

    }

    private boolean dfsRecursivo(Grafo<String> grafo,
                                 ListaGenerica<String> camino,
                                 Vertice<String> nodoActual,
                                 String destino, boolean[] enCamino,
                                 int tiempoMax, int tiempoActual,
                                 ListaGenerica<String> restringidos) {

        // en lugar de tener una lista de visitados, si forma parte de los nodos del camino, lo evito.
        if (enCamino[nodoActual.getPosicion()]) {
            return false;
        }
        if (tiempoActual > tiempoMax) {
            return false;
        }
        if (restringidos.incluye(nodoActual.dato())) {
            return false;
        }

        enCamino[nodoActual.getPosicion()] = true;
        camino.agregarFinal(nodoActual.dato());

        if (nodoActual.dato().equals(destino)) {
            return true;
        }

        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(nodoActual);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> arista = adyacentes.proximo();
            Vertice<String> verticeTemp = arista.verticeDestino();
            int nuevoTiempo = tiempoActual + arista.peso();
            if (dfsRecursivo(grafo, camino, verticeTemp, destino, enCamino, tiempoMax, nuevoTiempo, restringidos)) {
                return true;
            }

        }
        // quitar de la lista porque recorri sus adyacentes y no es el camino correcto.
        // ademas lo marco como que no forma parte del camino, para usarlo quizas en otro camino distino
        camino.eliminarEn(camino.tamanio());
        enCamino[nodoActual.getPosicion()] = false;
        return false;
    }
}
