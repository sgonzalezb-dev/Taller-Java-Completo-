package n06_enum;

/**
 * Nivel 06 · Enum: valores con nombre (Sesión 03).
 * Tamaños de vaso con mililitros y recargo.
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
