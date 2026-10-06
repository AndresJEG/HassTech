package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.entidad.AbonoEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;

import java.util.UUID;

public interface AbonoDAO extends
        ConsultarDAO<AbonoEntidad, UUID>,
        CrearDAO<AbonoEntidad>,
        ActualizarDAO<AbonoEntidad, UUID> {
}
