package n06_enum;

import java.util.EnumMap;
import java.util.Map;

/**
 * Nivel 06 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    void registrar(Map<Categoria, Integer> v, Categoria c, int valor) {
        v.put(c, v.getOrDefault(c, 0) + valor);
    }

    EnumMap<EstadoMesa, Integer> contarMesas(EstadoMesa[] salon) {
        var conteo = new EnumMap<EstadoMesa, Integer>(EstadoMesa.class);
        for (EstadoMesa estado : salon) {
            conteo.put(estado, conteo.getOrDefault(estado, 0) + 1);
        }
        return conteo;
    }

    void main() {
        IO.println("=== S03: Tamano y EstadoPedido ===");
        for (Tamano t : Tamano.values()) {
            IO.println(t + ": " + t.ml() + " ml, +$" + t.recargo());
        }
        EstadoPedido e = EstadoPedido.RECIBIDO;
        while (e != EstadoPedido.ENTREGADO) {
            e = e.siguiente();
            String aviso = switch (e) {
                case EN_PREPARACION -> "En barra";
                case LISTO -> "¡Listo para recoger!";
                default -> "Entregado";
            };
            IO.println(e.ordinal() + " " + e + " → " + aviso);
        }
        var conteo = new EnumMap<EstadoPedido, Integer>(EstadoPedido.class);
        conteo.put(EstadoPedido.LISTO, 3);
        conteo.put(EstadoPedido.RECIBIDO, 5);
        IO.println(conteo);
        IO.println(Tamano.valueOf("GRANDE").ml());

        IO.println("\n=== S04: Ventas por Categoria con EnumMap ===");
        Map<Categoria, Integer> ventas = new EnumMap<>(Categoria.class);
        registrar(ventas, Categoria.FRIA, 12000);
        registrar(ventas, Categoria.CALIENTE, 9500);
        registrar(ventas, Categoria.CALIENTE, 3500);
        registrar(ventas, Categoria.POSTRE, 7000);
        for (Categoria c : ventas.keySet()) {
            IO.println(c.etiqueta() + ": $" + ventas.get(c));
        }
        for (Categoria c : Categoria.values()) {
            if (!ventas.containsKey(c)) {
                IO.println("Sin ventas: " + c.etiqueta());
            }
        }

        IO.println("\n=== S06: Leche vegetal ===");
        for (Leche l : Leche.values()) {
            if (l.vegetal()) {
                IO.println(l + " +$" + l.recargo());
            }
        }

        IO.println("\n=== S07: Reto Plano del Salón (EstadoMesa y EnumMap) ===");
        EstadoMesa[] salon = {
                EstadoMesa.LIBRE, EstadoMesa.OCUPADA, EstadoMesa.OCUPADA, EstadoMesa.POR_LIMPIAR,
                EstadoMesa.RESERVADA, EstadoMesa.LIBRE, EstadoMesa.OCUPADA, EstadoMesa.RESERVADA
        };

        IO.println("Conteo inicial del salón: " + contarMesas(salon));
        for (int i = 0; i < salon.length; i++) {
            IO.println("  Mesa " + (i + 1) + ": " + salon[i] + " (" + salon[i].aviso()
                    + ") · ¿Disponible? " + salon[i].disponible());
            salon[i] = salon[i].siguiente();
        }
        IO.println("Conteo tras avanzar un paso: " + contarMesas(salon));
    }
}
