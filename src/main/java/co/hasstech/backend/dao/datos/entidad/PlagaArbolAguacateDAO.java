package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.entidad.PlagaArbolAguacateEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;
import co.hasstech.backend.dao.datos.EliminarDAO;

import java.util.UUID;

public interface PlagaArbolAguacateDAO extends
        ConsultarDAO<PlagaArbolAguacateEntidad, UUID>,
        CrearDAO<PlagaArbolAguacateEntidad>,
        ActualizarDAO<PlagaArbolAguacateEntidad, UUID>,
        EliminarDAO<PlagaArbolAguacateEntidad> {
}
