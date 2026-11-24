package n08_genericos;

/**
 * Nivel 08 · Genéricos (Sesión 03).
 * Cliente que implementa Identificable.
 */
public class Cliente implements Identificable {
    private final int id;
    private final String nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int id() { return id; }
    public String nombre() { return nombre; }
}
