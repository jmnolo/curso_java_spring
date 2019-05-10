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
public class Canario extends Mascota implements Ave {

    public Canario(String nombre, float tamanho) {
        super(2, true, false, nombre, tamanho);
    }

    @Override
    public void mover() {
        System.out.println(nombre+": vuela o lo intenta.");
    }

    @Override
    public void volar() {
        System.out.println(nombre+": Sabe volar pero no puede.");
    }

    @Override
    public void comer() {
        System.out.println(nombre+": Come pienso.");
    }

    @Override
    public void saludarAlPropietario() {
        System.out.println("PIO PIO "+propietario.getNombre());
    }

    @Override
    public void ponerHuevos() {
        System.out.println("Pone huevos vacíos.");
    }

    @Override
    public String esPadreDE(Ave ave) {
        return nombre+" es padre de "+ave.nombrar();
    }

    @Override
    public String nombrar() {
        return nombre;
    }
    
    
    
}
