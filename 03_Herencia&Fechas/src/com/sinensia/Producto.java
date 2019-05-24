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
public class Producto extends Entidad {
    //private long id; // Obtiene el ID de Entidad.
    private String nombre;
    private int stock;
    private double precio;

    /*public Producto() {
    }*/

    public Producto(long id, String nombre, int stock, double precio) {
        super(id); //Llamamos al padre y eliminamos los métodos get y set.
        //this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + '}';
    }
    
}
