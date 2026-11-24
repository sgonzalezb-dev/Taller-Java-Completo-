package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Clase concreta Galleta que extiende Snack.
 */
public class Galleta extends Snack {
    public Galleta() {
        super(3000);
    }

    @Override
    public String nombre() {
        return "Galleta de avena";
    }
}
