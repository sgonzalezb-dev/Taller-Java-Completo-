package n04_herencia;

/**
 * Nivel 04 · Herencia y composición (Sesión 03).
 * Superclase Producto que concentra nombre y precio.
 */
public class Producto {
    private final String nombre;
    private final int precio;

    public Producto(String nombre, int precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }

    public String descripcion() {
        return nombre + " $" + precio;
    }
}
