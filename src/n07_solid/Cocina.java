package n07_solid;

/**
 * Nivel 07 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Cocina que recibe su Impresora inyectada por constructor.
 */
public class Cocina {
    private final Impresora impresora;

    public Cocina(Impresora impresora) {
        this.impresora = impresora;
    }

    public void enviarComanda(String plato, int mesa) {
        impresora.imprimir("Mesa " + mesa + ": " + plato);
    }
}
