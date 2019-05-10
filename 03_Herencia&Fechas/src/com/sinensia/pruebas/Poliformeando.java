/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

import com.sinensia.Cliente;
import com.sinensia.ClienteInvitado;
import com.sinensia.ClienteVIP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Admin
 */
public class Poliformeando {
    // VARIABLES ESTÁTICAS (GLOBALES)
    static ArrayList<Cliente> listaClientes;
    static TreeMap/*HashMap /*Funciona por clave y valor*/<String, Cliente> diccClientes;
    // Cambiamos de HashMap a TreeMap para que ordene las claves.
    
    public static void listas(){
        
        Cliente pepe = new Cliente(1,"Pepe","pepito@gmail.com",1990,true,'M',"123456");
        Cliente ana = new Cliente(2,"Ana","anita@hotmail.com",1988,true,'F',"ana123");
        ClienteInvitado joseI = new ClienteInvitado(3,"Jose","jose@hotmail.com",1985,true,'M',"345jose");
        joseI.setDuracionMax(44);
        Cliente jose = joseI;
        ClienteInvitado julioI = new ClienteInvitado(4,"Julio","julio@hotmail.com",1988,true,'F',"ana123");
        julioI.setDuracionMax(4);
        Cliente julio = julioI;
        ClienteVIP carmenV = new ClienteVIP(5,"Carmen","carmen@hotmail.com",1988,true,'F',"ana123");
        carmenV.setBeneficios("Muchos descuentos.");
        Cliente carmen = carmenV;
        
        
        // EJEMPLO ArrayList: Incluir 2 Clientes, 2 ClientesInvitados y 1 ClienteVIP. 
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(pepe);
        listaClientes.add(ana);
        listaClientes.add(jose);
        listaClientes.add(julio);
        //Añado VIP
        listaClientes.add(carmen);
        
        System.out.println("ARRAYLIST: ");
        //for (Cliente cliente: listaClientes){
        //      cliente.mostrar();
        for (int i = 0; i<listaClientes.size();i++){
                    listaClientes.get(i).mostrar();
                }
        System.out.println(" - ");
        
        // EJEMPLO HashMap: Incluir 2 Clientes, 2 ClientesInvitados y 1 ClienteVIP. 
        diccClientes = new TreeMap<String, Cliente>(); // Cambiamos de HashMap a TreeMap para que ordene las claves.
        
        System.out.println("HASHMAP: ");
        diccClientes.put("a1", pepe);
        diccClientes.put("b2", ana);
        diccClientes.put("c3", jose);
        diccClientes.put("d4", julio);
        diccClientes.put("e5", carmen);
        /*
        for (Cliente cliente: listaClientes){ //listaClientes proviene del ArrayList
            diccClientes.put(cliente.getNombre(), cliente);
        }*/
        
        for (Map.Entry<String, Cliente> parClaveValor: diccClientes.entrySet()){ //entrySet: Cada entrada es un objeto de tipo clave-valor, con un valor de tipo cliente.
                    System.out.println("Cliente: " + parClaveValor.getKey());
                    Cliente cliente = parClaveValor.getValue();
                    cliente.mostrar();
                    //o parClaveValor.getValue().mostrar();
                    
                    // parClaveValor.getKey(); // Devuelve la clave.
                    // parClaveValor.getValue(); // Devuelve el valor, que es un objeto del tipo cliente.
                }
        System.out.println(" - ");
        
        
        // EJEMPLO Array: Incluir 2 Clientes, 2 ClientesInvitados y 1 ClienteVIP.
        System.out.println("ARRAY: ");
        //Creamos un array de objetos de la clase empleados
        Cliente arrayClientes[]=new Cliente[5];
 
        //Creamos objetos en cada posicion
        arrayClientes[0]= pepe;
        arrayClientes[1]= ana;
        arrayClientes[2]= jose;
        arrayClientes[3]= julio;
        arrayClientes[4]= carmen;
 
        //Recorremos el array para mostrar datos
        
        for (int i=0;i<arrayClientes.length;i++){
                arrayClientes[i].mostrar();
        }
    }
    
    public static void modificarClienteHM(){
        System.out.println("");
        System.out.println("");
        System.out.println(" EDICIÓN: ");
                /*System.out.println("");
                int idModificar = 1;
                int idMod = idModificar -1;
                for (int i = 0; i<listaClientes.size();i++){
                    listaClientes.get(idMod).setNombre("Julian");
                    System.out.println("Cliente " + i + " : " + listaClientes.get(i).toString());
                }
                System.out.println(" ELEMENTO MODIFICADO: Cliente " + idMod);*/
        
        String claveAna = "b2";
        String claveJulio = "d4";
        String claveCarmen = "e5";
        for (Map.Entry<String, Cliente> parClaveValor: diccClientes.entrySet()){
            if (parClaveValor.getKey()==claveAna) {
                //System.out.println("(NOMBRE DE ANA CAMBIADO)");
                parClaveValor.getValue().setNombre("ANA ISABEL");
            } else if (parClaveValor.getKey()==claveJulio) {
                ClienteInvitado cI1 = (ClienteInvitado) parClaveValor.getValue();
                //System.out.println("(DURACIÓN MÁX DE JULIO CAMBIADA)");
                cI1.setDuracionMax(80000);
            } else if (parClaveValor.getKey()==claveCarmen){
                //System.out.println("(BENEFICIOS DE CARMEN CAMBIADOS)");
                ClienteVIP cV1 = (ClienteVIP) parClaveValor.getValue();
                cV1.setBeneficios("VARIOS BENEFICIOS.");
            }
            parClaveValor.getValue().mostrar();
        }
    }
    
    public static void modificarClienteHMporTipo(){
        System.out.println("");
        System.out.println("");
        System.out.println(" EDICIÓN POR TIPO DE CLIENTE: ");
        
        for (Map.Entry<String, Cliente> parClaveValor: diccClientes.entrySet()){
            parClaveValor.getValue().mostrar();
            
            if (parClaveValor.getValue() instanceof ClienteInvitado) { // Buscamos o reconocemos los clientes invitados.
                //parClaveValor.getValue().setFechaNac(parClaveValor.getValue().getFechaNac()+1);
                ClienteInvitado cI = (ClienteInvitado) parClaveValor.getValue(); // Ese cliente encontrado lo pasamos a invitado
                cI.setDuracionMax(cI.getDuracionMax()+1000); // Lo modificamos.
            
            } else if (parClaveValor.getValue() instanceof ClienteVIP) {
                //parClaveValor.getValue().setFechaNac(parClaveValor.getValue().getFechaNac()+1);
                ClienteVIP cV = (ClienteVIP) parClaveValor.getValue();
                cV.setBeneficios(cV.getBeneficios()+", BENEFICIOS AÑADIDOS!!");
            }
            System.out.println("");
            parClaveValor.getValue().mostrar();
            System.out.println("");
        }
    }
    
}
