package co.hasstech.backend.negocio.negocio.especificacion.impl;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.negocio.negocio.especificacion.Especificacion;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class AbonoToxicidadExisteEspecificacion implements Especificacion<AbonoDominio> {

    private final DAOFactory daoFactory;

    public AbonoToxicidadExisteEspecificacion(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean esSatisfechoPor(AbonoDominio abono) {
        var toxicidadEntidad = daoFactory.obtenerToxicidadDAO().consultarPorId(abono.getToxicidad().getId());
        if (UtilObjeto.esNulo(toxicidadEntidad)) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0003: La toxicidad especificada para el abono no existe en la base de datos."
            );
        }
        return true;
    }
}