package cem.modelo.entidad;

import java.util.ArrayList;
import java.util.Date;

public class FamiliaAnfitriona extends Persona {
    
    private short cantidadIntegrantes;
    private String estado;
    // Falta implementar HashMap para acceder más ráidamente a los elementos
    // del ArrayList.
    private ArrayList<Antecedente> antecedentes = new ArrayList<>();
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores ">
    
    public FamiliaAnfitriona() {
    }
    
    public FamiliaAnfitriona(short cantidadIntegrantes, String estado) {
        
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
        this.antecedentes = null;
    }
    
    public FamiliaAnfitriona(short cantidadIntegrantes, String estado,
            int rutPersona, String nombreCompleto, Date fechaNacimiento,
            String domicilio, String ciudad, String pais, String correo,
            String telefono, String tipo, ArrayList<Antecedente> antecedentes) {
        
        super(rutPersona, nombreCompleto, fechaNacimiento, domicilio, ciudad,
                pais, correo, telefono, tipo);
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
        this.antecedentes = antecedentes;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Accesadores ">
    
    public short getCantidadIntegrantes() {
        return cantidadIntegrantes;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public ArrayList<Antecedente> getAntecedentes() {
        return antecedentes;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Mutadores ">
    
    public void setCantidadIntegrantes(short cantidadIntegrantes) {
        this.cantidadIntegrantes = cantidadIntegrantes;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setAntecedentes(ArrayList<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return
                super.toString() +
                "Cantidad de integrantes : " + cantidadIntegrantes + "\n" +
                "Estado de inscripción   : " + estado + "\n";
    }
    
}
