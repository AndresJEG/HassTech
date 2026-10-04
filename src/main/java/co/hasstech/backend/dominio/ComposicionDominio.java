package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilDecimal;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import java.util.UUID;

public class ComposicionDominio {
    private UUID id;
    private AbonoDominio abono;
    private ElementoQuimicoDominio elementoQuimico;
    private float concentracion;
    private UnidadMedidaDominio unidadMedida;

    private ComposicionDominio(final Builder builder) {
        setId(builder.id);
        setAbono(builder.abono);
        setElementoQuimico(builder.elementoQuimico);
        setConcentracion(builder.concentracion);
        setUnidadMedida(builder.unidadMedida);
    }

    public UnidadMedidaDominio getUnidadMedida() {
        return unidadMedida;
    }

    private void setUnidadMedida( final UnidadMedidaDominio unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getConcentracion() {
        return concentracion;
    }

    private void setConcentracion(final float concentracion) {
        this.concentracion = concentracion;
    }

    public AbonoDominio getAbono() {
        return abono;
    }

    private void setAbono(final AbonoDominio abono) {
        this.abono = abono;
    }

    public ElementoQuimicoDominio getElementoQuimico() {
        return elementoQuimico;
    }

    private void setElementoQuimico( final ElementoQuimicoDominio elementoQuimico) {
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
        private AbonoDominio abono;
        private ElementoQuimicoDominio elementoQuimico;
        private float concentracion;
        private UnidadMedidaDominio unidadMedida;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder abono(final AbonoDominio abono) {
            this.abono = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(abono, new AbonoDominio.Builder().build());
            return this;
        }

        public Builder elementoQuimico(final ElementoQuimicoDominio elementoQuimico) {
            this.elementoQuimico = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(elementoQuimico, new ElementoQuimicoDominio.Builder().build());
            return this;
        }

        public Builder concentracion(final float concentracion) {
            this.concentracion = UtilDecimal.obtenerValorDefecto(concentracion);
            return this;
        }

        public Builder unidadMedida(final UnidadMedidaDominio unidadMedida) {
            this.unidadMedida = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(unidadMedida, new UnidadMedidaDominio.Builder().build());
            return this;
        }

        public ComposicionDominio build() {
            return new ComposicionDominio(this);
        }
    }
}