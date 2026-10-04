package co.hasstech.backend.Entidad;

import co.hasstech.backend.transversal.utilitarios.UtilObjeto;

public class CompatibilidadEntidad {

    private PlagaEntidad plaga;
    private ProductoFitosanitarioEntidad productoFitosanitario;

    private CompatibilidadEntidad(final Builder builder){
        setPlaga(builder.plaga);
        setProductoFitosanitario(builder.productoFitosanitario);
    }


    public ProductoFitosanitarioEntidad getProductoFitosanitario() {
        return productoFitosanitario;
    }

    private void setProductoFitosanitario(ProductoFitosanitarioEntidad productoFitosanitario) {
        this.productoFitosanitario = productoFitosanitario;
    }

    public PlagaEntidad getPlaga() {
        return plaga;
    }

    private void setPlaga(PlagaEntidad plaga) {
        this.plaga = plaga;
    }


    public static class Builder{
        private PlagaEntidad plaga;
        private ProductoFitosanitarioEntidad productoFitosanitario;

        public Builder plaga (final PlagaEntidad plaga){
            this.plaga = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(plaga, new PlagaEntidad.Builder().build());
            return this;
        }

        public Builder productoFitosanitario (final ProductoFitosanitarioEntidad productoFitosanitario){
            this.productoFitosanitario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(productoFitosanitario, new ProductoFitosanitarioEntidad.Builder().build());
            return this;
        }

        public CompatibilidadEntidad build(){
            return new CompatibilidadEntidad(this);
        }
    }
}
