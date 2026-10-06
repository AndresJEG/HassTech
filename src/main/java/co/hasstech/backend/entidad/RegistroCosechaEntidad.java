package co.hasstech.backend.entidad;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class RegistroCosechaEntidad {
    private UUID id;
    private ArbolAguacateEntidad arbolAguacate;
    private CategoriaCalidadEntidad categoriaCalidad;
    private LocalDate fechaCosecha;
    private float pesoCosecha;
    private UnidadMedidaEntidad unidad;

    private RegistroCosechaEntidad(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setCategoriaCalidad(builder.categoriaCalidad);
        setFechaCosecha(builder.fechaCosecha);
        setPesoCosecha(builder.pesoCosecha);
        setUnidad(builder.unidad);
    }

    public UnidadMedidaEntidad Unidad() {
        return unidad;
    }

    private void setUnidad( final UnidadMedidaEntidad unidad) {
        this.unidad = unidad;
    }

    public float getPesoCosecha() {
        return pesoCosecha;
    }

    private void setPesoCosecha(final float pesoCosecha) {
        this.pesoCosecha = pesoCosecha;
    }

    public ArbolAguacateEntidad getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateEntidad arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }


    public CategoriaCalidadEntidad getCategoriaCalidad() {
        return categoriaCalidad;
    }

    private void setCategoriaCalidad( final CategoriaCalidadEntidad categoriaCalidad) {
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
        private ArbolAguacateEntidad arbolAguacate;
        private CategoriaCalidadEntidad categoriaCalidad;
        private LocalDate fechaCosecha;
        private float pesoCosecha;
        private UnidadMedidaEntidad unidad;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder unidad(final UnidadMedidaEntidad unidad) {
            this.unidad= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(unidad, new UnidadMedidaEntidad.Builder().build());
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateEntidad arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateEntidad.Builder().build());
            return this;
        }

        public Builder categoriaCalidad(final CategoriaCalidadEntidad categoriaCalidad) {
            this.categoriaCalidad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoriaCalidad, new CategoriaCalidadEntidad.Builder().build());
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

        public RegistroCosechaEntidad build() {
            return new RegistroCosechaEntidad(this);
        }
    }
}
