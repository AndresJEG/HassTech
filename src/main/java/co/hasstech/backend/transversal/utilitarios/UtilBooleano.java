package co.hasstech.backend.transversal.utilitarios;

public final class UtilBooleano {

    private UtilBooleano() {
        super();
    }

    public static boolean obtenerValorDefecto(final Boolean valor, final boolean valorDefecto) {
        return UtilObjeto.esNulo(valor) ? valorDefecto : valor;
    }

    public static boolean obtenerValorDefecto(final Boolean valor) {
        return obtenerValorDefecto(valor, false);
    }

    public static boolean esVerdadero(final Boolean valor) {
        return Boolean.TRUE.equals(valor);
    }

    public static boolean esFalso(final Boolean valor) {
        return Boolean.FALSE.equals(valor);
    }
}