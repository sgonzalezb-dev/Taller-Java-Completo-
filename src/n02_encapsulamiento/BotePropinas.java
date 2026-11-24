package n02_encapsulamiento;

/**
 * Nivel 02 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Bote de propinas sin setters públicos, con reparto entero y cálculo de sobrante (%).
 */
public class BotePropinas {
    private int total;
    private int aportes;

    public void aportar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "Aporte inválido (debe ser mayor a 0): " + valor);
        }
        total += valor;
        aportes++;
    }

    public int repartir(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException(
                    "Número de personas inválido: " + personas);
        }
        return total / personas;
    }

    public int sobrante(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException(
                    "Número de personas inválido: " + personas);
        }
        return total % personas;
    }

    public int getTotal() {
        return total;
    }

    public int getAportes() {
        return aportes;
    }
}
