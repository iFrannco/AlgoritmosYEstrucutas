package tp03.ejercicio4;

import tp03.estructuras.ArbolBinario;

public class RedBinariaLlena {

    ArbolBinario<Integer> arbol;

    public RedBinariaLlena(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        return retardoRecursivo(this.arbol);
    }


    private int retardoRecursivo(ArbolBinario<Integer> arbol) {
        if (arbol.esVacio()) {
            return 0;
        }
        int resultadoIzq = arbol.tieneHijoIzquierdo() ? retardoRecursivo(arbol.getHijoIzquierdo()) : 0;
        int resultadoDer = arbol.tieneHijoDerecho() ? retardoRecursivo(arbol.getHijoDerecho()) : 0;
        return arbol.getDato() + Math.max(resultadoIzq, resultadoDer);
    }

    // Otra opcion:

    /*private int calcularRetardo(ArbolGeneral<Nodo> arbol){
        if(arbol.esVacio()){
            return 0;
        }
        else{
            if(arbol.esHoja()){
                return arbol.getDato().getRetardo();
            }

            int mayorRetardo = 0;

            if(arbol.tieneHijoIzquierdo()){
                int retadoIzquierdo = calcularRetardo(arbol.getHijoIzquierdo());
                if(retardoIzquierdo < mayorRetardo){
                    mayorRetardo = retardoIzquierdo;
                }
            }

            if(arbol.tieneHijoDerecho){
                int retardoDerecho = calcularRetardo(arbol.getHijoDerecho());
                if(retardoDerecho > mayorRetardo){
                    mayorRetardo = retardoDerecho;
                }
            }

            return arbol.getDato().getRetardo() + mayorRetardo;
        }
    }*/

}
