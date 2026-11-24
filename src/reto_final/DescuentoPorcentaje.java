package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 07).
 * Descuento porcentual.
 */
public class DescuentoPorcentaje implements Descuento {
    private final int pct;

    public DescuentoPorcentaje(int pct) {
        if (pct < 0 || pct > 100) {
            throw new IllegalArgumentException("Porcentaje fuera de rango (0-100)");
        }
        this.pct = pct;
    }

    @Override
    public String nombre() { return "Descuento " + pct + "%"; }

    @Override
    public int aplicar(int total) {
        return Math.max(0, total * (100 - pct) / 100);
    }
}
