package co.hasstech.backend.negocio.negocio.especificacion.impl;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.negocio.negocio.especificacion.Especificacion;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class AbonoMetodoAplicacionExisteEspecificacion implements Especificacion<AbonoDominio> {

    private final DAOFactory daoFactory;

    public AbonoMetodoAplicacionExisteEspecificacion(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean esSatisfechoPor(AbonoDominio abono) {
        var metodoEntidad = daoFactory.obtenerMetodoAplicacionDAO().consultarPorId(abono.getMetodoAplicacion().getId());
        if (UtilObjeto.esNulo(metodoEntidad)) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0004: El método de aplicación especificado para el abono no existe en la base de datos."
            );
        }
        return true;
    }
}