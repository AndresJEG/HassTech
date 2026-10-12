package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.entidad.ToxicidadEntidad;
import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

import java.util.UUID;

public class AsegurarToxicidadExistaRule implements Rule<Object> {
    private static final AsegurarToxicidadExistaRule instancia = new AsegurarToxicidadExistaRule();

    private AsegurarToxicidadExistaRule(){

    }

    public static final Rule<Object> obtenerInstancia (){
        return instancia;

    }

    @Override
    public void ejecutar(Object... datos) {
        var idToxicidad = (UUID) datos[0];
        var daoFactory = (DAOFactory) datos[1];

        var idEntidadFiltro = new ToxicidadEntidad.Builder().id(idToxicidad).build();
        var resultadoBusquedaBD = daoFactory.obtenerToxicidadDAO().consultarPorFiltro(idEntidadFiltro);
        boolean existeMetodoAplicacion = resultadoBusquedaBD != null && resultadoBusquedaBD.stream()
                .anyMatch(e ->e.getId() != null && e.getId().equals(idToxicidad));

        if (!existeMetodoAplicacion) {
            var mensajeUsuario = CatalogoMensajes.ReglasImplementadasAbono.USUARIO_ERROR_TOXICIDAD_SELECCIONADA_NO_EXISTE_RULE;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);

        }

    }

}
