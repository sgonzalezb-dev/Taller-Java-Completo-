package n03_constructores;

/**
 * Nivel 03 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Postre de vitrina con constructor completo, constructor corto y etiqueta sobrecargada.
 */
public class Postre {
    private final String nombre;
    private final int precio;
    private final boolean sinAzucar;

    public Postre(String nombre, int precio, boolean sinAzucar) {
        this.nombre = nombre;
        this.precio = precio;
        this.sinAzucar = sinAzucar;
    }

    public Postre(String nombre, int precio) {
        this(nombre, precio, false);
    }

    public String etiqueta() {
        return nombre + " $" + precio;
    }

    public String etiqueta(boolean detallada) {
        if (detallada && sinAzucar) {
            return etiqueta() + " · sin azúcar";
        }
        return etiqueta();
    }
}
