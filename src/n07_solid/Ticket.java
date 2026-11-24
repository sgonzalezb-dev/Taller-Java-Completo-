package n07_solid;

/**
 * Nivel 07 · Principios SOLID (Sesión 03).
 * S (Responsabilidad única): clase dedicada exclusivamente a formatear el ticket.
 */
public class Ticket {
    public String formatear(int total) {
        return "TICKET · total $" + total;
    }
}
