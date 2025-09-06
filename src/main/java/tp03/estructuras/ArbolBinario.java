package tp03.estructuras;

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
        if (!esVacio()) {
            int cantHijos = 0;
            if (esHoja()) {
                return 1;
            } else {
                if (tieneHijoIzquierdo()) {
                    cantHijos += hijoIzquierdo.contarHojas();
                }
                if (tieneHijoDerecho()) {
                    cantHijos += hijoDerecho.contarHojas();
                }
                return cantHijos;
            }
        }
        return 0;
    }


    public ArbolBinario<T> espejo() {
        ArbolBinario<T> resultado = new ArbolBinario<>();
        espejar(resultado, this);
        return resultado;

    }

    private void espejar(ArbolBinario<T> resultado, ArbolBinario<T> arbolOriginal) {
        if (!arbolOriginal.esVacio()) {
            resultado.setDato(arbolOriginal.getDato());
            if (arbolOriginal.tieneHijoIzquierdo()) {
                resultado.agregarHijoDerecho(new ArbolBinario<>());
                espejar(resultado.getHijoDerecho(), arbolOriginal.getHijoIzquierdo());
            }
            if (arbolOriginal.tieneHijoDerecho()) {
                resultado.agregarHijoIzquierdo(new ArbolBinario<>());
                espejar(resultado.getHijoIzquierdo(), arbolOriginal.getHijoDerecho());
            }
        }
    }


    public void entreNiveles(int n, int m) {

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
