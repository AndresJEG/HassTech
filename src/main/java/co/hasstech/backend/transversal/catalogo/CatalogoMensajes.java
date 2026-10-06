package co.hasstech.backend.transversal.catalogo;

public class CatalogoMensajes {
	
	private CatalogoMensajes() {
		
	}
	
	public static class UtilSQL {
		
		private UtilSQL() {
			
		}
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA= "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA= "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible iniciar la operacion deseada debido a que la conexion contra la fuente de información deseada se encuentra en un estado inconsistente porque esta cerrada o vacio o ya fue iniciada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONEXION_NO_ESTA_ABIERTA_SQL= "No es posible asegurar que la conexión esté abierta. Por favor intente de nuevo, si el problema persiste, contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_AL_INICIAR_LA_TRANSACCION_SQL ="Ocurrió un problema al iniciar la transacción. Por favor intente de nuevo, si el problema persiste, por favor comunicarse con el administrador de la aplicación"; 
		public static final String USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CONFIRMARLA_SQL = "No es posible confirmar una transacción que no ha sido iniciada. Por favor intente de nuevo. Si el problema persiste, comuniquese con el administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_SE_CONFIRMO_LA_TRANSACCION_SQL = "Ocurrió un problema al intentar confirmar la transacción solicitada. Por favor intente de nuevo, si el problema persiste, por favor comunicarse con el administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CANCELARLA_SQL = "No es posible cancelar una transacción que no ha sido abierta. Por favor vuelva a intentar, si el problema persiste, comuniquese con el administrador";
		public static final String USUARIO_ERROR_NO_SE_CANCELO_LA_TRANSACCION_SQL = "Ocurrio un problema al intentar cancelar la transacción. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CERRARLA_SQL = "No es posible cerrar una transacción si no ha sido abierta";
		public static final String USUARIO_ERROR_NO_SE_CERRO_LA_TRANSACCION_SQL = "Ocurrió un problema al intentar cerrar la transacción. Por favor intente de nuevo, y si el problema persiste, cominucarlo al administrador";


		//MEtodoAplicacionSqlServerDAO
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODO_APLICACION_POR_ID = "Ocurrió un problema al consultar el método de aplicación solicitado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador ";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODOS_APLICACION_POR_FILTRO = "Ocurrió un problema al consultar los métodos de aplicación con el filtro indicado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_METODOS_APLICACION = "Ocurrió un problema al consultar los métodos de aplicación. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";

		//ToxicidadSqlServerDAO
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TOXICIDAD_POR_ID = "Ocurrió un problema al consultar la toxicidad solicitada. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TOXICIDADES_POR_FILTRO = "Ocurrió un problema al consultar las toxicidades con el filtro indicado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODAS_LAS_TOXICIDADES = "Ocurrió un problema al consultar las toxicidades.";

		//AbonoSqlServerDAO
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ABONO_POR_ID = "Ocurrió un problema al consultar el abono solicitado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ABONOS_POR_FILTRO = "Ocurrió un problema al consultar los abonos con el filtro indicado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_ABONOS = "Ocurrió un problema al consultar todos los abonos.";
		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_ABONO = "Ocurrió un problema al intentar crear un abono. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_ABONO = "Ocurrió un problema al intentar actualizar un abono. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";

	}

}
