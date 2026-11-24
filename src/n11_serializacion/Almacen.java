package n11_serializacion;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 11 · Serialización moderna con archivos (Sesión 03 y 04).
 * Almacén de bodega con ObjectOutputStream/InputStream, ObjectInputFilter (lista blanca) y exportación CSV.
 */
public class Almacen {
    private final Path archivo;
    private static final String PERMITIDOS =
            "Insumo;n11_serializacion.Insumo;java.util.ArrayList;java.lang.Object;!*";

    public Almacen(Path archivo) { this.archivo = archivo; }

    public void guardar(List<Insumo> insumos) throws IOException {
        try (var out = new ObjectOutputStream(
                Files.newOutputStream(archivo))) {
            out.writeObject(new ArrayList<>(insumos));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Insumo> cargar() throws IOException, ClassNotFoundException {
        if (Files.notExists(archivo)) {
            return List.of();
        }
        try (var in = new ObjectInputStream(
                Files.newInputStream(archivo))) {
            in.setObjectInputFilter(
                    ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Insumo>) in.readObject();
        }
    }

    // Sesión 04: Exportación e importación paralela a CSV con java.nio.file.Files
    public void exportarCsv(Path csv, List<Insumo> insumos) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (Insumo i : insumos) {
            lineas.add(aLinea(i));
        }
        Files.write(csv, lineas);
    }

    public List<Insumo> importarCsv(Path csv) throws IOException {
        List<Insumo> leidos = new ArrayList<>();
        for (String l : Files.readAllLines(csv)) {
            if (!l.isBlank()) {
                leidos.add(deLinea(l));
            }
        }
        return leidos;
    }

    public static String aLinea(Insumo i) {
        return i.id() + ";" + i.nombre() + ";" + i.cantidad();
    }

    public static Insumo deLinea(String linea) {
        String[] p = linea.split(";");
        return new Insumo(Integer.parseInt(p[0]), p[1], Integer.parseInt(p[2]));
    }
}
