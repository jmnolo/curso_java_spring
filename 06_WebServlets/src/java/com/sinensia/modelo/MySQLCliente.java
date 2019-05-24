package com.sinensia.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MySQLCliente {
    public MySQLCliente(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            
        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);  
        } catch (ClassNotFoundException eCnf){
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Error de clase", eCnf);
        } catch (Exception e){
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Error general", e);
        }
    }
    
    public boolean crear(String nombre, String email, String password, int edad, boolean activo){
        try (Connection conex = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd_ventas?user=admin&password=Admin1234&useSSL=false&serverTimezone=UTC",
                "admin","Admin1234")){
            
            String sqlQuery = "INSERT INTO cliente (nombre, email, password, edad, activo) "+
                    "VALUES ( '"+nombre+"' , '"+email+"' , '"+password+"' , "+edad+" , "+ (activo ? "1" : "0") + " )";
                            // Las cadenas en SQL van con comillas simples.
                            // No tiene seguridad, debido por la concatenación de cadenas en la sentencia SQL.
                            // Habría que utilizar PrepareStatement.
            Statement sentencia = conex.createStatement();
            sentencia.executeUpdate(sqlQuery);
            return true;
            
        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLCliente.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
            return false;
        }
    }
    
}
