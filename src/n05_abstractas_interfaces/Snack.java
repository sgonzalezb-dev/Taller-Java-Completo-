package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Plantilla abstracta Snack que implementa Descontable.
 */
public abstract class Snack implements Descontable {
    private final int precio;

    protected Snack(int precio) {
        this.precio = precio;
    }

    @Override
    public int precioBase() {
        return precio;
    }

    public abstract String nombre();
}
