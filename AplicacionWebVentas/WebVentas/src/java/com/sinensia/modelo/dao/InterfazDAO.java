package com.sinensia.modelo.dao;

import java.util.List;

/**
 * Interfaz Data Access Object para toda la app (Operaciones de acceso a datos).
 * @author Admin
 * @param <T> Entidad para interfaz DAO
 */
public interface InterfazDAO<T> {
    
    T insertar(T valor);
    T obtenerUno(Integer id);
    List<T> obtenerTodos();
    void eliminar(T valor);
    void eliminar(Integer id);
    T modificar(/*Integer id,*/ T nuevoValor);
}
