package n10_records;

/**
 * Nivel 10 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Record Calificacion de 1 a 5 estrellas.
 */
public record Calificacion(String cliente, int estrellas) {
    public Calificacion {
        if (estrellas < 1 || estrellas > 5) {
            throw new IllegalArgumentException("De 1 a 5");
        }
    }

    public boolean esBuena() {
        return estrellas >= 4;
    }
}
