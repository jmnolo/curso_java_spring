/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

/**
 *
 * @author Admin
 */
public class TratamientoCadenas {

    public static void pruebasString() {
        System.out.println("****Tratamiento de Cadenas****");
        String quijote = "En un lugar de la Mancha...";
        if (quijote.contains("Mancha")) {
            System.out.println("Contiene Mancha.");
        }
        if (quijote.contains("mAnchA")) {
            System.out.println("Contiene mAnchA.");
        } else {
            System.out.println("No contiene mAnchA.");
        }

        if (quijote.toLowerCase().contains("mAnchA".toLowerCase())) { //Convertir a minúscula todo el texto.
            System.out.println("Contiene mAnchA. (toLowerCase-versión minúscula)");
        } else {
            System.out.println("No contiene mAnchA. (toLowerCase-versión minúscula)");
        }
        
        if (quijote.startsWith("En un lugar")){
            System.out.println("Comienza con \"En un lugar\".");
        }
        if (quijote.endsWith("Mancha...")){
            System.out.println("Termina con \"Mancha...\".");
        }
        
        System.out.println("charAt(6) = " + quijote.charAt(6)); // Séptimo caracter, empieza en 0.
        
        System.out.println(String.format("El texto '%s' tiene %d caracteres.", quijote, quijote.length()));
        // %s String, %d Entero, % Decimal.
        System.out.println(String.format("%f; %.3f; %.2f; %.0f; %f;", 1.1f, 2.2f, 3.3f, 4.4f, 5.5f)); //"%.3f" 3 decimales.

        System.out.println("Mancha está en la posición " + quijote.indexOf("Mancha"));
        
        if(!quijote.isEmpty()){
            System.out.println("Quijote NO está vacía.");
        }
        
        System.out.println("La última 'a' está en la posición " + quijote.lastIndexOf('a'));
        
        System.out.println("Trozo de cadena: " + quijote.substring(6, 14));
        
        String csv = "German, Antonio, Julian";
         // split() : En los ficheros CSV sirve para separar por comas.
        for(String nombre: csv.split(",")){
            System.out.println(" Nombre: " + nombre.trim()); // trim() : Quita los espacios laterales.
        }
        
        
        
        //************************************************************************************************
        //CompareTo:  Los String los compara por orden alfabético.
        /*
        String uno = "Aaa";
        String dos = "Adios";
            if (uno.compareTo(dos) < 0) { //El signo0 es como si lo pusieramos en medio de las dos cadenas.
                System.out.println(uno + " es menor que " + dos);
            } else if (uno.compareTo(dos) > 0) { //El signo0 es como si lo pusieramos en medio de las dos cadenas.
                System.out.println(uno + " es mayor que " + dos);
            } else {
                System.out.println("Son iguales.");
            }*/
        //************************************************************************************************
    }

}
