package co.hasstech.backend.negocio.fachada.assembler;

import java.util.List;

public interface DTOAssembler <D, E>{

    E convertirADTO(D dominio);
    D convertirADominio(E DTO);
    List<E> convertirADTO (List<D> listaDominios);

}