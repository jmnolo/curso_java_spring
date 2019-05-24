package com.sinensia.test;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.logica.ServicioClientes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ClienteServicioTest {
    
    private static ServicioClientes servicioCli;
    
    public ClienteServicioTest() {
        //servicioCli = new ServicioClientes();
    }
    
    @BeforeClass
    public static void setUpClass() {
        servicioCli = new ServicioClientes();
        assertNotNull("Error inicialización DAO.", servicioCli);
    }
    
    @Test
    public void clienteBien_1() {
        assertNotNull(servicioCli.insertar("Pru1", "pru1@pru.es", "123", "20", "on"));
        /*assertEquals("Pru1", servicioCli.obtenerUno("pru1@pru.es").getNombre());*/
        servicioCli.eliminar("pru1@pru.es");  // Eliminamos el cliente de prueba creado.
        assertNull(servicioCli.obtenerUno("pru1@pru.es")); // Comprobamos que ya no existe.
    }
    
    @Test
    public void clientesBien_2() {
        servicioCli.insertar("Pru2", "pru2@pru.es", "123", "30", "on");
        servicioCli.insertar("Pru3", "pru3@pru.es", "123", "20", "on");
        assertEquals(30, servicioCli.obtenerUno("pru2@pru.es").getEdad());
        assertTrue(servicioCli.obtenerUno("pru3@pru.es").getActivo()==1);
        servicioCli.eliminar("pru2@pru.es");  // Eliminamos el cliente de prueba creado.
        servicioCli.eliminar("pru3@pru.es");
        assertNull(servicioCli.obtenerUno("pru2@pru.es")); // Comprobamos que ya no existe.
        assertNull(servicioCli.obtenerUno("pru3@pru.es"));
    }
    
    @Test
    public void clienteMal_1() { // Nombre incorrecto.
        servicioCli.insertar("", "pru2@pru.es", "123", "21", "on");
        assertNull(servicioCli.obtenerUno("pru2@pru.es"));
    }
    
    @Test
    public void clienteMal_2() { // Edad incorrecta.
        servicioCli.insertar("mal2", "pru3@pru.es", "123", "0", "on");
        assertNull(servicioCli.obtenerUno("pru3@pru.es"));
    }
    
    @Test
    public void clienteMal_3() { // Sin correo.
        servicioCli.insertar("mal4", "", "123", "10", "on");
        assertNull(servicioCli.obtenerUno(""));
    }
    
    @Test
    public void clienteMal_4() { // Campo no numérico.
        servicioCli.insertar("mal4", "mal4@correo.es", "123", "NONUM", "on");
        assertNull(servicioCli.obtenerUno("mal4@correo.es"));
    }
    
    @Test
    public void clienteMal_5() { // Contraseña sin completar.
        servicioCli.insertar("mal4", "mal5@correo.es", "", "NONUM", "on");
        assertNull(servicioCli.obtenerUno("mal5@correo.es"));
    }
    
    @Test
    public void clienteModifBien_1() {
        assertNotNull(servicioCli.insertar("Pru10", "pru10@pru.es", "123", "20", "on"));
        
        assertNotNull(servicioCli.modificar(servicioCli.obtenerUno("pru10@pru.es").getId(),"Pru10000", "pru10@pru.es", "123", "20", "on"));
        assertEquals("Pru10000", servicioCli.obtenerUno("pru10@pru.es").getNombre());
        
        servicioCli.eliminar("pru10@pru.es");  // Eliminamos el cliente de prueba creado.
        assertNull(servicioCli.obtenerUno("pru10@pru.es")); // Comprobamos que ya no existe.*/
    }
    
    @Test
    public void clienteModifMal_1() { // Nombre incorrecto.
        assertNotNull(servicioCli.insertar("Pru20", "pru20@pru.es", "123", "21", "on"));
        
        servicioCli.modificar(servicioCli.obtenerUno("pru20@pru.es").getId(),"", "pru20@pru.es", "123", "21", "on");
        assertEquals("Pru20", servicioCli.obtenerUno("pru20@pru.es").getNombre()); // Devuelve el nombre anterior.
        
        servicioCli.eliminar("pru20@pru.es");
        assertNull(servicioCli.obtenerUno("pru20@pru.es"));
    }
}
