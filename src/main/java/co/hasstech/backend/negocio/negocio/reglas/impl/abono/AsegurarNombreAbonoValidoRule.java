package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.catalogo.CatalogoMensajes;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;

public class AsegurarNombreAbonoValidoRule implements Rule<String>{

    private static final AsegurarNombreAbonoValidoRule instancia = new AsegurarNombreAbonoValidoRule();

    private AsegurarNombreAbonoValidoRule(){

    }

    public static final Rule<String> obtenerInstancia (){
        return instancia;

    }

    @Override
    public void ejecutar(String... datos) {
        var nombreAbono = datos[0];

        obligatoriedadNombre(nombreAbono);
        validarFormatoNombre(nombreAbono);
        validarLongitudNombreAbono(nombreAbono, 1, 40);

    }

    private void obligatoriedadNombre(String dato){
        if (UtilTexto.getUtilTexto().esVacia(dato)){
            var mensajeUsuario = CatalogoMensajes.ReglasImplementadasAbono.USUARIO_ERROR_NOMBRE_ABONO_OBLIGATORIO_RULE;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        };
    }

    private void validarLongitudNombreAbono(String dato, int longitudMinima, int longitudMaxima){
        if (!UtilTexto.getUtilTexto().longitudCadenaEsValida(longitudMinima, longitudMaxima, dato, false)) {
            var mensajeUsuario = CatalogoMensajes.ReglasImplementadasAbono.USUARIO_ERROR_VALIDACION_LONGITUD_NOMBRE_ABONO_RULE;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }

    private void validarFormatoNombre (String dato){
        if(!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.SOLO_LETRAS_ESPACIOS)){
            var mensajeUsuario = CatalogoMensajes.ReglasImplementadasAbono.USUARIO_ERROR_FORMATO_NOMBRE_ABONO_RULE;
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }
}
