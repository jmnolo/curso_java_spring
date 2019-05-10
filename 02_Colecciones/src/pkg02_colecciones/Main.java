package pkg02_colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        PruebasColecciones.ejemploHashMap();
        PruebasColecciones.ejemploSet();
        
        // ArrayList 
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        
        listaClientes.add(new Cliente(1,"Pepe","pepito@gmail.com",1990,true,'M',"123456"));
        listaClientes.add(new Cliente(2,"Ana","anita@hotmail.com",1988,true,'F',"ana123"));
        listaClientes.add(new Cliente(3,"Jose","jose@hotmail.com",1985,true,'F',"345jose"));
                
    
		}
}