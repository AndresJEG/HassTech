package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import java.util.UUID;

public class ComposicionDTO {
    private UUID id;
    private AbonoDTO abono;
    private ElementoQuimicoDTO elementoQuimico;
    private float concentracion;
    private UnidadMedidaDTO unidadMedida;

    private ComposicionDTO(final Builder builder) {
        setId(builder.id);
        setAbono(builder.abono);
        setElementoQuimico(builder.elementoQuimico);
        setConcentracion(builder.concentracion);
        setUnidadMedida(builder.unidadMedida);
    }

    public UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    private void setUnidadMedida( final UnidadMedidaDTO unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getConcentracion() {
        return concentracion;
    }

    private void setConcentracion(final float concentracion) {
        this.concentracion = concentracion;
    }

    public AbonoDTO getAbono() {
        return abono;
    }

    private void setAbono(final AbonoDTO abono) {
        this.abono = abono;
    }

    public ElementoQuimicoDTO getElementoQuimico() {
        return elementoQuimico;
    }

    private void setElementoQuimico( final ElementoQuimicoDTO elementoQuimico) {
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
        private AbonoDTO abono;
        private ElementoQuimicoDTO elementoQuimico;
        private float concentracion;
        private UnidadMedidaDTO unidadMedida;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder abono(final AbonoDTO abono) {
            this.abono = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(abono, new AbonoDTO.Builder().build());
            return this;
        }

        public Builder elementoQuimico(final ElementoQuimicoDTO elementoQuimico) {
            this.elementoQuimico = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(elementoQuimico, new ElementoQuimicoDTO.Builder().build());
            return this;
        }

        public Builder concentracion(final float concentracion) {
            this.concentracion = UtilDecimal.obtenerValorDefecto(concentracion);
            return this;
        }

        public Builder unidadMedida(final UnidadMedidaDTO unidadMedida) {
            this.unidadMedida = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(unidadMedida, new UnidadMedidaDTO.Builder().build());
            return this;
        }

        public ComposicionDTO build() {
            return new ComposicionDTO(this);
        }
    }
}