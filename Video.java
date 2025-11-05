import java.time.LocalTime;
import java.util.ArrayList;

public class Video extends Contenido implements Publicable {
    private LocalTime duracion;
    private boolean publicado;

    public Video(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, LocalTime duracion) {
        super(nombre, descripcion, etiquetas, categoria);
        this.duracion = duracion;
        this.publicado = false;
    }

    public LocalTime getDuracion() {
        return duracion;
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

    @Override
    public String toString() {
        return super.toString() + ", Duración: " + duracion + ", Publicado: " + publicado + "]";
    }
}
