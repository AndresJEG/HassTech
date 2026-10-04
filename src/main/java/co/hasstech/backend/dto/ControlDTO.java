package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

import java.time.LocalDate;

public class ControlDTO {
    private PlagaArbolAguacateDTO plagaArbolAguacate;
    private CompatibilidadDTO compatibilidadPlaguicida;
    private LocalDate fechaAplicacion;

    private ControlDTO(final Builder builder){
        setCompatibilidadPlaguicida(builder.compatibilidadPlaguicida);
        setPlagaArbolAguacate(builder.plagaArbolAguacate);
        setFechaAplicacion(builder.fechaAplicacion);
    }

    public PlagaArbolAguacateDTO getPlagaArbolAguacate() {
        return plagaArbolAguacate;
    }

    private void setPlagaArbolAguacate(PlagaArbolAguacateDTO plagaArbolAguacate) {
        this.plagaArbolAguacate = plagaArbolAguacate;
    }

    public CompatibilidadDTO getCompatibilidadPlaguicida() {
        return compatibilidadPlaguicida;
    }

    private void setCompatibilidadPlaguicida(CompatibilidadDTO compatibilidadPlaguicida) {
        this.compatibilidadPlaguicida = compatibilidadPlaguicida;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    private void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public static class Builder {
        private PlagaArbolAguacateDTO plagaArbolAguacate;
        private CompatibilidadDTO compatibilidadPlaguicida;
        private LocalDate fechaAplicacion;

        public Builder plagaArbolAguacate(final PlagaArbolAguacateDTO plagaArbolAguacate){
            this.plagaArbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plagaArbolAguacate, new PlagaArbolAguacateDTO.Builder().build());
            return this;
        }

        public Builder compatibilidad(final CompatibilidadDTO compatibilidadPlaguicida){
            this.compatibilidadPlaguicida = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(compatibilidadPlaguicida, new CompatibilidadDTO.Builder().build());
            return this;
        }

        public ControlDTO build(){
            return new ControlDTO(this);
        }
    }
}
