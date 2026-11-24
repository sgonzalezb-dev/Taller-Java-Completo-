package n06_enum;

/**
 * Nivel 06 · Enum: valores con nombre (Sesión 03).
 * Estados del pedido con transición mediante switch exhaustivo de flechas (JEP 441).
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
