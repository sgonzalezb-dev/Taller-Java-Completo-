package n11_serializacion;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 11 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Persistencia de reservas con try-with-resources, ObjectInputFilter con lista blanca y exportación CSV.
 */
public class ArchivoReservas {
    private final Path archivoSer;
    private static final String PERMITIDOS =
            "Reserva;n11_serializacion.Reserva;java.util.ArrayList;java.lang.Object;!*";

    public ArchivoReservas(Path archivoSer) {
        this.archivoSer = archivoSer;
    }

    public void guardar(List<Reserva> reservas) throws IOException {
        try (var out = new ObjectOutputStream(
                Files.newOutputStream(archivoSer))) {
            out.writeObject(new ArrayList<>(reservas));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Reserva> cargar() throws IOException, ClassNotFoundException {
        if (Files.notExists(archivoSer)) {
            return List.of();
        }
        try (var in = new ObjectInputStream(
                Files.newInputStream(archivoSer))) {
            in.setObjectInputFilter(
                    ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Reserva>) in.readObject();
        }
    }

    public void exportarCsv(Path archivoCsv, List<Reserva> reservas) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;cliente;personas;hora");
        for (Reserva r : reservas) {
            lineas.add(r.id() + ";" + r.cliente() + ";" + r.personas() + ";" + r.hora());
        }
        Files.write(archivoCsv, lineas);
    }
}
