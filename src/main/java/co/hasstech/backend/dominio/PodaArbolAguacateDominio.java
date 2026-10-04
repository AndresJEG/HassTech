package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilFecha;
import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.util.UUID;

public class PodaArbolAguacateDominio {
    private UUID id;
    private ArbolAguacateDominio arbolAguacate;
    private PodaDominio poda;
    private LocalDate fechaPoda;

    private PodaArbolAguacateDominio(final Builder builder) {
        setId(builder.id);
        setArbolAguacate(builder.arbolAguacate);
        setPoda(builder.poda);
        setFechaPoda(builder.fechaPoda);
    }

    public PodaDominio poda() {
        return poda;
    }

    private void setPoda( final PodaDominio poda) {
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

    public ArbolAguacateDominio getArbolAguacate() {
        return arbolAguacate;
    }

    private void setArbolAguacate(final ArbolAguacateDominio arbolAguacate) {
        this.arbolAguacate = arbolAguacate;
    }

    public static class Builder {
        private UUID id;
        private ArbolAguacateDominio arbolAguacate;
        private PodaDominio poda;
        private LocalDate fechaPoda;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder arbolAguacate(final ArbolAguacateDominio arbolAguacate) {
            this.arbolAguacate = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(arbolAguacate, new ArbolAguacateDominio.Builder().build());
            return this;
        }

        public Builder poda(final PodaDominio poda) {
            this.poda = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(poda, new PodaDominio.Builder().build());
            return this;
        }

        public Builder fechaPoda(final LocalDate fechaPoda) {
            this.fechaPoda = UtilFecha.obtenerValorDefecto(fechaPoda);
            return this;
        }


        public PodaArbolAguacateDominio build() {
            return new PodaArbolAguacateDominio(this);
        }
    }
}