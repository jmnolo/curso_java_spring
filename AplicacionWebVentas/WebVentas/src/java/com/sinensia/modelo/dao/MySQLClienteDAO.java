package com.sinensia.modelo.dao;

import com.sinensia.modelo.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MySQLClienteDAO implements InterfazDAO<Cliente> {

    public MySQLClienteDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
        } catch (ClassNotFoundException eCnf) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error de clase", eCnf);
        } catch (Exception e) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error general", e);
        }
    }

    @Override
    public Cliente insertar(Cliente cliente) {
        try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery = "INSERT INTO cliente (nombre, email, password, edad, activo) "
                    + "VALUES ( ?, ?, ?, ?, ? );";

            // Hay que utilizar PreparedStatement para mejorar la seguridad de los datos.
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);
            // Pasamos los valores:
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getEmail());
            sentencia.setString(3, cliente.getPassword());
            sentencia.setShort(4, cliente.getEdad());
            sentencia.setShort(5, cliente.getActivo());
            // Ejecutamos la sentencia:
            sentencia.executeUpdate();
            return cliente;

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
            return null;
        }
    }

    @Override
    public Cliente obtenerUno(Integer id) {

        try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery = "SELECT id, nombre, email, edad, activo, password FROM cliente WHERE id=?;";

            // Hay que utilizar PreparedStatement para mejorar la seguridad de los datos.
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);
            sentencia.setInt(1, id);

            ResultSet res = sentencia.executeQuery();

            Cliente clienteObtenido = null;
            while (res.next()) {
                String nombre = res.getString(2);
                String mail = res.getString(3);
                short edad = res.getShort(4);
                short activo = res.getShort(5);
                String password = res.getString(6);
                clienteObtenido = new Cliente(id, nombre, mail, edad, activo, password);
                
             }
            return clienteObtenido;

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
            return null;
        }
    }

    public Cliente obtenerUno(String email) {

        try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery = "SELECT id, nombre, email, edad, activo, password FROM cliente WHERE email=?;";

            // Hay que utilizar PreparedStatement para mejorar la seguridad de los datos.
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);
            sentencia.setString(1, email);

            ResultSet res = sentencia.executeQuery();

            Cliente clienteObtenido = null;
            while (res.next()) {
                int id = res.getInt(1);
                String nombre = res.getString(2);
                short edad = res.getShort(4);
                short activo = res.getShort(5);
                String password = res.getString(6);
                clienteObtenido = new Cliente(id, nombre, email, edad, activo, password);
                
             }
            return clienteObtenido;

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
            return null;
        }
    }

    @Override
    public List<Cliente> obtenerTodos() {

        try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery = "SELECT id, nombre, email, edad, activo, password FROM cliente;";

            // Hay que utilizar PreparedStatement para mejorar la seguridad de los datos.
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);

            List<Cliente> clientes = new ArrayList<Cliente>();
            // Ejecutamos la sentencia de resultado y la guardamos en ResultSet:
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                String email = res.getString("email");
                short edad = res.getShort("edad");
                short activo = res.getShort("activo");
                String password = res.getString("password");

                clientes.add(new Cliente(id, nombre, email, edad, activo, password));
            }

            return clientes;

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
            return null;
        }
    }

    @Override
    public void eliminar(Cliente cliente) {
        /*try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery = "SELECT id, nombre, email, edad, activo, password FROM cliente";

            // Hay que utilizar PreparedStatement para mejorar la seguridad de los datos.
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);

            List<Cliente> clientes = new ArrayList<Cliente>();
            // Ejecutamos la sentencia de resultado y la guardamos en ResultSet:
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                String email = res.getString("email");
                short edad = res.getShort("edad");
                short activo = res.getShort("activo");
                String password = res.getString("password");

                clientes.add(new Cliente(id, nombre, email, edad, activo, password));
            }

            clientes.remove(cliente);

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);

        }*/
        try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery = "DELETE FROM cliente WHERE id=?;";

            // Hay que utilizar PreparedStatement para mejorar la seguridad de los datos.
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);
            sentencia.setInt(1, cliente.getId());

            sentencia.executeUpdate();

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
                    }
    }

    @Override
    public void eliminar(Integer id) {
        
        try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery = "DELETE FROM cliente WHERE id=?;";

            // Hay que utilizar PreparedStatement para mejorar la seguridad de los datos.
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery);
            sentencia.setInt(1, id);

            sentencia.executeUpdate();

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
                    }
    }

    public void eliminar(String email) {
        eliminar(obtenerUno(email).getId());
    }

    @Override
    public Cliente modificar(Cliente nuevoValor) {
        try (Connection conex = DriverManager.getConnection(
                Constantes.CONEXION, Constantes.USUARIO, Constantes.PASSWORD)) {

            String sqlQuery2 = "UPDATE cliente SET nombre = ?, email = ?, edad = ?, activo = ?, password = ? WHERE id = ?;";
            PreparedStatement sentencia = conex.prepareStatement(sqlQuery2);
            // Pasamos los valores:
            sentencia.setString(1, nuevoValor.getNombre());
            sentencia.setString(2, nuevoValor.getEmail());
            sentencia.setShort(3, nuevoValor.getEdad());
            sentencia.setShort(4, nuevoValor.getActivo());
            sentencia.setString(5, nuevoValor.getPassword());
            sentencia.setInt(6, nuevoValor.getId());
            // Ejecutamos la sentencia:
            sentencia.executeUpdate();
            return nuevoValor;

        } catch (SQLException eSQL) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, "Error SQL", eSQL);
            return null;
        }
    }

}
