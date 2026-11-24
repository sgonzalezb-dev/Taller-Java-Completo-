package n04_herencia;

/**
 * Nivel 04 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Superclase Empleado para la nómina del turno.
 */
public class Empleado {
    private final String nombre;
    private final int salarioBase;

    public Empleado(String nombre, int salarioBase) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado es obligatorio");
        }
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() { return nombre; }
    public int getSalarioBase() { return salarioBase; }

    public int pago() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return nombre + " -> Pago: $" + pago();
    }
}
