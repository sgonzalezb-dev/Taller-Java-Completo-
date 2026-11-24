package n08_genericos;

import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 08 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Historial<T extends Comparable<T>> de capacidad fija que descarta el más antiguo con removeFirst().
 */
public class Historial<T extends Comparable<T>> {
    private final List<T> elementos = new ArrayList<>();
    private final int capacidad;

    public Historial(int capacidad) {
        if (capacidad < 1) {
            throw new IllegalArgumentException("La capacidad debe ser al menos 1");
        }
        this.capacidad = capacidad;
    }

    public void agregar(T item) {
        if (elementos.size() == capacidad) {
            elementos.removeFirst();
        }
        elementos.add(item);
    }

    public T masReciente() {
        return elementos.getLast();
    }

    public List<T> todos() {
        return List.copyOf(elementos);
    }

    // Extra +10 XP: obtener el mayor elemento usando Comparable<T>
    public T mayor() {
        T mejor = elementos.getFirst();
        for (T actual : elementos) {
            if (actual.compareTo(mejor) > 0) {
                mejor = actual;
            }
        }
        return mejor;
    }
}
