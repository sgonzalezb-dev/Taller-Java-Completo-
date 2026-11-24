package n05_abstractas_interfaces;

/**
 * Nivel 05 · Clases abstractas e interfaces (Sesión 03).
 * Contrato de barra para productos que admiten opciones adicionales.
 */
public interface Personalizable {
    int extra(String opcion);

    default String opciones() {
        return "leche de avena, shot extra";
    }
}
