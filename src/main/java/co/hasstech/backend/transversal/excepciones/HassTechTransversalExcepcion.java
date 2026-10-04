package co.hasstech.backend.transversal.excepciones;

import co.hasstech.backend.transversal.excepciones.enums.Capa;

public class HassTechTransversalExcepcion extends HassTechExcepcion {

	private static final long serialVersionUID = 4459747510831888830L;

	private HassTechTransversalExcepcion(String mensajeUsuario, String mensajeTecnico,
										 Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario) {
		return new HassTechTransversalExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new HassTechTransversalExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception exceptcionRaiz) {
		return new HassTechTransversalExcepcion(mensajeUsuario, mensajeUsuario, exceptcionRaiz);
	}

}
