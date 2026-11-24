package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Niveles 03, 04, 05, 06).
 * Subclase Postre con constructores sobrecargados y prólogo JEP 513.
 */
public class Postre extends Producto {
    private final boolean vegano;

    public Postre(int id, String nombre, Categoria categoria, int precioBase, boolean vegano) {
        super(id, nombre, categoria, precioBase);
        this.vegano = vegano;
    }

    public Postre(int id, String nombre, int precioBase) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Postre sin nombre");
        }
        this(id, nombre, Categoria.POSTRE, precioBase, false);
    }

    public boolean isVegano() { return vegano; }

    @Override
    public int minutosPreparacion() {
        return 2;
    }

    @Override
    public String descripcion() {
        return vegano ? super.descripcion() + " · vegano" : super.descripcion();
    }
}
