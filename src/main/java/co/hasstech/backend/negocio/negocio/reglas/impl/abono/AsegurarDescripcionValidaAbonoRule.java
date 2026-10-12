package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;

public class AsegurarDescripcionValidaAbonoRule implements Rule <String>{
    private static final AsegurarDescripcionValidaAbonoRule instancia = new AsegurarDescripcionValidaAbonoRule();

    private AsegurarDescripcionValidaAbonoRule(){

    }

    public static final Rule<String> obtenerInstancia (){
        return instancia;

    }

    @Override
    public void ejecutar(String... datos){
        var descripcionAbono = (String) datos[0];

        obligatoriedadDescripcion(descripcionAbono);
        validarFormatoDescripcion(descripcionAbono);
        validarLongitudDescripcionAbono(descripcionAbono, 1, 100);
    }

    private void obligatoriedadDescripcion(String dato){
        if (UtilTexto.getUtilTexto().esVacia(dato)){
            var mensajeUsuario = "La descripción es obligatoria";
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        };
    }

    private void validarLongitudDescripcionAbono(String dato, int longitudMinima, int longitudMaxima){
        if (!UtilTexto.getUtilTexto().longitudCadenaEsValida(longitudMinima, longitudMaxima, dato, false)) {
            var mensajeUsuario = "La descripción debe tener mínimo un carácter y máximo 100";
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }

    private void validarFormatoDescripcion (String dato){
        if(!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.SOLO_LETRAS_ESPACIOS)){
            var mensajeUsuario = "La descripción solo acepta número decimales y el alfabeto castellano.";
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }
}
