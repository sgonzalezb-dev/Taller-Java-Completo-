package n01_clases;

/**
 * Nivel 01 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    void main() {
        IO.println("=== S03: Producto ===");
        Producto latte = new Producto();
        latte.nombre = "Latte";
        latte.precio = 9500;
        latte.stock = 3;

        Producto brownie = new Producto();
        brownie.nombre = "Brownie";
        brownie.precio = 7000;

        IO.println(latte.descripcion());
        IO.println("¿Hay brownie? " + brownie.hayStock());
        int cobro = latte.vender(2);
        IO.println("Cobrar: $" + cobro);
        IO.println(latte.descripcion());
        latte.vender(5);

        IO.println("\n=== S04: Cliente ===");
        Cliente sofia = new Cliente();
        sofia.nombre = "Sofía";
        sofia.puntos = 41;
        sofia.sumarPuntos(12500);
        IO.println(sofia.tarjeta());
        IO.println("¿Café gratis? " + sofia.puedeCanjear());

        IO.println("\n=== S06: Mesa ===");
        Mesa m4 = new Mesa();
        m4.numero = 4;
        m4.ocupar(3);
        IO.println(m4.estado());
        m4.liberar();
        IO.println(m4.estado());

        IO.println("\n=== S07: Reto Barista (3, 20 [límite] y 21 bebidas + propinas) ===");
        Barista martin = new Barista();
        martin.nombre = "Martín";
        martin.turno = "mañana";
        for (int i = 0; i < 3; i++) {
            martin.preparar("Latte");
        }
        martin.recibirPropina(2500);
        martin.recibirPropina(-500); // Ignora valores negativos
        IO.println(martin.resumen() + " · ¿Merece pausa? " + martin.merecePausa() + " · Propinas: $" + martin.propinas);

        Barista valeria = new Barista();
        valeria.nombre = "Valeria";
        valeria.turno = "tarde";
        for (int i = 1; i <= 21; i++) {
            valeria.preparar("Capuchino");
            if (i == 20) {
                IO.println("[Caso límite 20] " + valeria.resumen() + " · ¿Merece pausa? " + valeria.merecePausa());
            }
        }
        valeria.recibirPropina(5000);
        IO.println(valeria.resumen() + " · ¿Merece pausa? " + valeria.merecePausa() + " · Propinas: $" + valeria.propinas);
    }
}
