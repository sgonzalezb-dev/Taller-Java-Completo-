package n07_solid;

/**
 * Nivel 07 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Destino que imprime el reporte en pantalla (consola).
 */
public class DestinoConsola implements Destino {
    @Override
    public void enviar(String texto) {
        IO.println(texto);
    }
}
