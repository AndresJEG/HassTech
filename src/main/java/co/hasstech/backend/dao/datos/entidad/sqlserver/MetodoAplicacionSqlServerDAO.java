package co.hasstech.backend.dao.datos.entidad.sqlserver;

import co.hasstech.backend.Entidad.MetodoAplicacionEntidad;
import co.hasstech.backend.dao.datos.entidad.MetodoAplicacionDAO;
import co.hasstech.backend.dao.datos.entidad.SqlDAO;
import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechDatosExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MetodoAplicacionSqlServerDAO extends SqlDAO implements MetodoAplicacionDAO {

    private static final String TABLA = "MetodoAplicacion";
    private static final String SELECT_BASE = "SELECT id, nombre, descripcion FROM " + TABLA;

    public MetodoAplicacionSqlServerDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public MetodoAplicacionEntidad consultarPorId(final UUID uuid) {
        final String sql = SELECT_BASE + " WHERE id = ?";

        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setObject(1, uuid);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapearEntidad(resultado);
                }
            }
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODO_APLICACION_POR_ID;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }
        return new MetodoAplicacionEntidad.Builder().build();
    }

    @Override
    public List<MetodoAplicacionEntidad> consultarPorFiltro(final MetodoAplicacionEntidad filtro) {
        final StringBuilder sql = new StringBuilder(SELECT_BASE + " WHERE 1 = 1");
        final List<Object> parametros = new ArrayList<>();

        if (filtro.getId() != null && !filtro.getId().equals(UtilUUID.VALOR_DEFECTO)) {
            sql.append(" AND id = ?");
            parametros.add(filtro.getId());
        }
        if (filtro.getNombre() != null && !filtro.getNombre().isBlank()) {
            sql.append(" AND nombre LIKE ?");
            parametros.add("%" + filtro.getNombre() + "%");
        }
        if (filtro.getDescripcion() != null && !filtro.getDescripcion().isBlank()) {
            sql.append(" AND descripcion LIKE ?");
            parametros.add("%" + filtro.getDescripcion() + "%");
        }

        final List<MetodoAplicacionEntidad> resultados = new ArrayList<>();

        try (PreparedStatement sentencia = getConnection().prepareStatement(sql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentencia.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    resultados.add(mapearEntidad(resultado));
                }
            }
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODOS_APLICACION_POR_FILTRO;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }

        return resultados;
    }

    @Override
    public List<MetodoAplicacionEntidad> consultarTodos() {
        final List<MetodoAplicacionEntidad> resultados = new ArrayList<>();

        try (PreparedStatement sentencia = getConnection().prepareStatement(SELECT_BASE);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                resultados.add(mapearEntidad(resultado));
            }
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_METODOS_APLICACION;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }

        return resultados;
    }

    private MetodoAplicacionEntidad mapearEntidad(final ResultSet resultado) throws SQLException {
        return new MetodoAplicacionEntidad.Builder()
                .id(UUID.fromString(resultado.getString("id")))
                .nombre(resultado.getString("nombre"))
                .descripcion(resultado.getString("descripcion"))
                .build();
    }
}