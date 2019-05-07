package pkg01_ejemplojava;

public class Tucan {
    String[] colores;
    float longitud;
    int edad;
    
    /**
     * Un pájaro dice pío.
     */
    public void piar(){
        System.out.println("Pio pio, " + edad + " años.");
    }
    
    public Tucan(){
        this.edad = 0;
        this.longitud = 5f;
        this.colores = new String[]{"blanco", "marron"};
    }
    
    /*public Tucan(String[] colores, float longitud, int edad){
        this.edad = edad;
        this.longitud = longitud;
        this.colores = colores;
    }*/
}
