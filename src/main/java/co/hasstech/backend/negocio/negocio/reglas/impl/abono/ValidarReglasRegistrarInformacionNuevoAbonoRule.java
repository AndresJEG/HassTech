package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.negocio.negocio.reglas.Rule;

public class ValidarReglasRegistrarInformacionNuevoAbonoRule implements Rule <Object> {

    private static final ValidarReglasRegistrarInformacionNuevoAbonoRule instancia = new ValidarReglasRegistrarInformacionNuevoAbonoRule();

    private ValidarReglasRegistrarInformacionNuevoAbonoRule(){

    }

    public static final Rule<Object> obtenerInstancia (){
        return instancia;

    }


    @Override
    public void ejecutar(Object ... datos) {
        var dominio = (AbonoDominio) datos[0];
        var daoFactory = (DAOFactory) datos[1];

        AsegurarDescripcionValidaAbonoRule.obtenerInstancia().ejecutar(dominio.getDescripcion());
        AsegurarEsOrganicoAbonoValidoRule.obtenerInstancia().ejecutar(dominio.getEsOrganico());
        AsegurarNombreAbonoValidoRule.obtenerInstancia().ejecutar(dominio.getNombre());
        AsegurarTipoDatoMetodoAplicacionValidoAbonoRule.obtenerInstancia().ejecutar(dominio.getMetodoAplicacion().getId());
        AsegurarTipoDatoToxicidadValidoAbonoRule.obtenerInstancia().ejecutar(dominio.getToxicidad().getId());
        AsegurarNombreNuevoAbonoNoExisteRule.obtenerInstancia().ejecutar(dominio.getNombre(), daoFactory);
        AsegurarExistaMetodoAplicacionAbonoRule.obtenerInstancia().ejecutar(dominio.getMetodoAplicacion().getId(), daoFactory);
        AsegurarToxicidadExistaRule.obtenerInstancia().ejecutar(dominio.getToxicidad().getId(), daoFactory);

    }
}
