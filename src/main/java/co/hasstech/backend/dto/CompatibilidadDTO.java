package co.hasstech.backend.dto;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class CompatibilidadDTO {

    private PlagaDTO plaga;
    private ProductoFitosanitarioDTO productoFitosanitario;

    private CompatibilidadDTO(final Builder builder){
        setPlaga(builder.plaga);
        setProductoFitosanitario(builder.productoFitosanitario);
    }


    public ProductoFitosanitarioDTO getProductoFitosanitario() {
        return productoFitosanitario;
    }

    private void setProductoFitosanitario(ProductoFitosanitarioDTO productoFitosanitario) {
        this.productoFitosanitario = productoFitosanitario;
    }

    public PlagaDTO getPlaga() {
        return plaga;
    }

    private void setPlaga(PlagaDTO plaga) {
        this.plaga = plaga;
    }


    public static class Builder{
        private PlagaDTO plaga;
        private ProductoFitosanitarioDTO productoFitosanitario;

        public Builder plaga (final PlagaDTO plaga){
            this.plaga = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plaga, new PlagaDTO.Builder().build());
            return this;
        }

        public Builder productoFitosanitario (final ProductoFitosanitarioDTO productoFitosanitario){
            this.productoFitosanitario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(productoFitosanitario, new ProductoFitosanitarioDTO.Builder().build());
            return this;
        }

        public CompatibilidadDTO build(){
            return new CompatibilidadDTO(this);
        }
    }
}
