package co.hasstech.backend.Entidad;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class UnidadMedidaEntidad {
    private UUID id;
    private String nombre;
    private String abreviacion;
    private TipoMagnitudEntidad tipoMagnitud;

    private UnidadMedidaEntidad(Builder builder) {
        setId(id);
        setNombre(nombre);
        setAbreviacion(abreviacion);
        setTipoMagnitud(tipoMagnitud);
    }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = nombre; }
    public String getAbreviacion() { return abreviacion; }
    private void setAbreviacion(final String abreviacion) { this.abreviacion = abreviacion; }
    public TipoMagnitudEntidad getTipoMagnitud() { return tipoMagnitud; }
    private void setTipoMagnitud(final TipoMagnitudEntidad tipoMagnitud) { this.tipoMagnitud = tipoMagnitud; }

    public static class Builder {
        private UUID id;
        private String nombre;
        private String abreviacion;
        private TipoMagnitudEntidad tipoMagnitud;

        public Builder id(final UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }
        public Builder nombre(final String nombre) {
            this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder abreviacion(final String abreviacion) {
            this.abreviacion = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(abreviacion);
            return this;
        }
        public Builder tipoMagnitud(final TipoMagnitudEntidad tipoMagnitud) {
            this.tipoMagnitud = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoMagnitud, new TipoMagnitudEntidad.Builder().build());
            return this;
        }
        public UnidadMedidaEntidad build() {
            return new UnidadMedidaEntidad(this);
        }
    }
}

