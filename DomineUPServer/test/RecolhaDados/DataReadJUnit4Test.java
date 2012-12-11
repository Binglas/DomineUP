/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecolhaDados;

import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author João Machado
 */
public class DataReadJUnit4Test {
    
    private static DataRead instance;
    private String username = "anonimo1";
    private String password = "e1c16c1206d95f88";
    private String email = "ee08666@fe.up.pt";
        
    
    public DataReadJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* JUnit4Test: @BeforeClass method");
        instance = new DataRead();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* JUnit4Test: @AfterClass method");
        instance = null;
    }

    /**
     * Test of Testlogin method, of class DataRead.
     */
    
    @Test
    public void testTestlogin() throws Exception {
        System.out.println("DataReadJUnit4Test: test method 1 - testTestlogin()");
        assertTrue("Verifica que o login é bem sucedido",instance.Testlogin(username,password));
        assertFalse("Verifica que o sistema retorna erro no caso de username errado",instance.Testlogin("anonimo",password));
        assertFalse("Verifica que o sistema retorna erro no caso de password errado",instance.Testlogin(username,"d1c16c1206d95f88"));
        System.out.println("DataReadJUnit4Test: test method 1 - testTestlogin() Success");
    }

    /**
     * Test of SelectUser method, of class DataRead.
     */
    @Test
    public void testSelectUser() throws Exception {
        System.out.println("DataReadJUnit4Test: test method 2 - testSelectUser()");
        String result = instance.SelectUser(username).toString();
        boolean result2 = result.contains("Share.User@");
        assertNotNull("Verifica que é enviado um objecto",result);
        assertTrue("Verifica que o objecto é do tipo Share.User@*****",result2);
        System.out.println("DataReadJUnit4Test: test method 2 - testSelectUser() Success");
    }

    /**
     * Test of SelectEmail method, of class DataRead.
     */
    @Test
    public void testSelectEmail() throws Exception {
        System.out.println("DataReadJUnit4Test: test method 3 - testSelectEmail()");
        String result = instance.SelectEmail(email).toString();
        boolean result2 = result.contains("Share.User@");
        assertNotNull("Verifica que é enviado um objecto",result);
        assertTrue("Verifica que o objecto é do tipo Share.User@*****",result2);
        System.out.println("DataReadJUnit4Test: test method 3 - testSelectEmail() Success");
    }

    /**
     * Test of getRank method, of class DataRead.
     */
    @Test
    public void testGetRank() throws Exception {
        System.out.println("DataReadJUnit4Test: test method 4 - testGetRank()");
        String rank = instance.getRank().toString();
        assertNotNull("Verifica que é enviado um Array",rank);
        assertTrue("Verifica que o Array dos jogadores é separado por ', ' ",rank.contains(", "));
        System.out.println("DataReadJUnit4Test: test method 4 - testGetRank() Success");
    }

    /**
     * Test of getPub method, of class DataRead.
     */
    
    @Test
    public void testGetPub() throws Exception {
        System.out.println("DataReadJUnit4Test: test method 5 - testGetPub()");
        String pub = instance.getPub().toString();
        assertNotNull("Existe um link para o pub?",pub);
        assertTrue("O link remete para um ficheiro de imagem de formato .png?",pub.contains(".png"));
        System.out.println("DataReadJUnit4Test: test method 5 - testGetPub() Success ");
    }
}
