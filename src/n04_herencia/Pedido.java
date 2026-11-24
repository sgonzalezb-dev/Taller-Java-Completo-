package n04_herencia;

import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 04 · Ejercicio resuelto explicado (Sesión 04).
 * Clase compuesta: un Pedido TIENE líneas de pedido.
 */
public class Pedido {
    private final int mesa;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(int mesa) {
        this.mesa = mesa;
    }

    public void agregar(Producto p, int cantidad) {
        lineas.add(new LineaPedido(p, cantidad));
    }

    public int total() {
        int t = 0;
        for (LineaPedido l : lineas) {
            t += l.subtotal();
        }
        return t;
    }

    public int cantidadDeItems() {
        int c = 0;
        for (LineaPedido l : lineas) {
            c += l.getCantidad();
        }
        return c;
    }

    public void imprimir() {
        IO.println("Mesa " + mesa);
        for (LineaPedido l : lineas) {
            IO.println("  " + l.texto());
        }
        IO.println("Total: $" + total());
    }
}
