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
    

}
