package n10_records;

/**
 * Nivel 10 · Ejercicio resuelto explicado (Sesión 04).
 * Jerarquía sellada (sealed interface) de medios de pago como records de datos.
 */
public sealed interface Pago permits Efectivo, Tarjeta, Billetera { }
