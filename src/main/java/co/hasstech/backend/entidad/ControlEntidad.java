package co.hasstech.backend.entidad;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;

public class ControlEntidad {
    private PlagaArbolAguacateEntidad plagaArbolAguacate;
    private CompatibilidadEntidad compatibilidadPlaguicida;
    private LocalDate fechaAplicacion;

    private ControlEntidad(final Builder builder){
        setCompatibilidadPlaguicida(builder.compatibilidadPlaguicida);
        setPlagaArbolAguacate(builder.plagaArbolAguacate);
        setFechaAplicacion(builder.fechaAplicacion);
    }

    public PlagaArbolAguacateEntidad getPlagaArbolAguacate() {
        return plagaArbolAguacate;
    }

    private void setPlagaArbolAguacate(PlagaArbolAguacateEntidad plagaArbolAguacate) {
        this.plagaArbolAguacate = plagaArbolAguacate;
    }

    public CompatibilidadEntidad getCompatibilidadPlaguicida() {
        return compatibilidadPlaguicida;
    }

    private void setCompatibilidadPlaguicida(CompatibilidadEntidad compatibilidadPlaguicida) {
        this.compatibilidadPlaguicida = compatibilidadPlaguicida;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    private void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public static class Builder {
        private PlagaArbolAguacateEntidad plagaArbolAguacate;
        private CompatibilidadEntidad compatibilidadPlaguicida;
        private LocalDate fechaAplicacion;

        public Builder plagaArbolAguacate(final PlagaArbolAguacateEntidad plagaArbolAguacate){
            this.plagaArbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plagaArbolAguacate, new PlagaArbolAguacateEntidad.Builder().build());
            return this;
        }

        public Builder compatibilidad(final CompatibilidadEntidad compatibilidadPlaguicida){
            this.compatibilidadPlaguicida = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(compatibilidadPlaguicida, new CompatibilidadEntidad.Builder().build());
            return this;
        }

        public ControlEntidad build(){
            return new ControlEntidad(this);
        }
    }
}
