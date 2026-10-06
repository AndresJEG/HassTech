package co.hasstech.backend.dao.datos.entidad;

import co.hasstech.backend.entidad.ProductoFitosanitarioEntidad;
import co.hasstech.backend.dao.datos.ActualizarDAO;
import co.hasstech.backend.dao.datos.ConsultarDAO;
import co.hasstech.backend.dao.datos.CrearDAO;
import co.hasstech.backend.dao.datos.EliminarDAO;

import java.util.UUID;

public interface ProductoFitosanitarioDAO extends
        ConsultarDAO<ProductoFitosanitarioEntidad, UUID>,
        CrearDAO<ProductoFitosanitarioEntidad>,
        ActualizarDAO<ProductoFitosanitarioEntidad, UUID>,
        EliminarDAO<ProductoFitosanitarioEntidad> {
}
