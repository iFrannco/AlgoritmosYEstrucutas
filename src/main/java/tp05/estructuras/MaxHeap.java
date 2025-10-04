package tp05.estructuras;

import tp01.ejercicio2.estructuras.ListaGenerica;

public class MaxHeap<T extends Comparable<T>> implements ColaPrioridad<T> {
    private T[] datos;
    private int cantElementos;

    public MaxHeap() {
        datos = (T[]) new Comparable[100];
    }

    public MaxHeap(ListaGenerica<T> listaDatos) {
        this.datos = (T[]) new Comparable[listaDatos.tamanio() * 2];
        listaDatos.comenzar();
        while (!listaDatos.fin()) {
            this.agregar(listaDatos.proximo());
        }
    }

    @Override
    public boolean esVacia() {
        return this.cantElementos == 0;
    }

    @Override
    public void eliminar() {
        if (!esVacia()) {
            datos[1] = datos[cantElementos];
            cantElementos--;
            perlocate_down();
        }
    }

    @Override
    public boolean agregar(T elemento) {
        // contempla que exista espacio
        try {
            this.datos[++this.cantElementos] = elemento;
            perlocate_up();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void perlocate_up() {
        int indice_hijo = cantElementos;
        int indice_padre = indice_hijo / 2;

        while (indice_hijo > 1 && datos[indice_hijo].compareTo(datos[indice_padre]) > 0) {
            T temp = datos[indice_padre];
            datos[indice_padre] = datos[indice_hijo];
            datos[indice_hijo] = temp;
            indice_hijo = indice_padre;
            indice_padre = indice_hijo / 2;
        }
    }

    private void perlocate_down() {

        int indice_raiz = 1;
        int indice_hijo_izq = indice_raiz * 2;
        int indice_hijo_der = (indice_raiz * 2) + 1;
        boolean cumple = false;

        while (!cumple) {
            if (cantElementos >= indice_hijo_izq) {
                if (cantElementos >= indice_hijo_der) {
                    if ((datos[indice_hijo_izq].compareTo(datos[indice_hijo_der]) > 0) && datos[indice_hijo_izq].compareTo(datos[indice_raiz]) > 0) {
                        T temp = this.datos[indice_raiz];
                        this.datos[indice_raiz] = this.datos[indice_hijo_izq];
                        this.datos[indice_hijo_izq] = temp;
                        indice_raiz = indice_hijo_izq;
                    } else if ((datos[indice_hijo_der].compareTo(datos[indice_hijo_izq]) > 0) && datos[indice_hijo_der].compareTo(datos[indice_raiz]) > 0) {
                        T temp = this.datos[indice_raiz];
                        this.datos[indice_raiz] = this.datos[indice_hijo_der];
                        this.datos[indice_hijo_der] = temp;
                        indice_raiz = indice_hijo_der;
                    } else {
                        cumple = true;
                    }
                } else if (datos[indice_hijo_izq].compareTo(datos[indice_raiz]) > 0) {
                    T temp = this.datos[indice_raiz];
                    this.datos[indice_raiz] = this.datos[indice_hijo_izq];
                    this.datos[indice_hijo_izq] = temp;
                    indice_raiz = indice_hijo_izq;
                } else {
                    cumple = true;
                }

            } else {
                cumple = true;
            }
            indice_hijo_izq = indice_raiz * 2;
            indice_hijo_der = (indice_raiz * 2) + 1;
        }

    }

    public void imprimir() {
        for (int i = 1; i <= this.cantElementos; i++) {
            System.out.println(datos[i]);
        }
    }

    @Override
    public T tope() {
        return datos[1];
    }
}
