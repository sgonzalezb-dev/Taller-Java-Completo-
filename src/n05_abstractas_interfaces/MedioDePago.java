package n05_abstractas_interfaces;

/**
 * Nivel 05 · Ejercicio resuelto explicado (Sesión 04).
 * Contrato polimórfico para cualquier medio de pago en caja.
 */
public interface MedioDePago {
    String nombre();
    boolean pagar(int valor);
}
