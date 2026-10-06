package co.hasstech.backend.entidad;

import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class ToxicidadEntidad {
    private UUID id;
    private String nombre;
    private String descripcion;

    private ToxicidadEntidad(Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setDescripcion(builder.descripcion);
    }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    private void setDescripcion(final String descripcion) { this.descripcion = descripcion; }

    public static class Builder {
        private UUID id;
        private String nombre;
        private String descripcion;

        public Builder id(final UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }
        public Builder nombre(final String nombre) {
            this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder descripcion(final String descripcion) {
            this.descripcion = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(descripcion);
            return this;
        }
        public ToxicidadEntidad build() {
            return new ToxicidadEntidad(this);
        }
    }
}