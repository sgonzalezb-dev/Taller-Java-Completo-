package n06_enum;

/**
 * Nivel 06 · Ejercicio resuelto explicado (Sesión 04).
 * Categorías del menú de Café Sintaxis.
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
