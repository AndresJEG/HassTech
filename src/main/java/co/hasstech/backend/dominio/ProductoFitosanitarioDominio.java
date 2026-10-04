package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;

import java.util.UUID;

public class ProductoFitosanitarioDominio {
    private UUID id;
    private String nombre;
    private ToxicidadDominio toxicidad;
    private TipoProductoFitosanitarioDominio tipoProductoFitosanitario;

    private ProductoFitosanitarioDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setTipoProductoFitosanitario(builder.tipoProductoFitosanitario);
        setToxicidad(builder.toxicidad);
    }

    public TipoProductoFitosanitarioDominio getTipoProductoFitosanitario() {
        return tipoProductoFitosanitario;
    }

    private void setTipoProductoFitosanitario(TipoProductoFitosanitarioDominio tipoProductoFitosanitario) {
        this.tipoProductoFitosanitario = tipoProductoFitosanitario;
    }

    public ToxicidadDominio getToxicidad() {
        return toxicidad;
    }

    private void setToxicidad(ToxicidadDominio toxicidad) {
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
        private ToxicidadDominio toxicidad;
        private TipoProductoFitosanitarioDominio tipoProductoFitosanitario;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder nombre(final String nombre) {
            this.nombre= UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
            return this;
        }
        public Builder toxicidad(final ToxicidadDominio toxicidad) {
            this.toxicidad= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(toxicidad, new ToxicidadDominio.Builder().build());
            return this;
        }

        public Builder tipoProductoFitosanitario(final TipoProductoFitosanitarioDominio tipoProductoFitosanitario) {
            this.tipoProductoFitosanitario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoProductoFitosanitario, new TipoProductoFitosanitarioDominio.Builder().build());
            return this;
        }

        public ProductoFitosanitarioDominio build() {
            return new ProductoFitosanitarioDominio(this);
        }
    }
}