package reto_final;

import java.util.ArrayList;
import java.util.List;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 07).
 * Notificador que imprime por consola y registra en bitácora en memoria para auditoría.
 */
public class NotificadorConsola implements Notificador {
    private final List<String> bitacora = new ArrayList<>();

    @Override
    public void enviar(String destino, String mensaje) {
        String registro = "[Notificación → " + destino + "] " + mensaje;
        bitacora.add(registro);
        IO.println(registro);
    }

    public List<String> bitacora() {
        return List.copyOf(bitacora);
    }
}
