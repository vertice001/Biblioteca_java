import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> inventario;
    private String direccion;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
        this.direccion = direccion;
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Almacenamiento vacío.");
        } else {
            System.out.println("Listado de libros en la biblioteca:");
            for (Libro l : inventario) {
                System.out.println("Título: " + l.getTitulo() + ", Autor: " + l.getAutor() +
                        ", Cantidad: " + l.getCantidad() + ", Editorial: " + l.getEditorial());
            }
        }
    }

    public List<Libro> buscarLibro(String titulo) {
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : inventario) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                librosEncontrados.add(libro);
            }
        }

        return librosEncontrados;
    }

    public void guardarLibro(Libro libro) {
        inventario.add(libro);
        System.out.println("Libro guardado con éxito.");
        System.out.println("Listado de libros en la biblioteca:");
        for (Libro l : inventario) {
            System.out.println("Título: " + l.getTitulo() + ", Autor: " + l.getAutor());
        }
    }

    public String prestarLibro(String titulo) {
        for (Libro libro : inventario) {
            if (libro.getTitulo().equals(titulo) && libro.getCantidad() > 0) {
                libro.setCantidad(libro.getCantidad() - 1);

                if (libro.getCantidad() == 0) {
                    inventario.remove(libro);
                }

                return "Se ha prestado el libro '" + titulo + "'.";
            }
        }
        return "El libro '" + titulo + "' no está disponible en este momento.";
    }

    public String devolverLibro(String titulo) {
        for (Libro libro : inventario) {
            if (libro.getTitulo().equals(titulo) && !libro.isDisponible()) {
                libro.setDisponible(true);
                return "Se ha devuelto el libro '" + titulo + "'.";
            }
        }
        return "El libro '" + titulo + "' no se encuentra prestado o no existe en la biblioteca.";
    }

    public String eliminarLibro(String titulo) {
        Iterator<Libro> iterator = inventario.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getTitulo().equals(titulo)) {
                iterator.remove();
                return "Se ha eliminado el libro '" + titulo + "' de la biblioteca.";
            }
        }
        return "No se encontró el libro '" + titulo + "' en la biblioteca.";
    }
}
