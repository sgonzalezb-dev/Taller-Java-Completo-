package n02_encapsulamiento;

/**
 * Nivel 02 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    void main() {
        IO.println("=== S03: Caja ===");
        Caja caja = new Caja();
        caja.cobrar(19000);
        caja.cobrar(7000);
        IO.println(caja.resumen());
        try {
            caja.cobrar(-500);
        } catch (IllegalArgumentException e) {
            IO.println("Rechazado: " + e.getMessage());
        }
        IO.println("Saldo: $" + caja.getSaldo());

        IO.println("\n=== S04: Producto encapsulado ===");
        Producto latte = new Producto();
        latte.setNombre("Latte");
        latte.setPrecio(9500);
        IO.println(latte.getNombre() + " $" + latte.getPrecio());
        try {
            latte.setPrecio(-9500);
        } catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }
        IO.println("Sigue en $" + latte.getPrecio());

        IO.println("\n=== S06: TarjetaRegalo ===");
        TarjetaRegalo t = new TarjetaRegalo();
        t.recargar(30000);
        IO.println("¿Pagó latte? " + t.pagar(9500));
        IO.println("¿Pagó torta? " + t.pagar(25000));
        IO.println("Saldo: $" + t.getSaldo());

        IO.println("\n=== S07: Reto BotePropinas ===");
        BotePropinas bote = new BotePropinas();
        bote.aportar(2000);
        bote.aportar(5000);
        bote.aportar(3500);
        try {
            bote.aportar(-100);
        } catch (IllegalArgumentException e) {
            IO.println("Aporte rechazado: " + e.getMessage());
        }
        int personas = 3;
        int porPersona = bote.repartir(personas);
        int resto = bote.sobrante(personas);
        IO.println("Total acumulado: $" + bote.getTotal() + " en " + bote.getAportes() + " aportes");
        IO.println("Reparto entre " + personas + ": $" + porPersona + " c/u · Sobrante en el bote: $" + resto);
        IO.println("Verificación sin pérdida: (" + porPersona + " × " + personas + ") + " + resto + " = $" + (porPersona * personas + resto));
    }
}
