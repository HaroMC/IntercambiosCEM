package cem.modelo.entidad;

public class CentroEstudiosLocal extends Persona {
    
    private int rutPersona;
    private byte estaAcreditada;

    public CentroEstudiosLocal() {
    }

    public CentroEstudiosLocal(int rutPersona, byte estaAcreditada) {
        this.rutPersona = rutPersona;
        this.estaAcreditada = estaAcreditada;
    }

    public CentroEstudiosLocal(int rutPersona, byte estaAcreditada, int rut,
            String nombreCompleto,  String domicilio, String ciudad,
            String pais, String correo, String telefono, String tipo) {
        
        super(rut, nombreCompleto, domicilio, ciudad, pais, correo, telefono,
                tipo);
        this.rutPersona = rutPersona;
        this.estaAcreditada = estaAcreditada;
    }

    public int getRutPersona() {
        return rutPersona;
    }

    public byte getEstaAcreditada() {
        return estaAcreditada;
    }

    public void setRutPersona(int rutPersona) {
        this.rutPersona = rutPersona;
    }

    public void setEstaAcreditada(byte estaAcreditada) {
        this.estaAcreditada = estaAcreditada;
    }
    
    
}
