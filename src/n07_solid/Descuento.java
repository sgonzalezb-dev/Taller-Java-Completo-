package n07_solid;

/**
 * Nivel 07 · Principios SOLID (Sesión 03).
 * O (Abierto/Cerrado) y L (Sustitución de Liskov): contrato de descuento que nunca da negativo.
 */
public interface Descuento {
    int aplicar(int total); // nunca negativo
}
