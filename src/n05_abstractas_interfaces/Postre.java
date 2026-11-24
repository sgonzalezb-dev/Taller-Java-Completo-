package n05_abstractas_interfaces;

/**
 * Nivel 05 · Clases abstractas e interfaces (Sesión 03).
 * Postre hereda de Producto sin implementar Personalizable.
 */
public class Postre extends Producto {
    public Postre(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public int minutosPreparacion() {
        return 1;
    }
}
