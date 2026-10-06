package co.hasstech.backend.negocio;

import java.util.List;
import java.util.UUID;

import co.hasstech.backend.dominio.AbonoDominio;

public interface AbonoNegocio {

    void registrarInformacionNuevoAbono(AbonoDominio datos);

    void modificarInformacionAbonoExistente(UUID id, AbonoDominio datos);

    void darBajaInformacionAbonoExistente(UUID id);

    List<AbonoDominio> consultarPorFiltro(AbonoDominio filtro);

    List<AbonoDominio> consultarTodos();

    AbonoDominio consultarPorID(UUID id);

}