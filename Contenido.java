import java.util.ArrayList;

// Clase abstracta de Contenido; base para otras clases hijas
public abstract class Contenido {
    // Atributos generales
    protected String nombre;
    protected String descripcion;
    protected ArrayList<String> etiquetas;
    protected String categoria;

    // Constructor
    public Contenido(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.categoria = categoria;
    }
    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }
    public String getCategoria() {
        return categoria;
    }
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    // Polimorfismo
    @Override 
    public String toString() {
        return "CONTENIDO: [Nombre: " +nombre+ ", Descripción: " + descripcion + ", etiquetas: " + etiquetas + ", Categoría: " + categoria;
    }

}
