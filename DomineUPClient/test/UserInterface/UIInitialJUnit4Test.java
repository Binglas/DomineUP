/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Machado
 */
public class UIInitialJUnit4Test {
    
    public UIInitialJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of UISetVisible method, of class UIInitial.
     */
    @Test
    public void UISetVisibleCheck() {
        System.out.println("UISetVisible");
        UIInitial instance = new UIInitial();
        instance.UISetVisible();
        assertNotNull(instance);    
    }

    /**
     * Test of setLoginButton method, of class UIInitial.
     */
    @Test
    public void testSetLoginButton() {
        System.out.println("setLoginButton");
        UIInitial instance = new UIInitial();
        instance.setLoginButton();        
        assertNotNull(instance);
    }

    /**
     * Test of main method, of class UIInitial.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        UIInitial.main(args);
        UIInitial instance = new UIInitial();
        assertNotNull(instance);
    }
}
