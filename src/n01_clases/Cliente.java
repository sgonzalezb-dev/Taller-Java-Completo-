package n01_clases;

/**
 * Nivel 01 · Ejercicio resuelto explicado (Sesión 04).
 * Tarjeta de puntos de fidelización de cada cliente.
 */
public class Cliente {
    String nombre;
    int puntos;

    // 1 punto por cada $1000 de compra (división entera)
    void sumarPuntos(int compra) {
        puntos = puntos + compra / 1000;
    }

    boolean puedeCanjear() {
        return puntos >= 50;
    }

    void canjear() {
        if (puedeCanjear()) {
            puntos -= 50;
        }
    }

    String tarjeta() {
        return nombre + ": " + puntos + " puntos";
    }
}
