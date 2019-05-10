/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

/**
 *
 * @author Admin
 */
public class ClienteInvitado extends Cliente {
    
    public ClienteInvitado(long id, String nombre, String email, int fechaNac, boolean activo, char genero, String password) {
        super(id, nombre, email, fechaNac, activo, genero, password);
    }
    
        private int duracionMax;

    /**
     * Get the value of duracionMax
     *
     * @return the value of duracionMax
     */
    public int getDuracionMax() {
        return duracionMax;
    }

    /**
     * Set the value of duracionMax
     *
     * @param duracionMax new value of duracionMax
     */
    public void setDuracionMax(int duracionMax) {
        this.duracionMax = duracionMax;
    }

    @Override // Sobreescritura del método mostrar.
    public void mostrar(){
        System.out.println("Cliente Invitado:"); // +nombre : Al ser protected se puede acceder desde la clase hijo.
        super.mostrar(); // Llama al método mostrar del padre.
        System.out.println(" Duración Máxima: "+ duracionMax);
    }
    
}
