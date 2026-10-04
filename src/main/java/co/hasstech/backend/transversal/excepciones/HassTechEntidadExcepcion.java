package co.hasstech.backend.transversal.excepciones;

import co.hasstech.backend.transversal.excepciones.enums.Capa;

public class HassTechEntidadExcepcion extends HassTechExcepcion {

	private static final long serialVersionUID = 7349983943373271971L;

	private HassTechEntidadExcepcion(String mensajeUsuario, String mensajeTecnico,
									 Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario) {
		return new HassTechEntidadExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new HassTechEntidadExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception exceptcionRaiz) {
		return new HassTechEntidadExcepcion(mensajeUsuario, mensajeUsuario, exceptcionRaiz);
	}

}
