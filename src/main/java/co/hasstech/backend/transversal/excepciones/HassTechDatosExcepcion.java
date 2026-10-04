package co.hasstech.backend.transversal.excepciones;

import co.hasstech.backend.transversal.excepciones.enums.Capa;

public class HassTechDatosExcepcion extends HassTechExcepcion {

	private static final long serialVersionUID = -3789453764295582052L;

	private HassTechDatosExcepcion(String mensajeUsuario, String mensajeTecnico,
								   Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	public static HassTechExcepcion crear(String mensajeUsuario) {
		return new HassTechDatosExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new HassTechDatosExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static HassTechExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception exceptcionRaiz) {
		return new HassTechDatosExcepcion(mensajeUsuario, mensajeUsuario, exceptcionRaiz);
	}

}
