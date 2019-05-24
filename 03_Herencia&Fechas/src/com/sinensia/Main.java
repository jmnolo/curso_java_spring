package com.sinensia;

import com.sinensia.dao.ProbandoDAO;
import com.sinensia.genericos.ProbandoGenericos;
import com.sinensia.poo_avanzado.ProbandoAnimales;
import com.sinensia.pruebas.Herencia;
import com.sinensia.pruebas.Fechas;
import com.sinensia.pruebas.Ficheros;
import com.sinensia.pruebas.Polimorfismo;
import com.sinensia.pruebas.Poliformeando;
import com.sinensia.pruebas.TratamientoCadenas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TratamientoCadenas.pruebasString();
        System.out.println("");
        
        try {
            Ficheros.probandoEscritura();
            Ficheros.escrituraSream();
            Ficheros.lecturaFich();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }   
            //ProbandoGenericos.probandoMetodo();
            /*System.out.println("");
            ProbandoDAO.probarCliente();
            System.out.println("");
            ProbandoDAO.probarProducto();
            System.out.println("");*/
            /*ProbandoAnimales.probarAbstractas();
            Poliformeando.listas();
            Poliformeando.modificarClienteHMporTipo();
            /*Polimorfismo.polimorfismo();
            System.out.println("--");
            Fechas.probar();
            System.out.println("--");
            Herencia.probandoHerencia();*/
        
        //COMPARACION DE OBJETOS:
        /*Cliente c1 = new Cliente(0, "nombre", "email1", 0, true, '0', "password");
        Cliente c2 = new Cliente(0, "nombre", "email2", 0, true, '0', "password");
        if (c1.compareTo(c2)<0){
            System.out.println("C1 es menor que C2.");
        } else {
            System.out.println("C1 es mayor que C2.");
        }*/
    }
        
}