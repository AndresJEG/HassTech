package co.hasstech.backend;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dao.factoria.impl.SqlServerDAOFactory;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.dominio.MetodoAplicacionDominio;
import co.hasstech.backend.dominio.ToxicidadDominio;
import co.hasstech.backend.negocio.AbonoNegocio;
import co.hasstech.backend.negocio.negocio.impl.AbonoNegocioImpl;
import co.hasstech.backend.transversal.excepciones.HassTechExcepcion;

public class PruebaRegistroAbono {

    private static final Logger LOGGER = LoggerFactory.getLogger(PruebaRegistroAbono.class);

    public static void main(String[] args) {
        LOGGER.info("=== Iniciando prueba de conexión, lógica de negocio y registro ===");

        try {
            DAOFactory daoFactory = new SqlServerDAOFactory();
            AbonoNegocio abonoNegocio = new AbonoNegocioImpl(daoFactory);

            UUID idToxicidadExistente = UUID.fromString("FD9B7DE5-58CE-4057-80D0-484E848BDE3A");
            UUID idMetodoExistente = UUID.fromString("05953B3F-581D-461E-BF6F-D99E1104780F");

            var nuevoAbono = new AbonoDominio.Builder()
                    .nombre("HumusLombriz")
                    .esOrganico(true)
                    .descripcion("Composta de lombriz roja, excelente para el suelo")
                    .toxicidad(new ToxicidadDominio.Builder().id(idToxicidadExistente).build())
                    .metodoAplicacion(new MetodoAplicacionDominio.Builder().id(idMetodoExistente).build())
                    .build();

            LOGGER.info("Intentando registrar el abono '{}'...", nuevoAbono.getNombre());
            abonoNegocio.registrarInformacionNuevoAbono(nuevoAbono);
            LOGGER.info("✅ ¡Abono registrado exitosamente en la base de datos!");

            var abonos = abonoNegocio.consultarTodos();
            LOGGER.info("Total de abonos encontrados en la BD: {}", abonos.size());

            abonos.forEach(abono ->
                    LOGGER.info("-> ID: {} | Nombre: {} | Es Orgánico: {}", abono.getId(), abono.getNombre(), abono.getEsOrganico())
            );

        } catch (HassTechExcepcion excepcion) {
            LOGGER.error("Excepción controlada de la arquitectura/negocio:");
            LOGGER.error("Mensaje Usuario : {}", excepcion.getMensajeUsuario());
            LOGGER.error("Mensaje Técnico : {}", excepcion.getMensajeTecnico(), excepcion);
        } catch (Exception e) {
            LOGGER.error("Error inesperado durante la ejecución:", e);
        }
    }
}