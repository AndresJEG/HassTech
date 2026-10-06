package co.hasstech.backend.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.negocio.AbonoNegocio;
import co.hasstech.backend.negocio.negocio.assembler.impl.AbonoEntidadAssembler;
import co.hasstech.backend.negocio.negocio.especificacion.impl.AbonoDatosValidosEspecificacion;
import co.hasstech.backend.negocio.negocio.especificacion.impl.AbonoMetodoAplicacionExisteEspecificacion;
import co.hasstech.backend.negocio.negocio.especificacion.impl.AbonoNombreUnicoEspecificacion;
import co.hasstech.backend.negocio.negocio.especificacion.impl.AbonoToxicidadExisteEspecificacion;
import co.hasstech.backend.transversal.excepciones.HassTechExcepcion;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class AbonoNegocioImpl implements AbonoNegocio {

    private final DAOFactory daoFactory;

    public AbonoNegocioImpl(DAOFactory daoFactory) {
        if (UtilObjeto.esNulo(daoFactory)) {
            throw HassTechNegocioExcepcion.crear(
                    "No es posible instanciar AbonoNegocioImpl con una factoría DAO nula.",
                    "Factoría DAO nula recibida en el constructor de AbonoNegocioImpl."
            );
        }
        this.daoFactory = daoFactory;
    }

    @Override
    public void registrarInformacionNuevoAbono(AbonoDominio datos) {
        new AbonoDatosValidosEspecificacion().esSatisfechoPor(datos);
        new AbonoToxicidadExisteEspecificacion(daoFactory).esSatisfechoPor(datos);
        new AbonoMetodoAplicacionExisteEspecificacion(daoFactory).esSatisfechoPor(datos);
        new AbonoNombreUnicoEspecificacion(daoFactory).esSatisfechoPor(datos);

        UUID idUnico = generarIdAbonoUnico();

        var abonoFinal = new AbonoDominio.Builder()
                .id(idUnico)
                .nombre(datos.getNombre().trim())
                .esOrganico(datos.getEsOrganico())
                .descripcion(datos.getDescripcion().trim())
                .toxicidad(datos.getToxicidad())
                .metodoAplicacion(datos.getMetodoAplicacion())
                .build();

        var abonoEntidad = new AbonoEntidadAssembler().convertirAEntidad(abonoFinal);

        try {
            daoFactory.iniciarTransacción();

            daoFactory.obtenerAbonoDAO().crear(abonoEntidad);

            daoFactory.confirmarTransacción();
        } catch (HassTechExcepcion excepcion) {
            daoFactory.cancelarTransacción();
            throw excepcion;
        } catch (Exception excepcion) {
            daoFactory.cancelarTransacción();
            throw HassTechNegocioExcepcion.crear(
                    "Se presentó un problema inesperado al registrar el nuevo abono.",
                    "Excepción no controlada en registrarInformacionNuevoAbono.",
                    excepcion
            );
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void modificarInformacionAbonoExistente(UUID id, AbonoDominio datos) {

    }

    @Override
    public void darBajaInformacionAbonoExistente(UUID id) {

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