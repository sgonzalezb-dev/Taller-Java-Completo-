package n04_herencia;

/**
 * Nivel 04 · Herencia y composición (Sesión 03).
 * Subclase Postre que hereda de Producto y añade si es vegano.
 */
public class Postre extends Producto {
    private final boolean vegano;

    public Postre(String nombre, int precio, boolean vegano) {
        super(nombre, precio);
        this.vegano = vegano;
    }

    public boolean isVegano() { return vegano; }

    @Override
    public String descripcion() {
        if (vegano) {
            return super.descripcion() + " · vegano";
        }
        return super.descripcion();
    }
}
