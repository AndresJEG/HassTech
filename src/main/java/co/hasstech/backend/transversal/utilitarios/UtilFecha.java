package co.hasstech.backend.transversal.utilitarios;

import java.time.LocalDate;

public class UtilFecha {
	
	public static final LocalDate FECHA_DEFECTO = LocalDate.of (1900,01,01);
	
	private UtilFecha() {
	}
	
	public static LocalDate obtenerValorDefecto(final LocalDate fecha, final LocalDate valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fecha, valorDefecto);
	};
	
	public static LocalDate obtenerValorDefecto(final LocalDate fecha) {
		return obtenerValorDefecto(fecha, FECHA_DEFECTO);
	}
}
