package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Clase abstracta Entrega con pedidoId, método abstracto costo() y método concreto resumen().
 */
public abstract class Entrega {
    private final int pedidoId;

    protected Entrega(int pedidoId) {
        if (pedidoId <= 0) {
            throw new IllegalArgumentException("El id del pedido debe ser positivo");
        }
        this.pedidoId = pedidoId;
    }

    public int getPedidoId() { return pedidoId; }

    public abstract int costo();

    public String resumen() {
        return "Pedido #" + pedidoId + " (" + getClass().getSimpleName() + ") · Costo entrega: $" + costo();
    }
}
