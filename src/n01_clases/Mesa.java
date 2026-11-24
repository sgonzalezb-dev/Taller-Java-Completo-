package n01_clases;

/**
 * Nivel 01 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Mesa del salón de Café Sintaxis.
 */
public class Mesa {
    int numero;
    int personas;
    boolean ocupada;

    void ocupar(int cuantas) {
        personas = cuantas;
        ocupada = true;
    }

    void liberar() {
        personas = 0;
        ocupada = false;
    }

    String estado() {
        if (ocupada) {
            return "Mesa " + numero + " ocupada por " + personas;
        }
        return "Mesa " + numero + " libre";
    }
}
