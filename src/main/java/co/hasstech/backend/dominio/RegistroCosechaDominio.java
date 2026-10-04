package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class RegistroCosechaDominio {
    private UUID id;
    private ArbolAguacateDominio arbolAguacate;
    private CategoriaCalidadDominio categoriaCalidad;
    private LocalDate fechaCosecha;
    private float pesoCosecha;
    private UnidadMedidaDominio unidad;

    private RegistroCosechaDominio(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setCategoriaCalidad(builder.categoriaCalidad);
        setFechaCosecha(builder.fechaCosecha);
        setPesoCosecha(builder.pesoCosecha);
        setUnidad(builder.unidad);
    }

    public UnidadMedidaDominio Unidad() {
        return unidad;
    }

    private void setUnidad( final UnidadMedidaDominio unidad) {
        this.unidad = unidad;
    }

    public float getPesoCosecha() {
        return pesoCosecha;
    }

    private void setPesoCosecha(final float pesoCosecha) {
        this.pesoCosecha = pesoCosecha;
    }

    public ArbolAguacateDominio getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateDominio arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }


    public CategoriaCalidadDominio getCategoriaCalidad() {
        return categoriaCalidad;
    }

    private void setCategoriaCalidad( final CategoriaCalidadDominio categoriaCalidad) {
        this.categoriaCalidad = categoriaCalidad;
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public LocalDate getFechaCosecha() {
        return fechaCosecha;
    }

    private void setFechaCosecha(final LocalDate fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
    }

    public static class Builder {
        private UUID id;
        private ArbolAguacateDominio arbolAguacate;
        private CategoriaCalidadDominio categoriaCalidad;
        private LocalDate fechaCosecha;
        private float pesoCosecha;
        private UnidadMedidaDominio unidad;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder unidad(final UnidadMedidaDominio unidad) {
            this.unidad= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(unidad, new UnidadMedidaDominio.Builder().build());
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateDominio arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateDominio.Builder().build());
            return this;
        }

        public Builder categoriaCalidad(final CategoriaCalidadDominio categoriaCalidad) {
            this.categoriaCalidad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoriaCalidad, new CategoriaCalidadDominio.Builder().build());
            return this;
        }

        public Builder fechaCosecha(final LocalDate fechaCosecha) {
            this.fechaCosecha = UtilFecha.obtenerValorDefecto(fechaCosecha);
            return this;
        }

        public Builder pesoCosecha(final float pesoCosecha) {
            this.pesoCosecha = UtilDecimal.obtenerValorDefecto(pesoCosecha);
            return this;
        }

        public RegistroCosechaDominio build() {
            return new RegistroCosechaDominio(this);
        }
    }
}
