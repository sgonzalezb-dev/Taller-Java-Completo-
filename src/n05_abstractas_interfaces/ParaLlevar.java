package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Entrega para llevar: costo $500 por empaque.
 */
public class ParaLlevar extends Entrega {
    private final int empaques;

    public ParaLlevar(int pedidoId, int empaques) {
        if (empaques < 1) {
            throw new IllegalArgumentException("Debe incluir al menos 1 empaque");
        }
        super(pedidoId);
        this.empaques = empaques;
    }

    @Override
    public int costo() {
        return empaques * 500;
    }
}
