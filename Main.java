// Universidad del Valle de Guatemala
// Programación Orientada a Objetos
// Jimena Vásquez - 25092
// Alejandro Sagastume - 25257

// Laboratorio 4

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner teclado = new Scanner(System.in);

        // "Llave" para el bucle principal
        int key = 0;
        // Si es true, el usuario sale al menú principal
        boolean salir = false;

        while (key == 0) {
            // Menú Principal
            System.out.println("\n--- Bienvenido a Estudio de Grabación Audiovisual (EGA) ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            // Input usuario
            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                // Iniciar sesión
                // Ingresar Usuario
                    System.out.print("\nUsuario: ");
                    String usuario = teclado.next();
                    boolean found = false;
                    for (Usuario u : controlador.getUsuarios()) {
                        if (u.getUsername().equals(usuario)) {
                            found = true;
                            System.out.print("Contraseña: ");
                            String password = teclado.next();
                            // Si el usuario existe, se procede a ingresar la contraseña; de lo contrario, sale al menu principal
                            if (u.getPassword().equals(password)) {
                                System.out.println("Inicio de sesión exitoso. Bienvenido " + u.getUsername() + "!");
                                controlador.setUsuarioActual(u);
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
                                    try {
                                        opc = Integer.parseInt(String.valueOf(opc));
                                    } catch (Exception e) {
                                        System.out.println("Entrada inválida. Por favor, ingrese un número.");
                                        continue;
                                    }
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
                                                    System.out.print("\nNombre: ");
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
                                                    LocalDate fechaPublicacion = LocalDate.parse(teclado.next());
                                                    try {
                                                        fechaPublicacion = LocalDate.parse(teclado.next());
                                                    } catch (Exception e) {
                                                        System.out.println("Fecha inválida. Por favor, ingrese la fecha en formato YYYY-MM-DD:");
                                                        fechaPublicacion = LocalDate.parse(teclado.next());
                                                    }
                                                    System.out.print("Hora de Publicación: ");
                                                    LocalTime horaPublicacion = LocalTime.parse(teclado.next());
                                                    try {
                                                        horaPublicacion = LocalTime.parse(teclado.next());
                                                    } catch (Exception e) {
                                                        System.out.println("Hora inválida. Por favor, ingrese la hora en formato HH:MM:");
                                                        horaPublicacion = LocalTime.parse(teclado.next());
                                                    }
                                                    System.out.print("Resumen: ");
                                                    String resumen = teclado.next();
                                                    // Crear el artículo
                                                    Articulo articulo = new Articulo(nombreArticulo, descripcionArticulo, etiquetasArticulo, categoriaArticulo, autorArticulo, fechaPublicacion, horaPublicacion, resumen);
                                                    controlador.agregarContenido(articulo);
                                                    System.out.println("Artículo creado exitosamente:\n" + articulo);
                                                    break;
                                                case "video":
                                                    System.out.print("\nNombre: ");
                                                    String nombreVideo = teclado.next();
                                                    System.out.print("Descripcion: ");
                                                    String descripcionVideo = teclado.next();
                                                    System.out.print("Etiqueta: ");
                                                    ArrayList<String> etiquetasVideos = new ArrayList<>();
                                                    String etiqueta1 = teclado.next();
                                                    etiquetasVideos.add(etiqueta1);
                                                    System.out.println("¿Desea agregar más etiquetas? (si/no)");
                                                    String etiquetasRespuesta1 = teclado.next().toLowerCase().trim();
                                                    while (etiquetasRespuesta1.equalsIgnoreCase("si")) {
                                                        System.out.print("Etiqueta: ");
                                                        String nuevaEtiqueta1 = teclado.next();
                                                        // Agregar etiqueta al arrayList de etiquetas
                                                        etiquetasVideos.add(nuevaEtiqueta1);
                                                        System.out.println("¿Desea agregar más etiquetas? (si/no)");
                                                        etiquetasRespuesta1 = teclado.next().toLowerCase().trim();
                                                    }
                                                    System.out.print("Categoría: ");
                                                    String categoriaVideo = teclado.next();
                                                    System.out.print("Duración del video (HH:mm:ss): ");
                                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                                                    LocalTime duracionVideo = LocalTime.parse(teclado.next(), formatter);
                                                    try {
                                                        duracionVideo = LocalTime.parse(teclado.next(), formatter);
                                                    } catch (Exception e) {
                                                        System.out.println("Duración inválida. Por favor, ingrese la duración en formato HH:mm:ss:");
                                                        duracionVideo = LocalTime.parse(teclado.next(), formatter);
                                                    }
                                                    // Crear el video
                                                    Video video = new Video(nombreVideo, descripcionVideo, etiquetasVideos, categoriaVideo, duracionVideo);
                                                    controlador.agregarContenido(video);
                                                    System.out.println("Video creado exitosamente:\n" + video);
                                                    break;
                                                case "imagen":
                                                    System.out.print("\nNombre: ");
                                                    String nombreImagen = teclado.next();
                                                    System.out.print("Descripcion: ");
                                                    String descripcionImagen = teclado.next();
                                                    System.out.print("Etiqueta: ");
                                                    ArrayList<String> etiquetasImagenes = new ArrayList<>();
                                                    String etiqueta2 = teclado.next();
                                                    etiquetasImagenes.add(etiqueta2);
                                                    System.out.println("¿Desea agregar más etiquetas? (si/no)");
                                                    String etiquetasRespuesta2 = teclado.next().toLowerCase().trim();
                                                    while (etiquetasRespuesta2.equalsIgnoreCase("si")) {
                                                        System.out.print("Etiqueta: ");
                                                        String nuevaEtiqueta2 = teclado.next();
                                                        // Agregar etiqueta al arrayList de etiquetas
                                                        etiquetasImagenes.add(nuevaEtiqueta2);
                                                        System.out.println("¿Desea agregar más etiquetas? (si/no)");
                                                        etiquetasRespuesta2 = teclado.next().toLowerCase().trim();
                                                    }
                                                    System.out.print("Categoría: ");
                                                    String categoriaImagen = teclado.next();
                                                    System.out.print("Resolución de la imagen: ");
                                                    double resolucionImagen = teclado.nextDouble();
                                                    // Crear la imagen
                                                    Imagen imagen = new Imagen(nombreImagen, descripcionImagen, etiquetasImagenes, categoriaImagen, resolucionImagen);
                                                    controlador.agregarContenido(imagen);
                                                    System.out.println("Imagen creada exitosamente:\n" + imagen);
                                                    break;
                                            }
                                            break;
                                        // Editar contenido
                                        case 2:
                                            System.out.println("\nEDITAR CONTENIDO");
                                            System.out.println("Elija el índice del contenido que quiere modificar");
                                            int i = 0;
                                            for (Contenido c : controlador.getMultimedia()) {
                                                System.out.println( i + " -> " + c.getNombre());
                                                i++;
                                            }
                                            if (i == 0) {
                                                System.out.println("No hay contenidos para editar.");
                                                break;
                                            }
                                            System.out.print("\nSeleccione una opción (índice): ");
                                            int editarOpcion = teclado.nextInt();
                                            if (editarOpcion >= 0 && editarOpcion < controlador.getMultimedia().size()) {
                                                Contenido c = controlador.getMultimedia().get(editarOpcion);
                                                System.out.println("¿Qué quiere modificar?");
                                                System.out.println("1. Nombre");
                                                System.out.println("2. Descripción");
                                                System.out.println("3. Agregar etiqueta");
                                                System.out.println("4. Categoría");
                                                System.out.print("Seleccione una opcion: ");
                                                int opcionEditar = teclado.nextInt();
                                                teclado.nextLine(); // linea de salto
                                                System.out.print("Ingrese la modificación: ");
                                                String modificacion = teclado.nextLine();
                                                controlador.editarContenido(c, opcionEditar, modificacion);
                                            } else {
                                                System.out.println("Índice inválido. Contenido no encontrado.");
                                                break;
                                            }
                                            break;
                                        // Eliminar contenido
                                        case 3:
                                            if (controlador.getMultimedia().isEmpty()) {
                                                System.out.println("No hay contenidos para eliminar.");
                                                break;
                                            }
                                            System.out.println("\nELIMINAR CONTENIDO");
                                            int idx = 0;
                                            for (Contenido c : controlador.getMultimedia()) {
                                                System.out.println(idx + " -> " + c.getNombre());
                                                idx++;
                                            }
                                            System.out.print("Seleccione índice a eliminar: ");
                                            int eliminarIdx = teclado.nextInt();
                                            if (eliminarIdx >= 0 && eliminarIdx < controlador.getMultimedia().size()) {
                                                String mensaje = controlador.eliminarContenido(eliminarIdx);
                                                System.out.println(mensaje);
                                            } else {
                                                System.out.println("Índice inválido...");
                                            }
                                            break;
                                        // Publicar contenido
                                        case 4:
                                            if (controlador.getMultimedia().isEmpty()) {
                                                System.out.println("No hay contenidos para publicar.");
                                                break;
                                            }
                                            System.out.println("\nPUBLICAR CONTENIDO");
                                            int index = 0;
                                            System.out.println("Contenidos disponibles:");
                                            for (Contenido cntnido : controlador.getMultimedia()) {
                                                System.out.println(index + "-> " + cntnido.getNombre());
                                                index++;
                                            }
                                            int nombreContenido = teclado.nextInt();
                                            if (nombreContenido >= 0 && nombreContenido < controlador.getMultimedia().size()) {
                                                String resultado = controlador.publicarContenido();
                                                System.out.println(resultado);
                                            } else {
                                                System.out.println("Índice inválido...");
                                            }
                                            break;
                                        // Listar contenidos
                                        case 5:
                                            if (controlador.getMultimedia().isEmpty()) {
                                                System.out.println("No hay contenidos disponibles.");
                                                break;
                                            }
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
                            break;
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
                            System.out.print("Ingrese un nuevo nombre de usuario: ");
                            newUsuario = teclado.next();
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
                    System.out.println("Saliendo del programa...");
                    controlador.salirSesion();
                    key = 1; // Salir del bucle para terminar el programa
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}