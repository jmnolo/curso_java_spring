/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.test;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.dao.ClienteDAO;
import com.sinensia.modelo.dao.InterfazDAO;
import com.sinensia.modelo.dao.MySQLClienteDAO;
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
public class ClienteDAOTest {
    
    private static MySQLClienteDAO daoCli;
    
    
    @BeforeClass  // Antes de ejecutar la clase.
    public static void setUpClass() {
        daoCli = new MySQLClienteDAO();
        assertNotNull("Error inicialización DAO.", daoCli);
    }
    
    @Test
    public void creandoClientes() {
        daoCli.insertar(new Cliente(1, "Pru1", "pru1@pru.es", (short) 21, (short) 1, "123"));
        daoCli.insertar(new Cliente(2, "Pru2", "pru2@pru.es", (short) 22, (short) 0, "2123"));
        daoCli.insertar(new Cliente(3, "Pru3", "pru3@pru.es", (short) 23, (short) 1, "3123"));
        daoCli.insertar(new Cliente(4, "Pru4", "pru4@pru.es", (short) 24, (short) 0, "4123"));
        
        daoCli.insertar(new Cliente(3, null, "pru6@pru.es", (short) 23, (short) 0, "3123"));
        daoCli.insertar(new Cliente(4, "Pru4", "pru4@pru.es", (short) 24, (short) 4, "4123"));
        daoCli.insertar(new Cliente(1, "Pru", "pru1@pru.es", (short) 27, (short) 1, "7123"));
        daoCli.insertar(new Cliente(2, null, "pru8@pru.es", (short) 28, (short) 6, "8123"));
        
        assertEquals(daoCli.obtenerTodos().size(), 4);
        
    }
    
    @Test
    public void clienteBien_1() {
        assertNotNull(daoCli.insertar(new Cliente(null, "Pru1", "prux@pru.es", (short) 20, (short) 1, "123")));
        assertEquals("prux@pru.es", daoCli.obtenerUno("pru1@pru.es").getEmail());
        daoCli.eliminar("prux@pru.es");  // Eliminamos el cliente de prueba creado.
        assertNull(daoCli.obtenerUno("prux@pru.es")); // Comprobamos que ya no existe.
    }
    
    @Test
    public void clienteMal_1() {
        assertNotNull(daoCli.insertar(new Cliente(null, "", "pruy@pru.es", (short) 20, (short) 1, "123")));
        assertEquals("pruy@pru.es", daoCli.obtenerUno("pru1@pru.es").getEmail());
        daoCli.eliminar("pruy@pru.es");  // Eliminamos el cliente de prueba creado.
        assertNull(daoCli.obtenerUno("pruy@pru.es")); // Comprobamos que ya no existe.
    }
    
    /*@Test
    public void leyendoClientes() {
        assertEquals(daoCli.obtenerTodos().size(), 4); // Si hay dos clientes la prueba es correcta.
        Cliente cli = daoCli.obtenerUno(3);
        assertTrue(cli.getEmail().equals("pru3@pru.es"));
    }*/
    
    @Test
    public void editandoClientes() {
        
    }
    
    @Test
    public void eliminandoClientes() {
        
    }
    
    
    /*@Before  // Antes de cada método de testing.
    public void setUp() {
    }
    
    @After  // Después de cada método de testing.
    public void tearDown() {
    }
    
    @AfterClass  // Después de ejecutar la clase.
    public static void tearDownClass() {
    }*/
}
