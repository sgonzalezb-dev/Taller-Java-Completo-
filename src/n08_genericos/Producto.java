package n08_genericos;

/**
 * Nivel 08 · Genéricos (Sesión 03).
 * Producto que implementa Identificable.
 */
public class Producto implements Identificable {
    private final int id;
    private final String nombre;
    private final int precio;

    public Producto(int id, String nombre, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public int id() { return id; }
    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }
}
