/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Funciones {

    static File fichRutaRelativa;

    public static void lecturaFich(String tF) {

        HashMap<Long, Cliente> diccClientes = new HashMap<Long, Cliente>();

        fichRutaRelativa = new File(tF);
        Scanner escaner = null;
        try {
            System.out.println("Leyendo fichero.");
            escaner = new Scanner(fichRutaRelativa);

            while (escaner.hasNextLine()) { // Busca hasta el siguiente salto de línea.
                String linea = escaner.nextLine();
                System.out.println(">>>>>> " + linea);

                try {
                    String data[] = linea.split(",");
                    Cliente c;
                    if (data.length == 7 || data.length == 8) { //Esto elimina las líneas que no tengan 7 u 8 datos.
                        System.out.println(data[0]);
                        long id = Integer.valueOf(data[0]);
                        int fecha = Integer.parseInt(data[3]);
                        //boolean activo = Boolean.valueOf(data[4]);
                        //boolean activo = data[4].equals("true") ? true : false;

                    // Si tiene 7 datos es Cliente y si tiene 8 ClienteInvitado.
                        if (data.length == 7) {
                            c = new Cliente(id, data[1], data[2], fecha, vOf(data[4]), data[5].charAt(0), data[6]);
                            diccClientes.put(c.getId(), c);
                        } else if (data.length == 8 && esNumerico(data[7]) == true) {
                            c = new ClienteInvitado(id, data[1], data[2], fecha, vOf(data[4]), data[5].charAt(0), data[6]);
                            ((ClienteInvitado) c).setDuracionMax(Integer.parseInt(data[7]));
                            diccClientes.put(c.getId(), c);
                        } else if (data.length == 8 && esNumerico(data[7]) == false) {
                            c = new ClienteVIP(id, data[1], data[2], fecha, vOf(data[4]), data[5].charAt(0), data[6]);
                            ((ClienteVIP) c).setBeneficios(data[7]);
                            diccClientes.put(c.getId(), c);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Mensaje de error: " + ex.getMessage());
                }
                //diccClientes.put(Long.toString(c.getId()), c);
            }
            for (Map.Entry<Long, Cliente> parClaveValor : diccClientes.entrySet()) {
                System.out.println("Cliente: " + parClaveValor.getKey());
                Cliente cliente = parClaveValor.getValue();
                System.out.println("Cliente: " + cliente.getNombre());
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

    public static boolean vOf(String texto) {
        if ("true".equals(texto)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esNumerico(String cadena) {

        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
