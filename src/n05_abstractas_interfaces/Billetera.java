package n05_abstractas_interfaces;

/**
 * Nivel 05 · Ejercicio resuelto explicado (Sesión 04).
 * Billetera digital con saldo propio que valida fondos suficientes.
 */
public class Billetera implements MedioDePago {
    private int saldo;

    public Billetera(int saldo) { this.saldo = saldo; }

    @Override
    public String nombre() { return "Billetera digital"; }

    @Override
    public boolean pagar(int valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
