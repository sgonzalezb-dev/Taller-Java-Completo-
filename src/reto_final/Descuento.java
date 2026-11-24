package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 07).
 * Principio O y L de SOLID: contrato de descuento inyectable que garantiza monto >= 0.
 */
public interface Descuento {
    String nombre();
    int aplicar(int total); // nunca negativo
}
