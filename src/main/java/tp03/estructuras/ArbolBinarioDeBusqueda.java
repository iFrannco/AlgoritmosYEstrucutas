package tp03.estructuras;

import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;
import tp01.ejercicio2.estructuras.ListaGenerica;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
    private T dato;
    private ArbolBinarioDeBusqueda<T> hijoIzquierdo;
    private ArbolBinarioDeBusqueda<T> hijoDerecho;


    public ArbolBinarioDeBusqueda() {
        super();
    }

    public ArbolBinarioDeBusqueda(T dato) {
        this.dato = dato;
    }

    /*
     * getters y setters
     *
     */
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Preguntar antes de invocar si tieneHijoIzquierdo()
     *
     * @return
     */
    public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    private void setHijoIzquierdo(ArbolBinarioDeBusqueda<T> hijo) {
        this.hijoIzquierdo = hijo;

    }

    public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
        return this.hijoDerecho;

    }

    private void setHijoDerecho(ArbolBinarioDeBusqueda<T> hijo) {
        this.hijoDerecho = hijo;

    }


    public boolean incluye(Comparable<T> dato) {
        return this.buscar(dato, this) != null;
    }


    public ArbolBinarioDeBusqueda<T> buscar(Comparable<T> x, ArbolBinarioDeBusqueda<T> arbol) {
        if (arbol != null) {
            if (x.compareTo(arbol.getDato()) < 0) {
                arbol = this.buscar(x, arbol.getHijoIzquierdo());
            } else if (x.compareTo(arbol.getDato()) > 0) {
                arbol = this.buscar(x, arbol.getHijoDerecho());
            } else
                ; // Se encontro el dato, asi que es arbol
            return arbol;
        } else {
            return null;
        }
    }

    public void agregar(Comparable<T> dato) {
        if (esVacio()) {
            this.setDato((T) dato);
        } else {
            if (dato.compareTo(this.getDato()) < 0) {
                if (!this.tieneHijoIzquierdo()) {
                    this.setHijoIzquierdo(new ArbolBinarioDeBusqueda<>());
                }
                this.getHijoIzquierdo().agregar(dato);
            } else {
                if (!this.tieneHijoDerecho()) {
                    this.setHijoDerecho(new ArbolBinarioDeBusqueda<>());
                }
                this.getHijoDerecho().agregar(dato);
            }
        }

    }

    private void agregar(Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO

    }

    public ArbolBinarioDeBusqueda<T> buscarMayorDeLosMenores(ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO
        if (!esVacio()) {
            if (!tieneHijoIzquierdo()) {
                return this;
            }
            return buscarMayor(this.getHijoIzquierdo());
        }
        return null;
    }

    public ArbolBinarioDeBusqueda<T> buscarMayor(ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO
        if (!arbol.esVacio()) {
            if (!arbol.tieneHijoDerecho()) {
                return arbol;
            }
            return buscarMayor(arbol.getHijoDerecho());
        }
        return null;
    }

    public ArbolBinarioDeBusqueda<T> buscarMenorDeLosMayores(ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO
        return null;
    }

    public ArbolBinarioDeBusqueda<T> buscarMenor(ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO
        return null;
    }

    @Override
    public String toString() {
        return this.getDato().toString();
    }

    public boolean esVacio() {
        return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
    }

    public boolean tieneHijoDerecho() {
        return this.hijoDerecho != null;
    }

    public boolean tieneHijoIzquierdo() {
        return this.hijoIzquierdo != null;
    }

    public boolean esHoja() {
        return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());
    }


    public void agregarHijoIzquierdo(ArbolBinarioDeBusqueda<T> arbol) {
        this.hijoIzquierdo = arbol;
    }

    public void agregarHijoDerecho(ArbolBinarioDeBusqueda<T> arbol) {
        this.hijoDerecho = arbol;
    }

//    public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> arbol) {
//        ListaGenerica<Integer> res = new ListaEnlazadaGenerica<>();
//        // casos borde
//        if (this == null || this.esVacio() || arbol == null || arbol.esVacio()) return res;
//
//        Integer objetivo = arbol.getDato();
//        ArbolBinarioDeBusqueda<Integer> actual = this;
//
//        // agrego la raíz (si el árbol no está vacío)
//        res.agregarFinal(actual.getDato());
//
//        // bajo hasta encontrar el objetivo, agregando SIEMPRE el nodo al que llego
//        while (actual != null && !actual.esVacio() && !actual.getDato().equals(objetivo)) {
//            if (objetivo < actual.getDato()) {
//                ArbolBinarioDeBusqueda<Integer> izq = actual.getHijoIzquierdo();
//                if (izq == null) break;                 // por si no existe (objetivo ausente)
//                res.agregarFinal(-izq.getDato());        // llegué por izquierda → negativo del hijo al que llego
//                actual = izq;
//            } else if (objetivo > actual.getDato()) {
//                ArbolBinarioDeBusqueda<Integer> der = actual.getHijoDerecho();
//                if (der == null) break;                  // por si no existe
//                res.agregarFinal(der.getDato());         // llegué por derecha → positivo del hijo al que llego
//                actual = der;
//            } else {
//                // por seguridad; en teoría no se entra por la condición del while
//                break;
//            }
//        }
//
//        return res;
//    }


    // imprimir en orden ascendente
    public void preOrden() {
        if (!this.esVacio()) {
            System.out.println(this.getDato());
            if (this.tieneHijoIzquierdo()) {
                this.hijoIzquierdo.preOrden();
            }
            if (this.tieneHijoDerecho()) {
                this.hijoDerecho.preOrden();
            }
        }
    }

    // imprimir en orden ascendente
    public void imprimirEnOrdenAsc() {
        if (!this.esVacio()) {
            if (this.tieneHijoIzquierdo()) {
                this.hijoIzquierdo.imprimirEnOrdenAsc();
            }
            System.out.println(this.getDato());
            if (this.tieneHijoDerecho()) {
                this.hijoDerecho.imprimirEnOrdenAsc();
            }
        }
    }

    // retornar una lista en orden ascendente
    public ListaGenerica<T> imprimirListaEnOrdenAsc() {

        if (!this.esVacio()) {
            ListaGenerica<T> resultado = new ListaEnlazadaGenerica<>();
            if (this.tieneHijoIzquierdo()) {
                ListaGenerica<T> resultadoIzq = this.hijoIzquierdo.imprimirListaEnOrdenAsc();
                for (int i = 1; i <= resultadoIzq.tamanio(); i++) {
                    resultado.agregarFinal(resultadoIzq.elemento(i));
                }
            }
            resultado.agregarFinal(this.getDato());
            if (this.tieneHijoDerecho()) {
                ListaGenerica<T> resultadoDer = this.hijoDerecho.imprimirListaEnOrdenAsc();
                for (int i = 1; i <= resultadoDer.tamanio(); i++) {
                    resultado.agregarFinal(resultadoDer.elemento(i));
                }
            }
            return resultado;
        }

        return null;
    }

    // imprimir en orden desc
    public void imprimirEnOrdenDesc() {
        if (!this.esVacio()) {
            if (this.tieneHijoDerecho()) {
                this.hijoDerecho.imprimirEnOrdenDesc();
            }
            System.out.println(this.getDato());
            if (this.tieneHijoIzquierdo()) {
                this.hijoIzquierdo.imprimirEnOrdenDesc();
            }

        }
    }

    // espejar sin metodo auxiliar

    public ArbolBinarioDeBusqueda<T> espejar() {

        if (!this.esVacio()) {
            ArbolBinarioDeBusqueda<T> resultado = new ArbolBinarioDeBusqueda<>(this.getDato());
            if (this.tieneHijoIzquierdo()) {
                resultado.agregarHijoDerecho(this.getHijoIzquierdo().espejar());
            }
            if (this.tieneHijoDerecho()) {
                resultado.agregarHijoIzquierdo(this.getHijoDerecho().espejar());
            }
            return resultado;
        }

        return null;
    }

    // camino mas largo
    public int caminoMasLargo() {

        if (!this.esVacio()) {
            int mayorIzq = tieneHijoIzquierdo() ? this.hijoIzquierdo.caminoMasLargo() : 0;
            int mayorDer = tieneHijoDerecho() ? this.hijoDerecho.caminoMasLargo() : 0;
            return mayorDer > mayorIzq ? mayorDer + 1 : mayorIzq + 1;
        }

        return 0;
    }

    public ListaGenerica<T> caminoMasLargoNodos() {

        if (!this.esVacio()) {
            ListaGenerica<T> resultado = new ListaEnlazadaGenerica<>();
            ListaGenerica<T> resultadoIzq = new ListaEnlazadaGenerica<>();
            ListaGenerica<T> resultadoDer = new ListaEnlazadaGenerica<>();
            if (tieneHijoIzquierdo()) {
                resultadoIzq = this.hijoIzquierdo.caminoMasLargoNodos();
            }
            if (tieneHijoDerecho()) {
                resultadoDer = this.hijoDerecho.caminoMasLargoNodos();
            }

            if (resultadoIzq.tamanio() > resultadoDer.tamanio()) {
                while (!resultadoIzq.fin()) {
                    resultado.agregarFinal(resultadoIzq.proximo());
                }

            } else {
                while (!resultadoDer.fin()) {
                    resultado.agregarFinal(resultadoDer.proximo());
                }

            }
            resultado.agregarInicio(this.getDato());
            resultado.comenzar();
            return resultado;
        }

        return null;
    }

    public int longitudAristas() {

        if (!this.esVacio()) {
            int caminoIzq = 0;
            int caminoDer = 0;
            int res;
            if (this.tieneHijoIzquierdo()) {
                caminoIzq = this.hijoIzquierdo.longitudAristas();
            }
            if (this.tieneHijoDerecho()) {
                caminoDer = this.hijoDerecho.longitudAristas();
            }
            res = Math.max(caminoIzq, caminoDer);

            return this.esHoja() ? 0 : res + 1;
        }


        return 0;
    }

    // clonar un arbol

    public ArbolBinarioDeBusqueda<T> clonar() {

        if (!this.esVacio()) {
            ArbolBinarioDeBusqueda<T> nuevoArbol = new ArbolBinarioDeBusqueda<>(this.getDato());
            if (this.tieneHijoIzquierdo()) {
                nuevoArbol.setHijoIzquierdo(this.getHijoIzquierdo().clonar());
            }
            if (this.tieneHijoDerecho()) {
                nuevoArbol.setHijoDerecho(this.getHijoDerecho().clonar());
            }
            return nuevoArbol;
        }

        return null;
    }

    // punto 9) Practica 3: Buscar un camino hasta un nodo, indicando con numeros negativos si se tomo
    // un camino por la izquierda.

    public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> arbol) {
        ListaGenerica<Integer> resultado = new ListaEnlazadaGenerica<>();
        if (!this.esVacio()) {
            resultado.agregarFinal((Integer) this.getDato());
            buscarCamino(arbol, resultado);

            if (resultado.incluye(arbol.getDato()) || resultado.incluye(-arbol.getDato())) {
                resultado.eliminarEn(resultado.tamanio());
                return resultado;
            }
        }

        return new ListaEnlazadaGenerica<>();
    }

    private void buscarCamino(ArbolBinarioDeBusqueda<Integer> arbol, ListaGenerica<Integer> resultado) {
        if (!this.esVacio()) {
            // los padres agregan a los hijos, porque saben si estan llendo por izquierda o por derecha.
            // si existe, el ultimo nodo es agregado por su padre.
            // al momento de llamar a la recursion con el nodo buscado, no cumple ninguna de las condiciones y vuelve.
            if (this.tieneHijoIzquierdo() && ((Integer) this.getDato() > arbol.getDato())) {
                resultado.agregarFinal(-(Integer) this.getHijoIzquierdo().getDato());
                this.getHijoIzquierdo().buscarCamino(arbol, resultado);
            }
            if (this.tieneHijoDerecho() && (Integer) this.getDato() < arbol.getDato()) {
                resultado.agregarFinal((Integer) this.getHijoDerecho().getDato());
                this.getHijoDerecho().buscarCamino(arbol, resultado);
            }

        }
    }


}
