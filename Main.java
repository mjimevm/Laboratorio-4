import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner teclado = new Scanner(System.in);

        int key = 0;
        boolean salir = false;

        while (key == 0) {
            System.out.println("\n--- Bienvenido a Estudio de Grabación Audiovisual (EGA) ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Ver lista de usuarios");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("\nUsuario: ");
                    String usuario = teclado.next();
                    boolean found = false;
                    for (Usuario u : controlador.getUsuarios()) {
                        if (u.getUsername().equals(usuario)) {
                            found = true;
                            System.out.print("Contraseña: ");
                            String password = teclado.next();
                            if (u.getPassword().equals(password)) {
                                System.out.println("Inicio de sesión exitoso. Bienvenido " + u.getUsername() + "!");
                                salir = false;
                                while (!salir) {
                                    System.out.println("\nMenú Principal:");
                                    System.out.println("1. Crear Contenido");
                                    System.out.println("2. Editar contenido");
                                    System.out.println("3. Eliminar Contenidos");
                                    System.out.println("4. Publicar Contenido");
                                    System.out.println("5. Lista de Contenidos");
                                    System.out.println("6. Salir");
                                    System.out.print("Seleccione una opción: ");
                                    int opc = teclado.nextInt();
                                    switch (opc) {
                                        case 1:
                                            if (u.getTipo() == 1) {
                                                System.out.println("\nEl administrador no puede crear contenido");
                                                break;
                                            }
                                            System.out.println("\nCreación de Contenido");
                                            System.out.print("Tipo de contenido (Articulo, video o imagen): ");
                                            String respuesta = teclado.next().toLowerCase().trim();
                                            while (!respuesta.equalsIgnoreCase("articulo") && !respuesta.equalsIgnoreCase("video") && !respuesta.equalsIgnoreCase("imagen")) {
                                                System.out.print("Contenido incorrecto. Ingrese tipo de contenido (Articulo, video o imagen): ");
                                                respuesta = teclado.next();
                                            }
                                            switch (respuesta) {
                                                case "articulo":
                                                    System.out.print("Nombre: ");
                                                    String nombreArticulo = teclado.next();
                                                    System.out.print("Descripcion: ");
                                                    String descripcionArticulo = teclado.next();
                                                    System.out.print("Etiqueta: ");
                                                    ArrayList<String> etiquetasArticulo = new ArrayList<>();
                                                    String etiqueta = teclado.next();
                                                    etiquetasArticulo.add(etiqueta);
                                                    System.out.println("¿Desea agregar más etiquetas? (si/no)");
                                                    String etiquetasRespuesta = teclado.next().toLowerCase().trim();
                                                    while (etiquetasRespuesta.equalsIgnoreCase("si")) {
                                                        System.out.print("Etiqueta: ");
                                                        String nuevaEtiqueta = teclado.next();
                                                        // Agregar etiqueta al arrayList de etiquetas
                                                        etiquetasArticulo.add(nuevaEtiqueta);
                                                        System.out.println("¿Desea agregar más etiquetas? (si/no)");
                                                        etiquetasRespuesta = teclado.next().toLowerCase().trim();
                                                    }
                                                    System.out.print("Categoría: ");
                                                    String categoriaArticulo = teclado.next();
                                                    System.out.print("Autor del artículo: ");
                                                    String autorArticulo = teclado.next();
                                                    System.out.print("Fecha Publicación: ");
                                                    String fechaPublicacion = teclado.next();
                                                    System.out.print("Hora de Publicación: ");
                                                    String horaPublicacion = teclado.next();
                                                    System.out.print("Resumen: ");
                                                    String resumen = teclado.next();
                                                    // Crear el artículo
                                                    Articulo articulo = new Articulo(nombreArticulo, descripcionArticulo, etiquetasArticulo, categoriaArticulo, autorArticulo, fechaPublicacion, horaPublicacion, resumen);
                                                    controlador.agregarContenido(articulo);
                                                    System.out.println("Artículo creado exitosamente:\n" + articulo);
                                                    break;
                                                case "video":
                                                    // Lógica para crear un video
                                                    break;
                                                case "imagen":
                                                    // Lógica para crear una imagen
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            // Lógica para editar contenido
                                            break;
                                        case 3:
                                            // Lógica para eliminar contenido
                                            break;
                                        case 4:
                                            // Lógica para publicar contenido
                                            break;
                                        case 5:
                                            // Lógica para listar contenidos
                                            for (Contenido c : controlador.getMultimedia()) {
                                                System.out.println(c);
                                            }
                                            break;
                                        case 6:
                                            // Salir de la sesión del usuario
                                            salir = true;
                                            break;
                                        default:
                                            System.out.println("Opción no válida. Por favor, intente de nuevo.");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Contraseña incorrecta. Intente de nuevo.");
                            }
                            break; // user handled (found or password wrong) -> exit loop
                        }
                    }
                    if (!found) {
                        System.out.println("Usuario no encontrado. Por favor, regístrese.");
                    }
                    break;

                // Registrarse
                case 2:
                    System.out.print("Ingrese un nuevo nombre de usuario: ");
                    String newUsuario = teclado.next();
                    for (Usuario u : controlador.getUsuarios()) {
                        if (u.getUsername().equals(newUsuario)) {
                            System.out.println("El nombre de usuario ya existe. Intente con otro.");
                            break;
                        }
                    }
                    System.out.print("Ingrese una nueva contraseña: ");
                    String newPassword = teclado.next();
                    System.out.print("Indique el tipo de usuario (1. Admin, 2. Editor): ");
                    int tipoUsuario = teclado.nextInt();
                    Usuario nuevoUsuario = new Usuario (newUsuario, newPassword, tipoUsuario);
                    controlador.agregarUsuario(nuevoUsuario);
                    break;
                case 3:
                    System.out.println("\nLista de Usuarios Registrados:");
                    for (Usuario u : controlador.getUsuarios()) {
                        System.out.println(u);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    key = 1; // Salir del bucle para terminar el programa
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}