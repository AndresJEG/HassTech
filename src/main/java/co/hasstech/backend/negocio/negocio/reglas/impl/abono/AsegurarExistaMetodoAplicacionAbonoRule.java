package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.entidad.MetodoAplicacionEntidad;
import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

import java.util.UUID;

public class AsegurarExistaMetodoAplicacionAbonoRule implements Rule<Object> {
    private static final AsegurarExistaMetodoAplicacionAbonoRule instancia = new AsegurarExistaMetodoAplicacionAbonoRule();

    private AsegurarExistaMetodoAplicacionAbonoRule(){

    }

    public static final Rule<Object> obtenerInstancia (){
        return instancia;

    }

    @Override
    public void ejecutar(Object... datos) {
        var idMetodoAplicacion = (UUID) datos[0];
        var daoFactory = (DAOFactory) datos[1];

        var idEntidadFiltro = new MetodoAplicacionEntidad.Builder().id(idMetodoAplicacion).build();
        var resultadoBusquedaBD = daoFactory.obtenerMetodoAplicacionDAO().consultarPorFiltro(idEntidadFiltro);

        boolean existeMetodoAplicacion = resultadoBusquedaBD != null && resultadoBusquedaBD.stream()
                .anyMatch(e ->e.getId() != null && e.getId().equals(idMetodoAplicacion));

        if (!existeMetodoAplicacion) {
            var mensajeUsuario = CatalogoMensajes.ReglasImplementadasAbono.USUARIO_ERROR_METODOAPLICACION_NO_EXISTE_RULE;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);

        }

    }

}
