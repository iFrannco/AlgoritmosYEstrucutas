package tp02;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp02.estructuras.ArbolGeneral;

public class Main {
    public static void main(String[] args) {
        ArbolGeneral<String> nodo1 = new ArbolGeneral<>("1");
        ArbolGeneral<String> nodo2 = new ArbolGeneral<>("2");
        ArbolGeneral<String> nodo3 = new ArbolGeneral<>("3");
        ArbolGeneral<String> nodo4 = new ArbolGeneral<>("4");
        ArbolGeneral<String> nodo5 = new ArbolGeneral<>("5");
        ArbolGeneral<String> nodo6 = new ArbolGeneral<>("6");
        ArbolGeneral<String> nodo7 = new ArbolGeneral<>("7");
        ArbolGeneral<String> nodo8 = new ArbolGeneral<>("8");


        ListaGenerica<ArbolGeneral<String>> hijosNodo1 = new ListaEnlazadaGenerica<>();
        hijosNodo1.agregarFinal(nodo2);
        hijosNodo1.agregarFinal(nodo3);

        ListaGenerica<ArbolGeneral<String>> hijosNodo2 = new ListaEnlazadaGenerica<>();
        hijosNodo2.agregarFinal(nodo4);
        hijosNodo2.agregarFinal(nodo5);

        ListaGenerica<ArbolGeneral<String>> hijosNodo3 = new ListaEnlazadaGenerica<>();
        hijosNodo3.agregarFinal(nodo8);

        ListaGenerica<ArbolGeneral<String>> hijosNodo5 = new ListaEnlazadaGenerica<>();
        hijosNodo5.agregarFinal(nodo6);
        hijosNodo5.agregarFinal(nodo7);

        nodo1.setHijos(hijosNodo1);
        nodo2.setHijos(hijosNodo2);
        nodo5.setHijos(hijosNodo5);
        nodo3.setHijos(hijosNodo3);

        RecorridoArboles recorridoArboles = new RecorridoArboles();
        ListaGenerica<String> res = recorridoArboles.separarPorNiveles(nodo1);

        for (int i = 1; i <= res.tamanio(); i++) {
            System.out.println(res.elemento(i));
        }
    }
}
