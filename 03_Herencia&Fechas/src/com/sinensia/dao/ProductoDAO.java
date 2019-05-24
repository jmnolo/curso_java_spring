package com.sinensia.dao;

import com.sinensia.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ProductoDAO implements InterfazDAO<Producto> {
    HashMap<Long, Producto> mapa;
    
    public ProductoDAO() {
        mapa = new HashMap<>();
    }
    
    @Override
    public void poner(Producto pro){
        if (pro == null){
            System.err.println("No se pueden añadir nulos.");
            //return; // En caso de no poner else.
        } else {
            mapa.put(pro.getId(), pro);
        }
    }
    
    @Override
    public Producto leerUno(long id){
        if (mapa.containsKey(id)){
            return mapa.get(id);
        } else {
            System.err.println("Clave no encontrada.");
            return null;
        }     
    }

    @Override
    public void eliminar(Producto pro) {
        if (pro == null){
            System.err.println("No se pueden eliminar nulos.");
            //return; // En caso de no poner else.
        } else {
            mapa.remove(pro.getId());
        }
    }

    @Override
    public void eliminar(long id) {
        Producto pro = mapa.get(id);
        if (pro.getId() != id){
            System.err.println("No se pueden eliminar nulos.");
            //return; // En caso de no poner else.
        } else if (pro.getId() == id) {
            mapa.remove(pro.getId());
        }
    }

    @Override
    public List<Producto> leerTodos() {
        List<Producto> listaProd = new ArrayList<>();
        for (Map.Entry<Long, Producto> parClaveValor: mapa.entrySet()){
            Producto producto = parClaveValor.getValue();
            listaProd.add(producto);
        }
        return listaProd;
    }

    @Override
    public void modificar(Producto nuevoPro) {
        long idPro = nuevoPro.getId();
        if (nuevoPro == null){
            System.err.println("No se pueden modificar nulos.");
            //return; // En caso de no poner else.
        } else {
            mapa.replace(idPro, nuevoPro);
        }
        
        
    }
}
