package n11_serializacion;

import java.io.Serializable;

/**
 * Nivel 11 · Serialización moderna con archivos (Sesión 03).
 * Record guardable Insumo con validación en su constructor compacto.
 */
public record Insumo(int id, String nombre, int cantidad) implements Serializable {
    public Insumo {
        if (cantidad < 0) {
            throw new IllegalArgumentException(
                    "Cantidad negativa");
        }
    }
}
