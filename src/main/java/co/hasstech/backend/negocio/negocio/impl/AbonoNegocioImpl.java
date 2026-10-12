package co.hasstech.backend.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.negocio.negocio.AbonoNegocio;
import co.hasstech.backend.negocio.negocio.assembler.impl.AbonoEntidadAssembler;
import co.hasstech.backend.negocio.negocio.reglas.impl.abono.ValidarReglasRegistrarInformacionNuevoAbonoRule;
import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechExcepcion;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class AbonoNegocioImpl implements AbonoNegocio {

    private final DAOFactory daoFactory;

    public AbonoNegocioImpl(DAOFactory daoFactory) {
        if (UtilObjeto.esNulo(daoFactory)) {
            throw HassTechNegocioExcepcion.crear(
                    CatalogoMensajes.AbonoNegocioImpl.USUARIO_ERROR_DAOFACTORY_ABONO_NEGOCIO_IMPL,
                    CatalogoMensajes.AbonoNegocioImpl.TECNICO_ERROR_DAOFACTORY_ABONO_NEGOCIO_IMPL
            );
        }
        this.daoFactory = daoFactory;
    }

    @Override
    public void registrarInformacionNuevoAbono(AbonoDominio datos) {
        ValidarReglasRegistrarInformacionNuevoAbonoRule.obtenerInstancia().ejecutar(datos, daoFactory);
        UUID nuevoId = generarIdAbonoUnico();

        var dominioConId = new AbonoDominio.Builder()
                .id(nuevoId)
                .nombre(datos.getNombre())
                .descripcion(datos.getDescripcion())
                .esOrganico(datos.getEsOrganico())
                .metodoAplicacion(datos.getMetodoAplicacion())
                .toxicidad(datos.getToxicidad())
                .build();

        var abonoEntidad = AbonoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioConId);

        daoFactory.obtenerAbonoDAO().crear(abonoEntidad);

    }

    @Override
    public void modificarInformacionAbonoExistente(UUID id, AbonoDominio datos) {

    }

    @Override
    public List<AbonoDominio> consultarPorFiltro(AbonoDominio filtro) {
        return List.of();
    }

    @Override
    public List<AbonoDominio> consultarTodos() {
        return List.of();
    }

    @Override
    public AbonoDominio consultarPorID(UUID id) {
        return null;
    }

    private UUID generarIdAbonoUnico() {
        return UUID.randomUUID();
    }
}