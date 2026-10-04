package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class PodaArbolAguacateDTO {
    private UUID id;
    private ArbolAguacateDTO arbolAguacate;
    private PodaDTO poda;
    private LocalDate fechaPoda;

    private PodaArbolAguacateDTO(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setPoda(builder.poda);
        setFechaPoda(builder.fechaPoda);
    }

    public PodaDTO poda() {
        return poda;
    }

    private void setPoda( final PodaDTO poda) {
        this.poda = poda;
    }

    public LocalDate getFechaPoda() {
        return fechaPoda;
    }

    private void setFechaPoda(final LocalDate fechaPoda) {
        this.fechaPoda = fechaPoda;
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
        private PodaDTO poda;
        private LocalDate fechaPoda;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateDTO arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateDTO.Builder().build());
            return this;
        }

        public Builder poda(final PodaDTO poda) {
            this.poda = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(poda, new PodaDTO.Builder().build());
            return this;
        }

        public Builder fechaPoda(final LocalDate fechaPoda) {
            this.fechaPoda = UtilFecha.obtenerValorDefecto(fechaPoda);
            return this;
        }


        public PodaArbolAguacateDTO build() {
            return new PodaArbolAguacateDTO(this);
        }
    }
}