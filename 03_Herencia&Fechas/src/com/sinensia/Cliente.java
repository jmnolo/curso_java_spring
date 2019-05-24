package com.sinensia;

/**
 *
 * @author Admin
 */
public class Cliente extends Entidad implements Comparable<Cliente> {
    // Variables protegidas para que puedan acceder sus clases hijas.
    //protected long id; // Obtiene el ID de Entidad.
    protected String nombre;
    protected String email;
    protected int fechaNac;
    protected boolean activo;
    protected char genero;
    protected String password;

    /*public Cliente() {
        
    }*/

    public Cliente(long id, String nombre, String email, int fechaNac, boolean activo, char genero, String password)
    /*throws Exception /*Incluimos la excepción.*/{
        super(id); //Llamamos al padre y eliminamos los métodos get y set.
        //this.id = id;
        // Validación de datos:
        if (nombre == null || nombre == ""){
            //throw new Exception("Nombre de cliente inválido.");
            System.err.println("Nombre de cliente inválido.");
        }
        this.nombre = nombre;
        this.email = email;
        this.fechaNac = fechaNac;
        this.activo = activo;
        this.genero = genero;
        this.password = password;
    }

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Validación de datos:
        if (nombre == null || nombre == ""){
            //throw new Exception("Nombre de cliente inválido.");
            System.err.println("Nombre de cliente inválido.");
        }
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(int fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void mostrar(){
        System.out.println("Cliente: "+nombre);
        System.out.println(" Id: "+ this.id);
        System.out.println(" Fecha: "+ this.getFechaNac());
    }

    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", fechaNac=" + fechaNac + ", activo=" + activo + ", genero=" + genero + ", password=" + password + '}';
    }

    
    @Override
    public int compareTo(Cliente otroCliente) {
        // Si los nombres son iguales comparamos por email.
        if (nombre.compareTo(otroCliente.nombre)==0){
            return email.compareTo(otroCliente.email);
        } else { // Si los nombres no son iguales los comparamos.
            return nombre.compareTo(otroCliente.nombre);
        }
    }
    
}
