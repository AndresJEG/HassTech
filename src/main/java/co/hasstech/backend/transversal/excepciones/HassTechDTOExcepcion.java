package co.hasstech.backend.transversal.excepciones;

import co.hasstech.backend.transversal.excepciones.enums.Capa;

public class HassTechDTOExcepcion extends HassTechExcepcion {

	private static final long serialVersionUID = -856566259327133495L;

	private HassTechDTOExcepcion(String mensajeUsuario, String mensajeTecnico,
								 Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario) {
		return new HassTechDTOExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new HassTechDTOExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception exceptcionRaiz) {
		return new HassTechDTOExcepcion(mensajeUsuario, mensajeUsuario, exceptcionRaiz);
	}

}
