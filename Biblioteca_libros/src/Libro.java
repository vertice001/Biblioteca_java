public class Libro {
    private String titulo;
    private String autor;
    private int cantidad;
    private String editorial; 
    private boolean disponible;

    public Libro(String titulo, String autor, int cantidad, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidad = cantidad;
        this.editorial = editorial;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
