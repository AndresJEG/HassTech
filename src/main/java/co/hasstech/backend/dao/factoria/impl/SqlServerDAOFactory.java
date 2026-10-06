package co.hasstech.backend.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import co.hasstech.backend.dao.datos.entidad.MetodoAplicacionDAO;
import co.hasstech.backend.dao.datos.entidad.ToxicidadDAO;
import co.hasstech.backend.dao.datos.entidad.AbonoDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.MetodoAplicacionSqlServerDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.ToxicidadSqlServerDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.AbonoSqlServerDAO;
import co.hasstech.backend.dao.factoria.DAOFactory;

@Component
public class SqlServerDAOFactory extends DAOFactory {

    @Override
    protected void abrirConexion() {
        try {
            String cadenaConexion = "jdbc:sqlserver://localhost:1433;databaseName=hasstech_data_base;encrypt=true;trustServerCertificate=true;";
            String usuario = "sa";
            String clave = "TuNuevaContrasenaSegura123!";

            Connection conexionSqlServer = DriverManager.getConnection(cadenaConexion, usuario, clave);

            setConexion(conexionSqlServer);

        } catch (SQLException e) {
            throw new RuntimeException("Error al intentar abrir la conexión con la base de datos SQL Server.", e);
        }
    }

    @Override
    public MetodoAplicacionDAO obtenerMetodoAplicacionDAO() {
        return new MetodoAplicacionSqlServerDAO(getConexion());
    }

    @Override
    public ToxicidadDAO obtenerToxicidadDAO() {
        return new ToxicidadSqlServerDAO(getConexion());
    }

    @Override
    public AbonoDAO obtenerAbonoDAO() {
        return new AbonoSqlServerDAO(getConexion());
    }
}