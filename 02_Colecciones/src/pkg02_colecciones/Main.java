package pkg02_colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        //PruebasColecciones.ejemploSet();
        /*
        // Array genérico
        List<Cliente> listaClientes = new ArrayList<Cliente>(); // Conversión implicita
        // No se puede hacer "new" de List, porque es una interface.
        // Con la clase ArrayList, que hereda de esta, sí podemos.
        Cliente c;
        
        boolean salir = false;
        while(!salir){
        
        System.out.println("Elija la opción a la que desee acceder: ");
        System.out.println("01. Crear cliente.");
        System.out.println("02. Modificar cliente.");
        System.out.println("03. Listar clientes.");
        System.out.println("04. Eliminar cliente.");
        System.out.println("05. Salir.");
        int opcion = 0;
        Scanner escaner = new Scanner(System.in);
        opcion = escaner.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Nombre de cliente:");
                String nombre = escaner.nextLine();
                System.out.println("Correo de cliente:");
                String correo = escaner.nextLine();
                System.out.println("03. Listar clientes.");
                System.out.println("04. Eliminar cliente.");
                System.out.println("05. Salir.");
                listaClientes.add(new Cliente(1,"Pepe","pepito@gmail.com",1990,true,'M',"123456"));
                listaClientes.add(new Cliente(2,"Ana","anita@hotmail.com",1988,true,'F',"ana123"));
                listaClientes.add(new Cliente(3,"Jose","jose@hotmail.com",1985,true,'F',"345jose"));
                //crearCliente();
                break;
            case 2:
                
                //modificarCliente();
                System.out.println(" EDICIÓN: ");
                System.out.println("");
                int idModificar = 1;
                int idMod = idModificar -1;
                for (int i = 0; i<listaClientes.size();i++){
                    listaClientes.get(idMod).setNombre("Julian");
                    System.out.println("Cliente " + i + " : " + listaClientes.get(i).toString());
                }
                System.out.println(" ELEMENTO MODIFICADO: Cliente " + idMod);
                break;
            case 3:
                /*
                Iterator<Cliente> it = listaClientes.iterator();
                while(it.hasNext()){
                    c = it.next();
                    System.out.println(c.toString());
                }
                System.out.println(" - ");
                for (int i = 0; i<listaClientes.size();i++){
                    int h = i+1;
                    System.out.println("Cliente " + h + " : " + listaClientes.get(i).toString());
                }*/
                /*for (Cliente cliente: listaClientes){
                    System.out.println(cliente.toString());
                }
                //listarClientes();
                break;
            case 4:
                int idEliminar = 2;
                int idDelete = idEliminar -1;
                System.out.println(" ELEMENTO ELIMINADO: Cliente "+ idDelete);
                for (int i = 0; i<listaClientes.size();i++){
                    System.out.println("Cliente " + i + " : " + listaClientes.get(i).toString());
                    listaClientes.remove(idDelete);
                    
                }
                //eliminarClientes();
                break;
            case 5:
                salir = true;
                break;
            default:
                break;
            }
        }
                /*System.out.println(" EDICIÓN: ");
                System.out.println("");
                int idModificar = 1;
                int idMod = idModificar -1;
                for (int i = 0; i<listaClientes.size();i++){
                    
                    System.out.println("Cliente " + i + " : " + listaClientes.get(i).toString());
                    listaClientes.get(idMod).setNombre("Julian");
                }
                System.out.println(" ELEMENTO MODIFICADO: Cliente " + idMod);*/
                
                /*int idEliminar = 2;
                int idDelete = idEliminar -1;
                System.out.println(" ELEMENTO ELIMINADO: Cliente "+ idDelete);
                for (int i = 0; i<listaClientes.size();i++){
                    System.out.println("Cliente " + i + " : " + listaClientes.get(i).toString());
                    listaClientes.remove(idDelete);
                }*/
    }

/*    private static void crearCliente() {
        //listaClientes.add(new Cliente();
    }

    private static void modificarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void listarClientes() {
        
    }

    private static void eliminarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
}