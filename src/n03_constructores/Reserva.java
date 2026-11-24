package n03_constructores;

/**
 * Nivel 03 · Ejercicio resuelto explicado (Sesión 04).
 * Reserva de mesa con delegación de constructores y avisos sobrecargados.
 */
public class Reserva {
    private final String cliente;
    private final int personas;
    private final String hora;

    public Reserva(String cliente, int personas, String hora) {
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException(
                    "Mesas de 1 a 8 personas");
        }
        this.cliente = cliente;
        this.personas = personas;
        this.hora = hora;
    }

    public Reserva(String cliente, int personas) {
        this(cliente, personas, "19:00");
    }

    public String aviso() {
        return cliente + " · " + personas + " pers. · " + hora;
    }

    public String aviso(int minutosAntes) {
        return "En " + minutosAntes + " min: " + aviso();
    }
}
