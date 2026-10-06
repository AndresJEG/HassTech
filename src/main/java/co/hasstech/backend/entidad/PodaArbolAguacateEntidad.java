package co.hasstech.backend.entidad;

import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class PodaArbolAguacateEntidad {
    private UUID id;
    private ArbolAguacateEntidad arbolAguacate;
    private PodaEntidad poda;
    private LocalDate fechaPoda;

    private PodaArbolAguacateEntidad(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setPoda(builder.poda);
        setFechaPoda(builder.fechaPoda);
    }

    public PodaEntidad poda() {
        return poda;
    }

    private void setPoda( final PodaEntidad poda) {
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

    public ArbolAguacateEntidad getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateEntidad arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }

    public static class Builder {
        private UUID id;
        private ArbolAguacateEntidad arbolAguacate;
        private PodaEntidad poda;
        private LocalDate fechaPoda;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateEntidad arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateEntidad.Builder().build());
            return this;
        }

        public Builder poda(final PodaEntidad poda) {
            this.poda = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(poda, new PodaEntidad.Builder().build());
            return this;
        }

        public Builder fechaPoda(final LocalDate fechaPoda) {
            this.fechaPoda = UtilFecha.obtenerValorDefecto(fechaPoda);
            return this;
        }


        public PodaArbolAguacateEntidad build() {
            return new PodaArbolAguacateEntidad(this);
        }
    }
}