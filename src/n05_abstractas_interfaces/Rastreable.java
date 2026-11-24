package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Contrato Rastreable para entregas con seguimiento en tiempo real.
 */
public interface Rastreable {
    String estado();

    default boolean entregado() {
        return "entregado".equals(estado());
    }
}
