package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class AbonoArbolAguacateDTO {
    private UUID id;
    private ArbolAguacateDTO arbolAguacate;
    private AbonoDTO abono;
    private LocalDate fechaAbono;
    private float cantidad;
    private UnidadMedidaDTO unidadMedida;

    private AbonoArbolAguacateDTO(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setAbono(builder.abono);
        setFechaAbono(builder.fechaAbono);
        setCantidad(builder.cantidad);
        setUnidadMedida(builder.unidadMedida);
    }

    public UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    private void setUnidadMedida( final UnidadMedidaDTO unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getCantidad() {
        return cantidad;
    }

    private void setCantidad(final float cantidad) {
        this.cantidad = cantidad;
    }

    public ArbolAguacateDTO getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateDTO arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }


    public AbonoDTO getAbono() {
        return abono;
    }

    private void setAbono( final AbonoDTO abono) {
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
        private ArbolAguacateDTO arbolAguacate;
        private AbonoDTO abono;
        private LocalDate fechaAbono;
        private float cantidad;
        private UnidadMedidaDTO unidadMedida;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateDTO arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateDTO.Builder().build());
            return this;
        }

        public Builder abono(final AbonoDTO abono) {
            this.abono= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(abono, new AbonoDTO.Builder().build());
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

        public Builder unidad(final UnidadMedidaDTO unidadMedida) {
            this.unidadMedida = unidadMedida;
            return this;
        }

        public AbonoArbolAguacateDTO build() {
            return new AbonoArbolAguacateDTO(this);
        }
    }
}