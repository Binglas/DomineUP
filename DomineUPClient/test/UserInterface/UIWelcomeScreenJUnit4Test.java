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
public class UIWelcomeScreenJUnit4Test {
    
    public UIWelcomeScreenJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setCreateRoomButton method, of class UIWelcomeScreen.
     */
    @Test
    public void testSetCreateRoomButton() {
        System.out.println("setCreateRoomButton");
        UIWelcomeScreen instance = new UIWelcomeScreen();
        instance.setCreateRoomButton();
        assertNotNull(instance); 
    }

    /**
     * Test of setRoomButton method, of class UIWelcomeScreen.
     */
    @Test
    public void testSetRoomButton() {
        System.out.println("setRoomButton");
        UIWelcomeScreen instance = new UIWelcomeScreen();
        instance.setRoomButton();
        assertNotNull(instance); 
    }

    /**
     * Test of JoinRoomStatusLabel method, of class UIWelcomeScreen.
     */
    @Test
    public void testJoinRoomStatusLabel() {
        System.out.println("JoinRoomStatusLabel");
        String texto = "";
        UIWelcomeScreen instance = new UIWelcomeScreen();
        instance.JoinRoomStatusLabel(texto);
        assertNotNull(instance); 
    }

    /**
     * Test of UIWelcomeSetVisible method, of class UIWelcomeScreen.
     */
    @Test
    public void testUIWelcomeSetVisible() {
        System.out.println("UIWelcomeSetVisible");
        UIWelcomeScreen instance = new UIWelcomeScreen();
        instance.UIWelcomeSetVisible();
        assertNotNull(instance); 
    }

    /**
     * Test of updateChat method, of class UIWelcomeScreen.
     */
    @Test
    public void testUpdateChat() {
        System.out.println("updateChat");
        String message = "";
        UIWelcomeScreen instance = new UIWelcomeScreen();
        instance.updateChat(message);
        assertNotNull(instance); 
    }

    /**
     * Test of main method, of class UIWelcomeScreen.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        UIWelcomeScreen.main(args);
        assertNull(UIWelcomeScreen.ERROR); 
    }

    /**
     * Test of updateScreen method, of class UIWelcomeScreen.
     */
    @Test
    public void testUpdateScreen() {
        System.out.println("updateScreen");
        UIWelcomeScreen instance = new UIWelcomeScreen();
        instance.updateScreen();
        assertNotNull(instance.Lang); 
    }
}
