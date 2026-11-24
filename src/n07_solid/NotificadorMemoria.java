package n07_solid;

import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 07 · Ejercicio resuelto explicado (Sesión 04).
 * Doble de prueba en memoria para verificar notificaciones sin enviar SMS reales.
 */
public class NotificadorMemoria implements Notificador {
    private final List<String> enviados = new ArrayList<>();

    @Override
    public void enviar(String destino, String mensaje) {
        enviados.add(destino + " → " + mensaje);
    }

    public List<String> enviados() {
        return enviados;
    }
}
