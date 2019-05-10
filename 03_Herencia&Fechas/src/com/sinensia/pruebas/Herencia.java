/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.pruebas;

import com.sinensia.ClienteInvitado;
import com.sinensia.ClienteVIP;

/**
 *
 * @author Admin
 */
public class Herencia {
    public static void probandoHerencia(){
        ClienteInvitado invitado = new ClienteInvitado(5,"PedroL","pedrolU@hotmail.com",1987,true,'M',"pedrolU");
        invitado.setDuracionMax(2);
        System.out.println("Cliente: "+invitado.getNombre()+", duracción: "+invitado.getDuracionMax());
        
        ClienteVIP vip = new ClienteVIP(5,"PedroL","pedrolU@hotmail.com",1987,true,'M',"pedrolU");
        vip.setBeneficios("Descuento en gasolina.");
        System.out.println("Cliente: "+vip.getNombre()+", beneficios: "+vip.getBeneficios());
    }
}
