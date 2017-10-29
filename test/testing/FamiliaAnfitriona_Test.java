package testing;

import cem.controlador.dao.DaoEntidades;
import cem.modelo.entidad.FamiliaAnfitriona;
import java.util.ArrayList;

public class FamiliaAnfitriona_Test {
    
    public static void main(String[] args) {
        
        DaoEntidades dao = new DaoEntidades();
        
        ArrayList<FamiliaAnfitriona> listado = dao.listarFamilias();
        
        if (!listado.isEmpty()) {
            listado.forEach((fa) -> {
                System.out.println(fa.toString());
            });
        }
    }
}
