package reto_final;

/**
 * Reto Final · Café Sintaxis 1.0 (Nivel 05).
 * Contrato para productos que admiten opciones adicionales en barra.
 */
public interface Personalizable {
    int extra(String opcion);

    default String opciones() {
        return "leche de avena, shot extra, canela";
    }
}
