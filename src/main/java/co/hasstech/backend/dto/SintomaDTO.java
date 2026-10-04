package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class SintomaDTO {
    private UUID id;
    private String nombre;
    private String descripcion;
    private ParteArbolDTO parteArbol;

    private SintomaDTO(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setDescripcion(builder.descripcion);
        setParteArbol(builder.parteArbol);
    }

    public ParteArbolDTO getParteArbol() {
        return parteArbol;
    }

    private void setParteArbol(ParteArbolDTO parteArbol) {
        this.parteArbol = parteArbol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public static class Builder {
        private UUID id;
        private String nombre;
        private String descripcion;
        private ParteArbolDTO parteArbol;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder nombre(final String nombre) {
            this.nombre= UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder parteArbol(final ParteArbolDTO parteArbol) {
            this.parteArbol = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(parteArbol, new ParteArbolDTO.Builder().build());
            return this;
        }

        public Builder descripcion(final String descripcion) {
            this.descripcion = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(descripcion);
            return this;
        }

        public SintomaDTO build() {
            return new SintomaDTO(this);
        }
    }
}