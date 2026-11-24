package n04_herencia;

/**
 * Nivel 04 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Subclase Temporada que sobrescribe descripcion() para productos de mes especial.
 */
public class Temporada extends Producto {
    private final String mes;

    public Temporada(String nombre, int precio, String mes) {
        super(nombre, precio);
        this.mes = mes;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " (solo " + mes + ")";
    }
}
