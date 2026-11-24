package n10_records;

/**
 * Nivel 10 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Record inmutable ItemMenu con validación en constructor compacto y actualización funcional conPrecio().
 */
public record ItemMenu(String nombre, Categoria categoria, int precio) {
    public ItemMenu {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del ítem no puede estar vacío");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo: " + precio);
        }
    }

    public ItemMenu conPrecio(int nuevoPrecio) {
        return new ItemMenu(nombre, categoria, nuevoPrecio);
    }
}
