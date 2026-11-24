package n03_constructores;

/**
 * Nivel 03 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    void main() {
        IO.println("=== S03: Bebida ===");
        Bebida a = new Bebida("Latte", "grande", 11000, true);
        Bebida b = new Bebida("Tinto", 3500);
        IO.println(a.descripcion());
        IO.println(b.descripcion());
        IO.println("Latte + 2 extras: $" + a.precioCon(2));
        IO.println("Con cupón: $" + a.precioCon("CAFE10"));
        try {
            new Bebida(" ", 3000);
        } catch (IllegalArgumentException e) {
            IO.println("Rechazada: " + e.getMessage());
        }

        IO.println("\n=== S04: Reserva ===");
        Reserva r1 = new Reserva("Familia Rojas", 6, "18:30");
        Reserva r2 = new Reserva("Andrés", 2);
        IO.println(r1.aviso());
        IO.println(r2.aviso(15));
        try {
            new Reserva("Fiesta", 12);
        } catch (IllegalArgumentException e) {
            IO.println("No se pudo: " + e.getMessage());
        }

        IO.println("\n=== S06: Postre ===");
        Postre p1 = new Postre("Brownie", 7000);
        Postre p2 = new Postre("Cheesecake", 9000, true);
        IO.println(p1.etiqueta(true));
        IO.println(p2.etiqueta(true));

        IO.println("\n=== S07: Reto Combo (JEP 513 y sobrecarga) ===");
        Combo comboCompleto = new Combo("Capuchino", "Torta de zanahoria", 15000);
        Combo comboCorto = new Combo("Americano", 6000);
        IO.println(comboCompleto.descripcion() + " · Sin propina: $" + comboCompleto.precioFinal()
                + " · Con 10% propina: $" + comboCompleto.precioFinal(10));
        IO.println(comboCorto.descripcion() + " · Sin propina: $" + comboCorto.precioFinal()
                + " · Con 15% propina: $" + comboCorto.precioFinal(15));

        try {
            new Combo("   ", 5000);
        } catch (IllegalArgumentException e) {
            IO.println("Error en prólogo (bebida vacía): " + e.getMessage());
        }

        try {
            new Combo("Moka", "Galleta", 0);
        } catch (IllegalArgumentException e) {
            IO.println("Error en constructor completo (precio <= 0): " + e.getMessage());
        }
    }
}
