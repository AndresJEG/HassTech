package co.hasstech.backend.negocio.fachada.assembler.impl;

import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.dto.AbonoDTO;
import co.hasstech.backend.negocio.fachada.assembler.DTOAssembler;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.util.List;

public class AbonoDTOAssembler implements DTOAssembler <AbonoDominio, AbonoDTO> {

    private static final DTOAssembler<AbonoDominio, AbonoDTO> instancia = new AbonoDTOAssembler();

    private AbonoDTOAssembler() {
    }

    public static DTOAssembler<AbonoDominio, AbonoDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public List<AbonoDTO> convertirADTO(List<AbonoDominio> listaDominios) {
        return listaDominios.stream().map(this::convertirADTO).toList();
    }

    @Override
    public AbonoDTO convertirADTO(AbonoDominio dominio) {
        var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new AbonoDominio.Builder().build());
        return new AbonoDTO.Builder().id(dominioTmp.getId()).nombre(dominioTmp.getNombre()).descripcion(dominioTmp.getDescripcion())
                .esOrganico(dominioTmp.getEsOrganico()).metodoAplicacion(MetodoAplicacionDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getMetodoAplicacion()))
                .toxicidad(ToxicidadDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getToxicidad())).build();
    }

    @Override
    public AbonoDominio convertirADominio(AbonoDTO DTO) {

        var DTOTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(DTO, new AbonoDTO.Builder().build());
        return new AbonoDominio.Builder()
                .id(DTOTmp.getId())
                .nombre(DTOTmp.getNombre())
                .descripcion(DTOTmp.getDescripcion())
                .esOrganico(DTOTmp.getEsOrganico())
                .metodoAplicacion(MetodoAplicacionDTOAssembler.obtenerInstancia().convertirADominio(DTOTmp.getMetodoAplicacion()))
                .toxicidad(ToxicidadDTOAssembler.obtenerInstancia().convertirADominio(DTOTmp.getToxicidad())).build();
    }
}
