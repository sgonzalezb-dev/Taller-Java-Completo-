package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 04).
 * Composición: cada línea de un pedido vincula un Producto con una cantidad positiva.
 */
public class LineaPedido {
    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (cantidad < 1) {
            throw new IllegalArgumentException("La cantidad mínima es 1");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public int subtotal() {
        return producto.getPrecio() * cantidad;
    }

    public LineaRecibo aLineaRecibo() {
        return new LineaRecibo(producto.getNombre(), producto.getPrecio(), cantidad);
    }
}
