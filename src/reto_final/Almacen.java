package reto_final;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 11).
 * Persistencia segura de la bodega de insumos con ObjectInputFilter (lista blanca terminada en !*)
 * y exportación paralela a CSV con java.nio.file.Files.
 */
public class Almacen {
    private final Path archivoSer;
    private final Path archivoCsv;
    private static final String PERMITIDOS =
            "Insumo;reto_final.Insumo;java.util.ArrayList;java.lang.Object;!*";

    public Almacen(Path archivoSer, Path archivoCsv) {
        this.archivoSer = archivoSer;
        this.archivoCsv = archivoCsv;
    }

    public void guardar(List<Insumo> insumos) throws IOException {
        try (var out = new ObjectOutputStream(Files.newOutputStream(archivoSer))) {
            out.writeObject(new ArrayList<>(insumos));
        }
        exportarCsv(insumos);
    }

    @SuppressWarnings("unchecked")
    public List<Insumo> cargar() throws IOException, ClassNotFoundException {
        if (Files.notExists(archivoSer)) {
            return List.of();
        }
        try (var in = new ObjectInputStream(Files.newInputStream(archivoSer))) {
            in.setObjectInputFilter(
                    ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Insumo>) in.readObject();
        }
    }

    public void exportarCsv(List<Insumo> insumos) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;nombre;cantidad");
        for (Insumo i : insumos) {
            lineas.add(i.id() + ";" + i.nombre() + ";" + i.cantidad());
        }
        Files.write(archivoCsv, lineas);
    }

    public Path getArchivoSer() { return archivoSer; }
    public Path getArchivoCsv() { return archivoCsv; }
}
