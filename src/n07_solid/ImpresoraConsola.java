package n07_solid;

/**
 * Nivel 07 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Implementación de Impresora por consola.
 */
public class ImpresoraConsola implements Impresora {
    @Override
    public void imprimir(String texto) {
        IO.println("[impresora] " + texto);
    }
}
