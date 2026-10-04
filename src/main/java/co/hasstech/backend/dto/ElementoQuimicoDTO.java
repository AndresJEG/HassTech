package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class ElementoQuimicoDTO {
    private UUID id;
    private String nombre;
    private String simbolo;
    private String clasificacion;

    private ElementoQuimicoDTO(Builder builder) {
        setId(id);
        setNombre(nombre);
        setSimbolo(simbolo);
        setClasificacion(clasificacion);
    }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = nombre; }
    public String getSimbolo() { return simbolo; }
    private void setSimbolo(final String simbolo) { this.simbolo = simbolo; }
    public String isClasificacion() { return clasificacion; }
    private void setClasificacion(final String clasificacion) { this.clasificacion = clasificacion; }

    public static class Builder {
        private UUID id;
        private String nombre;
        private String simbolo;
        private String clasificacion;

        public Builder id(final UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }
        public Builder nombre(final String nombre) {
            this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder simbolo(final String simbolo) {
            this.simbolo = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(simbolo);
            return this;
        }
        public Builder clasificacion(final String clasificacion) {
            this.clasificacion = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(clasificacion);
            return this;
        }
        public ElementoQuimicoDTO build() {
            return new ElementoQuimicoDTO(this);
        }
    }
}