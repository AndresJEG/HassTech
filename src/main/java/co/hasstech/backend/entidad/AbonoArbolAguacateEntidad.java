package co.hasstech.backend.entidad;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class AbonoArbolAguacateEntidad {
    private UUID id;
    private ArbolAguacateEntidad arbolAguacate;
    private AbonoEntidad abono;
    private LocalDate fechaAbono;
    private float cantidad;
    private UnidadMedidaEntidad unidadMedida;

    private AbonoArbolAguacateEntidad(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setAbono(builder.abono);
        setFechaAbono(builder.fechaAbono);
        setCantidad(builder.cantidad);
        setUnidadMedida(builder.unidadMedida);
    }

    public UnidadMedidaEntidad getUnidadMedida() {
        return unidadMedida;
    }

    private void setUnidadMedida( final UnidadMedidaEntidad unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getCantidad() {
        return cantidad;
    }

    private void setCantidad(final float cantidad) {
        this.cantidad = cantidad;
    }

    public ArbolAguacateEntidad getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateEntidad arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }


    public AbonoEntidad getAbono() {
        return abono;
    }

    private void setAbono( final AbonoEntidad abono) {
        this.abono = abono;
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public LocalDate getFechaAbono() {
        return fechaAbono;
    }

    private void setFechaAbono(final LocalDate fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public static class Builder {
        private UUID id;
        private ArbolAguacateEntidad arbolAguacate;
        private AbonoEntidad abono;
        private LocalDate fechaAbono;
        private float cantidad;
        private UnidadMedidaEntidad unidadMedida;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateEntidad arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateEntidad.Builder().build());
            return this;
        }

        public Builder abono(final AbonoEntidad abono) {
            this.abono= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(abono, new AbonoEntidad.Builder().build());
            return this;
        }

        public Builder fechaAbono(final LocalDate fechaAbono) {
            this.fechaAbono = UtilFecha.obtenerValorDefecto(fechaAbono);
            return this;
        }

        public Builder cantidad(final float cantidad) {
            this.cantidad = UtilDecimal.obtenerValorDefecto(cantidad);
            return this;
        }

        public Builder unidad(final UnidadMedidaEntidad unidadMedida) {
            this.unidadMedida = unidadMedida;
            return this;
        }

        public AbonoArbolAguacateEntidad build() {
            return new AbonoArbolAguacateEntidad(this);
        }
    }
}