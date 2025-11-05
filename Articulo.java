import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Articulo extends Contenido implements Publicable {
    private String autor;
    private LocalDate fechaPublicacion;
    private LocalTime horaPublicacion;
    private String resumen;
    private boolean publicado;

    public Articulo(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, String autor, LocalDate fechaPublicacion, LocalTime horaPublicacion, String resumen) {
        super(nombre,  descripcion, etiquetas, categoria);
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.horaPublicacion = horaPublicacion;
        this.resumen = resumen;
        this.publicado = false;
    }
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
        return super.toString() + ", Autor: " + autor + ", Fecha de Publicación: " + fechaPublicacion + ", Hora de Publicación: " + horaPublicacion + ", Resumen: " + resumen + ", Publicado: " + publicado + "]";
    }

}
