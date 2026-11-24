package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 07).
 * Principio I y D de SOLID: interfaz de notificación desacoplada.
 */
public interface Notificador {
    void enviar(String destino, String mensaje);
}
