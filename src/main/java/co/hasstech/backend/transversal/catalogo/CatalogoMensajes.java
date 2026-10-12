package co.hasstech.backend.transversal.catalogo;

public class CatalogoMensajes {
	
	private CatalogoMensajes() {
		
	}
	
	public static class UtilSQL {

		private UtilSQL() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operación deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible iniciar la operacion deseada debido a que la conexion contra la fuente de información deseada se encuentra en un estado inconsistente porque esta cerrada o vacio o ya fue iniciada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_CONEXION_NO_ESTA_ABIERTA_SQL = "No es posible asegurar que la conexión esté abierta. Por favor intente de nuevo, si el problema persiste, contacte al administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_AL_INICIAR_LA_TRANSACCION_SQL = "Ocurrió un problema al iniciar la transacción. Por favor intente de nuevo, si el problema persiste, por favor comunicarse con el administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CONFIRMARLA_SQL = "No es posible confirmar una transacción que no ha sido iniciada. Por favor intente de nuevo. Si el problema persiste, comuniquese con el administrador de la aplicación";
		public static final String USUARIO_ERROR_NO_SE_CONFIRMO_LA_TRANSACCION_SQL = "Ocurrió un problema al intentar confirmar la transacción solicitada. Por favor intente de nuevo, si el problema persiste, por favor comunicarse con el administrador de la aplicación";
		public static final String USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CANCELARLA_SQL = "No es posible cancelar una transacción que no ha sido abierta. Por favor vuelva a intentar, si el problema persiste, comuniquese con el administrador";
		public static final String USUARIO_ERROR_NO_SE_CANCELO_LA_TRANSACCION_SQL = "Ocurrio un problema al intentar cancelar la transacción. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_TRANSACCION_NO_INICIADA_AL_INTENTAR_CERRARLA_SQL = "No es posible cerrar una transacción si no ha sido abierta";
		public static final String USUARIO_ERROR_NO_SE_CERRO_LA_TRANSACCION_SQL = "Ocurrió un problema al intentar cerrar la transacción. Por favor intente de nuevo, y si el problema persiste, cominucarlo al administrador";

	}

	public static class DAOFactory {
		private DAOFactory(){
		}

		public static final String USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILIDATA_DAOFACTORY = "La fuente de informacion deseada que se solicito para llevar a cabo la operación no esta habilitada. Por favor contacte el administrador de la aplicacion";
		public static final String USUARIO_ERROR_PROBLEMA_CONEXION_BASE_DATOS_DAOFACTORY = "Se ha presentado un problema al intentar asignar la conexión a la base de datos.";
		public static final String TECNICO_ERROR_PROBLEMA_CONEXION_BASE_DATOS_DAOFACTORY = "La conexión recibida en el método setConexion() es nula.";
		public static final String USUARIO_ERROR_PROBLEMA_INESPERADO_ESTADO_CONEXION_DAOFACTORY = "Se ha presentado un problema inesperado al validar el estado de la conexión.";
		public static final String TECNICO_ERROR_PROBLEMA_INESPERADO_ESTADO_CONEXION_DAOFACTORY = "Se lanzó una SQLException al invocar el método conexion.isClosed().";
	}

	public static class SqlServerDAOFactory {
		private SqlServerDAOFactory(){
		}
		public static final String USUARIO_ERROR_PROBLEMA_CONEXION_POOL_BASEDATOS_SQLSERVERDAOFACTORY = "Error al intentar solicitar una conexión al pool de SQL Server.";
	}


	public static class MetodoAplicacionSqlServerDAO{
		private MetodoAplicacionSqlServerDAO(){
		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODO_APLICACION_POR_ID = "Ocurrió un problema al consultar el método de aplicación solicitado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador ";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODOS_APLICACION_POR_FILTRO = "Ocurrió un problema al consultar los métodos de aplicación con el filtro indicado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_METODOS_APLICACION = "Ocurrió un problema al consultar los métodos de aplicación. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";


	}

	public static class ToxicidadSqlServerDAO {
		private ToxicidadSqlServerDAO(){
		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TOXICIDAD_POR_ID = "Ocurrió un problema al consultar la toxicidad solicitada. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TOXICIDADES_POR_FILTRO = "Ocurrió un problema al consultar las toxicidades con el filtro indicado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODAS_LAS_TOXICIDADES = "Ocurrió un problema al consultar las toxicidades.";
	}


	public static class AbonoSqlServerDAO {
		private AbonoSqlServerDAO(){
		}
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ABONO_POR_ID = "Ocurrió un problema al consultar el abono solicitado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_ABONOS_POR_FILTRO = "Ocurrió un problema al consultar los abonos con el filtro indicado. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_ABONOS = "Ocurrió un problema al consultar todos los abonos.";
		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_ABONO = "Ocurrió un problema al intentar crear un abono. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_ABONO = "Ocurrió un problema al intentar actualizar un abono. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador";

	}

	public static class ReglasImplementadasAbono {
		private ReglasImplementadasAbono(){
		}

		public static final String USUARIO_ERROR_TOXICIDAD_SELECCIONADA_NO_EXISTE_RULE = "La toxicidad seleccionada no existe en el sistema. Por favor intente de nuevo.";
		public static final String USUARIO_ERROR_IDENTIFICADOR_TOXICIDAD_NO_VACIO_RULE = "El id de la toxicidad no puede ser vacio. Por favor intente de nuevo.";
		public static final String USUARIO_ERROR_IDENTIFICADOR_TOXICIDAD_OBLIGATORIO_RULE = "El id de la toxicidad es obligatorio. Por favor intente de nuevo. Si el problema persiste, comuniquese con el administrador";
		public static final String USUARIO_ERROR_IDENTIFICADOR_METODOAPLICACION_NO_VACIO_RULE = "El id del metodo de aplicacion no puede ser vacio. Por favor intente de nuevo.";
		public static final String USUARIO_ERROR_IDENTIFICADOR_METODOAPLICACION_OBLIGATORIO_RULE = "El id del metodo de aplicacion es obligatorio. Por favor intente de nuevo. Si el problema persiste, comuniquese con el administrador";
		public static final String USUARIO_ERROR_NOMBRE_ABONO_YA_EXISTE_RULE = "El nombre del abono ingresado ya existe. Por favor intente con otro.";
		public static final String USUARIO_ERROR_NOMBRE_ABONO_OBLIGATORIO_RULE = "El nombre del abono es obligatorio. Por favor intente de nuevo.";
		public static final String USUARIO_ERROR_VALIDACION_LONGITUD_NOMBRE_ABONO_RULE = "El nombre del abono debe tener entre 1 y 40 caracteres. Por favor intente de nuevo.";
		public static final String USUARIO_ERROR_FORMATO_NOMBRE_ABONO_RULE = "El formato del nombre del abono solo soporta el alfabeto español, números enteros, punto, coma, dos puntos y comillas; no soporta caracteres especiales. Por favor intente de nuevo.";
		public static final String USUARIO_ERROR_METODOAPLICACION_NO_EXISTE_RULE = "El metodo de aplicacion seleccionado no existe en el sistema. Por favor intente con otro.";
		public static final String USUARIO_ERROR_ESTADO_ORGANICO_ABONO_OBLIGATORIO_RULE = "El estado orgánico del abono es obligatorio. Por favor intente de nuevo, si el problema persiste, comuniquese con el administrador";
		public static final String USUARIO_ERROR_OBLIGATORIEDAD_DESCRIPCION_RULE = "La descripción del abono es obligatoria. Por favor intente de nuevo, si el problema persiste, comuniquese con el administrador";
		public static final String USUARIO_ERROR_VALIDACION_LONGITUD_DESCRIPCION_ABONO_RULE = "La descripción del abono debe tener una longitud de entre 1 y 100 caracteres. Por favor intente de nuevo.";
		public static final String USUARIO_ERROR_FORMATO_DESCRIPCION_ABONO_RULE = "El formato de la descripcion del abono solo soporta el alfabeto español, números enteros, punto, coma, dos puntos y comillas; no soporta caracteres especiales. Por favor intente de nuevo.";
	}

	public static class AbonoNegocioImpl {
		private AbonoNegocioImpl(){
		}

		public static final String USUARIO_ERROR_DAOFACTORY_ABONO_NEGOCIO_IMPL = "No es posible empezar con la transacción por problemas de datos o de conexion. Por favor intente de nuevo. Si el problema persiste, comunicarse con el administrador.";
		public static final String TECNICO_ERROR_DAOFACTORY_ABONO_NEGOCIO_IMPL = "Factoría DAO nula recibida en el constructor de AbonoNegocioImpl.";
	}

	public static class AbonoFachadaImpl {
		private AbonoFachadaImpl(){
		}
		public static final String USUARIO_ERROR_PROBLEMA_AL_REGISTRAR_NUEVO_ABONO_FACHADA_IMPL = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo abono deseado. Por favor intente de nuevo, y si el problema persiste contacte al administrador de la aplicacion";
	}



}
