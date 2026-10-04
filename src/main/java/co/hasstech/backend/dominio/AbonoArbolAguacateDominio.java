package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;
import java.util.UUID;

public class AbonoArbolAguacateDominio {
    private UUID id;
    private ArbolAguacateDominio arbolAguacate;
    private AbonoDominio abono;
    private LocalDate fechaAbono;
    private float cantidad;
    private UnidadMedidaDominio unidadMedida;

    private AbonoArbolAguacateDominio(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setAbono(builder.abono);
        setFechaAbono(builder.fechaAbono);
        setCantidad(builder.cantidad);
        setUnidadMedida(builder.unidadMedida);
    }

    public UnidadMedidaDominio getUnidadMedida() {
        return unidadMedida;
    }

    private void setUnidadMedida( final UnidadMedidaDominio unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getCantidad() {
        return cantidad;
    }

    private void setCantidad(final float cantidad) {
        this.cantidad = cantidad;
    }

    public ArbolAguacateDominio getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateDominio arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }


    public AbonoDominio getAbono() {
        return abono;
    }

    private void setAbono( final AbonoDominio abono) {
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
        private ArbolAguacateDominio arbolAguacate;
        private AbonoDominio abono;
        private LocalDate fechaAbono;
        private float cantidad;
        private UnidadMedidaDominio unidadMedida;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateDominio arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateDominio.Builder().build());
            return this;
        }

        public Builder abono(final AbonoDominio abono) {
            this.abono= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(abono, new AbonoDominio.Builder().build());
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

        public Builder unidad(final UnidadMedidaDominio unidadMedida) {
            this.unidadMedida = unidadMedida;
            return this;
        }

        public AbonoArbolAguacateDominio build() {
            return new AbonoArbolAguacateDominio(this);
        }
    }
}