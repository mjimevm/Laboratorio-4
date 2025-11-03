import java.util.ArrayList;

public class Imagen extends Contenido {
    private String resolucion;

    public Imagen(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, String resolucion) {
        super(nombre, descripcion, etiquetas, categoria);
        this.resolucion = resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Resolución: " + resolucion + "]";
    }
}
