package com.sinensia.modelo;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    //private Integer id;
    private String nombre;
    private String email;
    private short edad;
    private short activo;
    private String password;

    public Cliente() {
    }

    public Cliente(String nombre, String email, short edad, short activo, String password) {
        
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.activo = activo;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "com.sinensia.modelo.Cliente[ id=" + 0 + ", "
                + nombre + ", "
                + email + ", "
                + password + ", "
                + edad + ", "
                + activo + "]";
    }
}
