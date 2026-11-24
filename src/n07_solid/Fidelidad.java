package n07_solid;

/**
 * Nivel 07 · Principios SOLID (Sesión 03).
 * Descuento de fidelidad que respeta Liskov usando Math.max(0, ...).
 */
public class Fidelidad implements Descuento {
    @Override
    public int aplicar(int total) {
        return Math.max(0, total - 2000);
    }
}
