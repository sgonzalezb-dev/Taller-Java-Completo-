package n07_solid;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * D (Inversión de dependencias): interfaz para enviar el reporte a cualquier destino.
 */
public interface Destino {
    void enviar(String texto);
}
