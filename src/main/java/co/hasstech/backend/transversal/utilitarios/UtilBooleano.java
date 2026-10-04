package co.hasstech.backend.transversal.utilitarios;

public final class UtilBooleano {

    private UtilBooleano() {
        super();
    }

    public static boolean obtenerValorDefecto(final Boolean valor, final boolean valorDefecto) {
        return UtilObjeto.esNulo(valor) ? valorDefecto : valor;
    }

    /**
     * Sobrecarga común: si es nulo, por defecto es falso.
     * Muy útil para chequear permisos o estados.
     */
    public static boolean obtenerValorDefecto(final Boolean valor) {
        return obtenerValorDefecto(valor, false);
    }

    /**
     * Retorna true SOLO si el objeto no es nulo y es true.
     */
    public static boolean esVerdadero(final Boolean valor) {
        return Boolean.TRUE.equals(valor);
    }

    /**
     * Retorna true SOLO si el objeto no es nulo y es false.
     */
    public static boolean esFalso(final Boolean valor) {
        return Boolean.FALSE.equals(valor);
    }
}