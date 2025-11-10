package Practica;

import tp03.estructuras.ArbolBinarioDeBusqueda;

public class Ejercicio_3 {
    public void imprimirEstudiante(ArbolBinarioDeBusqueda<Estudiante> estudiantes) {
        if (!estudiantes.esVacio()) {
            if (estudiantes.tieneHijoDerecho()) {
                imprimirEstudiante(estudiantes.getHijoDerecho());
            }
            estudiantes.getDato().imprimirInformacion();
            if (estudiantes.tieneHijoIzquierdo()) {
                imprimirEstudiante(estudiantes.getHijoIzquierdo());
            }
        }
    }

}
