import java.util.ArrayList;

public class Podcast extends Contenido {
    private double duracion;

    public Podcast(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, double duracion) {
        super(nombre, descripcion, etiquetas, categoria);
        this.duracion = duracion;
    }

    public double getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duración: " + duracion + " minutos]";
    }
    
}
