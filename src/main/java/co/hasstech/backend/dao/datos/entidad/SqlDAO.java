package co.hasstech.backend.dao.datos.entidad;

import java.sql.Connection;

import co.hasstech.backend.transversal.utilitarios.UtilSQL;

public abstract class SqlDAO {

    private Connection conexion;

    protected SqlDAO(Connection conexion) {
        setConexion(conexion);
    }

    private void setConexion(Connection conexion) {

        UtilSQL.asegurarConexionAbierta(conexion);
        this.conexion = conexion;
    }

    protected Connection getConnection() {
        return conexion;
    }
}
