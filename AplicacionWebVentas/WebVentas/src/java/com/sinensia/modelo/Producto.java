package com.sinensia.modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Producto extends Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    //private Integer id;
    private String nombre;
    private int cantidad;
    private long precio;
    private List<Compra> compraList;
    

    public Producto() {
    }

    public Producto(Integer id) {
        super(id);
    }

    public Producto(Integer id, String nombre, int cantidad, long precio) {
        super(id);
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sinensia.modelo.Producto[ id=" + id + ", "
                + nombre + ", "
                + cantidad + ", "
                + precio + "]";
    }
}
