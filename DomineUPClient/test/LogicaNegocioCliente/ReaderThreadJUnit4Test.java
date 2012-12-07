/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author João Machado
 */
public class ReaderThreadJUnit4Test {
    
    public ReaderThreadJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class ReaderThread.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ReaderThread instance = null;
        instance.run();
        assertNotNull(instance.Lang);
        assertNotNull(instance.InitialScreen);
        
    }
}
