package com.sinensia.controladores;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.logica.ServicioClientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author Admin
 */
public class ClientesControladorREST extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * API REST Handles the HTTP <code>PUT</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter salida = response.getWriter()) {
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String password = request.getParameter("password_encrip");
            String edad = request.getParameter("edad");
            String activo = request.getParameter("activo");

            ServicioClientes servCli = new ServicioClientes();

            Cliente cli = servCli.obtenerUno(email);
            /*String jsonCli = " { "; // Para la salida (response.getWriter()).
            if (cli != null) {
                cli = servCli.modificar(cli.getId(), nombre, email, password, edad, activo);
                if (cli != null) {
                    jsonCli += "   \"id\" : \"" + cli.getId() + "\"";
                    jsonCli += " , \"nombre\" : \"" + cli.getNombre() + "\"";
                    jsonCli += " , \"email\" : \"" + cli.getEmail() + "\"";
                    jsonCli += " , \"edad\" : \"" + cli.getEdad() + "\"";
                    jsonCli += " , \"password\" : \"" + cli.getPassword() + "\"";
                    jsonCli += " , \"activo\" : \"" + cli.getActivo() + "\"";
                }
            }
            jsonCli += "}";
            salida.print(jsonCli); //LO HACEMOS CON GSON MÁS ABAJO.
            System.out.println(">>>>>>" + jsonCli);*/

            // Con GSON:
            // https://jarroba.com/gson-json-java-ejemplos/
            // https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/
            cli = servCli.modificar(cli.getId(), nombre, email, password, edad, activo);
            String gsonCli = new Gson().toJson(cli);
            salida.print(gsonCli);
            
            /* Proceso contrario
            Gson gson = new Gson();
            Cliente[] clientes = gson.fromJson(gsonCli,
                    Cliente[].class);

            for (Cliente cliente : clientes) {
                //salida.print(cliente.getNombre());
                System.out.println(cliente.toString());
            }*/
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
