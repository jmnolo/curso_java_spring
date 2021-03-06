package pkg02_colecciones;

/**
 *
 * @author Admin
 */
public class Cliente {
    // Variables nunca públicas.
    private long id;
    private String nombre;
    private String email;
    private int fechaNac;
    private boolean activo;
    private char genero;
    private String password;

    public Cliente() {
        
    }

    public Cliente(long id, String nombre, String email, int fechaNac, boolean activo, char genero, String password) 
    /*throws Exception /*Incluimos la excepción.*/{
        this.id = id;
        // Validación de datos:
        if (nombre == null || nombre == ""){
            //throw new Exception("Nombre de cliente inválido.");
        }
        this.nombre = nombre;
        this.email = email;
        this.fechaNac = fechaNac;
        this.activo = activo;
        this.genero = genero;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
        System.out.println(" Email: "+ this.getEmail());
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", fechaNac=" + fechaNac + ", activo=" + activo + ", genero=" + genero + ", password=" + password + '}';
    }

    
}
