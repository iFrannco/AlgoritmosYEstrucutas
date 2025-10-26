package tp06.estructuras;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp06.Recorridos;
import tp06.estructuras.implementacionMatriz.GrafoImplMatrizAdy;
import tp06.estructuras.implementacionMatriz.VerticeImplMatrizAdy;

public class Main {
    public static void main(String[] args) {
        Grafo<String> miGrafo = new GrafoImplMatrizAdy<>(10);
        VerticeImplMatrizAdy<String> v0 = new VerticeImplMatrizAdy<>("0");
        VerticeImplMatrizAdy<String> v1 = new VerticeImplMatrizAdy<>("1");
        VerticeImplMatrizAdy<String> v2 = new VerticeImplMatrizAdy<>("2");
        VerticeImplMatrizAdy<String> v3 = new VerticeImplMatrizAdy<>("3");
        VerticeImplMatrizAdy<String> v4 = new VerticeImplMatrizAdy<>("4");

        miGrafo.agregarVertice(v0);
        miGrafo.agregarVertice(v1);
        miGrafo.agregarVertice(v2);
        miGrafo.agregarVertice(v3);
        miGrafo.agregarVertice(v4);

        miGrafo.conectar(v0, v1);
        miGrafo.conectar(v0, v2);
        miGrafo.conectar(v2, v3);
        miGrafo.conectar(v3, v1);
        miGrafo.conectar(v1, v4);

        Recorridos<String> recorrido = new Recorridos<>();

        ListaGenerica<String> resultado = recorrido.dfs(miGrafo);

        resultado.comenzar();

        while (!resultado.fin()) {
            System.out.println(resultado.proximo());
        }
    }
}
