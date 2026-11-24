package reto_final;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Reto Final · Café Sintaxis 1.0 (Niveles 08 y 09).
 * Repositorio<T extends Identificable> genérico con CRUD completo, Optional, List.copyOf y removeIf.
 */
public class Repositorio<T extends Identificable> {
    private final List<T> items = new ArrayList<>();

    // C · Crear / Guardar
    public void guardar(T item) {
        if (item == null) {
            throw new IllegalArgumentException("No se puede guardar un elemento nulo");
        }
        eliminar(item.id());
        items.add(item);
    }

    // R · Leer (copia inmutable y búsqueda con Optional)
    public List<T> listar() {
        return List.copyOf(items);
    }

    public Optional<T> buscar(int id) {
        for (T item : items) {
            if (item.id() == id) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    // U · Actualizar reemplazando el elemento por id (ideal para records inmutables y objetos)
    public boolean actualizar(int id, Function<T, T> transformador) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id() == id) {
                items.set(i, transformador.apply(items.get(i)));
                return true;
            }
        }
        return false;
    }

    // D · Eliminar con removeIf
    public boolean eliminar(int id) {
        return items.removeIf(item -> item.id() == id);
    }

    public int cantidad() {
        return items.size();
    }
}
