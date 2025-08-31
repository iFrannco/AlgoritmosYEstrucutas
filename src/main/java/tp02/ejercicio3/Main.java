package tp02.ejercicio3;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp02.RecorridoArboles;
import tp02.estructuras.ArbolGeneral;

public class Main {
    public static void main(String[] args) {
        RecorridoArboles recorridoArboles = new RecorridoArboles();
        // arbol 1 - 2, 3 - 4, 5, 6, 7
        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(1);
        ArbolGeneral<Integer> arbol2 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> arbol3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> arbol4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> arbol5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> arbol6 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> arbol7 = new ArbolGeneral<>(7);

        ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijosUno = new ListaEnlazadaGenerica<>();
        hijosUno.agregarFinal(arbol2);
        hijosUno.agregarFinal(arbol3);

        ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijosDos = new ListaEnlazadaGenerica<>();
        hijosDos.agregarFinal(arbol4);
        hijosDos.agregarFinal(arbol5);

        ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijosTres = new ListaEnlazadaGenerica<>();
        hijosTres.agregarFinal(arbol6);
        hijosTres.agregarFinal(arbol7);

        arbol.setHijos(hijosUno);
        arbol2.setHijos(hijosDos);
        arbol3.setHijos(hijosTres);

        System.out.println("Recorrido en PreOrden");
        recorridoArboles.preOrden(arbol);

        System.out.println("------------------------");

        System.out.println("Numeros Impares Mayores Que (2) PreOrden");
        RecorridosAG recorridos = new RecorridosAG();
        ListaGenerica<Integer> listaNumerosImpares = recorridos.numerosImparesMayoresQuePreOrden(arbol, 2);
        for (int i = 1; i <= listaNumerosImpares.tamanio(); i++) {
            System.out.println(listaNumerosImpares.elemento(i));
        }

        System.out.println("-------------------------");

        System.out.println("Numeros Impares Mayores Que (2) PostOrden");
        ListaGenerica<Integer> listaNumerosImpares2 = recorridos.numerosImparesMayoresQuePostOrden(arbol, 2);
        for (int i = 1; i <= listaNumerosImpares2.tamanio(); i++) {
            System.out.println(listaNumerosImpares2.elemento(i));
        }

        // ARREGLAR EL METODO POR NIVELES
        System.out.println("----------------------------");
        System.out.println("Numeros Impares Mayores Que (2) Por Niveles");
        ListaGenerica<Integer> listaNumerosImpares3 = recorridos.numerosImparesMayoresQuePorNiveles(arbol, 2);
        for (int i = 1; i <= listaNumerosImpares3.tamanio(); i++) {
            System.out.println(listaNumerosImpares3.elemento(i));
        }


        System.out.println("-------------------------");
        System.out.println("Numeros Impares Mayores Que (2) InOrden");
        ListaGenerica<Integer> listaNumerosImpares4 = recorridos.numerosImparesMayoresQueInOrden(arbol, 2);
        for (int i = 1; i <= listaNumerosImpares4.tamanio(); i++) {
            System.out.println(listaNumerosImpares4.elemento(i));
        }


        System.out.println("-------------------------");
        System.out.println("Altura del arbol: " + arbol.altura());


        System.out.println("Es 7 ancestro de 3?: " + arbol.esAncestro(7, 3));

    }
}
