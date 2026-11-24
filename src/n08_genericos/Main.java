package n08_genericos;

import java.util.List;

/**
 * Nivel 08 · Programa principal de demostración y verificación (Sesiones 03, 04, 06 y 07).
 * Emplea método de instancia void main() y consola IO (JEP 512).
 */
public class Main {
    <T> T ultimo(List<T> lista) {
        return lista.getLast();
    }

    int sumarPrecios(List<? extends Producto> lista) {
        int s = 0;
        for (Producto p : lista) s += p.getPrecio();
        return s;
    }

    <T extends Comparable<T>> T maximo(List<T> lista) {
        T mejor = lista.getFirst();
        for (T x : lista) {
            if (x.compareTo(mejor) > 0) {
                mejor = x;
            }
        }
        return mejor;
    }

    <T> int contar(List<T> lista, T buscado) {
        int apariciones = 0;
        for (T item : lista) {
            if (item.equals(buscado)) {
                apariciones++;
            }
        }
        return apariciones;
    }

    int sumar(List<? extends Number> l) {
        int total = 0;
        for (Number n : l) {
            total += n.intValue();
        }
        return total;
    }

    void main() {
        IO.println("=== S03: Repositorio<T extends Identificable> ===");
        var productos = new Repositorio<Producto>();
        productos.guardar(new Producto(1, "Latte", 9500));
        productos.guardar(new Producto(2, "Brownie", 7000));
        var clientes = new Repositorio<Cliente>();
        clientes.guardar(new Cliente(7, "Sofía"));

        Producto p = productos.porId(2); // sin cast
        IO.println(p.getNombre() + " $" + p.getPrecio());
        IO.println(clientes.porId(7).nombre());
        IO.println(ultimo(List.of("tinto", "latte", "moka")));
        var mas = List.of(new Producto(3, "Té", 4000),
                new Producto(4, "Moka", 10500));
        IO.println("Total: $" + sumarPrecios(mas));

        IO.println("\n=== S04: Método genérico maximo con Comparable ===");
        List<Integer> precios = List.of(9500, 3500, 10500, 7000);
        List<String> nombres = List.of("latte", "moka", "tinto");
        IO.println("Precio más alto: " + maximo(precios));
        IO.println("Último en el menú: " + maximo(nombres));

        IO.println("\n=== S06: Bandeja<T> ===");
        Bandeja<String> b = new Bandeja<>(2);
        b.poner("latte");
        b.poner("moka");
        IO.println("¿Cabe un tinto? " + b.poner("tinto"));
        IO.println(b.primera() + " · " + b.cantidad());

        IO.println("\n=== S07: Reto Historial<T>, contar() y sumar() ===");
        var ultimosPedidos = new Historial<String>(3);
        ultimosPedidos.agregar("Latte");
        ultimosPedidos.agregar("Capuchino");
        ultimosPedidos.agregar("Brownie");
        ultimosPedidos.agregar("Latte"); // Desplaza el primer "Latte" con removeFirst()
        IO.println("Últimos 3 pedidos: " + ultimosPedidos.todos());
        IO.println("Más reciente: " + ultimosPedidos.masReciente());
        IO.println("Veces 'Latte' en historial: " + contar(ultimosPedidos.todos(), "Latte"));

        var ultimosCobros = new Historial<Integer>(3);
        ultimosCobros.agregar(8000);
        ultimosCobros.agregar(12500);
        ultimosCobros.agregar(9500);
        ultimosCobros.agregar(15000); // Quedan [12500, 9500, 15000]
        IO.println("Últimos 3 cobros: " + ultimosCobros.todos());
        IO.println("Suma de últimos cobros: $" + sumar(ultimosCobros.todos()));
        IO.println("Mayor cobro en historial (Extra): $" + ultimosCobros.mayor());
    }
}
