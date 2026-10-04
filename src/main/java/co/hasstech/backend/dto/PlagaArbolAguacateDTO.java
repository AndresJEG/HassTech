package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class PlagaArbolAguacateDTO {
    private UUID id;
    private ArbolAguacateDTO arbolAguacate;
    private PlagaDTO plaga;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private PlagaArbolAguacateDTO(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setPlaga(builder.plaga);
        setFechaInicio(builder.fechaInicio);
        setFechaFin(builder.fechaFin);
    }

    public PlagaDTO plaga() {
        return plaga;
    }

    private void setPlaga( final PlagaDTO plaga) {
        this.plaga = plaga;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    private void setFechaInicio(final LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    private void setFechaFin(final LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public ArbolAguacateDTO getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateDTO arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }

    public static class Builder {
        private UUID id;
        private ArbolAguacateDTO arbolAguacate;
        private PlagaDTO plaga;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateDTO arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateDTO.Builder().build());
            return this;
        }

        public Builder plaga(final PlagaDTO plaga) {
            this.plaga= UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plaga, new PlagaDTO.Builder().build());
            return this;
        }

        public Builder fechaInicio(final LocalDate fechaInicio) {
            this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
            return this;
        }

        public Builder fechaFin(final LocalDate fechaFin) {
            this.fechaFin = UtilFecha.obtenerValorDefecto(fechaFin);
            return this;
        }

        public PlagaArbolAguacateDTO build() {
            return new PlagaArbolAguacateDTO(this);
        }
    }
}
