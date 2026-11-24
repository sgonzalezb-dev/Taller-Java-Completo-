package n05_abstractas_interfaces;

/**
 * Nivel 05 · Ejercicio resuelto explicado (Sesión 04).
 * Pago en efectivo: siempre es aprobado.
 */
public class Efectivo implements MedioDePago {
    @Override
    public String nombre() { return "Efectivo"; }

    @Override
    public boolean pagar(int valor) {
        return true; // siempre se recibe
    }
}
