package n08_genericos;

import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 08 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Bandeja genérica que transporta bebidas o postres sin mezclarlos.
 */
public class Bandeja<T> {
    private final List<T> cosas = new ArrayList<>();
    private final int capacidad;

    public Bandeja(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean poner(T cosa) {
        if (cosas.size() == capacidad) {
            return false;
        }
        return cosas.add(cosa);
    }

    public T primera() { return cosas.getFirst(); }
    public int cantidad() { return cosas.size(); }
}
