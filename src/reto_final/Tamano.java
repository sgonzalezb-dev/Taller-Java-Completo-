package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 06).
 * Enum Tamano con mililitros y recargo de precio.
 */
public enum Tamano {
    PEQUENO(240, 0),
    MEDIANO(350, 1500),
    GRANDE(470, 2800);

    private final int ml;
    private final int recargo;

    Tamano(int ml, int recargo) {
        this.ml = ml;
        this.recargo = recargo;
    }

    public int ml() { return ml; }
    public int recargo() { return recargo; }
}
