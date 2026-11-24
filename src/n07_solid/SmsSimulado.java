package n07_solid;

/**
 * Nivel 07 · Principios SOLID (Sesión 03).
 * Detalle concreto para envío simulado de SMS.
 */
public class SmsSimulado implements Notificador {
    @Override
    public void enviar(String destino, String mensaje) {
        IO.println("SMS a " + destino + ": " + mensaje);
    }
}
