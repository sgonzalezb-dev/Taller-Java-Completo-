package n11_serializacion;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 11 · Programa principal de demostración y menú persistente (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    int leerEntero(String prompt) {
        String s = IO.readln(prompt + " › ");
        if (s == null) return 0;
        return Integer.parseInt(s.trim());
    }

    void ejecutarMenuReservas(ArchivoReservas repo, Path csvPath) {
        List<Reserva> reservas = new ArrayList<>();
        try {
            reservas.addAll(repo.cargar());
            IO.println("Reservas cargadas al iniciar: " + reservas.size());
        } catch (IOException | ClassNotFoundException e) {
            IO.println("Aviso al cargar archivo: " + e.getMessage());
        }

        int siguienteId = reservas.stream().mapToInt(Reserva::id).max().orElse(0) + 1;

        while (true) {
            IO.println("\n--- AGENDA PERSISTENTE (N11) ---");
            IO.println("[1] Crear reserva  [2] Listar reservas  [3] Exportar CSV  [0] Guardar y Salir");
            String op = IO.readln("Opción › ");
            if (op == null) {
                op = "0";
            }
            try {
                switch (op.trim()) {
                    case "1" -> {
                        String cliente = IO.readln("Cliente › ");
                        int personas = leerEntero("Personas (1-8)");
                        String hora = IO.readln("Hora (ej. 19:00) › ");
                        Reserva nueva = new Reserva(siguienteId++, cliente, personas, hora);
                        reservas.add(nueva);
                        IO.println("Registrada: " + nueva);
                    }
                    case "2" -> {
                        if (reservas.isEmpty()) {
                            IO.println("Agenda vacía.");
                        } else {
                            for (Reserva r : reservas) IO.println("  " + r);
                        }
                    }
                    case "3" -> {
                        repo.exportarCsv(csvPath, reservas);
                        IO.println("Exportado exitosamente a " + csvPath + " (" + Files.size(csvPath) + " bytes)");
                    }
                    case "0" -> {
                        repo.guardar(reservas);
                        IO.println("Agenda guardada en disco. ¡Hasta mañana!");
                        return;
                    }
                    default -> IO.println("Opción inválida.");
                }
            } catch (InvalidClassException e) {
                IO.println("Error de seguridad (Filtro rechazó clase): " + e.getMessage());
            } catch (IOException e) {
                IO.println("Error de entrada/salida en disco: " + e.getMessage());
            } catch (NumberFormatException e) {
                IO.println("Formato numérico inválido.");
            } catch (IllegalArgumentException e) {
                IO.println("Validación rechazada: " + e.getMessage());
            }
        }
    }

    void main() throws Exception {
        IO.println("=== S03: Almacen binario con ObjectInputFilter ===");
        Path serBodega = Path.of("bodega.ser");
        Files.deleteIfExists(serBodega);

        var almacen = new Almacen(serBodega);
        IO.println("Al abrir: " + almacen.cargar());
        List<Insumo> hoy = List.of(
                new Insumo(1, "Leche entera (L)", 20),
                new Insumo(2, "Café en grano (kg)", 5));
        almacen.guardar(hoy);
        long bytes = Files.size(serBodega);
        IO.println("Guardado: " + bytes + " bytes");
        List<Insumo> leidos = almacen.cargar();
        IO.println("Leído: " + leidos);
        IO.println("¿Iguales? " + hoy.equals(leidos));

        IO.println("\n=== S04: Exportación e importación paralela a CSV ===");
        Path csvBodega = Path.of("bodega.csv");
        almacen.exportarCsv(csvBodega, hoy);
        IO.print(Files.readString(csvBodega));
        List<Insumo> leidosCsv = almacen.importarCsv(csvBodega);
        IO.println(Files.size(csvBodega) + " bytes · ¿iguales? " + hoy.equals(leidosCsv));

        IO.println("\n=== S06: Record Turno serializado ===");
        Path fTurno = Path.of("turno.ser");
        try (var out = new ObjectOutputStream(Files.newOutputStream(fTurno))) {
            out.writeObject(new Turno("Martín", 42));
        }
        try (var in = new ObjectInputStream(Files.newInputStream(fTurno))) {
            in.setObjectInputFilter(
                    ObjectInputFilter.Config.createFilter("Turno;n11_serializacion.Turno;!*"));
            Turno t = (Turno) in.readObject();
            IO.println(t + " · " + Files.size(fTurno) + " bytes");
        }

        IO.println("\n=== S07: Reto ArchivoReservas (Persistencia + CSV + Menú) ===");
        Path serReservas = Path.of("reservas.ser");
        Path csvReservas = Path.of("reservas.csv");
        var archivoReservas = new ArchivoReservas(serReservas);

        List<Reserva> iniciales = List.of(
                new Reserva(1, "Familia Rojas", 6, "18:30"),
                new Reserva(2, "Andrés Gómez", 2, "19:00")
        );
        archivoReservas.guardar(iniciales);
        archivoReservas.exportarCsv(csvReservas, iniciales);
        IO.println("Reservas recuperadas del disco: " + archivoReservas.cargar());
        IO.println("Contenido de reservas.csv:\n" + Files.readString(csvReservas).trim());

        ejecutarMenuReservas(archivoReservas, csvReservas);
    }
}
