package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.entidad.RegistroCosechaEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;
import co.hasstech.backend.dao.datos.EliminarDAO;

import java.util.UUID;

public interface RegistroCosechaDAO extends
        ConsultarDAO<RegistroCosechaEntidad, UUID>,
        CrearDAO<RegistroCosechaEntidad>,
        ActualizarDAO<RegistroCosechaEntidad, UUID>,
        EliminarDAO<RegistroCosechaEntidad> {
}
