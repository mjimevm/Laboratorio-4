import java.time.LocalTime;
import java.util.ArrayList;

// Clase Video que extiende Contenido e implementa Publicable
public class Video extends Contenido implements Publicable {
    // Atributos específicos de Video
    private LocalTime duracion;
    private boolean publicado;

    // Constructor
    public Video(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, LocalTime duracion) {
        super(nombre, descripcion, etiquetas, categoria);
        this.duracion = duracion;
        this.publicado = false;
    }
    // Getter
    public LocalTime getDuracion() {
        return duracion;
    }
    // Polimorfismo via interfaces - Publicable
    @Override
    public boolean publicar() {
        if (!publicado) {
            publicado = true;
            return true;
        }
        return false;
    }
    // Polimorfismo via interfaces - Publicable
    @Override
    public boolean despublicar() {
        if (publicado) {
            publicado = false;
            return true;
        }
        return false;
    }
    // Polimorfismo via interfaces - Publicable
    @Override
    public boolean estaPublicado() {
        return publicado;
    }
    // Polimorfismo
    @Override
    // Representación en String del objeto Video
    public String toString() {
        return super.toString() + ", Duración: " + duracion + ", Publicado: " + publicado + "]";
    }
}
