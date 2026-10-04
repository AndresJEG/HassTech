package co.hasstech.backend.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechTransversalExcepcion;

public class UtilSQL {
	
	private UtilSQL() {
		
	}
	
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return (!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException excepcion) {
			
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
	
			throw HassTechTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			
			throw HassTechTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	
	public static void asegurarConexionAbierta (Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONEXION_NO_ESTA_ABIERTA_SQL;
			throw HassTechTransversalExcepcion.crear(mensajeUsuario);
		}
	}
	
	public static void iniciarTransaccion(Connection conexion) {
		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			
			throw HassTechTransversalExcepcion.crear(mensajeUsuario);
		}
		
		try {
			conexion.setAutoCommit(false);
		} catch (SQLException exception){
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_AL_INICIAR_LA_TRANSACCION_SQL;
			throw HassTechTransversalExcepcion.crear(mensajeUsuario);
		}
	}
	
	public static void confirmarTransaccion(Connection conexion) {
		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CONFIRMARLA_SQL;
					
			throw HassTechTransversalExcepcion.crear(mensajeUsuario);
		}
		
		try {
			conexion.commit();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_SE_CONFIRMO_LA_TRANSACCION_SQL;
			throw HassTechTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static void cancelarTransaccion(Connection conexion) {
		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CANCELARLA_SQL;
					
			throw HassTechTransversalExcepcion.crear(mensajeUsuario);
		}
		
		try {
			conexion.rollback();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_SE_CANCELO_LA_TRANSACCION_SQL;
			throw HassTechTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static void cerrarConexion (Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CERRARLA_SQL;
			throw HassTechTransversalExcepcion.crear(mensajeUsuario);
		}
		
		try {
			conexion.close();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_SE_CERRO_LA_TRANSACCION_SQL;
			throw HassTechTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		} catch (SQLException excepcion) {
			
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
	
			throw HassTechTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			
			throw HassTechTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static boolean conexionEstaVacia (Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

}
