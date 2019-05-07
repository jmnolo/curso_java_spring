package pkg01_ejemplojava;

public class Main {

    public static void main(String[] args) {
        boolean condicion = 5 == 5 && true;
        if (3>5) {
            if (condicion || false){
                System.out.println("Es verdadero.");
            //cmd: C:\Users\Admin\Desktop\CURSO_JAVA\01_EjemploJava\dist>java -jar 01_EjemploJava.jar
            }
        } else if (5>7){
            System.out.println("No se ejecuta");
        } else if (8>9){
            System.out.println("No se ejecuta");
        } else {
            System.out.println("Cualquier otro caso.");
        }
        
        char letra = 'B';
        switch (letra) {
            case 'A':
                System.out.println("Aaaaa");
                break;
            case 'B':
                System.out.println("Bbbbb");
                break;
            case 'C':
                System.out.println("Ccccc");
                break;
        }
        String formateado = nombreApell("German","Caballero Rodriguez");
        System.out.println(formateado);
        
        
        Tucan miPajaro;/*Referencia a un objeto (de momento sin valor). - Declarar variable*/
        miPajaro = new Tucan(); /*Reservar memoria y devuelve dirección de memoria a la que apunta.*/
        miPajaro.longitud = 20.5f;
        Tucan otroPajaro = new Tucan();
        otroPajaro.longitud = 30.9f;
        
        System.out.println("Long mi tucan: "+ miPajaro.longitud);
        System.out.println("Long otro tucan: "+ otroPajaro.longitud);
        
        otroPajaro = miPajaro; //Apunta al mismo objeto, copia la dirección de memoria.
        System.out.println("Nueva long otro tucan: "+ otroPajaro.longitud);
        
        miPajaro.longitud = 67.6f;
        System.out.println("Nueva long otro tucan: "+ otroPajaro.longitud);
        
        otroPajaro.edad = 11;
        otroPajaro.piar();
        miPajaro.piar();
        
        Tucan nuevoTuc = new Tucan();
        System.out.println("Long nuevo tucan: "+ nuevoTuc.longitud);
    }
    
    static String nombreApell(String nombre, String apellidos){
        return apellidos + ", " + nombre;
    }
    
    
    
}