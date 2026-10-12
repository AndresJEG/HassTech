package co.hasstech.backend.negocio.fachada.assembler.impl;

import co.hasstech.backend.dominio.MetodoAplicacionDominio;
import co.hasstech.backend.dominio.ToxicidadDominio;
import co.hasstech.backend.dto.MetodoAplicacionDTO;
import co.hasstech.backend.dto.ToxicidadDTO;
import co.hasstech.backend.negocio.fachada.assembler.DTOAssembler;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.util.List;

public class ToxicidadDTOAssembler implements DTOAssembler<ToxicidadDominio, ToxicidadDTO> {

    private static final DTOAssembler<ToxicidadDominio, ToxicidadDTO> instancia = new ToxicidadDTOAssembler();

    private ToxicidadDTOAssembler (){
    }

    public static DTOAssembler<ToxicidadDominio, ToxicidadDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public ToxicidadDTO convertirADTO(ToxicidadDominio dominio) {
        var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new ToxicidadDominio.Builder().build());
        return new ToxicidadDTO.Builder().id(dominioTmp.getId()).nombre(dominioTmp.getNombre()).descripcion(dominioTmp.getDescripcion()).build();
    }

    @Override
    public ToxicidadDominio convertirADominio(ToxicidadDTO dto) {
        var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ToxicidadDTO.Builder().build());
        return new ToxicidadDominio.Builder().id(dtoTmp.getId()).nombre(dtoTmp.getNombre()).descripcion(dtoTmp.getDescripcion()).build();
    }

    @Override
    public List<ToxicidadDTO> convertirADTO(List<ToxicidadDominio> listaDominios) {
        return listaDominios.stream().map(this::convertirADTO).toList();
    }
}
