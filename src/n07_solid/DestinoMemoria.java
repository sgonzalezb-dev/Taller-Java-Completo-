package n07_solid;

import java.util.ArrayList;
import java.util.List;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Destino en memoria para pruebas automatizadas sin imprimir por consola.
 */
public class DestinoMemoria implements Destino {
    private final List<String> guardados = new ArrayList<>();

    @Override
    public void enviar(String texto) {
        guardados.add(texto);
    }

    public List<String> guardados() {
        return List.copyOf(guardados);
    }
}
