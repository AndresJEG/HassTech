package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.Entidad.SintomaEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;

import java.util.UUID;

public interface SintomaDAO extends
        ConsultarDAO<SintomaEntidad, UUID>,
        ActualizarDAO<SintomaEntidad, UUID> {
}