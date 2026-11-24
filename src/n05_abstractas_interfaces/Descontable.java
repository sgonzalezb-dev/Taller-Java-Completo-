package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Contrato Descontable con método default conDescuento(int pct).
 */
public interface Descontable {
    int precioBase();

    default int conDescuento(int pct) {
        return precioBase() * (100 - pct) / 100;
    }
}
