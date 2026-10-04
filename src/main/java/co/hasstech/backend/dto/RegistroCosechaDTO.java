package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class RegistroCosechaDTO {
    private UUID id;
    private ArbolAguacateDTO arbolAguacate;
    private CategoriaCalidadDTO categoriaCalidad;
    private LocalDate fechaCosecha;
    private float pesoCosecha;
    private UnidadMedidaDTO unidad;

    private RegistroCosechaDTO(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setCategoriaCalidad(builder.categoriaCalidad);
        setFechaCosecha(builder.fechaCosecha);
        setPesoCosecha(builder.pesoCosecha);
        setUnidad(builder.unidad);
    }

    public UnidadMedidaDTO Unidad() {
        return unidad;
    }

    private void setUnidad( final UnidadMedidaDTO unidad) {
        this.unidad = unidad;
    }

    public float getPesoCosecha() {
        return pesoCosecha;
    }

    private void setPesoCosecha(final float pesoCosecha) {
        this.pesoCosecha = pesoCosecha;
    }

    public ArbolAguacateDTO getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateDTO arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }


    public CategoriaCalidadDTO getCategoriaCalidad() {
        return categoriaCalidad;
    }

    private void setCategoriaCalidad( final CategoriaCalidadDTO categoriaCalidad) {
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
        private ArbolAguacateDTO arbolAguacate;
        private CategoriaCalidadDTO categoriaCalidad;
        private LocalDate fechaCosecha;
        private float pesoCosecha;
        private UnidadMedidaDTO unidad;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder unidad(final UnidadMedidaDTO unidad) {
            this.unidad= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(unidad, new UnidadMedidaDTO.Builder().build());
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateDTO arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateDTO.Builder().build());
            return this;
        }

        public Builder categoriaCalidad(final CategoriaCalidadDTO categoriaCalidad) {
            this.categoriaCalidad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoriaCalidad, new CategoriaCalidadDTO.Builder().build());
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

        public RegistroCosechaDTO build() {
            return new RegistroCosechaDTO(this);
        }
    }
}
