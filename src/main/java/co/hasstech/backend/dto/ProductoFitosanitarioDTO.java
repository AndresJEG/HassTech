package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class ProductoFitosanitarioDTO {
    private UUID id;
    private String nombre;
    private ToxicidadDTO toxicidad;
    private TipoProductoFitosanitarioDTO tipoProductoFitosanitario;

    private ProductoFitosanitarioDTO(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setTipoProductoFitosanitario(builder.tipoProductoFitosanitario);
        setToxicidad(builder.toxicidad);
    }

    public TipoProductoFitosanitarioDTO getTipoProductoFitosanitario() {
        return tipoProductoFitosanitario;
    }

    private void setTipoProductoFitosanitario(TipoProductoFitosanitarioDTO tipoProductoFitosanitario) {
        this.tipoProductoFitosanitario = tipoProductoFitosanitario;
    }

    public ToxicidadDTO getToxicidad() {
        return toxicidad;
    }

    private void setToxicidad(ToxicidadDTO toxicidad) {
        this.toxicidad = toxicidad;
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
        private ToxicidadDTO toxicidad;
        private TipoProductoFitosanitarioDTO tipoProductoFitosanitario;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder nombre(final String nombre) {
            this.nombre= UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder toxicidad(final ToxicidadDTO toxicidad) {
            this.toxicidad= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(toxicidad, new ToxicidadDTO.Builder().build());
            return this;
        }

        public Builder tipoProductoFitosanitario(final TipoProductoFitosanitarioDTO tipoProductoFitosanitario) {
            this.tipoProductoFitosanitario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoProductoFitosanitario, new TipoProductoFitosanitarioDTO.Builder().build());
            return this;
        }

        public ProductoFitosanitarioDTO build() {
            return new ProductoFitosanitarioDTO(this);
        }
    }
}