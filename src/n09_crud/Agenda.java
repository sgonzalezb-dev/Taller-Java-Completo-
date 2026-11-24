package n09_crud;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Nivel 09 · Reto 2 de 2: Hazlo tú (Sesión 07).
 * Agenda de reservas con CRUD completo, búsqueda por hora, copia inmutable y ordenamiento por hora.
 */
public class Agenda {
    private final List<Reserva> reservas = new ArrayList<>();
    private int siguienteId = 1;

    // C · Crear
    public Reserva crear(String cliente, int personas, String hora) {
        Reserva r = new Reserva(siguienteId++, cliente, personas, hora);
        reservas.add(r);
        return r;
    }

    // R · Leer (entrega copia inmutable)
    public List<Reserva> listar() {
        return List.copyOf(reservas);
    }

    // Extra +10 XP: listado ordenado por hora con sort
    public List<Reserva> listarOrdenadoPorHora() {
        List<Reserva> copia = new ArrayList<>(reservas);
        copia.sort(Comparator.comparing(Reserva::getHora));
        return List.copyOf(copia);
    }

    public Optional<Reserva> buscar(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public List<Reserva> deLaHora(String hora) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getHora().equals(hora)) {
                resultado.add(r);
            }
        }
        return List.copyOf(resultado);
    }

    // U · Actualizar
    public boolean cambiarHora(int id, String nuevaHora) {
        Optional<Reserva> opt = buscar(id);
        if (opt.isEmpty()) {
            return false;
        }
        opt.get().setHora(nuevaHora);
        return true;
    }

    // D · Eliminar
    public boolean cancelar(int id) {
        return reservas.removeIf(r -> r.getId() == id);
    }
}
