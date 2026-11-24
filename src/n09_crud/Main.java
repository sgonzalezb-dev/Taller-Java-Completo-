package n09_crud;

import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 09 · Programa principal de demostración y menú interactivo (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    int leerNumero(String texto) {
        String linea = IO.readln(texto + " › ");
        if (linea == null) {
            return 0;
        }
        return Integer.parseInt(linea.trim());
    }

    void ejecutarMenuAgenda(Agenda agenda) {
        while (true) {
            IO.println("\n--- AGENDA DE RESERVAS (MENÚ INTERACTIVO) ---");
            IO.println("[1] Crear reserva  [2] Listar (por hora)  [3] Buscar por hora");
            IO.println("[4] Cambiar hora   [5] Cancelar reserva   [0] Salir");
            String op = IO.readln("Opción › ");
            if (op == null) {
                IO.println("Entrada finalizada (EOF). ¡Hasta mañana!");
                return;
            }
            try {
                switch (op.trim()) {
                    case "1" -> {
                        String cliente = IO.readln("Cliente › ");
                        int personas = leerNumero("Personas (1-8)");
                        String hora = IO.readln("Hora (ej. 18:30) › ");
                        IO.println("Creada: " + agenda.crear(cliente, personas, hora));
                    }
                    case "2" -> {
                        for (Reserva r : agenda.listarOrdenadoPorHora()) {
                            IO.println("  " + r);
                        }
                    }
                    case "3" -> {
                        String hora = IO.readln("Hora a consultar › ");
                        var filtradas = agenda.deLaHora(hora);
                        IO.println(filtradas.isEmpty() ? "Sin reservas a las " + hora : filtradas);
                    }
                    case "4" -> {
                        int id = leerNumero("Id de reserva");
                        String nuevaHora = IO.readln("Nueva hora › ");
                        boolean ok = agenda.cambiarHora(id, nuevaHora);
                        IO.println(ok ? "Hora actualizada" : "No existe la reserva #" + id);
                    }
                    case "5" -> {
                        int id = leerNumero("Id a cancelar");
                        boolean ok = agenda.cancelar(id);
                        IO.println(ok ? "Reserva cancelada" : "No existe la reserva #" + id);
                    }
                    case "0" -> {
                        IO.println("¡Hasta mañana!");
                        return;
                    }
                    default -> IO.println("Opción inválida");
                }
            } catch (NumberFormatException e) {
                IO.println("Error de formato: debes ingresar un número entero válido.");
            } catch (IllegalArgumentException e) {
                IO.println("Regla del negocio: " + e.getMessage());
            }
        }
    }

    void main() {
        IO.println("=== S03: CRUD de Inventario (Insumo) ===");
        Inventario inv = new Inventario();
        inv.crear("Leche entera (L)", 12);
        inv.crear("Café en grano (kg)", 5);
        inv.crear("Avena (L)", 3);
        IO.println("1 " + inv.listar());
        IO.println("2 " + inv.buscar(2).orElseThrow());
        IO.println("3 ¿Existe #9? " + inv.buscar(9).isPresent());
        inv.actualizar(1, 20);
        inv.eliminar(3);
        var lista = inv.listar();
        IO.println("4 " + lista);
        IO.println("5 Primero: " + lista.getFirst());
        IO.println("6 Último: " + lista.getLast());

        IO.println("\n=== S06: Lista de espera con ArrayList ===");
        List<String> espera = new ArrayList<>();
        espera.add("Rojas (4)"); // C
        espera.add("Gómez (2)");
        espera.add("Pérez (3)");
        IO.println("En espera: " + espera.size()); // R
        IO.println("Sigue: " + espera.getFirst());
        espera.set(1, "Gómez (5)"); // U
        espera.removeIf(n -> n.startsWith("Rojas")); // D
        IO.println(espera);
        IO.println("¿Pérez? " + espera.contains("Pérez (3)"));

        IO.println("\n=== S07: Reto Agenda de Reservas (Demostración CRUD + Menú) ===");
        Agenda agenda = new Agenda();
        agenda.crear("Familia Rojas", 6, "19:30");
        agenda.crear("Andrés Gómez", 2, "18:00");
        agenda.crear("Valeria Soto", 4, "19:30");
        IO.println("Reservas ordenadas por hora: " + agenda.listarOrdenadoPorHora());
        IO.println("Reservas de las 19:30: " + agenda.deLaHora("19:30"));
        agenda.cambiarHora(2, "20:00");
        agenda.cancelar(1);
        IO.println("Tras actualizar #2 y cancelar #1: " + agenda.listarOrdenadoPorHora());

        // Inicia el menú interactivo de consola (pulsa 0 o EOF para salir)
        ejecutarMenuAgenda(agenda);
    }
}
