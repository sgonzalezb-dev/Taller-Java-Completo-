package n07_solid;

import java.util.List;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * S (Responsabilidad única): clase dedicada exclusivamente a calcular totales de ventas.
 */
public class Totales {
    public int sumar(List<Integer> cobros) {
        int total = 0;
        for (int c : cobros) {
            total += c;
        }
        return total;
    }

    public int contar(List<Integer> cobros) {
        return cobros.size();
    }
}
