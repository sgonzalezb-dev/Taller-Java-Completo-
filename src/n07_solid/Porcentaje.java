package n07_solid;

/**
 * Nivel 07 · Principios SOLID (Sesión 03).
 * Descuento por porcentaje.
 */
public class Porcentaje implements Descuento {
    private final int pct;

    public Porcentaje(int pct) { this.pct = pct; }

    @Override
    public int aplicar(int total) {
        return total * (100 - pct) / 100;
    }
}
