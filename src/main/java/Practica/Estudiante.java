package Practica;

public class Estudiante implements Comparable<Estudiante> {
    private String dni;
    private String nombre;
    private String apellido;

    public Estudiante(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void imprimirInformacion() {
        System.out.println("DNI: " + this.dni + "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\n");
    }

    @Override
    public int compareTo(Estudiante o) {
        return this.dni.compareTo(o.getDni());
    }

    public String getDni() {
        return this.dni;
    }
}
