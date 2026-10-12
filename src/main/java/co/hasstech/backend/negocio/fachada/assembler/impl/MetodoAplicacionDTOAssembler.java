package co.hasstech.backend.negocio.fachada.assembler.impl;

import co.hasstech.backend.dominio.MetodoAplicacionDominio;
import co.hasstech.backend.dto.MetodoAplicacionDTO;
import co.hasstech.backend.entidad.MetodoAplicacionEntidad;
import co.hasstech.backend.negocio.fachada.assembler.DTOAssembler;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.util.List;

public class MetodoAplicacionDTOAssembler implements DTOAssembler<MetodoAplicacionDominio, MetodoAplicacionDTO> {

    private static final DTOAssembler<MetodoAplicacionDominio, MetodoAplicacionDTO> instancia = new MetodoAplicacionDTOAssembler();

    private MetodoAplicacionDTOAssembler(){
    }

    public static DTOAssembler<MetodoAplicacionDominio, MetodoAplicacionDTO> obtenerInstancia (){
        return instancia;
    }


    @Override
    public MetodoAplicacionDTO convertirADTO(MetodoAplicacionDominio dominio) {
        var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new MetodoAplicacionDominio.Builder().build());
        return new MetodoAplicacionDTO.Builder().id(dominioTmp.getId()).nombre(dominioTmp.getNombre()).descripcion(dominioTmp.getDescripcion()).build();
    }

    @Override
    public MetodoAplicacionDominio convertirADominio(MetodoAplicacionDTO dto) {
        var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new MetodoAplicacionDTO.Builder().build());
        return new MetodoAplicacionDominio.Builder().id(dtoTmp.getId()).nombre(dtoTmp.getNombre()).descripcion(dtoTmp.getDescripcion()).build();
    }

    @Override
    public List<MetodoAplicacionDTO> convertirADTO(List<MetodoAplicacionDominio> listaDominios) {
        return listaDominios.stream().map(this::convertirADTO).toList();
    }
}
