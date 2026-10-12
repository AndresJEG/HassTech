package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

import java.util.UUID;

public class AsegurarTipoDatoToxicidadValidoAbonoRule implements Rule<Object>{
    private static final AsegurarTipoDatoToxicidadValidoAbonoRule instancia = new AsegurarTipoDatoToxicidadValidoAbonoRule();

    private AsegurarTipoDatoToxicidadValidoAbonoRule(){

    }

    public static final Rule<Object> obtenerInstancia (){
        return instancia;

    }

    @Override
    public void ejecutar(Object... datos) {

        var dato = (UUID) datos[0];
        validarIdNoVacioTipoDatoToxicida(dato);
        validarObligatoriedadTipoDatoToxicidad(dato);
    }

    private void validarObligatoriedadTipoDatoToxicidad(UUID id) {

        if (id == null) {
            var mensajeUsuario = CatalogoMensajes.ReglasImplementadasAbono.USUARIO_ERROR_IDENTIFICADOR_TOXICIDAD_OBLIGATORIO_RULE;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }

    private void validarIdNoVacioTipoDatoToxicida(UUID id){

        if (id.equals(new UUID(0L, 0L))) {
            var mensajeUsuario = CatalogoMensajes.ReglasImplementadasAbono.USUARIO_ERROR_IDENTIFICADOR_TOXICIDAD_NO_VACIO_RULE;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }
}
