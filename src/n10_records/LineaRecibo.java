package n10_records;

/**
 * Nivel 10 · Records: datos inmutables (Sesión 03).
 * Record LineaRecibo con constructor compacto para validar cantidad mínima.
 */
public record LineaRecibo(String producto, int precio, int cantidad) {
    public LineaRecibo { // constructor compacto
        if (cantidad < 1) {
            throw new IllegalArgumentException(
                    "Cantidad mínima: 1");
        }
    }

    public int subtotal() {
        return precio * cantidad;
    }
}
