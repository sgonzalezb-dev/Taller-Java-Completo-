package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Domicilio hereda de Entrega y firma dos contratos: Rastreable y Asegurable.
 */
public class Domicilio extends Entrega implements Rastreable, Asegurable {
    private final int kilometros;
    private String estadoActual;

    public Domicilio(int pedidoId, int kilometros) {
        if (kilometros < 1) {
            throw new IllegalArgumentException("Los kilómetros deben ser al menos 1");
        }
        super(pedidoId);
        this.kilometros = kilometros;
        this.estadoActual = "preparando";
    }

    @Override
    public int costo() {
        return 2000 + (800 * kilometros);
    }

    @Override
    public String estado() {
        return estadoActual;
    }

    public void avanzar() {
        estadoActual = switch (estadoActual) {
            case "preparando" -> "en camino";
            case "en camino", "entregado" -> "entregado";
            default -> "entregado";
        };
    }

    @Override
    public int coberturaMaxima() {
        return 50000;
    }
}
