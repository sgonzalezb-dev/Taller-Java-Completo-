package n04_herencia;

import java.util.List;

/**
 * Nivel 04 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    void main() {
        IO.println("=== S03: Familia Producto (Herencia y Polimorfismo) ===");
        Bebida latte = new Bebida("Latte", 9500, 350);
        Postre torta = new Postre("Torta de zanahoria", 8000, true);
        IO.println(latte.getNombre() + " cuesta " + latte.getPrecio());

        List<Producto> vitrina = List.of(latte, torta, new Producto("Galleta", 3000));
        for (Producto p : vitrina) {
            IO.println(p.descripcion());
        }

        IO.println("\n=== S04: Pedido compuesto con LineaPedido ===");
        Pedido p = new Pedido(4);
        p.agregar(new Bebida("Latte", 9500, 350), 2);
        p.agregar(new Postre("Brownie", 7000, false), 1);
        p.imprimir();

        IO.println("\n=== S06: Temporada y Combo ===");
        Producto ponque = new Temporada("Ponqué de calabaza", 8500, "octubre");
        Combo c = new Combo(new Bebida("Latte", 9500, 350), ponque);
        IO.println(ponque.descripcion());
        IO.println("Combo: $" + c.precio());

        IO.println("\n=== S07: Reto Nómina del Turno ===");
        Turno turnoManana = new Turno();
        turnoManana.agregar(new Barista("Martín", 45000, 30)); // 45000 + 6000 = 51000
        turnoManana.agregar(new Mesero("Sofía", 40000, 12000)); // 40000 + 12000 = 52000
        turnoManana.agregar(new Barista("Aprendiz (0 bebidas)", 35000, 0));
        turnoManana.agregar(new Mesero("Apoyo (0 propinas)", 35000, 0));

        for (Empleado emp : turnoManana.getEmpleados()) {
            IO.println("  " + emp); // Usa toString() sobrescrito en Empleado
        }
        IO.println("Nómina total del turno: $" + turnoManana.totalNomina());
    }
}
