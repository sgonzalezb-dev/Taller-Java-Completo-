package reto_final;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Reto Final · Café Sintaxis 1.0 (Integración completa de los 11 niveles).
 * Sistema integral de la cafetería:
 * - Carta de productos polimórficos (N01, N03, N04, N05, N06) en Repositorio<Producto> (N08, N09).
 * - Pedidos compuestos y flujo de estados con Enum y switch (N04, N06).
 * - Caja SOLID con inyección de Descuento y Notificador, más reporte por Categoria con EnumMap (N02, N06, N07).
 * - Recibos como records inmutables verificados con patrones de record en instanceof/switch (N10).
 * - Bodega de insumos con CRUD completo, Optional y persistencia binaria con filtro + CSV al cerrar (N08, N09, N11).
 */
public class Main {
    int sumarPreciosMenu(List<? extends Producto> productos) {
        int suma = 0;
        for (Producto p : productos) {
            suma += p.getPrecio();
        }
        return suma;
    }

    void imprimirReciboConPatrones(Recibo recibo) {
        IO.println("  ┌── Recibo #" + recibo.numero() + " · Cliente: " + recibo.cliente());
        for (LineaRecibo linea : recibo.lineas()) {
            if (linea instanceof LineaRecibo(var prod, var precioUnit, var cant)) {
                IO.println("  │   " + cant + " × " + prod + " ($" + precioUnit + " c/u) = $" + (cant * precioUnit));
            }
        }
        IO.println("  └── Subtotal: $" + recibo.subtotalBruto() + " · Total cobrado: $" + recibo.totalFinal());
    }

    int leerEntero(String prompt) {
        String entrada = IO.readln(prompt + " › ");
        if (entrada == null) return 0;
        return Integer.parseInt(entrada.trim());
    }

    void ejecutarMenuInteractivo(Repositorio<Producto> carta,
                                 Repositorio<Insumo> bodega,
                                 Caja caja,
                                 Almacen almacen) {
        while (true) {
            IO.println("\n================ CAFÉ SINTAXIS 1.0 · CONSOLA PRINCIPAL ================");
            IO.println("[1] Ver carta del menú     [2] Registrar pedido rápido   [3] Listar bodega (CRUD)");
            IO.println("[4] Crear insumo (CRUD)    [5] Actualizar stock insumo   [6] Eliminar insumo");
            IO.println("[7] Ver cierre de caja     [0] Guardar bodega (.ser/.csv) y Salir");
            String op = IO.readln("Opción › ");
            if (op == null) {
                op = "0";
            }
            try {
                switch (op.trim()) {
                    case "1" -> {
                        for (Producto p : carta.listar()) {
                            IO.println("  " + p.descripcion());
                            if (p instanceof Personalizable per) {
                                IO.println("      Opciones personalizables: " + per.opciones());
                            }
                        }
                    }
                    case "2" -> {
                        String cliente = IO.readln("Nombre del cliente › ");
                        int idProd = leerEntero("ID del producto");
                        int cant = leerEntero("Cantidad");
                        Producto prod = carta.buscar(idProd)
                                .orElseThrow(() -> new IllegalArgumentException("No existe el producto #" + idProd));
                        Pedido nuevo = new Pedido(caja.getRecibosEmitidos().size() + 1, 1, cliente);
                        nuevo.agregar(prod, cant);
                        Recibo r = caja.cobrarPedido(nuevo, new SinDescuento());
                        imprimirReciboConPatrones(r);
                    }
                    case "3" -> {
                        for (Insumo i : bodega.listar()) {
                            IO.println("  #" + i.id() + " " + i.nombre() + " · Stock: " + i.cantidad());
                        }
                    }
                    case "4" -> {
                        int nuevoId = bodega.listar().stream().mapToInt(Insumo::id).max().orElse(0) + 1;
                        String nombre = IO.readln("Nombre del insumo › ");
                        int cant = leerEntero("Cantidad inicial");
                        Insumo creado = new Insumo(nuevoId, nombre, cant);
                        bodega.guardar(creado);
                        IO.println("Insumo registrado: " + creado);
                    }
                    case "5" -> {
                        int id = leerEntero("ID del insumo a actualizar");
                        int cant = leerEntero("Nueva cantidad");
                        boolean ok = bodega.actualizar(id, actual -> actual.conCantidad(cant));
                        IO.println(ok ? "Stock actualizado." : "No existe el insumo #" + id);
                    }
                    case "6" -> {
                        int id = leerEntero("ID del insumo a retirar");
                        boolean ok = bodega.eliminar(id);
                        IO.println(ok ? "Insumo eliminado." : "No existe el insumo #" + id);
                    }
                    case "7" -> {
                        IO.println(caja.resumenCierre());
                        IO.println("Ventas por categoría (EnumMap): " + caja.getVentasPorCategoria());
                    }
                    case "0" -> {
                        almacen.guardar(bodega.listar());
                        IO.println("Bodega guardada en '" + almacen.getArchivoSer() + "' y exportada a '"
                                + almacen.getArchivoCsv() + "'. ¡Hasta mañana en Café Sintaxis!");
                        return;
                    }
                    default -> IO.println("Opción no reconocida.");
                }
            } catch (Exception e) {
                IO.println("Aviso del sistema: " + e.getMessage());
            }
        }
    }

    void main() throws Exception {
        IO.println("╔════════════════════════════════════════════════════════════════╗");
        IO.println("║        CAFÉ SINTAXIS 1.0 · SISTEMA INTEGRADO (11 NIVELES)      ║");
        IO.println("╚════════════════════════════════════════════════════════════════╝");

        // 1. Carta de productos en Repositorio<Producto> (N01, N03, N04, N05, N06, N08)
        var carta = new Repositorio<Producto>();
        carta.guardar(new Bebida(1, "Latte de la Casa", Categoria.CALIENTE, 9500, Tamano.GRANDE, true));
        carta.guardar(new Bebida(2, "Tinto Origen", 3500)); // Constructor corto con prólogo JEP 513
        carta.guardar(new Bebida(3, "Cold Brew Naranja", Categoria.FRIA, 11000, Tamano.MEDIANO, false));
        carta.guardar(new Postre(4, "Torta de Zanahoria", Categoria.POSTRE, 8500, true));
        carta.guardar(new Postre(5, "Brownie Melcochudo", 7000));

        IO.println("\n[1] CARTA DEL MENÚ (" + carta.cantidad() + " productos · Suma precios unitarios: $"
                + sumarPreciosMenu(carta.listar()) + "):");
        for (Producto p : carta.listar()) {
            IO.println("  • " + p.descripcion());
        }

        // 2. Pedidos compuestos, Caja SOLID, Descuentos, Notificador y Recibos Record (N02, N04, N07, N10)
        IO.println("\n[2] PROCESAMIENTO DE PEDIDOS EN CAJA SOLID:");
        var notificador = new NotificadorConsola();
        var caja = new Caja(notificador);

        Pedido pMesa4 = new Pedido(101, 4, "Valeria");
        pMesa4.agregar(carta.buscar(1).orElseThrow(), 2);
        pMesa4.agregar(carta.buscar(4).orElseThrow(), 1);
        Recibo r1 = caja.cobrarPedido(pMesa4, new DescuentoPorcentaje(10));
        imprimirReciboConPatrones(r1);

        Pedido pBarra = new Pedido(102, 2, "Martín");
        pBarra.agregar(carta.buscar(2).orElseThrow(), 1);
        pBarra.agregar(carta.buscar(5).orElseThrow(), 1);
        Recibo r2 = caja.cobrarPedido(pBarra, new DescuentoFidelidad());
        imprimirReciboConPatrones(r2);

        IO.println("Resumen parcial de Caja: " + caja.resumenCierre());
        IO.println("Contabilidad por Categoría (EnumMap): " + caja.getVentasPorCategoria());

        // 3. Bodega con CRUD, Optional, Serialización con ObjectInputFilter y exportación CSV (N08, N09, N11)
        IO.println("\n[3] BODEGA PERSISTENTE (SERIALIZACIÓN CON FILTRO + CSV):");
        var almacen = new Almacen(Path.of("cafe_bodega.ser"), Path.of("cafe_bodega.csv"));
        var bodega = new Repositorio<Insumo>();

        List<Insumo> recuperados = almacen.cargar();
        if (recuperados.isEmpty()) {
            bodega.guardar(new Insumo(1, "Leche entera (L)", 24));
            bodega.guardar(new Insumo(2, "Café en grano Huila (kg)", 10));
            bodega.guardar(new Insumo(3, "Bebida de avena (L)", 8));
        } else {
            for (Insumo ins : recuperados) {
                bodega.guardar(ins);
            }
        }

        // Actualización funcional de un record en el CRUD
        bodega.actualizar(1, ins -> ins.conCantidad(ins.cantidad() + 6));
        almacen.guardar(bodega.listar());

        IO.println("Insumos verificados desde '" + almacen.getArchivoSer() + "' ("
                + Files.size(almacen.getArchivoSer()) + " bytes): " + almacen.cargar());
        IO.println("Vista de '" + almacen.getArchivoCsv() + "' para contabilidad:\n"
                + Files.readString(almacen.getArchivoCsv()).trim());

        // 4. Menú interactivo (finaliza limpiamente al elegir 0 o recibir EOF)
        ejecutarMenuInteractivo(carta, bodega, caja, almacen);
    }
}
