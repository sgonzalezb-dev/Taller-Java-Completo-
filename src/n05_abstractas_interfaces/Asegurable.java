package n05_abstractas_interfaces;

/**
 * Nivel 05 · Reto 2 de 2: Hazlo tú - Extra +10 XP (Sesión 07).
 * Segunda interfaz para demostrar múltiples contratos implementados por una misma clase.
 */
public interface Asegurable {
    int coberturaMaxima();

    default String poliza() {
        return "Cobertura por derrame hasta $" + coberturaMaxima();
    }
}
