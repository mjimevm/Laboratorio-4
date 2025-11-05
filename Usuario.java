public class Usuario {
    private String username;
    private String password;
    private int tipo;

    public Usuario (String username, String password, int tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getTipo() {
        return tipo;
    }
    
    public boolean esAdmin() {
        return tipo == 1;
    }

    public boolean puedePublicar () {
        return tipo == 1;
    }

    public boolean puedeEliminar () {
        return tipo == 1;
    }

    public boolean esEditor() {
        return tipo == 2;
    }

    public boolean puedeEditar () {
        return tipo == 2;
    }

    public boolean puedeCrear() {
        return tipo == 2;
    }

    @Override
    public String toString() {
        return "[Username: " + username + "] [Password: " + password + " ] [Tipo de usuario: " + tipo + "]";
    }
}