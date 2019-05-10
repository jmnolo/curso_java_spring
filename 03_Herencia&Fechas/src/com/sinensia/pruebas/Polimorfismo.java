/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

import com.sinensia.Cliente;
import com.sinensia.ClienteInvitado;
import com.sinensia.ClienteVIP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Polimorfismo {
    public static void polimorfismo() {
        ClienteInvitado invitado = new ClienteInvitado(5,"Lolo","lolo@hotmail.com",1993,true,'M',"lolololo");
        invitado.setDuracionMax(50);
        
        // Objeto de tipo ClienteInvitado con la forma de Cliente.
        Cliente clienteNormal = invitado; //Sin casting se puede convertir de hijo a padre.
         //System.out.println("Nombre: "+clienteNormal.getNombre()); //No podemos coger la duracción máxima al ser exclusivo de la clase hijo.
        
        //Otra vez de nuevo tiene la forma de ClienteInvitado.
        ClienteInvitado elMismoInv = (ClienteInvitado) clienteNormal;
         //System.out.println("Dur.Max.: "+ elMismoInv.getDuracionMax()); //Guarda el valor aunque cambie de forma.
        
        //(Override) Siempre llama al método mostrar del hijo, tenga la forma del padre o del hijo.
         //clienteNormal.mostrar();
         //elMismoInv.mostrar();
        Cliente c1 = new Cliente(6,"Lolo","lolo@hotmail.com",1993,true,'M',"lolololo");
         //c1.mostrar();
        ClienteVIP cVIP = new ClienteVIP(7,"VIPLolo","loloVIP@hotmail.com",1993,true,'M',"VIPlolololo");
        cVIP.setBeneficios("DESCUENTOS");
        Cliente cvip = cVIP;
         //cvip.mostrar();
        // No se puede hacer casting de padre a hijo. Excepción de casting.
        /*Cliente normal = new Cliente(5,"Lolo","lolo@hotmail.com",1993,true,'M',"lolololo");
        ClienteInvitado normalEnInvitado = (ClienteInvitado) normal;
        System.out.println("Duración invitado: "+normalEnInvitado.getDuracionMax());*/

    }
}
