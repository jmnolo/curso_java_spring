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
public class ClienteVIP extends Cliente{
    
    public ClienteVIP(long id, String nombre, String email, int fechaNac, boolean activo, char genero, String password) {
        super(id, nombre, email, fechaNac, activo, genero, password);
    }
    
    private String beneficios;

    public ClienteVIP(String beneficios, long id, String nombre, String email, int fechaNac, boolean activo, char genero, String password) {
        super(id, nombre, email, fechaNac, activo, genero, password);
        this.beneficios = beneficios;
    }
        
        

    /**
     * Get the value of beneficios
     *
     * @return the value of beneficios
     */
    public String getBeneficios() {
        return beneficios;
    }

    /**
     * Set the value of beneficios
     *
     * @param beneficios new value of beneficios
     */
    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    @Override // Sobreescritura del método mostrar.
    public void mostrar(){
        System.out.println("Cliente VIP:"); 
        super.mostrar(); // Llama al método mostrar del padre.
        System.out.println(" Beneficios: "+ beneficios);
    }
}
