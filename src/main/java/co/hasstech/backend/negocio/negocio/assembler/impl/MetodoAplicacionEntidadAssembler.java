package co.hasstech.backend.negocio.negocio.assembler.impl;

import co.hasstech.backend.entidad.MetodoAplicacionEntidad;
import co.hasstech.backend.dominio.MetodoAplicacionDominio;
import co.hasstech.backend.negocio.negocio.assembler.EntidadAssembler;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class MetodoAplicacionEntidadAssembler implements EntidadAssembler <MetodoAplicacionDominio, MetodoAplicacionEntidad> {
    @Override
    public MetodoAplicacionEntidad convertirAEntidad(MetodoAplicacionDominio dominio) {
        var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new MetodoAplicacionDominio.Builder().build());
        return new MetodoAplicacionEntidad.Builder().id(dominioTmp.getId()).nombre(dominioTmp.getNombre()).descripcion(dominioTmp.getDescripcion()).build();
    }

    @Override
    public MetodoAplicacionDominio convertirADominio(MetodoAplicacionEntidad entidad) {
        var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new MetodoAplicacionEntidad.Builder().build());
        return new MetodoAplicacionDominio.Builder().id(entidadTmp.getId()).nombre(entidadTmp.getNombre()).descripcion(entidadTmp.getDescripcion()).build();
    }
}
