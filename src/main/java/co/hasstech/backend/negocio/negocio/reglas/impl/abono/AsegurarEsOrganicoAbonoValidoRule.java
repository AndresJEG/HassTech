package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

public class AsegurarEsOrganicoAbonoValidoRule implements Rule <Boolean>{
    private static final AsegurarEsOrganicoAbonoValidoRule instancia = new AsegurarEsOrganicoAbonoValidoRule();

    private AsegurarEsOrganicoAbonoValidoRule(){

    }

    public static final Rule<Boolean> obtenerInstancia (){
        return instancia;

    }

    @Override
    public void ejecutar(Boolean... datos) {
        Boolean esOrganico = (Boolean) datos[0];

        validarObligatoriedad(esOrganico);

    }

    private void validarObligatoriedad(Boolean esOrganico) {
        if (esOrganico == null) {
            var mensajeUsuario = "El estado orgánico es obligatorio.";
            throw HassTechNegocioExcepcion.crear(mensajeUsuario);
        }
    }
}
