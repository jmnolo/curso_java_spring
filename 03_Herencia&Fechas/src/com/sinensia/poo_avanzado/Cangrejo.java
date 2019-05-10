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
public class Cangrejo extends AnimalSalvaje {

    public Cangrejo(String nombre, float tamanho) {
        super(8, true, false, nombre, tamanho);
    }

    @Override
    public void mover() {
        System.out.println(nombre+": Se mueve para detrás.");
    }

    @Override
    public void comer() {
        System.out.println(nombre+": Come palitos de cangrejo.");
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException("No vuela."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
