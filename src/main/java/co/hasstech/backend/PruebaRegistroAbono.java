package co.hasstech.backend;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.hasstech.backend.dto.AbonoDTO;
import co.hasstech.backend.dto.ToxicidadDTO;
import co.hasstech.backend.dto.MetodoAplicacionDTO;
import co.hasstech.backend.negocio.fachada.AbonoFachada;
import co.hasstech.backend.negocio.fachada.impl.AbonoFachadaImpl;
import co.hasstech.backend.transversal.excepciones.HassTechExcepcion;

public class PruebaRegistroAbono {

    private static final Logger LOGGER = LoggerFactory.getLogger(PruebaRegistroAbono.class);

    public static void main(String[] args) {
        LOGGER.info("Iniciando prueba de registro de abono desde la fachada");

        try {
            AbonoFachada abonoFachada = new AbonoFachadaImpl();

            //se inyectaron los id de toxicidad y metodo aplicacion para la prueba. Son sacadas de la misma base de datos.
            UUID idToxicidadExistente = UUID.fromString("FD9B7DE5-58CE-4057-80D0-484E848BDE3A");
            UUID idMetodoExistente = UUID.fromString("05953B3F-581D-461E-BF6F-D99E1104780F");

            var abonoDto = new AbonoDTO.Builder()
                    .nombre("Emulsion")
                    .descripcion("Nutriente semiácido")
                    .esOrganico(false)
                    .toxicidad(new ToxicidadDTO.Builder().id(idToxicidadExistente).build())
                    .metodoAplicacion(new MetodoAplicacionDTO.Builder().id(idMetodoExistente).build())
                    .build();

            System.out.println("DEBUG DESCRIPCION DTO: [" + abonoDto.getDescripcion() + "]");

            abonoFachada.registrarInformacionNuevoAbono(abonoDto);

            LOGGER.info("Intentando registrar el abono '{}' a través de la fachada...", abonoDto.getNombre());

            LOGGER.info("Abono registrado exitosamente y transacción confirmada por la fachada");

        } catch (HassTechExcepcion excepcion) {
            LOGGER.error("Excepción controlada de la arquitectura / negocio:");
            LOGGER.error("Mensaje Usuario : {}", excepcion.getMensajeUsuario());
            LOGGER.error("Mensaje Técnico : {}", excepcion.getMensajeTecnico(), excepcion);
        } catch (Exception e) {
            if (e.getClass().getName().contains("SilentExitException")) {
                return;
            }
            LOGGER.error(" Error inesperado durante la ejecución en la fachada:", e);
        }
    }
}