package co.hasstech.backend.dao.factoria;

import java.sql.Connection;
import java.sql.SQLException;

import co.hasstech.backend.dao.datos.entidad.MetodoAplicacionDAO;
import co.hasstech.backend.dao.datos.entidad.ToxicidadDAO;
import co.hasstech.backend.dao.datos.entidad.AbonoDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.MetodoAplicacionSqlServerDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.ToxicidadSqlServerDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.AbonoSqlServerDAO;
import co.hasstech.backend.transversal.excepciones.HassTechDatosExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

    private Connection conexion;

    protected DAOFactory() {
        abrirConexion();
    }

    protected Connection getConexion() {
        return conexion;
    }

    protected void setConexion(Connection conexion) {
        if (conexion == null) {
            throw HassTechDatosExcepcion.crear(
                    "Se ha presentado un problema al intentar asignar la conexión a la base de datos.",
                    "La conexión recibida en el método setConexion() es nula."
            );
        }

        try {
            if (conexion.isClosed()) {
                throw HassTechDatosExcepcion.crear(
                        "Se ha presentado un problema al intentar asignar la conexión a la base de datos.",
                        "La conexión recibida en el método setConexion() se encuentra cerrada."
                );
            }
            this.conexion = conexion;
        } catch (SQLException e) {
            throw HassTechDatosExcepcion.crear(
                    "Se ha presentado un problema inesperado al validar el estado de la conexión.",
                    "Se lanzó una SQLException al invocar el método conexion.isClosed().",
                    e
            );
        }
    }

    protected abstract void abrirConexion();

    public void cerrarConexion() {
        UtilSQL.cerrarConexion(conexion);
    }

    public void iniciarTransacción() {
        UtilSQL.iniciarTransaccion(conexion);
    }

    public void confirmarTransacción() {
        UtilSQL.confirmarTransaccion(conexion);
    }

    public void cancelarTransacción() {
        UtilSQL.cancelarTransaccion(conexion);
    }

    public MetodoAplicacionDAO obtenerMetodoAplicacionDAO() {
        return new MetodoAplicacionSqlServerDAO(getConexion());
    };

    public ToxicidadDAO obtenerToxicidadDAO() {
        return new ToxicidadSqlServerDAO(getConexion());
    };

    public AbonoDAO obtenerAbonoDAO() {
        return new AbonoSqlServerDAO(getConexion());
    };

}