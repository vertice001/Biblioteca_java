import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Principal");
        Scanner scanner = new Scanner(System.in);

        menuPrincipal: while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1.Bibliotecario ");
            System.out.println("2.Lector");
            System.out.println("0. Salir");

            int opcion1 = scanner.nextInt();
            scanner.nextLine();

            if (opcion1 == 1) {

                while (true) {
                    System.out.println("\n--- Menú ---");
                    System.out.println("1. Agregar libro");
                    System.out.println("2. Prestar libro");
                    System.out.println("3. Devolver libro");
                    System.out.println("4. Buscar libro");
                    System.out.println("5. Eliminar libro");
                    System.out.println("6. Mostrar inventario");
                    System.out.println("7. volver");
                    System.out.print("Seleccione una opción: ");

                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el título del libro: ");
                            String titulo = scanner.nextLine();
                            System.out.print("Ingrese el autor del libro: ");
                            String autor = scanner.nextLine();
                            System.out.print("Ingrese la cantidad de copias: ");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Ingrese la editorial del libro: ");
                            String editorial = scanner.nextLine();

                            Libro nuevoLibro = new Libro(titulo, autor, cantidad, editorial);
                            biblioteca.guardarLibro(nuevoLibro);
                            break;

                        case 2:
                            System.out.print("Ingrese el título del libro a prestar: ");
                            String tituloPrestamo = scanner.nextLine();
                            String resultadoPrestamo = biblioteca.prestarLibro(tituloPrestamo);
                            System.out.println(resultadoPrestamo);
                            break;

                        case 3:
                            System.out.print("Ingrese el título del libro a devolver: ");
                            String tituloDevolucion = scanner.nextLine();
                            String resultadoDevolucion = biblioteca.devolverLibro(tituloDevolucion);
                            System.out.println(resultadoDevolucion);
                            break;

                        case 4:
                            System.out.print("Ingrese el título del libro a buscar: ");
                            String tituloBusqueda = scanner.nextLine();
                            List<Libro> librosEncontrados = biblioteca.buscarLibro(tituloBusqueda);

                            if (!librosEncontrados.isEmpty()) {
                                System.out.println("Libros encontrados:");
                                for (Libro libro : librosEncontrados) {
                                    System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()
                                            + ", Cantidad: " + libro.getCantidad());

                                }
                            } else {
                                System.out.println("No se encontraron libros con ese título.");
                            }
                            break;

                        case 5:
                            System.out.print("Ingrese el título del libro a eliminar: ");
                            String tituloEliminar = scanner.nextLine();
                            String resultadoEliminar = biblioteca.eliminarLibro(tituloEliminar);
                            System.out.println(resultadoEliminar);
                            break;
                        case 6:
                            biblioteca.mostrarInventario();
                            break;

                        case 7:

                            break menuPrincipal;

                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                }
            } else {
                System.out.println("\n--- Menú ---");

                System.out.println("1. Devolver libro");
                System.out.println("2. Buscar libro");
                System.out.println("0. volver");
                System.out.print("Seleccione una opción: ");
                int opcion2 = scanner.nextInt();
                scanner.nextLine();
                switch (opcion2) {

                    case 1:
                        System.out.print("Ingrese el título del libro a devolver: ");
                        String tituloDevolucion = scanner.nextLine();
                        String resultadoDevolucion = biblioteca.devolverLibro(tituloDevolucion);
                        System.out.println(resultadoDevolucion);
                        break;

                    case 2:
                        System.out.print("Ingrese el título del libro a buscar: ");
                        String tituloBusqueda = scanner.nextLine();
                        List<Libro> librosEncontrados = biblioteca.buscarLibro(tituloBusqueda);

                        if (!librosEncontrados.isEmpty()) {
                            System.out.println("Libros encontrados:");
                            for (Libro libro : librosEncontrados) {
                                System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()
                                        + ", Cantidad: " + libro.getCantidad());

                            }
                        } else {
                            System.out.println("No se encontraron libros con ese título.");
                        }
                        break;

                    case 0:
                        System.out.println("¡Hasta luego!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }

        }
    }
}
