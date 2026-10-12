package co.hasstech.backend.negocio.negocio.reglas;

public interface Rule <O>{

    void ejecutar(O... datos);

}
