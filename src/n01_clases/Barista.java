package n01_clases;

/**
 * Nivel 01 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Control de bebidas preparadas, pausas justas y propinas por barista.
 */
public class Barista {
    String nombre;
    String turno;
    int bebidas;
    int propinas; // Extra +10 XP

    void preparar(String bebida) {
        IO.println(nombre + " prepara un " + bebida);
        bebidas++;
    }

    String resumen() {
        return nombre + " (" + turno + "): " + bebidas + " bebidas";
    }

    boolean merecePausa() {
        return bebidas >= 20;
    }

    void recibirPropina(int valor) {
        if (valor > 0) {
            propinas += valor;
        }
    }
}
