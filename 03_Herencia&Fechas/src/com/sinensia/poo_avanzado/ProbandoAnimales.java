/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.poo_avanzado;

import com.sinensia.Cliente;

/**
 *
 * @author Admin
 */
public class ProbandoAnimales {
    
    public static void probarAbstractas(){
        Animal unTucan = new Tucan("Turigualpa", 15.8f);
        unTucan.mover();
        
        Canario lolo = new Canario("Lolo", 1.2f);
        
        ((Tucan) unTucan).ponerHuevos();
        
        System.out.println(((Tucan) unTucan).esPadreDE(lolo));
        System.out.println(lolo.esPadreDE(((Tucan) unTucan)));
        
        /*Mascota miMascota = new Mascota(0, true, true, "nombre", 0) { // Implementa el método en la llamada al ser abstracta.
            @Override
            public void mover() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };*/
        Cliente c = new Cliente(20, "DUEÑA", "dueña@dueños.com", 1980, true, 'F', "9012732918");
        
        Animal michelangelo = new TortugaNinja("michelangelo", 175.5f); //Casting implicito.
        
        ((Mascota) michelangelo).setPropietario(c); //Casting explicito.
        ((Mascota) michelangelo).saludarAlPropietario();
        ((Mascota) michelangelo).pedirComida();
        
        michelangelo.mover(); //Como Java sabe que TortugaNinja tiene este método implementado y declarado en Animal no hace falta casting.
        michelangelo.comer();
        
        TortugaNinja michelangeloAnimalATortuga = ((TortugaNinja) michelangelo); //Casting explicito de Animal a TortugaNinja.
        michelangeloAnimalATortuga.cazar("PIZZA");
        try{
            michelangelo.volar(); //Aquí para el programa con la excepción.
        } catch (Exception ex) {
            // ex.getStackTrace(); // Pila de mensajes de error.
            System.err.println(ex.getMessage());
        } finally {
            System.out.println("Siempre me ejecuto. Cerramos recursos.\n"); // "\n SALTO DE LÍNEA +.
        }
        
        lolo.mover();
        lolo.volar();
        lolo.comer();
        lolo.ponerHuevos();
        Cangrejo sebastian = new Cangrejo("Sebastian",2.4f);
        sebastian.mover();
        try {
            sebastian.volar(); //Aquí para el programa con la excepción.
        } catch (UnsupportedOperationException ex) {
            System.err.println(ex.getMessage());
        }
        sebastian.comer();
        
    }
    
}
