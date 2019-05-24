/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.genericos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ProbandoGenericos {
    
    public static void probandoMetodo() {
        int num = 10;
        Integer objNum = new Integer(10); // Clase Integer, crea objetos.
        String texto = objNum.toString();
        
        ArrayList<Integer> listaInt = new ArrayList<>();
        insertarDoble(listaInt, 10);
        insertarDoble(listaInt, 15);
        System.out.println("Enteros: "+listaInt.toString());
        
        ArrayList<String> listaStr = new ArrayList<>();
        insertarDoble(listaStr, "Texto1");
        insertarDoble(listaStr, "Texto2");
        System.out.println("Cadenas de texto: "+listaStr.toString());
        
        ArrayList<Date> listaDate = new ArrayList<>();
        insertarDobleGenerico(listaDate, new Date(95, 6, 2));
        insertarDobleGenerico(listaDate, new Date(97, 10, 2));
        System.out.println("Fechas: "+listaDate.toString());
        
        System.out.println("CON MÉTODO GENÉRICO");
        // CON MÉTODO GENÉRICO:
        ArrayList<Float> listaFloat = new ArrayList<>();
        insertarDobleGenerico(listaFloat, 3.5f);
        insertarDobleGenerico(listaFloat, 10.9f);
        System.out.println("Números decimales (con Método Genérico): "+listaFloat.toString());
        
    }
    
    public static void insertar(ArrayList<Integer> lista, int valor) {
        lista.add(valor);
    }
    
    // El código de estos tres métodos es el mismo, por lo que debemos de utilizar los MÉTODOS GENÉRICOS.
    public static void insertarDoble(ArrayList<Integer> lista, int valor) {
        lista.add(valor);
        lista.add(valor);
    }
    public static void insertarDoble(ArrayList<String> lista, String valor) {
        lista.add(valor);
        lista.add(valor);
    }  
    public static void insertarDoble(ArrayList<Date> lista, Date valor) {
        lista.add(valor);
        lista.add(valor);
    }
    // MÉTODO GENÉRICO:
    public static<Tipo> void insertarDobleGenerico(ArrayList<Tipo> lista, Tipo valor) {
        lista.add(valor);
        lista.add(valor);
    }
    
}
