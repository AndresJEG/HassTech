package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.Entidad.SintomaPlagaEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;

import java.util.UUID;

public interface SintomaPlagaDAO extends
        ConsultarDAO<SintomaPlagaEntidad, UUID>,
        CrearDAO<SintomaPlagaEntidad>,
        ActualizarDAO<SintomaPlagaEntidad, UUID> {
}