package com.sinensia.api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Admin
 */
// Decoradores en forma de anotación (PATRON DE DISEÑO).
@WebServlet( asyncSupported = true, urlPatterns = "/api/productos" )
public class ProductoRestController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        PrintWriter escritorRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        // Coge de un flujo:
        BufferedReader bufRead = request.getReader();
        StringBuilder textoJson = new StringBuilder();
        //String textoJson = "";
        // for (Inicializas; límite o fin; incremento)
        for (String lineaJson = bufRead.readLine(); lineaJson != null; lineaJson=bufRead.readLine()){
            //textoJson += lineaJson;
            textoJson.append(lineaJson);
        }
        //http://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html
        Gson g = new Gson();
        Producto p = g.fromJson(textoJson.toString().toUpperCase(), Producto.class);

        String gsonProd = g.toJson(p);
        
        bufRead.close();
        
        escritorRespuesta.println(gsonProd/*textoJson.toString().toUpperCase()*/);
        System.out.println(textoJson.toString().toUpperCase());
    }
}