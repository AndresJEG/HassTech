package co.hasstech.backend.Entidad;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class SintomaPlagaEntidad {
    private UUID id;
    private PlagaEntidad plaga;
    private SintomaEntidad sintoma;
    private String observacion;

    private SintomaPlagaEntidad(final Builder builder) {
        setId(builder.id);
        setPlaga(builder.plaga);
        setSintoma(builder.sintoma);
        setObservacion(builder.observacion);
    }

    public PlagaEntidad plaga() {
        return plaga;
    }

    private void setPlaga( final PlagaEntidad plaga) {
        this.plaga = plaga;
    }

    public SintomaEntidad sintoma() {
        return sintoma;
    }

    private void setSintoma(final SintomaEntidad sintoma) {
        this.sintoma = sintoma;
    }

    public String getObservacion() {
        return observacion;
    }

    private void setObservacion(final String observacion) {
        this.observacion = observacion;
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public static class Builder {
        private UUID id;
        private SintomaEntidad sintoma;
        private PlagaEntidad plaga;
        private String observacion;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder sintoma(final SintomaEntidad sintoma) {
            this.sintoma = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sintoma, new SintomaEntidad.Builder().build());
            return this;
        }

        public Builder plaga(final PlagaEntidad plaga) {
            this.plaga = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plaga, new PlagaEntidad.Builder().build());
            return this;
        }

        public Builder observacion(final String observacion) {
            this.observacion = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(observacion);
            return this;
        }


        public SintomaPlagaEntidad build() {
            return new SintomaPlagaEntidad(this);
        }
    }
}