package n06_enum;

/**
 * Nivel 06 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Estados de las mesas del salón con switch exhaustivo sin default.
 */
public enum EstadoMesa {
    LIBRE("Mesa disponible"),
    OCUPADA("Clientes en mesa"),
    POR_LIMPIAR("Esperando limpieza"),
    RESERVADA("Apartada con reserva");

    private final String aviso;

    EstadoMesa(String aviso) {
        this.aviso = aviso;
    }

    public String aviso() {
        return aviso;
    }

    public EstadoMesa siguiente() {
        return switch (this) {
            case LIBRE, RESERVADA -> OCUPADA;
            case OCUPADA -> POR_LIMPIAR;
            case POR_LIMPIAR -> LIBRE;
        };
    }

    public boolean disponible() {
        return this == LIBRE;
    }
}
