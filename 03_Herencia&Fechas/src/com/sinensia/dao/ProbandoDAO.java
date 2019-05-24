/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.dao;

import com.sinensia.Cliente;
import com.sinensia.Producto;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProbandoDAO {
    public static void probarCliente(){
        ClaseDAO<Cliente> repoCli = new ClaseDAO();  //Usando clase genérica.
        //ClienteDAO repoCli = new ClienteDAO();
        repoCli.poner(new Cliente(1, "uno", "uno@mail.com", 0, true, 'a', "uno"));
        repoCli.poner(new Cliente(2, "dos", "dos@mail.es", 0, true, 'b', "dos"));
        repoCli.poner(new Cliente(3, "tres", "tres@mail.es", 0, true, 'c', "tres"));
        System.out.println("Leyendo cliente nº 3: " + repoCli.leerUno(3));
        
        Cliente clModif = new Cliente(3, "cuatro", "cuatro@mail.es", 0, true, 'd', "cuatro");
        repoCli.modificar(clModif);
        System.out.println("Cliente modificado nº "+repoCli.leerUno(3).getId()+" : " + repoCli.leerUno(3)); //Si pones 4 no encuentra la clave.
        
        System.out.println("\n****LISTA DE CLIENTES****");
        List<Cliente> lista =
                repoCli.leerTodos();
        for (Cliente cliente: lista){
            System.out.println(cliente.toString());
        }
        
    }
    
    public static void probarProducto(){
        Producto pro1 = new Producto(1, "uno", 1000, 7.6);
        Producto pro2 = new Producto(2, "dos", 2000, 4.7);
        Producto pro3 = new Producto(3, "tres", 3000, 10.5);
        ProductoDAO repoPro = new ProductoDAO();
        repoPro.poner(pro1);
        repoPro.poner(pro2);
        repoPro.poner(pro3);
        
        System.out.println("Leyendo producto nº 2: " + repoPro.leerUno(2));
        
        Producto pModif = new Producto(2, "MODIF", 100, 20.8);
        repoPro.modificar(pModif);
        System.out.println("Producto modificado nº "+repoPro.leerUno(2).getId()+" : " + repoPro.leerUno(2)); //Si pones 4 no encuentra la clave.
        
        System.out.println("\n****Eliminar producto:****");
        System.out.println("Producto nº 1: " + repoPro.leerUno(1));
        repoPro.eliminar(1);
        System.out.println("Producto nº 1: " + repoPro.leerUno(1));
        
        System.out.println("\n****LISTA DE PRODUCTOS****");
        for (Producto producto: repoPro.leerTodos()){
            System.out.println(producto.toString());
        }
    }
}
