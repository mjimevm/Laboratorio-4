import java.util.ArrayList;

public abstract class Contenido {
    protected String nombre;
    protected String descripcion;
    protected ArrayList<String> etiquetas;
    protected String categoria;

    public Contenido(String nombre, String descripcion, ArrayList<String> etiquetas, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.categoria = categoria;
    }
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
   
    @Override 
    public String toString() {
        return "CONTENIDO: [Nombre: " +nombre+ ", Descripción: " + descripcion + ", etiquetas: " + etiquetas + ", Categoría: " + categoria;
    }

}
