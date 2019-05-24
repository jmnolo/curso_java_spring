package com.sinensia.dao;

import com.sinensia.Entidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 * @param <T> el tipo T hereda de Entidad.
 */
public class ClaseDAO<T extends Entidad> implements InterfazDAO<T>{
    
    HashMap<Long, T> mapa;

    public ClaseDAO() {
        mapa = new HashMap<>();
    }
       
    @Override
    public void poner(T tipo) {
        if (tipo == null){
            System.err.println("No se pueden añadir nulos.");
            //return; // En caso de no poner else.
        } else {
            mapa.put(tipo.getId(), tipo);
        }
    }

    @Override
    public T leerUno(long id) {
        if (mapa.containsKey(id)){
            return mapa.get(id);
        } else {
            System.err.println("Clave no encontrada.");
            return null;
        }
    }

    @Override
    public List leerTodos() {
        List<T> listaProd = new ArrayList<>();
        for (Map.Entry<Long, T> parClaveValor: mapa.entrySet()){
            T tipo = parClaveValor.getValue();
            listaProd.add(tipo);
        }
        return listaProd;
    }

    @Override
    public void eliminar(T tipo) {
        if (tipo == null){
            System.err.println("No se pueden eliminar nulos.");
            //return; // En caso de no poner else.
        } else {
            mapa.remove(tipo.getId());
        }
    }

    @Override
    public void eliminar(long id) {
        T valor = mapa.get(id);
        if (valor.getId() != id){
            System.err.println("No se pueden eliminar nulos.");
            //return; // En caso de no poner else.
        } else if (valor.getId() == id) {
            mapa.remove(valor.getId());
        }
    }

    @Override
    public void modificar(T nuevoValor) {
        long idPro = nuevoValor.getId();
        //Producto pModif = new Producto(pro.getId(), "MODIF", 100, 20.8);
        if (nuevoValor == null){
            System.err.println("No se pueden modificar nulos.");
            //return; // En caso de no poner else.
        } else {
            //mapa.replace(idPro, pro, pModif);
            mapa.replace(idPro, nuevoValor);
        }
    }
    
}
