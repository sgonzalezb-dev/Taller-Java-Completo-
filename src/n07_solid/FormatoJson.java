package n07_solid;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú - Extra +10 XP (Sesión 07).
 * Extensión en JSON sin modificar ninguna clase existente.
 */
public class FormatoJson implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "{\"ventas\": " + ventas + ", \"total\": " + total + "}";
    }
}
