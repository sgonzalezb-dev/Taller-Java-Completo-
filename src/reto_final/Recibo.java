package reto_final;

import java.io.Serializable;
import java.util.List;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 10).
 * Record inmutable Recibo con copia defensiva List.copyOf en su constructor compacto.
 */
public record Recibo(int numero, String cliente, List<LineaRecibo> lineas, int totalFinal) implements Serializable {
    public Recibo {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número de recibo inválido");
        }
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("Cliente vacío en recibo");
        }
        if (totalFinal < 0) {
            throw new IllegalArgumentException("El total del recibo nunca puede ser negativo");
        }
        lineas = List.copyOf(lineas);
    }

    public int subtotalBruto() {
        int s = 0;
        for (LineaRecibo l : lineas) {
            s += l.subtotal();
        }
        return s;
    }
}
