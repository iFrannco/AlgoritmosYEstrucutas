package tp01.ejercicio2.estructuras;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String legajo;

    public Estudiante(String nombre, String apellido, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\nApellido: " + this.apellido +
                "\nLegajo: " + this.legajo + "\n";
    }
}
