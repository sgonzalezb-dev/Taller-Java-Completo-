package n04_herencia;

/**
 * Nivel 04 · Herencia y composición (Sesión 03).
 * Subclase Bebida que hereda de Producto y añade mililitros.
 */
public class Bebida extends Producto {
    private final int ml;

    public Bebida(String nombre, int precio, int ml) {
        super(nombre, precio);
        this.ml = ml;
    }

    public int getMl() { return ml; }

    @Override
    public String descripcion() {
        return super.descripcion() + " · " + ml + " ml";
    }
}
