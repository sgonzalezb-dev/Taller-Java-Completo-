package n11_serializacion;

import java.io.Serializable;

/**
 * Nivel 11 · Reto 1 de 2: Autocompleta el código (Sesión 06).
 * Record Turno serializable.
 */
public record Turno(String barista, int bebidas) implements Serializable { }
