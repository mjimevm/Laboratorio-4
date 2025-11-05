import java.util.ArrayList;

public class Controlador {
    private ArrayList<Contenido> multimedia;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;

    public Controlador() {
        multimedia = new ArrayList<>();
        usuarios = new ArrayList<>();
        usuarioActual = null;
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
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
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
    public String eliminarContenido(int indice) {
        if (indice >= 0 && indice < multimedia.size()) {
            Contenido eliminado = multimedia.remove(indice);
            for (Contenido c : multimedia) {
                if (c instanceof Publicable) {
                    ((Publicable) c).despublicar();
                }
            }
            return "Contenido eliminado: " + eliminado;
        }
        return "Índice inválido. No se pudo eliminar el contenido.";
    }
    public String publicarContenido() {
        if (usuarioActual.puedePublicar()) {
            for (Contenido c : multimedia) {
                if (c instanceof Publicable) {
                    ((Publicable) c).publicar();
                }
            }
            return "Contenido publicado exitosamente por: " + usuarioActual.getUsername();
        }
        return "El usuario actual no tiene permisos para publicar contenido.";
    }
    public void salirSesion() {
        usuarioActual = null;
    }
}
