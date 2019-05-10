package com.sinensia.pruebas;

import com.sinensia.FechaSinMinutos;
import java.util.GregorianCalendar;

/**
 *
 * @author Admin
 */
public class Fechas {
    public static void probar(){
        /*GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(2019, 5, 8); //MESES DE 0 A 11. =en JavaScript
        System.out.println("Fecha: "+fecha.getTime());
        
        GregorianCalendar miCumple;
        miCumple = new GregorianCalendar(2019, 5, 8);
        
        if (miCumple.getTime().after(fecha.getTime())) {
            System.out.println("Aún no cumples.");
            System.out.println("Te faltan "+miCumple2.compareTo(fecha)+" días.");
        } else if (miCumple.getTime().before(fecha.getTime())) {
            System.out.println("Ya cumpliste.");
        } else if (miCumple.getTime().equals(fecha.getTime())){
            System.out.println("FELICIDADES.");
        }
        */
        
        FechaSinMinutos fecha = new FechaSinMinutos(/*2019, 5, 9*/);
        fecha.set(2019,5,9);
        System.out.println("Fecha: "+fecha.getTimeWithoutSeconds());
        
        FechaSinMinutos miCumple2;
        miCumple2 = new FechaSinMinutos(2019,5,9);
        
        if (miCumple2.equals(fecha)){
            System.out.println("FELICIDADES.");
        } else if (miCumple2.before(fecha)) {
            System.out.println("Ya cumpliste.");
        } else if (miCumple2.after(fecha)) {
            System.out.println("Aún no cumples.");
        }
    }
}
