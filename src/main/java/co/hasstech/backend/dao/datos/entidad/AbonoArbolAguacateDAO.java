package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.Entidad.AbonoArbolAguacateEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;
import co.hasstech.backend.dao.datos.EliminarDAO;

import java.util.UUID;

public interface AbonoArbolAguacateDAO extends
        ConsultarDAO<AbonoArbolAguacateEntidad, UUID>,
        CrearDAO<AbonoArbolAguacateEntidad>,
        ActualizarDAO<AbonoArbolAguacateEntidad, UUID>,
        EliminarDAO<AbonoArbolAguacateEntidad> {
}
