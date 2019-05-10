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
        Canario lolo = new Canario("Lolo", 1.2f);
        unTucan.mover();
        ((Tucan) unTucan).ponerHuevos();
        System.out.println(((Tucan) unTucan).esPadreDE(lolo));
        
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
        
        michelangelo.volar(); //Aquí para el programa con la excepción.
        
        
        
        lolo.mover();
        lolo.volar(); 
        lolo.comer();
        lolo.ponerHuevos();
        Cangrejo sebastian = new Cangrejo("Sebastian",2.4f);
        sebastian.mover();
        sebastian.volar(); //Aquí para el programa con la excepción.
        sebastian.comer();
        
    }
    
}
