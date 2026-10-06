package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilBooleano;
import java.util.UUID;

public class PlagaDominio {
    private UUID id;
    private String nombre;
    private String origen;
    private Boolean esContagioso;

    private PlagaDominio(Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setOrigen(builder.origen);
        setEsContagioso(builder.esContagioso);
    }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = nombre; }
    public String getOrigen() { return origen; }
    private void setOrigen(final String origen) { this.origen = origen; }
    public Boolean EsContagioso() { return esContagioso; }
    private void setEsContagioso(final boolean esContagioso) { this.esContagioso = esContagioso; }

    public static class Builder {
        private UUID id;
        private String nombre;
        private String origen;
        private Boolean esContagioso;

        public Builder id(final UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }
        public Builder nombre(final String nombre) {
            this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder origen(final String origen) {
            this.origen = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(origen);
            return this;
        }
        public Builder esContagioso(final Boolean esContagioso) {
            this.esContagioso = UtilBooleano.obtenerValorDefecto(esContagioso);
            return this;
        }
        public PlagaDominio build() {
            return new PlagaDominio(this);
        }
    }
}