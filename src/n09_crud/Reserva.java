package n09_crud;

/**
 * Nivel 09 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Reserva de mesa con id, cliente, personas (1 a 8) y hora (ej. "18:30").
 */
public class Reserva {
    private final int id;
    private final String cliente;
    private final int personas;
    private String hora;

    public Reserva(int id, String cliente, int personas, String hora) {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException("Mesas de 1 a 8 personas");
        }
        if (hora == null || hora.isBlank()) {
            throw new IllegalArgumentException("La hora es obligatoria");
        }
        this.id = id;
        this.cliente = cliente;
        this.personas = personas;
        this.hora = hora;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public int getPersonas() { return personas; }
    public String getHora() { return hora; }

    public void setHora(String nuevaHora) {
        if (nuevaHora == null || nuevaHora.isBlank()) {
            throw new IllegalArgumentException("La nueva hora no puede estar vacía");
        }
        this.hora = nuevaHora;
    }

    @Override
    public String toString() {
        return "Reserva #" + id + " [" + hora + "] " + cliente + " (" + personas + " pers.)";
    }
}
