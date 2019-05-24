package com.sinensia.dao;

import com.sinensia.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ClienteDAO implements InterfazDAO<Cliente>{
    
    HashMap<Long, Cliente> mapa;
    
    public ClienteDAO() {
        mapa = new HashMap<>();
    }
    
    @Override
    public void poner(Cliente cli){
        if (cli == null){
            System.err.println("No se pueden añadir nulos.");
            //return; // En caso de no poner else.
        } else {
            mapa.put(cli.getId(), cli);
        }
    }
    
    @Override
    public Cliente leerUno(long id){
        if (mapa.containsKey(id)){
            return mapa.get(id);
        } else {
            System.err.println("Clave no encontrada.");
            return null;
        }     
    }

    @Override
    public void eliminar(Cliente cli) {
        if (cli == null){
            System.err.println("No se pueden eliminar nulos.");
            //return; // En caso de no poner else.
        } else {
            mapa.remove(cli.getId());
        }
    }

    @Override
    public void eliminar(long id) {
        Cliente cli = mapa.get(id);
        if (cli.getId() != id){
            System.err.println("No se pueden eliminar nulos.");
            //return; // En caso de no poner else.
        } else if (cli.getId() == id) {
            mapa.remove(cli.getId());
        }
    }

    @Override
    public List<Cliente> leerTodos() {
        List<Cliente> listaC = new ArrayList<>();
        for (Map.Entry<Long, Cliente> parClaveValor: mapa.entrySet()){
            Cliente cliente = parClaveValor.getValue();
            listaC.add(cliente);
        }
        return listaC;
    }

    @Override
    public void modificar(Cliente nuevoCliente) {
        long idCli = nuevoCliente.getId();
        if (nuevoCliente == null){
            System.err.println("No se pueden modificar nulos.");
            //return; // En caso de no poner else.
        } else {
            //mapa.replace(idPro, pro, pModif);
            mapa.replace(idCli, nuevoCliente);
        }
        /*Cliente cli = mapa.get(nuevoCliente.getId());
        cli.setActivo(nuevoCliente.isActivo());
        cli.setEmail(nuevoCliente.getEmail());
        cli.setNombre(nuevoCliente.getNombre());*/
    }
    
}