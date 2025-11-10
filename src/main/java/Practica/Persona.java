package Practica;

public class Persona implements Comparable<Persona> {
    private String dni;

    public Persona(String dni) {
        this.dni = dni;
    }

    @Override
    public int compareTo(Persona p) {
        return this.dni.compareTo(p.getDNI());
    }

    public String getDNI() {
        return this.dni;
    }

    public String toString() {
        return "dni: " + this.dni;
    }

}