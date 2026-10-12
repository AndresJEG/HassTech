package co.hasstech.backend.negocio.negocio.reglas.impl.abono;

import co.hasstech.backend.dao.factoria.DAOFactory;
import co.hasstech.backend.entidad.AbonoEntidad;
import co.hasstech.backend.negocio.negocio.reglas.Rule;
import co.hasstech.backend.transversal.excepciones.HassTechNegocioExcepcion;

public class AsegurarNombreNuevoAbonoNoExisteRule implements Rule<Object> {

    private static final AsegurarNombreNuevoAbonoNoExisteRule instancia = new AsegurarNombreNuevoAbonoNoExisteRule();

    private AsegurarNombreNuevoAbonoNoExisteRule() {

    }

    public static final Rule<Object> obtenerInstancia() {
        return instancia;
    }

    @Override
    public void ejecutar(Object... datos) {

        var nombreAbono = (String) datos[0];
        var daoFactory = (DAOFactory) datos[1];


        var entidadFiltro = new AbonoEntidad.Builder().nombre(nombreAbono).build();

        var resultados = daoFactory.obtenerAbonoDAO().consultarPorFiltro(entidadFiltro);

        boolean existeCoincidenciaExacta = resultados.stream()
                .anyMatch(p -> p.getNombre() != null && p.getNombre().trim().equalsIgnoreCase(nombreAbono.trim()));

        if (existeCoincidenciaExacta) {
            throw HassTechNegocioExcepcion.crear(
                    "Ya existe un abono registrado con el nombre '" + nombreAbono.trim() + "'."            );
        }

    }
}
