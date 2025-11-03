import java.util.ArrayList;

public class Video extends Contenido {
    private String duracion;

    public Video(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, String duracion) {
        super(nombre, descripcion, etiquetas, categoria);
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duración: " + duracion + "]";
    }
}
