package co.hasstech.backend.transversal.excepciones;

import co.hasstech.backend.transversal.excepciones.enums.Capa;

public class HassTechControladorExcepcion extends HassTechExcepcion {

	private static final long serialVersionUID = 2008961953121852599L;

	private HassTechControladorExcepcion(String mensajeUsuario, String mensajeTecnico,
										 Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario) {
		return new HassTechControladorExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new HassTechControladorExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception exceptcionRaiz) {
		return new HassTechControladorExcepcion(mensajeUsuario, mensajeUsuario, exceptcionRaiz);
	}

}
