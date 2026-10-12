package co.hasstech.backend.negocio.negocio.assembler.impl;

import co.hasstech.backend.entidad.AbonoEntidad;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.negocio.negocio.assembler.EntidadAssembler;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.util.List;

public class AbonoEntidadAssembler implements EntidadAssembler <AbonoDominio, AbonoEntidad> {

    private static final AbonoEntidadAssembler instancia = new AbonoEntidadAssembler();

    private AbonoEntidadAssembler(){
    }

    public static AbonoEntidadAssembler obtenerInstancia() {
        return instancia;
    }

    @Override
    public AbonoEntidad convertirAEntidad(AbonoDominio dominio) {
        var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new AbonoDominio.Builder()
                .build());
        return new AbonoEntidad.Builder().id(dominioTmp.getId()).nombre(dominioTmp.getNombre()).descripcion(dominioTmp.getDescripcion())
                .esOrganico(dominioTmp.getEsOrganico()).metodoAplicacion(new MetodoAplicacionEntidadAssembler()
                        .convertirAEntidad(dominioTmp.getMetodoAplicacion()))
                .toxicidad(new ToxicidadEntidadAssembler().convertirAEntidad(dominioTmp.getToxicidad())).build();
    }

    @Override
    public AbonoDominio convertirADominio(AbonoEntidad entidad) {
        var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new AbonoEntidad.Builder().build());
        return new AbonoDominio.Builder().id(entidadTmp.getId()).nombre(entidadTmp.getNombre()).descripcion(entidadTmp.getDescripcion())
                .esOrganico(entidadTmp.getEsOrganico()).metodoAplicacion(new MetodoAplicacionEntidadAssembler()
                        .convertirADominio(entidadTmp.getMetodoAplicacion()))
                .toxicidad(new ToxicidadEntidadAssembler().convertirADominio(entidadTmp.getToxicidad())).build();
    }

    @Override
    public List<AbonoDominio> convertirADominio(List<AbonoEntidad> listaEntidades) {
        return listaEntidades.stream().map(this::convertirADominio).toList();
    }
}
