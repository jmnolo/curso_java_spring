/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Admin
 */
public class FechaSinMinutos extends GregorianCalendar {

    

    public FechaSinMinutos(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    public FechaSinMinutos(){
        super();
    }
    
    /*FechaSinMinutos(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }*/
    //Creamos un método similar a getTime() de GregorianCalendar.
    public Date getTimeWithoutSeconds() {
        Date fecha = new Date/*((*/(getTimeInMillis()/*+86399) / 86400)*86400*/); //Redondear fechar.
        fecha.setHours(HOUR);
        fecha.setMinutes(HOUR);
        fecha.setSeconds(HOUR);
        
        return fecha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FechaSinMinutos) { //Instancia de (Operador)
            //Casting : Conversión de tipos.
            FechaSinMinutos objFecha = (FechaSinMinutos) obj; //Se puede convertir de abuelo a nieto porque se instancia arriba.
            if (this.get(YEAR)==objFecha.get(YEAR)
                    &&this.get(MONTH)==objFecha.get(MONTH)
                    &&this.get(DAY_OF_MONTH)==objFecha.get(DAY_OF_MONTH)) {
                        return true;
            }
        }
        //return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        return false;
    }
}