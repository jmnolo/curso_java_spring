package com.sinensia.pruebas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Ficheros {

    public static void probandoEscritura() throws IOException {
        String[] lineasTexto = {"Línea primera",
            "Línea segunda",
            "Línea tercera"};

        FileWriter fichero = null;
        try {
            fichero = new FileWriter("Fichero_Texto.txt", false); // Si ponemos true añade líneas al archivo creado antes.
            for (String linea : lineasTexto) {
                fichero.write(linea + "\r\n"); //\r para salto de línea en Windows.
            }
            fichero.write("FIN DE FICHERO\r\n");
            //fichero.close(); // Cierra el fichero y guarda el texto incluido.
            // Este close() sobra porque el fichero siempre se cierra desde el finally.
        } catch (IOException ex) {
            System.err.println("Mensaje de error: " + ex.getMessage());
        } finally {
            fichero.close();
            // Por si falla en alguna entrada de texto que se guarde lo que haya escrito hasta ese momento sí o sí.
            System.out.println("FICHERO CERRADO.");
        }
    }

    public static void escrituraSream() throws IOException {
        String[] lineasTexto = {"Línea primera",
            "Línea segunda",
            "Línea tercera"};
        Writer out = null;
        try {
            FileOutputStream streamFich;
            streamFich = new FileOutputStream("fich_2.txt");
            OutputStreamWriter streamWriter = new OutputStreamWriter(streamFich, "UTF-8");
            out = new BufferedWriter(streamWriter);
            for (String linea : lineasTexto) {
                try {
                    out.write(linea + "\r\n"); //\r para salto de línea en Windows.
                } catch (IOException ex) {
                    System.out.println("Error al escribir fichero: " + ex.getMessage());
                }
            }
            out.write("FIN DE FICHERO\r\n");

        } catch (UnsupportedEncodingException | FileNotFoundException ex2) {
            System.out.println("ERROR 2: " + ex2.getMessage());
        } finally {
            try {
                out.close();
                System.out.println("FICHERO STREAM CERRADO.");
            } catch (IOException ioEx) {
                System.out.println("ERROR EN CIERRE DE FICHERO: " + ioEx.getMessage());
            }
        }
    }

    public static void lecturaFich() {
        File ficheroFormWin = new File("C:\\Users\\Admin\\Desktop\\CURSO_JAVA\\03_Herencia&Fechas\\Fichero_Texto.txt");
        // En Unix se pone la barra /. Windows utiliza la contrabarra (doble).
        File ficheroFormJava = new File("C:/Users/Admin/Desktop/CURSO_JAVA/03_Herencia&Fechas/Fichero_Texto.txt");
        // Java Multiplataforma: barra normal.
        File fichRutaRelativa = new File("Fichero_Texto.txt");
        Scanner escaner = null;
        try {
            System.out.println("Leyendo fichero.");
            escaner = new Scanner(ficheroFormWin);
            while (escaner.hasNextLine()) { // Busca hasta el siguiente salto de línea.
                String linea = escaner.nextLine();
                System.out.println(">>>>>> " + linea);
                //CompareTo:  Los String los compara por orden alfabético.
                if (linea.compareTo("Línea segunda") < 0) { //El signo0 es como si lo pusieramos en medio de las dos cadenas.
                    System.out.println(linea + " es menor que Linea segunda");
                } else if (linea.compareTo("Línea segunda") > 0) { //El signo0 es como si lo pusieramos en medio de las dos cadenas.
                    System.out.println(linea + " es mayor que Linea segunda");
                } else {
                    System.out.println("Son iguales.");
                }
                //________________________________________________________
            }
            

        } catch (FileNotFoundException ex) {
            System.out.println("Mensajes: " + ex.getMessage());
        } finally {
            try {
                if (escaner != null) {
                    escaner.close();
                }
            } catch (Exception e) {
                System.out.println("Mensaje de error al cerrar: " + e.getMessage());
            }
        }
    }

}
