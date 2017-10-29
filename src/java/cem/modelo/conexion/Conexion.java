package cem.modelo.conexion; 

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
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
    
    private static  Properties dbPropiedades;
    private static String url;
    private static Driver dbControlador;
    
    static {
        try {
            
            dbPropiedades = new Properties();
            dbPropiedades.load(new FileInputStream("./src/java/cem/modelo/conexion/OracleJDBC.properties"));
            
            // This will load all the properties (i.e. key=value) from the
            // .properties file from the current working directory.
            dbControlador = (Driver) Class.forName(dbPropiedades.getProperty("DriverClassName")).newInstance();
            //This will return the value of url, if not found return null.
            url = dbPropiedades.getProperty("url");
            
            
           /*Class.forName("com.mysql.jdbc.Driver").newInstance();
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema", "root","avaras08");*/
            
            
        }
        catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | IOException ex) {
            
            Logger.getLogger(Conexion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection abrir() throws SQLException {
        return dbControlador.connect(url, dbPropiedades);
    }
    
    public static void cerrar(Connection c, PreparedStatement ps,
            CallableStatement cs, ResultSet rs)
            throws SQLException {
        
        if (c != null) {
            c.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (cs != null) {
            cs.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
}
