package n04_herencia;

import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 04 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Clase compuesta Turno que agrupa una lista de Empleados y calcula la nómina total.
 */
public class Turno {
    private final List<Empleado> empleados = new ArrayList<>();

    public void agregar(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return List.copyOf(empleados);
    }

    public int totalNomina() {
        int total = 0;
        for (Empleado e : empleados) {
            total += e.pago();
        }
        return total;
    }
}
