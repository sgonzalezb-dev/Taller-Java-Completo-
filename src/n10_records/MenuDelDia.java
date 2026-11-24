package n10_records;

import java.util.List;

/**
 * Nivel 10 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Record MenuDelDia con copia inmutable de la lista y cálculo de precio promedio.
 */
public record MenuDelDia(String fecha, List<ItemMenu> items) {
    public MenuDelDia {
        if (fecha == null || fecha.isBlank()) {
            throw new IllegalArgumentException("La fecha no puede estar vacía");
        }
        items = List.copyOf(items);
    }

    public int promedioPrecio() {
        if (items.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (ItemMenu item : items) {
            suma += item.precio();
        }
        return suma / items.size();
    }
}
