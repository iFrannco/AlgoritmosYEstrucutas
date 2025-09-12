package tp03.estructuras;

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
        // TO DO

    }

    private void agregar(Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO

    }

    public ArbolBinarioDeBusqueda<T> buscarMayorDeLosMenores(ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO
        return null;
    }

    public ArbolBinarioDeBusqueda<T> buscarMayor(ArbolBinarioDeBusqueda<T> arbol) {
        // TO DO
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
}
