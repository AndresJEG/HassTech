package co.hasstech.backend.negocio.negocio;

import co.hasstech.backend.dominio.ToxicidadDominio;

import java.util.List;
import java.util.UUID;

public interface ToxicidadNegocio {
    List<ToxicidadDominio> consultarPorFiltro(ToxicidadDominio filtro);

    List<ToxicidadDominio> consultarTodos();

    ToxicidadDominio consultarPorID(UUID id);
}
