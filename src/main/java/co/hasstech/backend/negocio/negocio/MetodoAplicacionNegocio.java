package co.hasstech.backend.negocio.negocio;

import co.hasstech.backend.dominio.MetodoAplicacionDominio;
import co.hasstech.backend.dominio.ToxicidadDominio;

import java.util.List;
import java.util.UUID;

public interface MetodoAplicacionNegocio {
    List<MetodoAplicacionDominio> consultarPorFiltro(MetodoAplicacionDominio filtro);

    List<MetodoAplicacionDominio> consultarTodos();

    MetodoAplicacionDominio consultarPorID(UUID id);

}
