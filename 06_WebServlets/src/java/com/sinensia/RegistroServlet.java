package com.sinensia;

import com.google.gson.Gson;
import com.sinensia.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sinensia.modelo.MySQLCliente;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RegistroServlet extends HttpServlet { // Tiene que heredar de Servlet

    /*@Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
    throws ServletException, IOException 
    //Hacer lo que tenemos que hacer en la petición GET del HTML.
    {
        respuesta.setContentType("text/html;charset=UTF-8");
        try (PrintWriter salida = respuesta.getWriter()){ //Otra manera de hacer el try sin catch y sin close().
            salida.println("<html><head>");
            salida.println("<title>Web servlet desde Java</title>");
            salida.println("</head><body>");
            salida.println("<h1>Respuesta al registro</h1>");
            salida.println("<h2>Ruta del servlet: "+peticion.getContextPath()+", método: "+peticion.getMethod()+"</h2>");
            salida.println("<ul>");
            for(int i=0; i<3; i++){
                salida.println("<li>Num "+ i +"</li>");
            }
            salida.println("</ul>");
            
            String nombre = peticion.getParameter("nombre");  // Obtenemos los parámetros del HTML.
            String strEdad = peticion.getParameter("edad");
            int edad = Integer.parseInt(strEdad);
            String email = peticion.getParameter("email");
            String strActivo = peticion.getParameter("activo");  // Valores: on - null.
            boolean activo = strActivo != null; // No haría falta incluir el "? true : false;" o "==null ? false : true;"
            // Esto es igual a: if(strActivo != null) { activo = true };
            
            salida.println("<p>Nombre = "+nombre+"</p>");  // Mostramos los valores incluidos en el HTML.
            salida.println("<p>Edad = "+edad+"</p>");
            salida.println("<p>Email = "+email+"</p>");
            salida.println("<p>Activo = "+activo+"</p>");
            
            // Incluimos este cliente en la BBDD SQL:
            MySQLCliente bdCliente = new MySQLCliente();
            //bdCliente.crear(nombre, email, "0000"+nombre, edad, activo);
            if (bdCliente.crear(nombre, email, "0000"+nombre, edad, activo)) {
                salida.println("<p>Guardado correctamente.</p>");
            } else {
                salida.println("<p>Guardado ERRONEAMENTE.</p>");
            }
                    
                    
            salida.println("</body></html>");
            salida.println("");
            salida.println("");
        }
    }*/
    /**
     * API REST Handles the HTTP <code>POST</code> method.
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
        
        
        BufferedReader buffer = request.getReader();
        StringBuilder sb = new StringBuilder();
        String s;
        while((s = buffer.readLine()) != null){
            sb.append(s);
            System.out.println(s);
        }
        //java json to object (G)
        Gson gson = new Gson(); //Se crea un objeto JSON con la librería de Google
        Cliente c = gson.fromJson(sb.toString(), Cliente.class);
        
        
        /*BufferedReader reader = request.getReader(); //Se toma la fuente de datos de la solicitud
        Gson gson = new Gson(); //Se crea un objeto JSON con la librería de Google
        Cliente c = gson.fromJson(reader, Cliente.class); //Se instancia la clase Data como un objeto JSON que apunta a la fuente de datos
        
        //Se imprimen los datos dentro del JSON
        System.out.println("Nombre: " + c.getNombre());
        System.out.println("Edad: " + c.getEdad());
        System.out.println("País: " + c.getEmail());*/
        
        //Modificamos:
        c.setNombre(c.getNombre().toUpperCase());
        c.setEmail(c.getEmail().toUpperCase());

        PrintWriter salida1 = response.getWriter();
        String gsonCli = new Gson().toJson(/*cliente*/c);
        salida1.print(gsonCli);

    }

    @Override
    public String getServletInfo() {
        return "Registro clientes.";
    }

    public static String leeBuffer(BufferedReader buffer) /*throws Exception*/ {

        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = buffer.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
