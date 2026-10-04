package co.hasstech.backend.Entidad;

import co.hasstech.backend.transversal.utilitarios.*;

import java.time.LocalDate;
import java.util.UUID;

public class ArbolAguacateEntidad {
    private UUID id;
    private String codigo;
    private float ejeX;
    private float ejeY;
    private UnidadMedidaEntidad unidadUbicacion;
    private LocalDate fechaPlantacion;

    private ArbolAguacateEntidad(final Builder builder) {
        setId(builder.id);
        setCodigo(builder.codigo);
        setEjeX(builder.ejeX);
        setEjeY(builder.ejeY);
        setUnidadUbicacion(builder.unidadUbicacion);
        setFechaPlantacion(builder.fechaPlantacion);
    }

    public UnidadMedidaEntidad UnidadUbicacion() {
        return unidadUbicacion;
    }

    private void setUnidadUbicacion( final UnidadMedidaEntidad unidadUbicacion) {
        this.unidadUbicacion = unidadUbicacion;
    }

    public float getEjeY() {
        return ejeY;
    }

    private void setEjeY(final float EjeY) {
        this.ejeY = ejeY;
    }

    public float getEjeX() {
        return ejeX;
    }

    private void setEjeX(final float ejeX) {
        this.ejeX = ejeX;
    }

    public LocalDate getFechaPlantacion() {
        return fechaPlantacion;
    }

    private void setFechaPlantacion( final LocalDate fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    private void setCodigo(final String codigo) {
        this.codigo = codigo;
    }

    public UnidadMedidaEntidad getUnidadUbicacion() { return unidadUbicacion;
    }

    public static class Builder {
        private UUID id;
        private String codigo;
        private float ejeX;
        private float ejeY;
        private UnidadMedidaEntidad unidadUbicacion;
        private LocalDate fechaPlantacion;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder codigo(final String codigo) {
            this.codigo = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(codigo);
            return this;
        }

        public Builder ejeX(final float ejeX) {
            this.ejeX= UtilDecimal.obtenerValorDefecto(ejeX);
            return this;
        }

        public Builder ejeY(final float ejeY) {
            this.ejeY = UtilDecimal.obtenerValorDefecto(ejeY);
            return this;
        }

        public Builder unidadUbicacion(final UnidadMedidaEntidad unidadUbicacion) {
            this.unidadUbicacion= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(unidadUbicacion, new UnidadMedidaEntidad.Builder().build());
            return this;
        }

        public Builder fechaPlantacion(final LocalDate fechaPlantacion) {
            this.fechaPlantacion = UtilFecha.obtenerValorDefecto(fechaPlantacion);
            return this;
        }

        public ArbolAguacateEntidad build() {
            return new ArbolAguacateEntidad(this);
        }
    }
}