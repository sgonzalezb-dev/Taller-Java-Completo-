package reto_final;

import java.util.ArrayList;
import java.util.List;

/**
 * Reto Final · Café Sintaxis 1.0 (Niveles 04, 06, 08, 10).
 * Pedido compuesto de líneas con ciclo de estado EstadoPedido y generación de Recibo inmutable.
 */
public class Pedido implements Identificable {
    private final int id;
    private final int mesa;
    private final String cliente;
    private EstadoPedido estado;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(int id, int mesa, String cliente) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id del pedido debe ser positivo");
        }
        if (mesa < 0) {
            throw new IllegalArgumentException("Número de mesa inválido");
        }
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        }
        this.id = id;
        this.mesa = mesa;
        this.cliente = cliente;
        this.estado = EstadoPedido.RECIBIDO;
    }

    @Override
    public int id() { return id; }
    public int getMesa() { return mesa; }
    public String getCliente() { return cliente; }
    public EstadoPedido getEstado() { return estado; }
    public List<LineaPedido> getLineas() { return List.copyOf(lineas); }

    public void agregar(Producto producto, int cantidad) {
        lineas.add(new LineaPedido(producto, cantidad));
    }

    public void avanzarEstado() {
        this.estado = this.estado.siguiente();
    }

    public int totalBruto() {
        int suma = 0;
        for (LineaPedido l : lineas) {
            suma += l.subtotal();
        }
        return suma;
    }

    public List<LineaRecibo> generarLineasRecibo() {
        List<LineaRecibo> resultado = new ArrayList<>();
        for (LineaPedido l : lineas) {
            resultado.add(l.aLineaRecibo());
        }
        return List.copyOf(resultado);
    }
}
