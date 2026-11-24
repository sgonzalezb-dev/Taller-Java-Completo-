package n02_encapsulamiento;

/**
 * Nivel 02 · Ejercicio resuelto explicado (Sesión 04).
 * Producto encapsulado con rango de precio válido [0, 50000].
 */
public class Producto {
    private String nombre;
    private int precio;
    private int stock;

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        if (precio < 0 || precio > 50000) {
            throw new IllegalArgumentException(
                    "Precio fuera de rango: " + precio);
        }
        this.precio = precio;
    }

    public void reponer(int unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException(
                    "Unidades a reponer inválidas: " + unidades);
        }
        this.stock += unidades;
    }
}
