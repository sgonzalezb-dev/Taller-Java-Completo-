package n05_abstractas_interfaces;

import java.util.List;

/**
 * Nivel 05 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    String cobrar(MedioDePago medio, int valor) {
        String r = medio.pagar(valor) ? "aprobado" : "rechazado";
        return medio.nombre() + " $" + valor + ": " + r;
    }

    void main() {
        IO.println("=== S03: Producto abstracto e interfaz Personalizable ===");
        List<Producto> menu = List.of(
                new Bebida("Capuchino", 9000),
                new Postre("Brownie", 7000));
        for (Producto p : menu) {
            IO.println(p.ficha());
            if (p instanceof Personalizable per) {
                IO.println("  opciones: " + per.opciones());
                IO.println("  avena: +$" + per.extra("avena"));
            }
        }

        IO.println("\n=== S04: Polimorfismo con MedioDePago ===");
        List<MedioDePago> medios = List.of(
                new Efectivo(), new Billetera(12000));
        for (MedioDePago m : medios) {
            IO.println(cobrar(m, 9500));
            IO.println(cobrar(m, 9500));
        }

        IO.println("\n=== S06: Snack y Descontable ===");
        Snack s = new Galleta();
        IO.println(s.nombre() + ": $" + s.precioBase());
        Descontable d = s;
        IO.println("Con 20 %: $" + d.conDescuento(20));

        IO.println("\n=== S07: Reto Formas de Entrega (Rastreable e instanceof con patrón) ===");
        Domicilio dom = new Domicilio(103, 4);
        dom.avanzar(); // pasa a "en camino"

        List<Entrega> entregas = List.of(
                new EnMesa(101),
                new ParaLlevar(102, 2),
                dom
        );

        for (Entrega e : entregas) {
            IO.println(e.resumen());
            if (e instanceof Rastreable r) {
                IO.println("  [Rastreo] Estado: " + r.estado() + " · ¿Entregado? " + r.entregado());
            }
            if (e instanceof Asegurable a) {
                IO.println("  [Seguro]  " + a.poliza());
            }
        }

        dom.avanzar(); // pasa a "entregado"
        IO.println("Tras avanzar domicilio #103 -> Estado: " + dom.estado() + " · ¿Entregado? " + dom.entregado());
    }
}
