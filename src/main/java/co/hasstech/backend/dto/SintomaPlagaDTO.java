package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class SintomaPlagaDTO {
    private UUID id;
    private PlagaDTO plaga;
    private SintomaDTO sintoma;
    private String observacion;

    private SintomaPlagaDTO(final Builder builder) {
        setId(builder.id);
        setPlaga(builder.plaga);
        setSintoma(builder.sintoma);
        setObservacion(builder.observacion);
    }

    public PlagaDTO plaga() {
        return plaga;
    }

    private void setPlaga( final PlagaDTO plaga) {
        this.plaga = plaga;
    }

    public SintomaDTO sintoma() {
        return sintoma;
    }

    private void setSintoma(final SintomaDTO sintoma) {
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
        private SintomaDTO sintoma;
        private PlagaDTO plaga;
        private String observacion;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder sintoma(final SintomaDTO sintoma) {
            this.sintoma = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sintoma, new SintomaDTO.Builder().build());
            return this;
        }

        public Builder plaga(final PlagaDTO plaga) {
            this.plaga = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plaga, new PlagaDTO.Builder().build());
            return this;
        }

        public Builder observacion(final String observacion) {
            this.observacion = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(observacion);
            return this;
        }


        public SintomaPlagaDTO build() {
            return new SintomaPlagaDTO(this);
        }
    }
}