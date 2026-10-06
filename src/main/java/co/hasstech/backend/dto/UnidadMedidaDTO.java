package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class UnidadMedidaDTO {
    private UUID id;
    private String nombre;
    private String abreviacion;
    private TipoMagnitudDTO tipoMagnitud;

    private UnidadMedidaDTO(Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setAbreviacion(builder.abreviacion);
        setTipoMagnitud(builder.tipoMagnitud);
    }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = nombre; }
    public String getAbreviacion() { return abreviacion; }
    private void setAbreviacion(final String abreviacion) { this.abreviacion = abreviacion; }
    public TipoMagnitudDTO getTipoMagnitud() { return tipoMagnitud; }
    private void setTipoMagnitud(final TipoMagnitudDTO tipoMagnitud) { this.tipoMagnitud = tipoMagnitud; }

    public static class Builder {
        private UUID id;
        private String nombre;
        private String abreviacion;
        private TipoMagnitudDTO tipoMagnitud;

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
        public Builder tipoMagnitud(final TipoMagnitudDTO tipoMagnitud) {
            this.tipoMagnitud = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoMagnitud, new TipoMagnitudDTO.Builder().build());
            return this;
        }
        public UnidadMedidaDTO build() {
            return new UnidadMedidaDTO(this);
        }
    }
}

