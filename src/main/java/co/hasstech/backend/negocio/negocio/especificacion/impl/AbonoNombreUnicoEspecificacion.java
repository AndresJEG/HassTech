package co.hasstech.backend.negocio.negocio.especificacion.impl;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.entidad.AbonoEntidad;
import co.hasstech.backend.negocio.negocio.especificacion.Especificacion;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

public class AbonoNombreUnicoEspecificacion implements Especificacion<AbonoDominio> {

    private final DAOFactory daoFactory;

    public AbonoNombreUnicoEspecificacion(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean esSatisfechoPor(AbonoDominio abono) {
        var filtroEntidad = new AbonoEntidad.Builder()
                .nombre(abono.getNombre())
                .build();

        var resultados = daoFactory.obtenerAbonoDAO().consultarPorFiltro(filtroEntidad);

        boolean existeMismoNombre = resultados.stream().anyMatch(
                p -> p.getNombre() != null && p.getNombre().trim().equalsIgnoreCase(abono.getNombre().trim())
        );

        if (existeMismoNombre) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0007: Ya existe un abono registrado con el nombre '" + abono.getNombre().trim() + "'."
            );
        }
        return true;
    }
}