import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
// Clase Articulo que extiende Contenido e implementa Publicable
public class Articulo extends Contenido implements Publicable {
    // Atributos específicos de Articulo
    private String autor;
    private LocalDate fechaPublicacion;
    private LocalTime horaPublicacion;
    private String resumen;
    private boolean publicado;
    //  Constructor
    public Articulo(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, String autor, LocalDate fechaPublicacion, LocalTime horaPublicacion, String resumen) {
        super(nombre,  descripcion, etiquetas, categoria);
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.horaPublicacion = horaPublicacion;
        this.resumen = resumen;
        this.publicado = false;
    }
    // Getters
    public String getAutor() {
        return autor;
    }
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public LocalTime getHoraPublicacion() {
        return horaPublicacion;
    }
    public String getResumen() {
        return resumen;
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
    // Representación en String del objeto Articulo
    public String toString() {
        return super.toString() + ", Autor: " + autor + ", Fecha de Publicación: " + fechaPublicacion + ", Hora de Publicación: " + horaPublicacion + ", Resumen: " + resumen + ", Publicado: " + publicado + "]";
    }

}
