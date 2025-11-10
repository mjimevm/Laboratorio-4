public class Usuario {
    // Atributos de la clase
    private String username;
    private String password;
    private int tipo;

    // Constructor
    public Usuario (String username, String password, int tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }
    // Getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getTipo() {
        return tipo;
    }
    // Setters
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

    // Polimorfismo
    @Override
    // Representación en String del objeto Usuario
    public String toString() {
        return "[Username: " + username + "] [Password: " + password + " ] [Tipo de usuario: " + tipo + "]";
    }
}