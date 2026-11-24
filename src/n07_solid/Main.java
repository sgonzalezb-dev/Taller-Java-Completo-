package n07_solid;

import java.util.List;

/**
 * Nivel 07 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    void main() {
        IO.println("=== S03: Caja refactorizada con SOLID ===");
        Caja caja = new Caja(new SmsSimulado());
        var pedido = List.of(9500, 7000, 3500);
        caja.cobrar(pedido, new Porcentaje(10), "300 555 0101");
        caja.cobrar(List.of(1500), new Fidelidad(), "300 555 0103");

        IO.println("\n=== S04: Prueba de Caja con NotificadorMemoria ===");
        var memoria = new NotificadorMemoria();
        Caja cajaPrueba = new Caja(memoria);
        cajaPrueba.cobrar(List.of(9500), new Porcentaje(0), "300 555 0104");
        cajaPrueba.cobrar(List.of(3500), new Porcentaje(50), "300 555 0105");
        IO.println("Mensajes enviados: " + memoria.enviados().size());
        IO.println("Último: " + memoria.enviados().getLast());

        IO.println("\n=== S06: Cocina e Impresora ===");
        Cocina c = new Cocina(new ImpresoraConsola());
        c.enviarComanda("Sándwich de pollo", 4);

        IO.println("\n=== S07: Reto ReporteDiario (SOLID) ===");
        var cobrosDia = List.of(9500, 12000, 7000, 15000);

        IO.print("[Original]      ");
        String salidaOriginal = ReporteDiario.generarOriginal(cobrosDia);

        IO.print("[Refactorizado] ");
        var reporteTexto = new ReporteDiario(new FormatoTexto(), new DestinoConsola());
        String salidaRefactor = reporteTexto.generar(cobrosDia);
        IO.println("¿Salida idéntica al paso 1? " + salidaOriginal.equals(salidaRefactor));

        var destinoMem = new DestinoMemoria();
        var reporteCsv = new ReporteDiario(new FormatoCsv(), destinoMem);
        reporteCsv.generar(cobrosDia);
        IO.println("[CSV en memoria]\n" + destinoMem.guardados().getFirst());

        var reporteJson = new ReporteDiario(new FormatoJson(), new DestinoConsola());
        IO.print("[Extra JSON]    ");
        reporteJson.generar(cobrosDia);
    }
}
