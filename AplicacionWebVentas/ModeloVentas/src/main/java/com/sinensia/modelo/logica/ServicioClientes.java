package com.sinensia.modelo.logica;

import com.sinensia.modelo.Cliente;
//import com.sinensia.modelo.dao.InterfazDAO;
//import com.sinensia.modelo.dao.ClienteDAO;
import com.sinensia.modelo.dao.MySQLClienteDAO;

/**
 *
 * @author Admin
 *
 * Sirve para recibir los datos de la web e incluirlos en la base de datos, sin
 * id.
 */
public class ServicioClientes {

    //private ClienteDAO dao;
    private MySQLClienteDAO dao;

    public ServicioClientes() {
        //dao = new ClienteDAO();
        dao = new MySQLClienteDAO();
    }

    // Todos los datos de la web vienen como String.
    public Cliente insertar(String nombre, String email, String passwd, String edad, String activo) {

        if (validar(nombre, email, passwd, edad, activo)) {
            short iEdad = Short.parseShort(edad);
            short iActivo = (short) ("on".equals(activo) ? 1 : 0);
            Cliente nuevoCli = new Cliente(null, nombre, email, iEdad, iActivo, passwd);
            // DATA ACCES OBJECT (DAO)
            nuevoCli = dao.insertar(nuevoCli);
            return nuevoCli;
        } else {
            return null;
        }
    }

    public Cliente obtenerUno(int id) {
        return dao.obtenerUno(id);
    }

    public Cliente obtenerUno(String email) {
        //TODO: Implementar en el DAO.
        /*for (Cliente c : dao.obtenerTodos()) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;*/
        return dao.obtenerUno(email);
    }

    public boolean validar(String nombre, String email, String passwd, String edad, String activo) {
        if (nombre == null || nombre.equals("")) {
            return false;
        }
        if (email == null || email.equals("")) {
            return false;
        }
        if (passwd == null || passwd.equals("")) {
            return false;
        }
        short iEdad = 0;
        try { // Para evitar que insertemos un campo no numérico.
            iEdad = Short.parseShort(edad);
        } catch (NumberFormatException e) {
            return false;
        }
        if (iEdad <= 0) {
            return false;
        }
        short iActivo = (short) ("on".equals(activo) ? 1 : 0);
        // Si ponemos activo.equals("on") puede cerrar el programa ya que el otro valor
        // de activo es null.
        // TODO: Faltan ciertas validaciones.
        return true;
    }

    public Cliente modificar(int id, String nombre, String email, String passwd, String edad, String activo) /*throws Exception*/ {

        Cliente cli = null;
        if (validar(nombre, email, passwd, edad, activo)) {
                short iActivo = (short) ("on".equals(activo) ? 1 : 0);
            cli = new Cliente(id, nombre, email, Short.parseShort(edad), iActivo, passwd);

            cli = dao.modificar(cli);
        }/* else {
            throw new Exception("Validación errónea en cliente");
        }*/

        return cli;
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public void eliminar(String email) {
        eliminar(obtenerUno(email).getId());
    }
}
