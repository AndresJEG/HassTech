package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.Entidad.ArbolAguacateEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;

import java.util.UUID;

public interface ArbolAguacateDAO extends
        ConsultarDAO<ArbolAguacateEntidad, UUID>,
        CrearDAO<ArbolAguacateEntidad>,
        ActualizarDAO<ArbolAguacateEntidad, UUID> {
}