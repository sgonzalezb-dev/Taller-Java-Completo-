package n06_enum;

/**
 * Nivel 06 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Tipos de leche con recargo y clasificación vegetal.
 */
public enum Leche {
    ENTERA(0), DESLACTOSADA(500), AVENA(1500), ALMENDRAS(1800);

    private final int recargo;

    Leche(int recargo) {
        this.recargo = recargo;
    }

    public int recargo() { return recargo; }

    public boolean vegetal() {
        return switch (this) {
            case AVENA, ALMENDRAS -> true;
            default -> false;
        };
    }
}
