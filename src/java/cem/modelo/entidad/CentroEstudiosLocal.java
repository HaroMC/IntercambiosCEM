package cem.modelo.entidad;

public class CentroEstudiosLocal extends Persona {
    
    private int rutPersona;
    private byte estaAcreditada;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public CentroEstudiosLocal() {
    }
    
    public CentroEstudiosLocal(int rutPersona, byte estaAcreditada) {
        this.rutPersona = rutPersona;
        this.estaAcreditada = estaAcreditada;
    }
    
    public CentroEstudiosLocal(int rutPersona, byte estaAcreditada, int rut,
            String nombreCompleto, String domicilio, String ciudad,
            String pais, String correo, String telefono, String tipo) {
        
        super (rut, nombreCompleto, domicilio, ciudad, pais, correo, telefono,
                tipo);
        
        this.rutPersona = rutPersona;
        this.estaAcreditada = estaAcreditada;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public int getRutPersona() {
        return rutPersona;
    }
    
    public byte getEstaAcreditada() {
        return estaAcreditada;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setEstaAcreditada(byte estaAcreditada) {
        this.estaAcreditada = estaAcreditada;
    }
    
    //</editor-fold>
    
}
