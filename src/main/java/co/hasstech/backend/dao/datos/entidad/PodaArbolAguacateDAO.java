package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.entidad.PodaArbolAguacateEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;
import co.hasstech.backend.dao.datos.EliminarDAO;

import java.util.UUID;

public interface PodaArbolAguacateDAO extends
        ConsultarDAO<PodaArbolAguacateEntidad, UUID>,
        CrearDAO<PodaArbolAguacateEntidad>,
        ActualizarDAO<PodaArbolAguacateEntidad, UUID>,
        EliminarDAO<PodaArbolAguacateEntidad> {
}
