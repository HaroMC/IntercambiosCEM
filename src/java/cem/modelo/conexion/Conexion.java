package cem.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion = null;
    
    private String driver = "oracle.jdbc.OracleDriver";
    private String dbName = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "cem";
    private String password = "portafolioCaso1";

    public Conexion() {
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(dbName, user, password);
        }
        catch (ClassNotFoundException | SQLException | InstantiationException
                | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public Connection abrir() {
        return conexion;
    }

    public void cerrar() throws SQLException {
        conexion.close();
    }
    
}
