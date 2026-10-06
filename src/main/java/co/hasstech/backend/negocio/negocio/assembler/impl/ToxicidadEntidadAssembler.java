package co.hasstech.backend.negocio.negocio.assembler.impl;

import co.hasstech.backend.entidad.ToxicidadEntidad;
import co.hasstech.backend.dominio.ToxicidadDominio;
import co.hasstech.backend.negocio.negocio.assembler.EntidadAssembler;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class ToxicidadEntidadAssembler implements EntidadAssembler <ToxicidadDominio, ToxicidadEntidad> {
    @Override
    public ToxicidadEntidad convertirAEntidad(ToxicidadDominio dominio) {
        var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new ToxicidadDominio.Builder().build());
        return new ToxicidadEntidad.Builder().id(dominioTmp.getId()).nombre(dominioTmp.getNombre()).descripcion(dominioTmp.getDescripcion()).build();
    }

    @Override
    public ToxicidadDominio convertirADominio(ToxicidadEntidad entidad) {
        var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ToxicidadEntidad.Builder().build());
        return new ToxicidadDominio.Builder().id(entidadTmp.getId()).nombre(entidadTmp.getNombre()).descripcion(entidadTmp.getDescripcion()).build();
    }
}
