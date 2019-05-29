package com.sinensia.controladores;

import com.sinensia.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sinensia.modelo.logica.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;

/**
 *
 * @author Admin
 */
public class ControladorClientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Método común para procesar todo.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorClientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorClientes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

/*    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
*/    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request /*petición*/, HttpServletResponse response/*respuesta al cliente*/)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String nombre = request.getParameter("nombre_busq");  // A la petición se le pasa el nombre.
        nombre = nombre != null ? nombre : "";  // Si el nombre es distinto de null lo devuelve, si es null devuelve "".
        
        // Cookies: guardamos el nombre.
        Cookie galleta = new Cookie("nombre_busqueda", nombre); // Creamos la cookie en el lado del servidor.
        galleta.setMaxAge(10000); //Tiempo en el que el navegador guarda la cookie.
        // Añadimos la cookie a la respuesta:
        response.addCookie(galleta);
        
        ServicioClientes srvCli = new ServicioClientes();
        List<Cliente> listado = srvCli.obtenerTodos(); // Obtenemos todos los registros Cliente del servidor.
        List<Cliente> listaPorNombre = new ArrayList<>(); // Los filtramos por nombre.
        for (Cliente cliente : listado) {
            if (cliente.getNombre().contains(nombre)) {
                listaPorNombre.add(cliente);
            }
        }
        // Añadimos a la bolsa de sesión del usuario la petición por nombre.
        request.getSession().setAttribute("listaPorNombre", listaPorNombre); // Añade al controlador la lista por nombre.
                                                                            // listaPorNombre es el JavaBean (POJO SERIALIZABLE).
        // Redirige a este archivo, a la lista JSTL, para que se muestren las búsquedas.
        request.getRequestDispatcher("listado_jstl.jsp").forward(request, response);
        // Esta lista jsp devuelve una respuesta (objeto response) con código HTML
        // y con las cookies (directamente desde el servidor mediante JavaScript).

    }

// Las peticiones se utilizan para enviar datos al controlador para que vuelvan, sin que lleguen a la base de datos. (HashMap: clave-valor).
//Petición POST (CONECTAR-CREAR) debe ser mediante formulario (la información va en los paquetes HTTP, no aparecen en la URL).
//Petición GET (OBTENER) mediante URL (la información va en la URL).
//Petición PUT (MODIFICAR).
//Petición DELETE (ELIMINAR).
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);  No nos sirve porque mezcla la vista con el modelo.
        
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password_encrip");
        String edad = request.getParameter("edad");
        String activo = request.getParameter("activo");
        
        ServicioClientes servCli = new ServicioClientes();
        Cliente cli = servCli.insertar(nombre, email, password, edad, activo);
        if (cli == null) { // Redirecciona la petición:
            request.getRequestDispatcher("error_registro.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("registro_ok.jsp").forward(request, response);
        }
        
    }

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
