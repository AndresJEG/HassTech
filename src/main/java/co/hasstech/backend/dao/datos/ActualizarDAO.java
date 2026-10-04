package co.hasstech.backend.dao.datos;

public interface ActualizarDAO <E, ID>{
	void actualizar (ID id, E entidad);
}
