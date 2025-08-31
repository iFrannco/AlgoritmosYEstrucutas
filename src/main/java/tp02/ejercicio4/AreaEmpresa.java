package tp02.ejercicio4;

public class AreaEmpresa {

    private String nombre;
    private int tardanza_mensaje;


    public AreaEmpresa(String nombre, int tardanza_mensaje) {
        this.nombre = nombre;
        this.tardanza_mensaje = tardanza_mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTardanza_mensaje() {
        return tardanza_mensaje;
    }

    public void setTardanza_mensaje(int tardanza_mensaje) {
        this.tardanza_mensaje = tardanza_mensaje;
    }

    @Override
    public String toString() {
        return "AreaEmpresa{" +
                "nombre='" + nombre + '\'' +
                ", tardanza_mensaje=" + tardanza_mensaje +
                '}';
    }
}
