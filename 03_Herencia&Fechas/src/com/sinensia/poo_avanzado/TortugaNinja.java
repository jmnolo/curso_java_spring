/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.poo_avanzado;

/**
 *
 * @author Admin
 */
public class TortugaNinja extends Mascota implements Depredador {

    public TortugaNinja(String nombre, float tamanho) {
        super(4, true, true, nombre, tamanho); // Como ya sabemos 3 propiedades no hace falta incluirlas en el constructor.
    }

    @Override
    public void mover() {
        System.out.println(nombre + ": Salto de edificios.");
    }

    @Override
    public void comer() {
        System.out.println(nombre+ ": Come pizzas.");
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException("No vuela."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saludarAlPropietario() {
        System.out.println("EHHHH "+propietario.getNombre());
    }

    @Override
    public void cazar(String presa) {
        System.out.println("Le gusta cazar... "+presa);
    }
    
    
}
