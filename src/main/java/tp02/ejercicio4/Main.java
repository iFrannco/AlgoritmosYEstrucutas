package tp02.ejercicio4;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp02.estructuras.ArbolGeneral;

public class Main {
    public static void main(String[] args) {
        AreaEmpresa areaEmpresa1 = new AreaEmpresa("M", 14);

        AreaEmpresa areaEmpresa2 = new AreaEmpresa("J", 13);
        AreaEmpresa areaEmpresa3 = new AreaEmpresa("K", 25);
        AreaEmpresa areaEmpresa4 = new AreaEmpresa("L", 10);

        AreaEmpresa areaEmpresa5 = new AreaEmpresa("A", 4);
        AreaEmpresa areaEmpresa6 = new AreaEmpresa("B", 7);
        AreaEmpresa areaEmpresa7 = new AreaEmpresa("C", 5);

        AreaEmpresa areaEmpresa8 = new AreaEmpresa("D", 6);
        AreaEmpresa areaEmpresa9 = new AreaEmpresa("E", 10);
        AreaEmpresa areaEmpresa10 = new AreaEmpresa("F", 18);

        AreaEmpresa areaEmpresa11 = new AreaEmpresa("G", 9);
        AreaEmpresa areaEmpresa12 = new AreaEmpresa("H", 12);
        AreaEmpresa areaEmpresa13 = new AreaEmpresa("I", 19);

        ArbolGeneral<AreaEmpresa> nodoM = new ArbolGeneral<>(areaEmpresa1);
        ArbolGeneral<AreaEmpresa> nodoJ = new ArbolGeneral<>(areaEmpresa2);
        ArbolGeneral<AreaEmpresa> nodoK = new ArbolGeneral<>(areaEmpresa3);
        ArbolGeneral<AreaEmpresa> nodoL = new ArbolGeneral<>(areaEmpresa4);
        ArbolGeneral<AreaEmpresa> nodoA = new ArbolGeneral<>(areaEmpresa5);
        ArbolGeneral<AreaEmpresa> nodoB = new ArbolGeneral<>(areaEmpresa6);
        ArbolGeneral<AreaEmpresa> nodoC = new ArbolGeneral<>(areaEmpresa7);
        ArbolGeneral<AreaEmpresa> nodoD = new ArbolGeneral<>(areaEmpresa8);
        ArbolGeneral<AreaEmpresa> nodoE = new ArbolGeneral<>(areaEmpresa9);
        ArbolGeneral<AreaEmpresa> nodoF = new ArbolGeneral<>(areaEmpresa10);
        ArbolGeneral<AreaEmpresa> nodoG = new ArbolGeneral<>(areaEmpresa11);
        ArbolGeneral<AreaEmpresa> nodoH = new ArbolGeneral<>(areaEmpresa12);
        ArbolGeneral<AreaEmpresa> nodoI = new ArbolGeneral<>(areaEmpresa13);

        ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijosM = new ListaEnlazadaGenerica<>();
        hijosM.agregarFinal(nodoJ);
        hijosM.agregarFinal(nodoK);
        hijosM.agregarFinal(nodoL);

        ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijosJ = new ListaEnlazadaGenerica<>();
        hijosJ.agregarFinal(nodoA);
        hijosJ.agregarFinal(nodoB);
        hijosJ.agregarFinal(nodoC);

        ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijosK = new ListaEnlazadaGenerica<>();
        hijosK.agregarFinal(nodoD);
        hijosK.agregarFinal(nodoE);
        hijosK.agregarFinal(nodoF);

        ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijosL = new ListaEnlazadaGenerica<>();
        hijosL.agregarFinal(nodoG);
        hijosL.agregarFinal(nodoH);
        hijosL.agregarFinal(nodoI);

        nodoM.setHijos(hijosM);
        nodoJ.setHijos(hijosJ);
        nodoK.setHijos(hijosK);
        nodoL.setHijos(hijosL);

        CalculoPromedio calculoPromedio = new CalculoPromedio();
        System.out.println("El meyor promedio es: " + calculoPromedio.promedioMaximoNivel(nodoM));


        if (nodoM.esArbolLleno()) {
            System.out.println("El arbol esta lleno");
        } else {
            System.out.println("El arbol NO esta lleno");
        }

        System.out.println("grado del arbol: " + nodoM.grado());

        System.out.println("-------------------------------");

//        boolean esAncestro = nodoM.esAncestro(areaEmpresa13, areaEmpresa1);
//        System.out.println("Es la empresa I abuelo de la empresa K?: " + esAncestro);

        System.out.println("-------------------------------");

        System.out.println("Ancho: " + nodoM.ancho());

    }
}
