package n04_herencia;

/**
 * Nivel 04 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Subclase Barista que hereda de Empleado y suma bonificación por bebida preparada.
 */
public class Barista extends Empleado {
    private final int bebidas;

    public Barista(String nombre, int salarioBase, int bebidas) {
        if (bebidas < 0) {
            throw new IllegalArgumentException("Las bebidas no pueden ser negativas");
        }
        super(nombre, salarioBase);
        this.bebidas = bebidas;
    }

    @Override
    public int pago() {
        return super.pago() + (bebidas * 200);
    }
}
