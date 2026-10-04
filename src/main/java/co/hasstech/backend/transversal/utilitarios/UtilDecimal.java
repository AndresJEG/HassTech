package co.hasstech.backend.transversal.utilitarios;

public final class UtilDecimal {

    private UtilDecimal() { super(); }

    public static float obtenerValorDefecto(float valor) {
        return (valor < 0) ? (float) 0.0 : valor;
    }
}