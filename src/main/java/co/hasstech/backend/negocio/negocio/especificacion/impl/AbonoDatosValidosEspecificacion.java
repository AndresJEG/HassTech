package co.hasstech.backend.negocio.negocio.especificacion.impl;

import co.hasstech.backend.dominio.AbonoDominio;
import co.hasstech.backend.negocio.negocio.especificacion.Especificacion;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

public class AbonoDatosValidosEspecificacion implements Especificacion<AbonoDominio> {

    @Override
    public boolean esSatisfechoPor(AbonoDominio abono) {
        if (UtilObjeto.esNulo(abono)) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: La información del abono no puede estar vacía."
            );
        }

        if (UtilObjeto.esNulo(abono.getNombre()) || abono.getNombre().isBlank()) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: El nombre comercial del abono es obligatorio."
            );
        }
        if (!abono.getNombre().equals(abono.getNombre().trim())) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: El nombre comercial no debe contener espacios al inicio ni al final."
            );
        }
        if (abono.getNombre().length() < 1 || abono.getNombre().length() > 20) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: El nombre comercial del abono debe tener entre 1 y 20 caracteres."
            );
        }

        if (UtilObjeto.esNulo(abono.getEsOrganico())) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: Debe especificar si el abono es orgánico o no."
            );
        }

        if (UtilObjeto.esNulo(abono.getDescripcion()) || abono.getDescripcion().isBlank()) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: La descripción del abono es obligatoria."
            );
        }
        if (!abono.getDescripcion().equals(abono.getDescripcion().trim())) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: La descripción no debe contener espacios al inicio ni al final."
            );
        }
        if (abono.getDescripcion().length() < 1 || abono.getDescripcion().length() > 100) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: La descripción del abono debe tener entre 1 y 100 caracteres."
            );
        }

        if (UtilObjeto.esNulo(abono.getToxicidad()) || UtilObjeto.esNulo(abono.getToxicidad().getId())
                || abono.getToxicidad().getId().equals(UtilUUID.VALOR_DEFECTO)) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: La información de la toxicidad asociada no es válida."
            );
        }

        if (UtilObjeto.esNulo(abono.getMetodoAplicacion()) || UtilObjeto.esNulo(abono.getMetodoAplicacion().getId())
                || abono.getMetodoAplicacion().getId().equals(UtilUUID.VALOR_DEFECTO)) {
            throw HassTechNegocioExcepcion.crear(
                    "P-ABO-0001: La información del método de aplicación asociado no es válida."
            );
        }

        return true;
    }
}