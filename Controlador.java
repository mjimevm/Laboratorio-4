import java.util.ArrayList;

public class Controlador {
    private ArrayList<Contenido> multimedia;
    private ArrayList<Usuario> usuarios;

    public Controlador() {
        multimedia = new ArrayList<>();
        usuarios = new ArrayList<>();
    }
    public void agregarContenido(Contenido contenido) {
        multimedia.add(contenido);
    }
    public ArrayList<Contenido> getMultimedia() {
        return multimedia;
    }
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void editarContenido(Contenido c,int opcion, String modificacion) {
        if (opcion == 1) {
            // Editar nombre
            c.setNombre(modificacion);
        } else if (opcion == 2) {
            // Editar descripcion
            c.setDescripcion(modificacion);
        } else if (opcion == 3) {
            // Agregar etiquetas
            ArrayList<String> etiquetas = c.getEtiquetas();
            etiquetas.add(modificacion);
        } else if (opcion == 4) {
            // Editar categoria
            c.setCategoria(modificacion);
        }
    }
    public String eliminarContenido(int indice) {
        if (indice >= 0 && indice < multimedia.size()) {
            Contenido eliminado = multimedia.remove(indice);
            return "Contenido eliminado: " + eliminado.getNombre();
        }
        return "Índice inválido. No se pudo eliminar el contenido.";
    }
}
