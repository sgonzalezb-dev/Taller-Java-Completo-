package n07_solid;

import java.util.List;

/**
 * Nivel 07 · Principios SOLID (Sesión 02).
 * Antes del refactor: una "clase dios" con cuatro razones para cambiar.
 */
public class CajaVieja {
    public void cobrar(List<Integer> precios,
                       String descuento, String tel) {
        int total = 0;
        for (int p : precios) total += p;
        if (descuento.equals("CAFE10")) {
            total = total * 90 / 100;
        } else if (descuento.equals("FIDELIDAD")) {
            total = total - 2000;
        }
        IO.println("TICKET · total $" + total);
        IO.println("SMS a " + tel + ": gracias");
    }
}
