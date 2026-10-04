package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;
import co.hasstech.backend.transversal.utilitarios.UtilUUID;
import co.hasstech.backend.transversal.utilitarios.UtilTexto;

import java.util.UUID;

public class SintomaPlagaDominio {
    private UUID id;
    private PlagaDominio plaga;
    private SintomaDominio sintoma;
    private String observacion;

    private SintomaPlagaDominio(final Builder builder) {
        setId(builder.id);
        setPlaga(builder.plaga);
        setSintoma(builder.sintoma);
        setObservacion(builder.observacion);
    }

    public PlagaDominio plaga() {
        return plaga;
    }

    private void setPlaga( final PlagaDominio plaga) {
        this.plaga = plaga;
    }

    public SintomaDominio sintoma() {
        return sintoma;
    }

    private void setSintoma(final SintomaDominio sintoma) {
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
        private SintomaDominio sintoma;
        private PlagaDominio plaga;
        private String observacion;

        public Builder id(final UUID id) {
            this.id= UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder sintoma(final SintomaDominio sintoma) {
            this.sintoma = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sintoma, new SintomaDominio.Builder().build());
            return this;
        }

        public Builder plaga(final PlagaDominio plaga) {
            this.plaga = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plaga, new PlagaDominio.Builder().build());
            return this;
        }

        public Builder observacion(final String observacion) {
            this.observacion = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(observacion);
            return this;
        }


        public SintomaPlagaDominio build() {
            return new SintomaPlagaDominio(this);
        }
    }
}