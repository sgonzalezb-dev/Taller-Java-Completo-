package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Entrega en mesa: costo $0.
 */
public class EnMesa extends Entrega {
    public EnMesa(int pedidoId) {
        super(pedidoId);
    }

    @Override
    public int costo() {
        return 0;
    }
}
