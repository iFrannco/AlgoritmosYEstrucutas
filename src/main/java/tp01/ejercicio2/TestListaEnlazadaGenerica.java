package tp01.ejercicio2;

import tp01.ejercicio2.estructuras.Estudiante;
import tp01.ejercicio2.estructuras.ListaEnlazadaGenerica;

public class TestListaEnlazadaGenerica {
    public static void main(String[] args) {
        ListaEnlazadaGenerica lista = new ListaEnlazadaGenerica();
        Estudiante[] estudiantes = new Estudiante[3];

        estudiantes[0] = new Estudiante("damian", "gasparini", "42244");
        estudiantes[1] = new Estudiante("franco", "cabeza", "53434");
        estudiantes[2] = new Estudiante("lautaro", "salvo", "422443");

        lista.agregar(estudiantes);

        lista.tusDatos();

    }
}
