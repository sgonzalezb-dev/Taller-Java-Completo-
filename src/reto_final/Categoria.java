package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 06).
 * Enum Categoria para clasificar el menú y agrupar ventas en EnumMap.
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
