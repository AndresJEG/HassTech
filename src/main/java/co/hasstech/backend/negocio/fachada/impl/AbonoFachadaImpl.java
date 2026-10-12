package co.hasstech.backend.negocio.fachada.impl;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dto.AbonoDTO;
import co.hasstech.backend.negocio.fachada.AbonoFachada;
import co.hasstech.backend.negocio.fachada.assembler.impl.AbonoDTOAssembler;
import co.hasstech.backend.negocio.negocio.AbonoNegocio;
import co.hasstech.backend.negocio.negocio.impl.AbonoNegocioImpl;
import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechExcepcion;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

import java.util.List;
import java.util.UUID;

public class AbonoFachadaImpl implements AbonoFachada {

    private DAOFactory daoFactory;
    private AbonoNegocio  abonoNegocio;

    public AbonoFachadaImpl(){
        daoFactory = DAOFactory.obtenerFactoria();
        abonoNegocio = new AbonoNegocioImpl(daoFactory);
    }

    @Override
    public void registrarInformacionNuevoAbono(AbonoDTO datos) {
        daoFactory.iniciarTransacción();
        try {
            var abonoDominio = AbonoDTOAssembler.obtenerInstancia().convertirADominio(datos);
            abonoNegocio.registrarInformacionNuevoAbono(abonoDominio);

            daoFactory.confirmarTransacción();
        } catch (HassTechExcepcion excepcion) {
            daoFactory.cancelarTransacción();
            throw excepcion;
        } catch (Exception excepcion){
            daoFactory.cancelarTransacción();

            var mensajeUsuario = CatalogoMensajes.AbonoFachadaImpl.USUARIO_ERROR_PROBLEMA_AL_REGISTRAR_NUEVO_ABONO_FACHADA_IMPL;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        } finally {
            daoFactory.cerrarConexion();
        }

    }

    @Override
    public void modificarInformacionAbonoExistente(UUID id, AbonoDTO datos) {

    }

    @Override
    public List<AbonoDTO> consultarPorFiltro(AbonoDTO filtro) {
        return List.of();
    }

    @Override
    public List<AbonoDTO> consultarTodos() {
        return List.of();
    }

    @Override
    public AbonoDTO consultarPorID(UUID id) {
        return null;
    }
}
