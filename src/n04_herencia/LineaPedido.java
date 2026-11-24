package n04_herencia;

/**
 * Nivel 04 · Ejercicio resuelto explicado (Sesión 04).
 * Pieza de composición: una línea de pedido que tiene un Producto y una cantidad.
 */
public class LineaPedido {
    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() { return cantidad; }

    public int subtotal() {
        return producto.getPrecio() * cantidad;
    }

    public String texto() {
        return cantidad + " × " + producto.getNombre() + " = $" + subtotal();
    }
}
