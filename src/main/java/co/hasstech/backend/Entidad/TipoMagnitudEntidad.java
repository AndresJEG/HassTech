package co.hasstech.backend.Entidad;

import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;


public class TipoMagnitudEntidad {
    private UUID id;
    private String nombre;

    private TipoMagnitudEntidad(Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
    }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = nombre; }

    public static class Builder {
        private UUID id;
        private String nombre;

        public Builder id(final UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }
        public Builder nombre(final String nombre) {
            this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public TipoMagnitudEntidad build() {
            return new TipoMagnitudEntidad(this);
        }
    }
}