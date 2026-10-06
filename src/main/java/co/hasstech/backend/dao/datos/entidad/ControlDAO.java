package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.entidad.ControlEntidad;
import co.hasstech.backend.dao.datos.*;

import java.util.UUID;

public interface ControlDAO extends ActualizarDAO<ControlEntidad, UUID>, ConsultarDAO<ControlEntidad, UUID>,
        CrearDAO<ControlEntidad>, EliminarDAO<UUID>, VerificarDAO<ControlEntidad> {
}
