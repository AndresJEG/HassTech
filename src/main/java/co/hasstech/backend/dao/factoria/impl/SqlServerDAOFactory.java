package co.hasstech.backend.dao.factoria.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import co.hasstech.backend.dao.datos.entidad.AbonoDAO;
import co.hasstech.backend.dao.datos.entidad.MetodoAplicacionDAO;
import co.hasstech.backend.dao.datos.entidad.ToxicidadDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.AbonoSqlServerDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.MetodoAplicacionSqlServerDAO;
import co.hasstech.backend.dao.datos.entidad.sqlserver.ToxicidadSqlServerDAO;
import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.transversal.excepciones.HassTechDatosExcepcion;


public class SqlServerDAOFactory extends DAOFactory {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=hasstech_data_base;encrypt=true;trustServerCertificate=true;");
        config.setUsername("sa");
        config.setPassword("TuNuevaContrasenaSegura123!");
        config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(300000);

        dataSource = new HikariDataSource(config);
    }

    @Override
    protected void abrirConexion() {
        try {
            Connection conexionSqlServer = dataSource.getConnection();
            setConexion(conexionSqlServer);
        } catch (SQLException e) {
            throw HassTechDatosExcepcion.crear(
                    "Error al intentar solicitar una conexión al pool de SQL Server.",
                    e.getMessage(),
                    e
            );
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