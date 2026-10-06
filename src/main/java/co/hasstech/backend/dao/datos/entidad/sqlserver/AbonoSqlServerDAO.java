package co.hasstech.backend.dao.datos.entidad.sqlserver;

import co.hasstech.backend.Entidad.AbonoEntidad;
import co.hasstech.backend.Entidad.MetodoAplicacionEntidad;
import co.hasstech.backend.Entidad.ToxicidadEntidad;
import co.hasstech.backend.dao.datos.entidad.AbonoDAO;
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

public class AbonoSqlServerDAO extends SqlDAO implements AbonoDAO {

    // AJUSTA tabla/columnas si en tu base de datos son distintas.
    private static final String TABLA = "Abono";

    // Un solo SELECT con JOIN a Toxicidad y MetodoAplicacion (opción "b"):
    // se alían las columnas repetidas (id, nombre, descripcion aparecen en
    // las 3 tablas) para no tener ambigüedad al leer el ResultSet por nombre.
    private static final String SELECT_BASE =
            "SELECT " +
                    "  a.id AS abono_id, a.nombre AS abono_nombre, a.esOrganico AS abono_es_organico, " +
                    "  a.descripcion AS abono_descripcion, " +
                    "  t.id AS toxicidad_id, t.nombre AS toxicidad_nombre, t.descripcion AS toxicidad_descripcion, " +
                    "  m.id AS metodo_id, m.nombre AS metodo_nombre, m.descripcion AS metodo_descripcion " +
                    "FROM " + TABLA + " a " +
                    "INNER JOIN Toxicidad t ON a.toxicidadId = t.id " +
                    "INNER JOIN MetodoAplicacion m ON a.metodoAplicacionId = m.id";

    public AbonoSqlServerDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public AbonoEntidad consultarPorId(final UUID uuid) {
        final String sql = SELECT_BASE + " WHERE a.id = ?";

        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setObject(1, uuid);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapearEntidad(resultado);
                }
            }
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ABONO_POR_ID;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }

        // Patrón antinulos: si no se encontró nada, se retorna el objeto
        // "vacío" del Builder (con toxicidad y metodoAplicacion también
        // vacíos, por los UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
        // que ya tiene el Builder de AbonoEntidad) en lugar de null.
        return new AbonoEntidad.Builder().build();
    }

    @Override
    public List<AbonoEntidad> consultarPorFiltro(final AbonoEntidad filtro) {
        final StringBuilder sql = new StringBuilder(SELECT_BASE + " WHERE 1 = 1");
        final List<Object> parametros = new ArrayList<>();

        if (filtro.getId() != null && !filtro.getId().equals(UtilUUID.VALOR_DEFECTO)) {
            sql.append(" AND a.id = ?");
            parametros.add(filtro.getId());
        }
        if (filtro.getNombre() != null && !filtro.getNombre().isBlank()) {
            sql.append(" AND a.nombre LIKE ?");
            parametros.add("%" + filtro.getNombre() + "%");
        }
        if (filtro.getDescripcion() != null && !filtro.getDescripcion().isBlank()) {
            sql.append(" AND a.descripcion LIKE ?");
            parametros.add("%" + filtro.getDescripcion() + "%");
        }

        if (filtro.getToxicidad() != null && filtro.getToxicidad().getId() != null
                && !filtro.getToxicidad().getId().equals(UtilUUID.VALOR_DEFECTO)) {
            sql.append(" AND t.id = ?");
            parametros.add(filtro.getToxicidad().getId());
        }
        if (filtro.getMetodoAplicacion() != null && filtro.getMetodoAplicacion().getId() != null
                && !filtro.getMetodoAplicacion().getId().equals(UtilUUID.VALOR_DEFECTO)) {
            sql.append(" AND m.id = ?");
            parametros.add(filtro.getMetodoAplicacion().getId());
        }

        final List<AbonoEntidad> resultados = new ArrayList<>();

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
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ABONOS_POR_FILTRO;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }

        return resultados;
    }

    @Override
    public List<AbonoEntidad> consultarTodos() {
        final List<AbonoEntidad> resultados = new ArrayList<>();

        try (PreparedStatement sentencia = getConnection().prepareStatement(SELECT_BASE);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                resultados.add(mapearEntidad(resultado));
            }
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_ABONOS;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }

        return resultados;
    }

    @Override
    public void crear(final AbonoEntidad entidad) {

        final String sql = "INSERT INTO " + TABLA +
                " (id, nombre, esOrganico, descripcion, toxicidadId, metodoAplicacionId) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setObject(1, entidad.getId());
            sentencia.setString(2, entidad.getNombre());
            sentencia.setBoolean(3, entidad.getEsOrganico());
            sentencia.setString(4, entidad.getDescripcion());
            sentencia.setObject(5, entidad.getToxicidad().getId());
            sentencia.setObject(6, entidad.getMetodoAplicacion().getId());

            sentencia.executeUpdate();
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CREANDO_ABONO;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }
    }

    @Override
    public void actualizar(final UUID id, final AbonoEntidad entidad) {
        final String sql = "UPDATE " + TABLA +
                " SET nombre = ?, esOrganico = ?, descripcion = ?, toxicidadId = ?, metodoAplicacionId = ? " +
                "WHERE id = ?";

        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, entidad.getNombre());
            sentencia.setBoolean(2, entidad.getEsOrganico());
            sentencia.setString(3, entidad.getDescripcion());
            sentencia.setObject(4, entidad.getToxicidad().getId());
            sentencia.setObject(5, entidad.getMetodoAplicacion().getId());
            sentencia.setObject(6, id);

            sentencia.executeUpdate();
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_ABONO;
            throw HassTechDatosExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }
    }

    private AbonoEntidad mapearEntidad(final ResultSet resultado) throws SQLException {
        final ToxicidadEntidad toxicidad = new ToxicidadEntidad.Builder()
                .id(UUID.fromString(resultado.getString("toxicidad_id")))
                .nombre(resultado.getString("toxicidad_nombre"))
                .descripcion(resultado.getString("toxicidad_descripcion"))
                .build();

        final MetodoAplicacionEntidad metodoAplicacion = new MetodoAplicacionEntidad.Builder()
                .id(UUID.fromString(resultado.getString("metodo_id")))
                .nombre(resultado.getString("metodo_nombre"))
                .descripcion(resultado.getString("metodo_descripcion"))
                .build();

        return new AbonoEntidad.Builder()
                .id(UUID.fromString(resultado.getString("abono_id")))
                .nombre(resultado.getString("abono_nombre"))
                .esOrganico(resultado.getBoolean("abono_es_organico"))
                .descripcion(resultado.getString("abono_descripcion"))
                .toxicidad(toxicidad)
                .metodoAplicacion(metodoAplicacion)
                .build();
    }
}