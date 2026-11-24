package n07_solid;

import java.util.List;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * ReporteDiario refactorizado con SOLID: delega el cálculo en Totales y recibe Formato y Destino por constructor.
 */
public class ReporteDiario {
    private final Totales totales;
    private final Formato formato;
    private final Destino destino;

    public ReporteDiario(Totales totales, Formato formato, Destino destino) {
        this.totales = totales;
        this.formato = formato;
        this.destino = destino;
    }

    public ReporteDiario(Formato formato, Destino destino) {
        this(new Totales(), formato, destino);
    }

    public String generar(List<Integer> cobros) {
        int total = totales.sumar(cobros);
        int ventas = totales.contar(cobros);
        String salida = formato.dar(total, ventas);
        destino.enviar(salida);
        return salida;
    }

    // Paso 1 de referencia: método original antes de refactorizar para verificar que la salida en texto es idéntica
    public static String generarOriginal(List<Integer> cobros) {
        int total = 0;
        for (int c : cobros) total += c;
        String texto = "CIERRE DEL DÍA · " + cobros.size() + " ventas · total $" + total;
        IO.println(texto);
        return texto;
    }
}
