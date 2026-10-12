package co.hasstech.backend.negocio.fachada;

import co.hasstech.backend.dto.AbonoDTO;

import java.util.List;
import java.util.UUID;

public interface AbonoFachada {

    void registrarInformacionNuevoAbono(AbonoDTO datos);

    void modificarInformacionAbonoExistente(UUID id, AbonoDTO datos);

    List<AbonoDTO> consultarPorFiltro(AbonoDTO filtro);

    List<AbonoDTO> consultarTodos();

    AbonoDTO consultarPorID(UUID id);
}
