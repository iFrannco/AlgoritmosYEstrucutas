package Practica;

import tp01.ejercicio2.estructuras.ListaGenerica;
import tp02.estructuras.ArbolGeneral;

public class Ejercicio_Extra_1 {

    // Enunciado: Implementa un metodo para contar todos los elementos a partir de un nombre
    // determinado

    // Pasos:
    // buscar una carpeta y adentro contar los elmentos.
    // primero recorrer el arbol buscando la carpeta raiz
    // si la encuentro, llamar a otro metodo que cuenta la cantidad de elementos dentro de la carpeta

    public int contarElementos(ArbolGeneral<File> fileSystem, String nombre) {
        int resultado = 0;

        if (!fileSystem.esVacio()) {
            if (fileSystem.getDato().getNombre().equals(nombre)) {
                resultado = contadorDeElementosPropio(fileSystem) - 1; // -1 si no se quiere contar la carpeta raiz.
            } else {
                ListaGenerica<ArbolGeneral<File>> hijos = fileSystem.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    resultado = contarElementos(hijos.proximo(), nombre);
                    if (resultado > 0) { // la carpeta tiene al menos un archivo. Si la encuentra, retorna el resultado.
                        return resultado;
                    }
                }
            }
        }

        return resultado;
    }

    private int contadorDeElementosPropio(ArbolGeneral<File> fileSystem) {
        int resultado = 0;

        if (!fileSystem.esVacio()) {
            resultado++;
            ListaGenerica<ArbolGeneral<File>> hijos = fileSystem.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                resultado += contadorDeElementosPropio(hijos.proximo());
            }

        }

        return resultado;
    }

    public class File {
        private String nombre;

        public String getNombre() {
            return this.nombre;
        }

    }
}
