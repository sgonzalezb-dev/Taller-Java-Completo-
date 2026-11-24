package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Niveles 03, 04, 05, 06).
 * Subclase Bebida con constructores sobrecargados, prólogo JEP 513, Tamano e interfaz Personalizable.
 */
public class Bebida extends Producto implements Personalizable {
    private final Tamano tamano;
    private final boolean lecheVegetal;

    public Bebida(int id, String nombre, Categoria categoria, int precioBase,
                  Tamano tamano, boolean lecheVegetal) {
        // Prólogo de Java 25 (JEP 513) antes de super(...)
        if (tamano == null) {
            throw new IllegalArgumentException("El tamaño de la bebida es obligatorio");
        }
        super(id, nombre, categoria, precioBase);
        this.tamano = tamano;
        this.lecheVegetal = lecheVegetal;
    }

    // Constructor corto sobrecargado con prólogo JEP 513 antes de this(...)
    public Bebida(int id, String nombre, int precioBase) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Bebida sin nombre");
        }
        this(id, nombre, Categoria.CALIENTE, precioBase, Tamano.MEDIANO, false);
    }

    public Tamano getTamano() { return tamano; }
    public boolean isLecheVegetal() { return lecheVegetal; }

    @Override
    public int getPrecio() {
        int recargoLeche = lecheVegetal ? 1500 : 0;
        return super.getPrecio() + tamano.recargo() + recargoLeche;
    }

    @Override
    public int minutosPreparacion() {
        return lecheVegetal ? 5 : 4;
    }

    @Override
    public int extra(String opcion) {
        if ("shot extra".equalsIgnoreCase(opcion)) {
            return 2000;
        }
        return 1500;
    }

    @Override
    public String descripcion() {
        String detalle = super.descripcion() + " (" + tamano + " " + tamano.ml() + "ml)";
        return lecheVegetal ? detalle + " · leche vegetal" : detalle;
    }
}
