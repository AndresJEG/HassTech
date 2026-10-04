package co.hasstech.backend.dominio;

import java.util.UUID;

import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;


public class TipoMagnitudDominio {
    private UUID id;
    private String nombre;

    private TipoMagnitudDominio(Builder builder) {
        setId(id);
        setNombre(nombre);
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
        public TipoMagnitudDominio build() {
            return new TipoMagnitudDominio(this);
        }
    }
}