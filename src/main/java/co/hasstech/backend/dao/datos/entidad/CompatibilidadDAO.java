package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.Entidad.CompatibilidadEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;
import co.hasstech.backend.dao.datos.EliminarDAO;

import java.util.UUID;

public interface CompatibilidadDAO extends ConsultarDAO<CompatibilidadEntidad, UUID>, CrearDAO<CompatibilidadDAO>,
        ActualizarDAO<CompatibilidadEntidad, UUID>, EliminarDAO<UUID> {

}
