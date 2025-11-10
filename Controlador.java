import java.util.ArrayList;

public class Controlador {
    // Atributos
    private ArrayList<Contenido> multimedia;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;

    // Constructor
    public Controlador() {
        multimedia = new ArrayList<>();
        usuarios = new ArrayList<>();
        usuarioActual = null;
    }
    // Agregar el contenido al ArrayList multimedia
    public void agregarContenido(Contenido contenido) {
        multimedia.add(contenido);
    }
    // Obtener la lista de contenido multimedia
    public ArrayList<Contenido> getMultimedia() {
        return multimedia;
    }
    // Agregar un usuario al ArrayList usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    // Obtener la lista de usuarios
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    // Obtener el usuario actual
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    // Establecer el usuario actual
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    // Editar contenido multimedia
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
        // Despublicar el contenido si el usuario tiene permisos para crear
        if (usuarioActual.puedeCrear()) {
            for (Contenido contenido : multimedia) {
                if (contenido == c) {
                    if (c instanceof Publicable) {
                        ((Publicable) c).despublicar();
                    }
                    return;
                }
            }
        }
    }
    // Eliminar contenido multimedia
    public String eliminarContenido(int indice) {
        if (indice >= 0 && indice < multimedia.size()) {
            Contenido eliminado = multimedia.remove(indice);
            // Recorrer la lista y despublicar el contenido eliminado
            for (Contenido c : multimedia) {
                if (c instanceof Publicable) {
                    ((Publicable) c).despublicar();
                }
            }
            return "Contenido eliminado: " + eliminado;
        }
        return "Índice inválido. No se pudo eliminar el contenido.";
    }
    // Publicar contenido multimedia
    public String publicarContenido() {
        if (usuarioActual.puedePublicar()) {
            // Recorrer la lista y publicar todo el contenido
            for (Contenido c : multimedia) {
                if (c instanceof Publicable) {
                    ((Publicable) c).publicar();
                }
            }
            return "Contenido publicado exitosamente por: " + usuarioActual.getUsername();
        }
        return "El usuario actual no tiene permisos para publicar contenido.";
    }
    // Salir de la sesión del usuario actual
    public void salirSesion() {
        usuarioActual = null;
    }
}
