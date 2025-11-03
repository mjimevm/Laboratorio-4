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

    @Override
    public String toString() {
        return "[Username: " + username + "] [Password: " + password + " ] [Tipo de usuario: " + tipo + "]";
    }
}