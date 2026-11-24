package n07_solid;

/**
 * Nivel 07 · Principios SOLID (Sesión 03).
 * I (Segregación de interfaces): contrato pequeño de notificación.
 */
public interface Notificador {
    void enviar(String destino, String mensaje);
}
