package tp06.estructuras;

import Practica.Ejercicio_1;
import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.Recorridos;
import tp06.estructuras.implementacionMatriz.GrafoImplMatrizAdy;
import tp06.estructuras.implementacionMatriz.VerticeImplMatrizAdy;

public class Main {
    public static void main(String[] args) {
        Grafo<String> miGrafo = new GrafoImplMatrizAdy<>(20);
        VerticeImplMatrizAdy<String> v0 = new VerticeImplMatrizAdy<>("0");
        VerticeImplMatrizAdy<String> v1 = new VerticeImplMatrizAdy<>("1");
        VerticeImplMatrizAdy<String> v2 = new VerticeImplMatrizAdy<>("2");
        VerticeImplMatrizAdy<String> v3 = new VerticeImplMatrizAdy<>("3");
        VerticeImplMatrizAdy<String> v4 = new VerticeImplMatrizAdy<>("4");
        VerticeImplMatrizAdy<String> v5 = new VerticeImplMatrizAdy<>("5");

        miGrafo.agregarVertice(v0);
        miGrafo.agregarVertice(v1);
        miGrafo.agregarVertice(v2);
        miGrafo.agregarVertice(v3);
        miGrafo.agregarVertice(v4);
        miGrafo.agregarVertice(v5);

        miGrafo.conectar(v0, v1);
        miGrafo.conectar(v0, v2);
        miGrafo.conectar(v0, v5);
        miGrafo.conectar(v2, v3);
        miGrafo.conectar(v3, v1);
        miGrafo.conectar(v1, v4);

        Recorridos<String> r = new Recorridos<>();

        ListaGenerica<String> resultado = r.bfs(miGrafo);

        resultado.comenzar();

        while (!resultado.fin()) {
            System.out.println(resultado.proximo());
        }

        // ----------------------------------------------------------

        // Ejercicio 4 paseo en bici en Oslo

        GrafoImplMatrizAdy<String> recorrido = new GrafoImplMatrizAdy<>(35);
        VerticeImplMatrizAdy<String> holmenkollen = new VerticeImplMatrizAdy<>("Holmenkollen");
        VerticeImplMatrizAdy<String> parqueVigeland = new VerticeImplMatrizAdy<>("Parque Vigeland");
        VerticeImplMatrizAdy<String> galeriaNacional = new VerticeImplMatrizAdy<>("Galeria Nacional");
        VerticeImplMatrizAdy<String> parqueBotanico = new VerticeImplMatrizAdy<>("Parque Botanico");
        VerticeImplMatrizAdy<String> museoMunch = new VerticeImplMatrizAdy<>("Museo Munch");
        VerticeImplMatrizAdy<String> folkMuseum = new VerticeImplMatrizAdy<>("FolkMuseum");
        VerticeImplMatrizAdy<String> palacioReal = new VerticeImplMatrizAdy<>("Palacio Real");
        VerticeImplMatrizAdy<String> ayuntamiento = new VerticeImplMatrizAdy<>("Ayuntamiento");
        VerticeImplMatrizAdy<String> elTigre = new VerticeImplMatrizAdy<>("El Tigre");
        VerticeImplMatrizAdy<String> akkerBrigge = new VerticeImplMatrizAdy<>("Akker Brigge");
        VerticeImplMatrizAdy<String> laOpera = new VerticeImplMatrizAdy<>("La Opera");
        VerticeImplMatrizAdy<String> museoFram = new VerticeImplMatrizAdy<>("Museo Fram");
        VerticeImplMatrizAdy<String> museoVikingo = new VerticeImplMatrizAdy<>("Museo Vikingo");
        VerticeImplMatrizAdy<String> fortalezaAkarshus = new VerticeImplMatrizAdy<>("Fortaleza Akarshus");
        VerticeImplMatrizAdy<String> museoDelBarcoPolar = new VerticeImplMatrizAdy<>("Museo del Barco Polar");

        recorrido.agregarVertice(holmenkollen);
        recorrido.agregarVertice(parqueVigeland);
        recorrido.agregarVertice(galeriaNacional);
        recorrido.agregarVertice(parqueBotanico);
        recorrido.agregarVertice(museoMunch);
        recorrido.agregarVertice(folkMuseum);
        recorrido.agregarVertice(palacioReal);
        recorrido.agregarVertice(ayuntamiento);
        recorrido.agregarVertice(elTigre);
        recorrido.agregarVertice(akkerBrigge);
        recorrido.agregarVertice(laOpera);
        recorrido.agregarVertice(museoFram);
        recorrido.agregarVertice(museoVikingo);
        recorrido.agregarVertice(fortalezaAkarshus);
        recorrido.agregarVertice(museoDelBarcoPolar);

        recorrido.conectar(holmenkollen, parqueVigeland, 30);
        recorrido.conectar(parqueVigeland, galeriaNacional, 10);
        recorrido.conectar(galeriaNacional, parqueBotanico, 15);
        recorrido.conectar(parqueBotanico, museoMunch, 1);
        recorrido.conectar(parqueVigeland, folkMuseum, 20);
        recorrido.conectar(folkMuseum, palacioReal, 5);
        recorrido.conectar(palacioReal, ayuntamiento, 5);
        recorrido.conectar(ayuntamiento, parqueBotanico, 10);
        recorrido.conectar(ayuntamiento, akkerBrigge, 20);
        recorrido.conectar(ayuntamiento, elTigre, 15);
        recorrido.conectar(elTigre, museoMunch, 15);
        recorrido.conectar(elTigre, laOpera, 5);
        recorrido.conectar(laOpera, fortalezaAkarshus, 10);
        recorrido.conectar(folkMuseum, akkerBrigge, 30); // lo modifique antes era 30
        recorrido.conectar(akkerBrigge, museoVikingo, 30);
        recorrido.conectar(folkMuseum, museoFram, 5);
        recorrido.conectar(museoFram, museoDelBarcoPolar, 5);
        recorrido.conectar(museoDelBarcoPolar, museoVikingo, 5);

        ListaGenerica<String> restringidos = new ListaEnlazadaGenerica<>();
        restringidos.agregarFinal("Akker Brigge");
        restringidos.agregarFinal("Palacio Real");

        visitaOslo visitaOslo = new visitaOslo();
        ListaGenerica<String> caminoFinal = visitaOslo.paseoEnBici(recorrido, "Museo Vikingo", 120, restringidos);

        caminoFinal.comenzar();
        while (!caminoFinal.fin()) {
            System.out.println(caminoFinal.proximo());
        }

        System.out.println("----------------------------------------");
        System.out.println();
        // ----------------------------------------------------------------------

        // Ejercicio 1 practica extra

        Grafo<String> ciudades = new GrafoImplMatrizAdy<>(30);

        VerticeImplMatrizAdy<String> suipacha = new VerticeImplMatrizAdy<>("Suipacha");
        VerticeImplMatrizAdy<String> carlosKeen = new VerticeImplMatrizAdy<>("Carlos Keen");
        VerticeImplMatrizAdy<String> moreno = new VerticeImplMatrizAdy<>("Moreno");
        VerticeImplMatrizAdy<String> quilmes = new VerticeImplMatrizAdy<>("Quilmes");
        VerticeImplMatrizAdy<String> navarro = new VerticeImplMatrizAdy<>("Navarro");
        VerticeImplMatrizAdy<String> cañuelas = new VerticeImplMatrizAdy<>("Cañuelas");
        VerticeImplMatrizAdy<String> abasto = new VerticeImplMatrizAdy<>("Abasto");
        VerticeImplMatrizAdy<String> laPlata = new VerticeImplMatrizAdy<>("La Plata");
        VerticeImplMatrizAdy<String> saladillo = new VerticeImplMatrizAdy<>("Saladillo");
        VerticeImplMatrizAdy<String> lobos = new VerticeImplMatrizAdy<>("Lobos");
        VerticeImplMatrizAdy<String> pinamar = new VerticeImplMatrizAdy<>("Pinamar");

        ciudades.agregarVertice(suipacha);
        ciudades.agregarVertice(carlosKeen);
        ciudades.agregarVertice(moreno);
        ciudades.agregarVertice(quilmes);
        ciudades.agregarVertice(navarro);
        ciudades.agregarVertice(cañuelas);
        ciudades.agregarVertice(abasto);
        ciudades.agregarVertice(laPlata);
        ciudades.agregarVertice(saladillo);
        ciudades.agregarVertice(lobos);
        ciudades.agregarVertice(pinamar);

        ciudades.conectar(suipacha, carlosKeen);
        ciudades.conectar(carlosKeen, moreno);
        ciudades.conectar(moreno, quilmes);
        ciudades.conectar(suipacha, navarro);
        ciudades.conectar(navarro, cañuelas);
        ciudades.conectar(cañuelas, abasto);
        ciudades.conectar(abasto, moreno);
        ciudades.conectar(abasto, laPlata);
        ciudades.conectar(laPlata, quilmes);
        ciudades.conectar(saladillo, navarro);
        ciudades.conectar(lobos, navarro);
        ciudades.conectar(pinamar, laPlata);

        Ejercicio_1 ejercicio1 = new Ejercicio_1();
        ListaGenerica<String> caminoPasandoPor = ejercicio1.buscarCamino(ciudades, "Pinamar", "Suipacha", "Navarro");

        caminoPasandoPor.comenzar();
        while (!caminoPasandoPor.fin()) {
            System.out.println(caminoPasandoPor.proximo());
        }

        System.out.println("---------------------------------------------");
        System.out.println("prueba buscar si existe un camino entre dos puntos, si no existe no devuelve nada");

        borrar b = new borrar();
        ListaGenerica<String> caminito = b.buscarCamino(ciudades, "Lobos", "Quilmes");
        caminito.comenzar();
        while (!caminito.fin()) {
            System.out.println(caminito.proximo());
        }

    }
}
