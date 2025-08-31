package tp02.ejercicio5;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;
import tp02.estructuras.ArbolGeneral;

public class Main {
    public static void main(String[] args) {

        ArbolGeneral<String> A = new ArbolGeneral<>("A");
        ArbolGeneral<String> B = new ArbolGeneral<>("B");
        ArbolGeneral<String> C = new ArbolGeneral<>("C");
        ArbolGeneral<String> D = new ArbolGeneral<>("D");
        ArbolGeneral<String> E = new ArbolGeneral<>("E");
        ArbolGeneral<String> F = new ArbolGeneral<>("F");
        ArbolGeneral<String> G = new ArbolGeneral<>("G");
        ArbolGeneral<String> H = new ArbolGeneral<>("H");
        ArbolGeneral<String> I = new ArbolGeneral<>("I");
        ArbolGeneral<String> J = new ArbolGeneral<>("J");
        ArbolGeneral<String> K = new ArbolGeneral<>("K");
        ArbolGeneral<String> L = new ArbolGeneral<>("L");
        ArbolGeneral<String> M = new ArbolGeneral<>("M");
        ArbolGeneral<String> N = new ArbolGeneral<>("N");

        ListaGenerica<ArbolGeneral<String>> hijosDeA = new ListaEnlazadaGenerica<>();
        hijosDeA.agregarFinal(B);
        hijosDeA.agregarFinal(C);
        hijosDeA.agregarFinal(D);
        hijosDeA.agregarFinal(E);

        ListaGenerica<ArbolGeneral<String>> hijosDeC = new ListaEnlazadaGenerica<>();
        hijosDeC.agregarFinal(F);
        hijosDeC.agregarFinal(G);

        ListaGenerica<ArbolGeneral<String>> hijosDeD = new ListaEnlazadaGenerica<>();
        hijosDeD.agregarFinal(H);
        hijosDeD.agregarFinal(I);
        hijosDeD.agregarFinal(J);
        hijosDeD.agregarFinal(K);

        ListaGenerica<ArbolGeneral<String>> hijosDeG = new ListaEnlazadaGenerica<>();
        hijosDeG.agregarFinal(L);

        ListaGenerica<ArbolGeneral<String>> hijosDeJ = new ListaEnlazadaGenerica<>();
        hijosDeJ.agregarFinal(M);
        hijosDeJ.agregarFinal(N);

        A.setHijos(hijosDeA);
        C.setHijos(hijosDeC);
        D.setHijos(hijosDeD);
        G.setHijos(hijosDeG);
        J.setHijos(hijosDeJ);

        RedAguaPotable red = new RedAguaPotable(A);
        System.out.println(red.minimoCaudal(1000));
        
    }
}
