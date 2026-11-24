package reto_final;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Reto Final · Café Sintaxis 1.0 (Niveles 02, 05, 06, 07, 10).
 * Caja registradora encapsulada y gobernada por SOLID:
 * - Invariante: saldo nunca negativo.
 * - Descuento y Notificador inyectados como interfaces sin condicionales if por promoción.
 * - Contabilidad por Categoria en un EnumMap.
 * - Emisión de Recibo inmutable (record).
 */
public class Caja {
    private int saldo;
    private int consecutivoRecibo = 1001;
    private final Notificador notificador;
    private final Map<Categoria, Integer> ventasPorCategoria = new EnumMap<>(Categoria.class);
    private final List<Recibo> recibosEmitidos = new ArrayList<>();

    public Caja(Notificador notificador) {
        if (notificador == null) {
            throw new IllegalArgumentException("El notificador es obligatorio");
        }
        this.notificador = notificador;
    }

    public int getSaldo() { return saldo; }
    public List<Recibo> getRecibosEmitidos() { return List.copyOf(recibosEmitidos); }
    public Map<Categoria, Integer> getVentasPorCategoria() { return new EnumMap<>(ventasPorCategoria); }

    public Recibo cobrarPedido(Pedido pedido, Descuento descuento) {
        int bruto = pedido.totalBruto();
        int neto = descuento.aplicar(bruto);
        if (neto < 0) {
            throw new IllegalStateException("Invariante violado: cobro negativo");
        }
        saldo += neto;

        for (LineaPedido lp : pedido.getLineas()) {
            Categoria cat = lp.getProducto().getCategoria();
            ventasPorCategoria.put(cat, ventasPorCategoria.getOrDefault(cat, 0) + lp.subtotal());
        }

        while (pedido.getEstado() != EstadoPedido.ENTREGADO) {
            pedido.avanzarEstado();
        }

        Recibo recibo = new Recibo(
                consecutivoRecibo++,
                pedido.getCliente(),
                pedido.generarLineasRecibo(),
                neto
        );
        recibosEmitidos.add(recibo);

        notificador.enviar(
                pedido.getCliente(),
                "Recibo #" + recibo.numero() + " (" + descuento.nombre() + ") pagado por $" + neto
        );
        return recibo;
    }

    public String resumenCierre() {
        return recibosEmitidos.size() + " recibos emitidos · Saldo en caja: $" + saldo;
    }
}
