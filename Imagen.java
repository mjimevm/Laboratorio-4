import java.util.ArrayList;

public class Imagen extends Contenido implements Publicable {
    private double resolucion;
    private boolean publicado;

    public Imagen(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, double resolucion) {
        super(nombre, descripcion, etiquetas, categoria);
        this.resolucion = resolucion;
        this.publicado = false;
    }

    @Override
    public boolean publicar() {
        if (!publicado) {
            publicado = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean despublicar() {
        if (publicado) {
            publicado = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean estaPublicado() {
        return publicado;
    }

    public double getResolucion() {
        return resolucion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Resolución: " + resolucion + " px , Publicado: " + publicado + "]";
    }
}
