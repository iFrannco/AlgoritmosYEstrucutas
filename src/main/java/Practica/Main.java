package Practica;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.estructuras.ArbolGeneral;
import tp03.estructuras.ArbolBinarioDeBusqueda;
import tp06.estructuras.Grafo;
import tp06.estructuras.Vertice;
import tp06.estructuras.implementacionMatriz.GrafoImplMatrizAdy;
import tp06.estructuras.implementacionMatriz.VerticeImplMatrizAdy;

public class Main {
    public static void main(String[] args) {
        ArbolGeneral<String> nodo1 = new ArbolGeneral<>("Juan");
        ArbolGeneral<String> nodo2 = new ArbolGeneral<>("Pedro");
        ArbolGeneral<String> nodo3 = new ArbolGeneral<>("Maria");
        ArbolGeneral<String> nodo4 = new ArbolGeneral<>("Luis");

        ListaGenerica<ArbolGeneral<String>> hijosJuan = new ListaEnlazadaGenerica<>();
        hijosJuan.agregarFinal(nodo2);
        hijosJuan.agregarFinal(nodo3);

        ListaGenerica<ArbolGeneral<String>> hijoPedro = new ListaEnlazadaGenerica<>();
        hijoPedro.agregarFinal(nodo4);

        nodo1.setHijos(hijosJuan);
        nodo2.setHijos(hijoPedro);

        Ejercicio_2 ejercicio1 = new Ejercicio_2();
        ejercicio1.contarDescendientes(nodo1);

        System.out.println("\n-------------------------------------------");

        Estudiante estudiante1 = new Estudiante("Pau", "Agostineli", "34567890");
        Estudiante estudiante2 = new Estudiante("Benja", "", "27481736");
        Estudiante estudiante3 = new Estudiante("Dani", "Antrichipay", "56789012");
        Estudiante estudiante4 = new Estudiante("Dami", "Gasparini", "12345678");
        Estudiante estudiante5 = new Estudiante("Lautaro", "Salvo", "29678930");
        Estudiante estudiante6 = new Estudiante("Gera", "Loza", "45678901");
        Estudiante estudiante7 = new Estudiante("Lucas", "Glave", "67890123");

        ArbolBinarioDeBusqueda<Estudiante> n1 = new ArbolBinarioDeBusqueda<>(estudiante1);
        ArbolBinarioDeBusqueda<Estudiante> n2 = new ArbolBinarioDeBusqueda<>(estudiante2);
        ArbolBinarioDeBusqueda<Estudiante> n3 = new ArbolBinarioDeBusqueda<>(estudiante3);
        ArbolBinarioDeBusqueda<Estudiante> n4 = new ArbolBinarioDeBusqueda<>(estudiante4);
        ArbolBinarioDeBusqueda<Estudiante> n5 = new ArbolBinarioDeBusqueda<>(estudiante5);
        ArbolBinarioDeBusqueda<Estudiante> n6 = new ArbolBinarioDeBusqueda<>(estudiante6);
        ArbolBinarioDeBusqueda<Estudiante> n7 = new ArbolBinarioDeBusqueda<>(estudiante7);

        n1.agregarHijoIzquierdo(n2);
        n1.agregarHijoDerecho(n3);

        n2.agregarHijoIzquierdo(n4);
        n2.agregarHijoDerecho(n5);

        n3.agregarHijoIzquierdo(n6);
        n3.agregarHijoDerecho(n7);


        Ejercicio_3 ejercicio2 = new Ejercicio_3();

        ejercicio2.imprimirEstudiante(n1);

        System.out.println("-------------------------------------------");

        ArbolGeneral<String> nod1 = new ArbolGeneral<>("si");
        ArbolGeneral<String> nod2 = new ArbolGeneral<>("buscas");
        ArbolGeneral<String> nod3 = new ArbolGeneral<>("resultados");
        ArbolGeneral<String> nod4 = new ArbolGeneral<>("distintos");
        ArbolGeneral<String> nod5 = new ArbolGeneral<>("no");
        ArbolGeneral<String> nod6 = new ArbolGeneral<>("hagas");
        ArbolGeneral<String> nod7 = new ArbolGeneral<>("siempre");
        ArbolGeneral<String> nod8 = new ArbolGeneral<>("lo");
        ArbolGeneral<String> nod9 = new ArbolGeneral<>("mismo");

        nod1.agregarHijo(nod2);
        nod1.agregarHijo(nod3);
        nod1.agregarHijo(nod4);

        nod2.agregarHijo(nod5);
        nod2.agregarHijo(nod6);
        nod2.agregarHijo(nod7);

        nod3.agregarHijo(nod8);
        nod3.agregarHijo(nod9);

        Ejercicio_5 ejercicio3 = new Ejercicio_5();
        String res = ejercicio3.generarFrase(nod1);
        System.out.println(res);

        System.out.println("-------------------------------------");

        ColaGenerica<String> cola = new ColaGenerica<>();
        cola.encolar("damian");
        cola.encolar("pau");
        cola.encolar("lauti");

        ListaGenerica<String> asdf = new ListaEnlazadaGenerica<>();

        System.out.println("-------------------------------------");


        System.out.println("Ejercicio 4 grafos: ");

        Grafo<String> recorrido = new GrafoImplMatrizAdy<>(10);
        Vertice<String> mayoYVillarino = new VerticeImplMatrizAdy<>("25 de Mayo y Villarino");
        Vertice<String> mayoYBuenosAires = new VerticeImplMatrizAdy<>("25 de Mayo y Buenos Aires");
        Vertice<String> colonYVillarino = new VerticeImplMatrizAdy<>("Colon y Villarino");
        Vertice<String> buenosAiresYColon = new VerticeImplMatrizAdy<>("Buenos Aires y Colon");

        recorrido.agregarVertice(mayoYVillarino);
        recorrido.agregarVertice(mayoYBuenosAires);
        recorrido.agregarVertice(colonYVillarino);
        recorrido.agregarVertice(buenosAiresYColon);

        recorrido.conectar(mayoYVillarino, mayoYBuenosAires);
        recorrido.conectar(mayoYBuenosAires, colonYVillarino);
        recorrido.conectar(colonYVillarino, buenosAiresYColon);
        recorrido.conectar(buenosAiresYColon, mayoYVillarino); // comentar para probar el caso contrario

        Ejercicio_4 ejercicio4 = new Ejercicio_4();

        if (ejercicio4.recorridoMaratonValido(recorrido, "25 de Mayo y Villarino")) {
            System.out.println("recorrido valido");
        } else {
            System.out.println("recorrido invalido");
        }


        System.out.println("-------------------------------------------------------------");

        System.out.println("Ejercicio 6 de la practica extra");

        Grafo<String> aeropuertos = new GrafoImplMatrizAdy<>(20);

        Vertice<String> aep = new VerticeImplMatrizAdy<>("AEP");
        Vertice<String> eze = new VerticeImplMatrizAdy<>("EZE");
        Vertice<String> cor = new VerticeImplMatrizAdy<>("COR");
        Vertice<String> sla = new VerticeImplMatrizAdy<>("SLA");
        Vertice<String> vdm = new VerticeImplMatrizAdy<>("VDM");
        Vertice<String> brc = new VerticeImplMatrizAdy<>("BRC");
        Vertice<String> mdz = new VerticeImplMatrizAdy<>("MDZ");
        Vertice<String> nqn = new VerticeImplMatrizAdy<>("NQN");
        Vertice<String> crd = new VerticeImplMatrizAdy<>("CRD");

        aeropuertos.agregarVertice(aep);
        aeropuertos.agregarVertice(eze);
        aeropuertos.agregarVertice(cor);
        aeropuertos.agregarVertice(sla);
        aeropuertos.agregarVertice(vdm);
        aeropuertos.agregarVertice(brc);
        aeropuertos.agregarVertice(mdz);
        aeropuertos.agregarVertice(nqn);
        aeropuertos.agregarVertice(crd);

        aeropuertos.conectar(aep, cor);
        aeropuertos.conectar(aep, eze);
        aeropuertos.conectar(cor, eze);
        aeropuertos.conectar(cor, sla);
        aeropuertos.conectar(cor, mdz);
        aeropuertos.conectar(mdz, brc);
        aeropuertos.conectar(mdz, nqn);
        aeropuertos.conectar(vdm, nqn);
        aeropuertos.conectar(brc, nqn);
        aeropuertos.conectar(crd, brc);
        aeropuertos.conectar(crd, nqn);


        Ejercicio_6 ejercicio6 = new Ejercicio_6();
        ListaEnlazadaGenerica<String> alternativas = ejercicio6.aeropuertosAlternativos(aeropuertos, "AEP");

        alternativas.comenzar();
        while (!alternativas.fin()) {
            System.out.println(alternativas.proximo());
        }
    }
}
