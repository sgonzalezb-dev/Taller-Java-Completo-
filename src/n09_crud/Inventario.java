package n09_crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Nivel 09 · CRUD paso a paso con ArrayList (Sesión 03).
 * Gestión de inventario en memoria con ArrayList, Optional, List.copyOf y removeIf.
 */
public class Inventario {
    private final List<Insumo> insumos = new ArrayList<>();
    private int siguienteId = 1;

    // C · crear
    public Insumo crear(String nombre, int cantidad) {
        Insumo i = new Insumo(siguienteId++, nombre, cantidad);
        insumos.add(i);
        return i;
    }

    // R · leer
    public List<Insumo> listar() {
        return List.copyOf(insumos);
    }

    public Optional<Insumo> buscar(int id) {
        for (Insumo i : insumos) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    // U · actualizar
    public boolean actualizar(int id, int cantidad) {
        Optional<Insumo> o = buscar(id);
        if (o.isEmpty()) {
            return false;
        }
        o.get().setCantidad(cantidad);
        return true;
    }

    // D · eliminar
    public boolean eliminar(int id) {
        return insumos.removeIf(i -> i.getId() == id);
    }
}
