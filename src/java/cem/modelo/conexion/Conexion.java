package cem.modelo.conexion; 

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    //<editor-fold defaultstate="collapsed" desc=" Método de conexión 1 ">
    
    private Connection conexion = null;
    
    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "cem",
                    "portafolioCaso1"
            );
        }
        catch (ClassNotFoundException | SQLException |
                InstantiationException | IllegalAccessException ex) {
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
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Método de conexión 2 ">
    /*
    private static Properties dbPropiedades;
    private static String url;
    private static Driver dbDriver;
    
    static {
        try {
            dbPropiedades = new Properties();
            
            String dbUrl           = "jdbc:oracle:thin:@localhost:1521:XE";
            String driverClassName = "oracle.jdbc.OracleDriver";
            String user            = "cem";
            String password        = "portafolioCaso1";
            
            dbPropiedades.setProperty("url", dbUrl);
            dbPropiedades.setProperty("DriverClassName", driverClassName);
            dbPropiedades.setProperty("user", user);
            dbPropiedades.setProperty("password", password);
            
            dbDriver = (Driver) Class.forName(dbPropiedades
                    .getProperty("DriverClassName"))
                    .newInstance();
            
            url = dbPropiedades.getProperty("url");
        }
        catch (ClassNotFoundException | IllegalAccessException |
                InstantiationException e) {
        }
    }
    
    public static Connection openConnection()
            throws SQLException {
        return dbDriver.connect(url, dbPropiedades);
    }
    
    public static void closeConnection(Connection c, PreparedStatement ps,
            ResultSet rs)
            throws SQLException {
        
        if (c != null) {
            c.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
    */
    //</editor-fold>
}
