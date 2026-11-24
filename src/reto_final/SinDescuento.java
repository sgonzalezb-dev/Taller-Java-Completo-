package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 07).
 * Sin promoción: deja el valor intacto.
 */
public class SinDescuento implements Descuento {
    @Override
    public String nombre() { return "Precio pleno"; }

    @Override
    public int aplicar(int total) {
        return Math.max(0, total);
    }
}
