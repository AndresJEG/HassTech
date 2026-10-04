package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;

public class ControlDominio {
    private PlagaArbolAguacateDominio plagaArbolAguacate;
    private CompatibilidadDominio compatibilidadPlaguicida;
    private LocalDate fechaAplicacion;

    private ControlDominio(final Builder builder){
        setCompatibilidadPlaguicida(builder.compatibilidadPlaguicida);
        setPlagaArbolAguacate(builder.plagaArbolAguacate);
        setFechaAplicacion(builder.fechaAplicacion);
    }

    public PlagaArbolAguacateDominio getPlagaArbolAguacate() {
        return plagaArbolAguacate;
    }

    private void setPlagaArbolAguacate(PlagaArbolAguacateDominio plagaArbolAguacate) {
        this.plagaArbolAguacate = plagaArbolAguacate;
    }

    public CompatibilidadDominio getCompatibilidadPlaguicida() {
        return compatibilidadPlaguicida;
    }

    private void setCompatibilidadPlaguicida(CompatibilidadDominio compatibilidadPlaguicida) {
        this.compatibilidadPlaguicida = compatibilidadPlaguicida;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    private void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public static class Builder {
        private PlagaArbolAguacateDominio plagaArbolAguacate;
        private CompatibilidadDominio compatibilidadPlaguicida;
        private LocalDate fechaAplicacion;

        public Builder plagaArbolAguacate(final PlagaArbolAguacateDominio plagaArbolAguacate){
            this.plagaArbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plagaArbolAguacate, new PlagaArbolAguacateDominio.Builder().build());
            return this;
        }

        public Builder compatibilidad(final  CompatibilidadDominio compatibilidadPlaguicida){
            this.compatibilidadPlaguicida = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(compatibilidadPlaguicida, new CompatibilidadDominio.Builder().build());
            return this;
        }

        public ControlDominio build(){
            return new ControlDominio(this);
        }
    }
}
