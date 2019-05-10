
package pkg02_colecciones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class PruebasColecciones {
    public static void ejemploHashMap(){
        HashMap /*Funciona por clave y valor*/<String, Cliente> diccClientes;
        diccClientes = new HashMap<String, Cliente>();
        
        Cliente Pepe = new Cliente(1,"Pepe","pepito@gmail.com",1990,true,'M',"123456");
        Cliente Ana = new Cliente(2,"Ana","anita@hotmail.com",1988,true,'F',"ana123");
        Cliente Jose = new Cliente(3,"Jose","jose@hotmail.com",1985,true,'M',"345jose");
        
        diccClientes.put("a1", Pepe);
        diccClientes.put("b2", Ana);
        diccClientes.put("c3", Jose);
        
        System.out.println("Ana: "+ diccClientes.get("b2").getNombre());
        
        if (!diccClientes.containsKey("b2")){
            diccClientes.put("b2", new Cliente(4,"Pedro","pedrolo@hotmail.com",2000,true,'M',"pedrolo"));
        }
        
        System.out.println("Ana??: "+ diccClientes.get("b2").getNombre());
        
        for (Map.Entry<String, Cliente> parClaveValor: diccClientes.entrySet()){
                    System.out.println("Cliente: " + parClaveValor.getKey());
                    Cliente cliente = parClaveValor.getValue();
                    System.out.println("Cliente: " + cliente.getNombre());
                }
    }
    
    
    public static void ejemploSet(){ //CONJUNTO, NO TIENE UN ORDEN Y NO SE PUEDEN REPETIR ELEMENTOS.
        // SORTEDSET: Se ordenan los elementos según los incluimos.
        HashSet<Cliente> conjuntoClientes = new HashSet<Cliente>();
        conjuntoClientes.add(new Cliente(4,"Pedro","pedrolo@hotmail.com",2000,true,'M',"pedrolo"));
        Cliente ollloo = new Cliente(9,"ollloo","ollloo@hotmail.com",9000,true,'M',"ollloo");
        conjuntoClientes.add(ollloo);
        conjuntoClientes.add(ollloo);
        //En el ArrayList tendríamos este elemento duplicado pero con el HashSet no.
        
        for (Cliente cli : conjuntoClientes){
            System.out.println(cli.getNombre());
        }
        /*
        Iterator<Cliente> iter = conjuntoClientes.iterator();
        while(iter.hasNext()){ //PREGUNTA SI HAY SIGUIENTE.
            Cliente cli = iter.next();
            System.out.println(cli.getNombre());
            
        }*/
    }
    
}
