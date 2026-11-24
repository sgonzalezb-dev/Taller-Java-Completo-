package reto_final;

import java.io.Serializable;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 10).
 * Record inmutable para cada línea de un recibo impreso.
 */
public record LineaRecibo(String producto, int precioUnitario, int cantidad) implements Serializable {
    public LineaRecibo {
        if (producto == null || producto.isBlank()) {
            throw new IllegalArgumentException("Producto vacío en recibo");
        }
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("Precio unitario inválido");
        }
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad mínima: 1");
        }
    }

    public int subtotal() {
        return precioUnitario * cantidad;
    }
}
