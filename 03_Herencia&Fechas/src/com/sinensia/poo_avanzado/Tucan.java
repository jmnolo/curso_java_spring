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
public class Tucan extends AnimalSalvaje implements Ave {

    public Tucan(String nombre, float tamanho) {
        super(2, true, false, nombre, tamanho); // Introducimos el resto de datos en el super();

    }

    @Override
    public void mover() {
        System.out.println(nombre + ": Volando va!");
    }

    @Override
    public void volar() {
        System.out.println(nombre + ": Vuela!");
    }

    @Override
    public void comer() {
        System.out.println(nombre + ": Lo que pilla.");
    }

    @Override
    public void ponerHuevos() {
        System.out.println(nombre + " pone bastantes huevos.");
    }

    @Override
    public String esPadreDE(Ave ave) {
        /*if(ave instanceof Animal){
                Animal anim = (Animal) ave;
                return nombre+" es padre de "+ anim.getNombre();
            }
            return "";*/
        
        return nombre+" es padre de "+ave.nombrar();

        // Opción profesor:
        //return nombre + " es padre de " + ave.toString();
    }

    @Override
    public String nombrar() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
