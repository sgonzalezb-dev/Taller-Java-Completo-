package reto_final;

import java.io.Serializable;

/**
 * Reto Final · Café Sintaxis 1.0 (Niveles 08, 09, 10, 11).
 * Record Insumo inmutable, Identificable y Serializable, con método funcional conCantidad().
 */
public record Insumo(int id, String nombre, int cantidad) implements Identificable, Serializable {
    public Insumo {
        if (id <= 0) {
            throw new IllegalArgumentException("El id del insumo debe ser positivo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del insumo es obligatorio");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad negativa no permitida: " + cantidad);
        }
    }

    public Insumo conCantidad(int nuevaCantidad) {
        return new Insumo(id, nombre, nuevaCantidad);
    }
}
