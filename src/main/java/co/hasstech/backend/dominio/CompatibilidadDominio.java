package co.hasstech.backend.dominio;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class CompatibilidadDominio {

    private PlagaDominio plaga;
    private ProductoFitosanitarioDominio productoFitosanitario;

    private CompatibilidadDominio(final Builder builder){
        setPlaga(builder.plaga);
        setProductoFitosanitario(builder.productoFitosanitario);
    }


    public ProductoFitosanitarioDominio getProductoFitosanitario() {
        return productoFitosanitario;
    }

    private void setProductoFitosanitario(ProductoFitosanitarioDominio productoFitosanitario) {
        this.productoFitosanitario = productoFitosanitario;
    }

    public PlagaDominio getPlaga() {
        return plaga;
    }

    private void setPlaga(PlagaDominio plaga) {
        this.plaga = plaga;
    }


    public static class Builder{
        private PlagaDominio plaga;
        private ProductoFitosanitarioDominio productoFitosanitario;

        public Builder plaga (final PlagaDominio plaga){
            this.plaga = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plaga, new PlagaDominio.Builder().build());
            return this;
        }

        public Builder productoFitosanitario (final ProductoFitosanitarioDominio productoFitosanitario){
            this.productoFitosanitario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(productoFitosanitario, new ProductoFitosanitarioDominio.Builder().build());
            return this;
        }

        public CompatibilidadDominio build(){
            return new CompatibilidadDominio(this);
        }
    }
}
