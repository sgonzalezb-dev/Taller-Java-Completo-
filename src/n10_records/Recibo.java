package n10_records;

import java.util.List;

/**
 * Nivel 10 · Records: datos inmutables (Sesión 03).
 * Record Recibo profundamente inmutable con List.copyOf en su constructor compacto.
 */
public record Recibo(int numero, List<LineaRecibo> lineas) {
    public Recibo {
        lineas = List.copyOf(lineas); // copia inmutable defensiva
    }

    public int total() {
        int t = 0;
        for (LineaRecibo l : lineas) t += l.subtotal();
        return t;
    }
}
