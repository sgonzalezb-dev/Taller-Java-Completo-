package n07_solid;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Formato de reporte en CSV para contabilidad.
 */
public class FormatoCsv implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "ventas;total\n" + ventas + ";" + total;
    }
}
