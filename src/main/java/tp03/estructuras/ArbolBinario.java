package tp03.estructuras;

import tp01.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
    private T dato;
    private ArbolBinario<T> hijoIzquierdo;
    private ArbolBinario<T> hijoDerecho;


    public ArbolBinario() {
        super();
    }

    public ArbolBinario(T dato) {
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
    public ArbolBinario<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public ArbolBinario<T> getHijoDerecho() {
        return this.hijoDerecho;

    }

    public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
        this.hijoIzquierdo = hijo;
    }

    public void agregarHijoDerecho(ArbolBinario<T> hijo) {
        this.hijoDerecho = hijo;
    }

    public void eliminarHijoIzquierdo() {
        this.hijoIzquierdo = null;
    }

    public void eliminarHijoDerecho() {
        this.hijoDerecho = null;
    }

    public boolean esVacio() {
        return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
    }

    public boolean esHoja() {
        return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

    }

    @Override
    public String toString() {
        return this.getDato().toString();
    }


    public boolean tieneHijoIzquierdo() {
        return this.hijoIzquierdo != null;
    }


    public boolean tieneHijoDerecho() {
        return this.hijoDerecho != null;
    }

    public int contarHojas() {
        if (!this.esVacio()) {
            if (this.esHoja()) {
                return 1;
            }
            int cantHojas = 0;
            if (this.tieneHijoIzquierdo()) {
                cantHojas += this.getHijoIzquierdo().contarHojas();
            }
            if (this.tieneHijoDerecho()) {
                cantHojas += this.getHijoDerecho().contarHojas();
            }

            return cantHojas;
        }

        return 0;
    }


    public ArbolBinario<T> espejo() {
        ArbolBinario<T> resultado = new ArbolBinario<>(this.getDato());

        if (!this.esVacio()) {
            if (this.tieneHijoIzquierdo()) {
                resultado.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
            }
            if (this.tieneHijoDerecho()) {
                resultado.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
            }
        }

        return resultado;

    }


    public void entreNiveles(int n, int m) {
        if (n > m) {
            System.out.println("n tiene que ser mayor que m");
            return;
        }
        if (n < 0) {
            System.out.println("n y m tienen que ser numeros positivos");
            return;
        }

        ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
        ColaGenerica<Integer> niveles = new ColaGenerica<>();
        cola.encolar(this);
        niveles.encolar(0);

        while (!cola.esVacia()) {
            ArbolBinario<T> actual = cola.desencolar();
            int nivelActual = niveles.desencolar();

            if (nivelActual > m) {
                break;
            }

            System.out.println(actual.getDato());

            if (actual.tieneHijoIzquierdo()) {
                cola.encolar(actual.getHijoIzquierdo());
                niveles.encolar(nivelActual + 1);
            }
            if (actual.tieneHijoDerecho()) {
                cola.encolar(actual.getHijoDerecho());
                niveles.encolar(nivelActual + 1);
            }

        }

    }

    public void imprimirPreOrden() {
        if (!this.esVacio()) {
            System.out.println(dato);
            if (this.tieneHijoIzquierdo()) {
                this.getHijoIzquierdo().imprimirPreOrden();
            }
            if (this.tieneHijoDerecho()) {
                this.getHijoDerecho().imprimirPreOrden();
            }
        }
    }


}
