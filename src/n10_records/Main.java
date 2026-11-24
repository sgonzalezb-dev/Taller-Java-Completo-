package n10_records;

import java.util.List;

/**
 * Nivel 10 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    String describir(Pago p, int total) {
        return switch (p) {
            case Efectivo(int recibido) ->
                    "Efectivo · vuelto $" + (recibido - total);
            case Tarjeta(String f, int cuotas) when cuotas > 1 ->
                    f + " a " + cuotas + " cuotas";
            case Tarjeta(String f, int cuotas) -> f + " de contado";
            case Billetera(String tel) -> "Billetera " + tel;
        };
    }

    void main() {
        IO.println("=== S03: LineaRecibo y Recibo con patrones ===");
        var l1 = new LineaRecibo("Latte", 9500, 2);
        var l2 = new LineaRecibo("Brownie", 7000, 1);
        IO.println(l1);
        IO.println(l1.producto() + " → $" + l1.subtotal());
        var otra = new LineaRecibo("Latte", 9500, 2);
        IO.println("¿Iguales? " + l1.equals(otra));
        var r = new Recibo(1001, List.of(l1, l2));
        IO.println("Recibo " + r.numero() + ": $" + r.total());
        if (r.lineas().getFirst() instanceof LineaRecibo(var p, var precio, var c)) {
            IO.println(c + " × " + p + " a $" + precio);
        }

        IO.println("\n=== S04: Medios de Pago sealed + switch con patrones ===");
        int total = 26000;
        List<Pago> pagos = List.of(new Efectivo(30000),
                new Tarjeta("Débito", 1), new Tarjeta("Crédito", 3),
                new Billetera("300 555 0110"));
        for (Pago p : pagos) {
            IO.println(describir(p, total));
        }

        IO.println("\n=== S06: Calificacion ===");
        var a = new Calificacion("Sofía", 5);
        var b = new Calificacion("Sofía", 5);
        IO.println(a.cliente() + ": " + a.estrellas());
        IO.println("¿Buena? " + a.esBuena());
        IO.println("¿Iguales? " + a.equals(b));
        IO.println(a);

        IO.println("\n=== S07: Reto MenuDelDia e ItemMenu ===");
        var itemLatte = new ItemMenu("Latte", Categoria.CALIENTE, 9500);
        var itemColdBrew = new ItemMenu("Cold Brew", Categoria.FRIA, 11000);
        var itemTorta = new ItemMenu("Torta de zanahoria", Categoria.POSTRE, 8000);
        var itemCroissant = new ItemMenu("Croissant de mantequilla", Categoria.PANADERIA, 6500);

        var menu = new MenuDelDia("2026-11-11", List.of(itemLatte, itemColdBrew, itemTorta, itemCroissant));
        IO.println("Menú del " + menu.fecha() + " · Precio promedio: $" + menu.promedioPrecio());

        var latteSubido = itemLatte.conPrecio(itemLatte.precio() * 110 / 100);
        IO.println("Original: " + itemLatte);
        IO.println("Nuevo (+10%): " + latteSubido);
        IO.println("¿El original sigue intacto (9500)? " + itemLatte.equals(new ItemMenu("Latte", Categoria.CALIENTE, 9500)));

        IO.println("Ítems de categoría CALIENTE (con patrón de record):");
        for (Object obj : menu.items()) {
            if (obj instanceof ItemMenu(var n, var c, var p) && c == Categoria.CALIENTE) {
                IO.println("  - " + n + " (" + c.etiqueta() + "): $" + p);
            }
        }

        try {
            menu.items().add(latteSubido);
        } catch (UnsupportedOperationException e) {
            IO.println("Protección inmutable verificada: List.copyOf impide add() con UnsupportedOperationException.");
        }
    }
}
