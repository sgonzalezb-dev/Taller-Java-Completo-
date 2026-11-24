package n04_herencia;

/**
 * Nivel 04 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Subclase Mesero que hereda de Empleado y suma sus propinas al pago.
 */
public class Mesero extends Empleado {
    private final int propinas;

    public Mesero(String nombre, int salarioBase, int propinas) {
        if (propinas < 0) {
            throw new IllegalArgumentException("Las propinas no pueden ser negativas");
        }
        super(nombre, salarioBase);
        this.propinas = propinas;
    }

    @Override
    public int pago() {
        return super.pago() + propinas;
    }
}
