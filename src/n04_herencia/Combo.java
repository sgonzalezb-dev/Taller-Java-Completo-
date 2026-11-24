package n04_herencia;

/**
 * Nivel 04 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Clase compuesta Combo que tiene un Producto principal y un Producto acompañante.
 */
public class Combo {
    private final Producto principal;
    private final Producto acompanante;

    public Combo(Producto principal, Producto acompanante) {
        this.principal = principal;
        this.acompanante = acompanante;
    }

    public int precio() {
        int suma = principal.getPrecio() + acompanante.getPrecio();
        return suma * 90 / 100; // 10 % menos
    }
}
