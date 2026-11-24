package n07_solid;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Formato de reporte en texto legible para Valeria.
 */
public class FormatoTexto implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "CIERRE DEL DÍA · " + ventas + " ventas · total $" + total;
    }
}
