package n11_serializacion;

import java.io.Serializable;

/**
 * Nivel 11 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Record Reserva serializable con validación en constructor compacto (1 a 8 personas).
 */
public record Reserva(int id, String cliente, int personas, String hora) implements Serializable {
    public Reserva {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException("Mesas de 1 a 8 personas (recibido: " + personas + ")");
        }
        if (hora == null || hora.isBlank()) {
            throw new IllegalArgumentException("La hora es obligatoria");
        }
    }
}
