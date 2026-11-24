package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 06).
 * Enum EstadoPedido con máquina de estados exhaustiva en switch de flechas (JEP 441).
 */
public enum EstadoPedido {
    RECIBIDO, EN_PREPARACION, LISTO, ENTREGADO;

    public EstadoPedido siguiente() {
        return switch (this) {
            case RECIBIDO -> EN_PREPARACION;
            case EN_PREPARACION -> LISTO;
            case LISTO, ENTREGADO -> ENTREGADO;
        };
    }
}
