package n03_constructores;

/**
 * Nivel 03 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Combos de la tarde con validación en prólogo de constructor (JEP 513) y sobrecarga de precioFinal.
 */
public class Combo {
    private final String bebida;
    private final String postre;
    private final int precio;

    public Combo(String bebida, String postre, int precio) {
        if (bebida == null || bebida.isBlank()) {
            throw new IllegalArgumentException("La bebida no puede estar vacía");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido: " + precio);
        }
        this.bebida = bebida;
        this.postre = postre;
        this.precio = precio;
    }

    public Combo(String bebida, int precio) {
        // Prólogo de Java 25 (JEP 513): validación antes de this(...)
        // Nota: no se puede usar this.precio en el prólogo ("cannot reference this before supertype constructor has been called")
        if (bebida == null || bebida.isBlank()) {
            throw new IllegalArgumentException("La bebida no puede estar vacía");
        }
        this(bebida, "sin postre", precio);
    }

    public int precioFinal() {
        return precio;
    }

    public int precioFinal(int propinaPct) {
        return precioFinal() + (precioFinal() * propinaPct / 100);
    }

    public String descripcion() {
        return "Combo [" + bebida + " + " + postre + "] $" + precio;
    }
}
