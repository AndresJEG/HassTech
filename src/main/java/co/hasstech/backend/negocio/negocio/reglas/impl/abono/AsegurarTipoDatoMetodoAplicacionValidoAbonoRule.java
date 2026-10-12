package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

import java.util.UUID;

public class AsegurarTipoDatoMetodoAplicacionValidoAbonoRule implements Rule <Object> {
    private static final AsegurarTipoDatoMetodoAplicacionValidoAbonoRule instancia = new AsegurarTipoDatoMetodoAplicacionValidoAbonoRule();

    private AsegurarTipoDatoMetodoAplicacionValidoAbonoRule(){

    }

    public static final Rule<Object> obtenerInstancia (){
        return instancia;

    }

    @Override
    public void ejecutar(Object... datos) {

        var dato = (UUID) datos[0];
        validarIdNoVacioTipoDatoMetodoAplicacion(dato);
        validarObligatoriedadTipoDatoMetodoAplicacion(dato);
    }

    private void validarObligatoriedadTipoDatoMetodoAplicacion(UUID id) {

        if (id == null) {
            var mensajeUsuario = "El identificador del método de aplicación es obligatorio.";
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }

    private void validarIdNoVacioTipoDatoMetodoAplicacion(UUID id){

        if (id.equals(new UUID(0L, 0L))) {
            var mensajeUsuario = "El identificador del método de aplicación no puede estar vacío.";
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }
}
