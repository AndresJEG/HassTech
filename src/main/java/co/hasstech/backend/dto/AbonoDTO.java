package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilBooleano;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class AbonoDTO {
    private UUID id;
    private String nombre;
    private boolean esOrganico;
    private ToxicidadDTO toxicidad;
    private String descripcion;
    private MetodoAplicacionDTO metodoAplicacion;

    private AbonoDTO(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setEsOrganico(builder.esOrganico);
        setMetodoAplicacion(builder.metodoAplicacion);
        setDescripcion(builder.descripcion);
        setToxicidad(builder.toxicidad);
    }

    public boolean getEsOrganico() {
        return esOrganico;
    }

    private void setEsOrganico(final boolean esOrganico) {
        this.esOrganico = esOrganico;
    }

    public ToxicidadDTO getToxicidad() {
        return toxicidad;
    }

    private void setToxicidad(final ToxicidadDTO toxicidad) {
        this.toxicidad = toxicidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public MetodoAplicacionDTO getMetodoAplicacion() {
        return metodoAplicacion;
    }

    private void setMetodoAplicacion(final MetodoAplicacionDTO metodoAplicacion) {
        this.metodoAplicacion = metodoAplicacion;
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
        private boolean esOrganico;
        private ToxicidadDTO toxicidad;
        private String descripcion;
        private MetodoAplicacionDTO metodoAplicacion;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder nombre(final String nombre) {
            this.nombre= UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }

        public Builder esOrganico(final boolean esOrganico) {
            this.esOrganico= UtilBooleano.obtenerValorDefecto(esOrganico);
            return this;
        }

        public Builder toxicidad(final ToxicidadDTO toxicidad) {
            this.toxicidad= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(toxicidad, new ToxicidadDTO.Builder().build());
            return this;
        }

        public Builder descripcion(final String descripcion) {
            this.descripcion= UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(descripcion);
            return this;
        }

        public Builder metodoAplicacion(final MetodoAplicacionDTO metodoAplicacion) {
            this.metodoAplicacion= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(metodoAplicacion, new MetodoAplicacionDTO.Builder().build());
            return this;
        }

        public AbonoDTO build() {
            return new AbonoDTO(this);
        }
    }
}