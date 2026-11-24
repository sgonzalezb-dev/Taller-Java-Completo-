package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Niveles 01, 02, 03, 04, 05, 06, 08).
 * Plantilla abstracta Producto con atributos encapsulados, validación en constructor y método abstracto.
 */
public abstract class Producto implements Identificable {
    private final int id;
    private final String nombre;
    private final Categoria categoria;
    private final int precioBase;

    protected Producto(int id, String nombre, Categoria categoria, int precioBase) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id del producto debe ser positivo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }
        if (precioBase <= 0 || precioBase > 100000) {
            throw new IllegalArgumentException("Precio fuera de rango válido: " + precioBase);
        }
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
    }

    @Override
    public int id() { return id; }
    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }
    public int getPrecioBase() { return precioBase; }

    public int getPrecio() {
        return precioBase;
    }

    public abstract int minutosPreparacion();

    public String descripcion() {
        return "#" + id + " " + nombre + " [" + categoria.etiqueta() + "] $" + getPrecio()
                + " · " + minutosPreparacion() + " min";
    }
}
