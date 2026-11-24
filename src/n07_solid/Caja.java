package n07_solid;

import java.util.List;

/**
 * Nivel 07 · Principios SOLID (Sesión 03).
 * D (Inversión de dependencias): Caja recibe Notificador por constructor y Descuento por parámetro.
 */
public class Caja {
    private final Notificador notificador;
    private final Ticket ticket = new Ticket();

    public Caja(Notificador notificador) {
        this.notificador = notificador;
    }

    public int cobrar(List<Integer> precios, Descuento d, String tel) {
        int total = 0;
        for (int p : precios) total += p;
        total = d.aplicar(total);
        IO.println(ticket.formatear(total));
        notificador.enviar(tel, "gracias");
        return total;
    }
}
