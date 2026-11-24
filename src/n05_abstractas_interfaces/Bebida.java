package n05_abstractas_interfaces;

/**
 * Nivel 05 · Clases abstractas e interfaces (Sesión 03).
 * Bebida hereda de Producto e implementa Personalizable.
 */
public class Bebida extends Producto implements Personalizable {
    public Bebida(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public int minutosPreparacion() {
        return 4;
    }

    @Override
    public int extra(String opcion) {
        if (opcion.equals("shot extra")) {
            return 2000;
        }
        return 1500;
    }
}
