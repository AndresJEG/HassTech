package co.hasstech.backend.Entidad;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import java.util.UUID;

public class ComposicionEntidad {
    private UUID id;
    private AbonoEntidad abono;
    private ElementoQuimicoEntidad elementoQuimico;
    private float concentracion;
    private UnidadMedidaEntidad unidadMedida;

    private ComposicionEntidad(final Builder builder) {
        setId(builder.id);
        setAbono(builder.abono);
        setElementoQuimico(builder.elementoQuimico);
        setConcentracion(builder.concentracion);
        setUnidadMedida(builder.unidadMedida);
    }

    public UnidadMedidaEntidad getUnidadMedida() {
        return unidadMedida;
    }

    private void setUnidadMedida( final UnidadMedidaEntidad unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getConcentracion() {
        return concentracion;
    }

    private void setConcentracion(final float concentracion) {
        this.concentracion = concentracion;
    }

    public AbonoEntidad getAbono() {
        return abono;
    }

    private void setAbono(final AbonoEntidad abono) {
        this.abono = abono;
    }

    public ElementoQuimicoEntidad getElementoQuimico() {
        return elementoQuimico;
    }

    private void setElementoQuimico( final ElementoQuimicoEntidad elementoQuimico) {
        this.elementoQuimico = elementoQuimico;
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public static class Builder {
        private UUID id;
        private AbonoEntidad abono;
        private ElementoQuimicoEntidad elementoQuimico;
        private float concentracion;
        private UnidadMedidaEntidad unidadMedida;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder abono(final AbonoEntidad abono) {
            this.abono = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(abono, new AbonoEntidad.Builder().build());
            return this;
        }

        public Builder elementoQuimico(final ElementoQuimicoEntidad elementoQuimico) {
            this.elementoQuimico = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(elementoQuimico, new ElementoQuimicoEntidad.Builder().build());
            return this;
        }

        public Builder concentracion(final float concentracion) {
            this.concentracion = UtilDecimal.obtenerValorDefecto(concentracion);
            return this;
        }

        public Builder unidadMedida(final UnidadMedidaEntidad unidadMedida) {
            this.unidadMedida = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(unidadMedida, new UnidadMedidaEntidad.Builder().build());
            return this;
        }

        public ComposicionEntidad build() {
            return new ComposicionEntidad(this);
        }
    }
}