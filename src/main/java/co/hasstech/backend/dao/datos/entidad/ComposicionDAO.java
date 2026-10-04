package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.Entidad.ComposicionEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;
import co.hasstech.backend.dao.datos.EliminarDAO;

import java.util.UUID;

public interface ComposicionDAO extends
        ConsultarDAO<ComposicionEntidad, UUID>,
        CrearDAO<ComposicionEntidad>,
        ActualizarDAO<ComposicionEntidad, UUID>,
        EliminarDAO<ComposicionEntidad> {
}