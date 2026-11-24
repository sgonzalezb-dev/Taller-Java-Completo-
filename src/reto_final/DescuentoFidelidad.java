package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 07).
 * Bono de fidelidad que respeta Liskov con Math.max(0, total - 2000).
 */
public class DescuentoFidelidad implements Descuento {
    @Override
    public String nombre() { return "Bono Fidelidad ($2000)"; }

    @Override
    public int aplicar(int total) {
        return Math.max(0, total - 2000);
    }
}
