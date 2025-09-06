package tp03.estructuras;

public class Main {
    public static void main(String[] args) {
        ArbolBinario<String> nodo1 = new ArbolBinario<>("1");
        ArbolBinario<String> nodo2 = new ArbolBinario<>("2");
        ArbolBinario<String> nodo3 = new ArbolBinario<>("3");
        ArbolBinario<String> nodo4 = new ArbolBinario<>("4");
        ArbolBinario<String> nodo5 = new ArbolBinario<>("5");
        ArbolBinario<String> nodo6 = new ArbolBinario<>("6");
        ArbolBinario<String> nodo7 = new ArbolBinario<>("7");


        nodo1.agregarHijoIzquierdo(nodo2);
        nodo1.agregarHijoDerecho(nodo3);

        nodo2.agregarHijoIzquierdo(nodo4);
        nodo2.agregarHijoDerecho(nodo5);

        nodo3.agregarHijoIzquierdo(nodo6);
        // nodo3.agregarHijoDerecho(nodo7);

        nodo1.imprimirPreOrden();

        System.out.println("cantidad hojas: " + nodo1.contarHojas());
        ArbolBinario<String> espejado = nodo1.espejo();
        espejado.imprimirPreOrden();


    }
}
