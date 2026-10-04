package co.hasstech.backend.Entidad;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class ProductoFitosanitarioEntidad {
    private UUID id;
    private String nombre;
    private ToxicidadEntidad toxicidad;
    private TipoProductoFitosanitarioEntidad tipoProductoFitosanitario;

    private ProductoFitosanitarioEntidad(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setTipoProductoFitosanitario(builder.tipoProductoFitosanitario);
        setToxicidad(builder.toxicidad);
    }

    public TipoProductoFitosanitarioEntidad getTipoProductoFitosanitario() {
        return tipoProductoFitosanitario;
    }

    private void setTipoProductoFitosanitario(TipoProductoFitosanitarioEntidad tipoProductoFitosanitario) {
        this.tipoProductoFitosanitario = tipoProductoFitosanitario;
    }

    public ToxicidadEntidad getToxicidad() {
        return toxicidad;
    }

    private void setToxicidad(ToxicidadEntidad toxicidad) {
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
        private ToxicidadEntidad toxicidad;
        private TipoProductoFitosanitarioEntidad tipoProductoFitosanitario;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder nombre(final String nombre) {
            this.nombre= UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder toxicidad(final ToxicidadEntidad toxicidad) {
            this.toxicidad= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(toxicidad, new ToxicidadEntidad.Builder().build());
            return this;
        }

        public Builder tipoProductoFitosanitario(final TipoProductoFitosanitarioEntidad tipoProductoFitosanitario) {
            this.tipoProductoFitosanitario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoProductoFitosanitario, new TipoProductoFitosanitarioEntidad.Builder().build());
            return this;
        }

        public ProductoFitosanitarioEntidad build() {
            return new ProductoFitosanitarioEntidad(this);
        }
    }
}