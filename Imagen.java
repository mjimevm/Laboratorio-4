import java.util.ArrayList;
// Clase Imagen que extiende Contenido e implementa Publicable
public class Imagen extends Contenido implements Publicable {
    // Atributos específicos de Imagen
    private double resolucion;
    private boolean publicado;
    // Constructor
    public Imagen(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria, double resolucion) {
        super(nombre, descripcion, etiquetas, categoria);
        this.resolucion = resolucion;
        this.publicado = false;
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
    // Getter
    public double getResolucion() {
        return resolucion;
    }
    // Polimorfismo
    @Override
    public String toString() {
        // Representación en String del objeto Imagen
        return super.toString() + ", Resolución: " + resolucion + " px , Publicado: " + publicado + "]";
    }
}
