package n10_records;

/**
 * Nivel 10 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Enum Categoria reutilizado para el menú del día.
 */
public enum Categoria {
    CALIENTE("Bebida caliente"),
    FRIA("Bebida fría"),
    POSTRE("Postre"),
    PANADERIA("Panadería");

    private final String etiqueta;

    Categoria(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String etiqueta() { return etiqueta; }
}
