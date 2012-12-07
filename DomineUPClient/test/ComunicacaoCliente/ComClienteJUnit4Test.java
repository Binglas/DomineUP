/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComunicacaoCliente;

import Share.GameRoom;
import Share.User;
import java.net.Socket;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Machado
 */
public class ComClienteJUnit4Test {
    
    public ComClienteJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getClientSocket method, of class ComCliente.
     */
    @Test
    public void testGetClientSocket() {
        System.out.println("getClientSocket");
        ComCliente instance = new ComCliente();
        Socket result = instance.getClientSocket();
        assertNotNull(result);

    }

    /**
     * Test of getInstance method, of class ComCliente.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ComCliente result = ComCliente.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of connection method, of class ComCliente.
     */
    @Test
    public void testConnection() {
        System.out.println("connection");
        ComCliente instance = new ComCliente();
        int result = instance.connection();
        assertNotNull(result);
    }

    /**
     * Test of login method, of class ComCliente.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String passEnc = "";
        ComCliente instance = new ComCliente();
        instance.login(username, passEnc);
        assertNotNull(instance);
    }

    /**
     * Test of logout method, of class ComCliente.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        User player = null;
        ComCliente instance = new ComCliente();
        instance.logout(player);
        assertNotNull(instance);
    }

    /**
     * Test of mudarConfig method, of class ComCliente.
     */
    @Test
    public void testMudarConfig() {
        System.out.println("mudarConfig");
        String username = "";
        String passEnc = "";
        String email = "";
        String avatar = "";
        int flag = 0;
        ComCliente instance = new ComCliente();
        instance.mudarConfig(username, passEnc, email, avatar, flag);
        assertNotNull(instance);
    }

    /**
     * Test of registar method, of class ComCliente.
     */
    @Test
    public void testRegistar() {
        System.out.println("registar");
        String username = "";
        String passEnc = "";
        String email = "";
        ComCliente instance = new ComCliente();
        instance.registar(username, passEnc, email);
        assertNotNull(instance);
    }

    /**
     * Test of recoverPass method, of class ComCliente.
     */
    @Test
    public void testRecoverPass() {
        System.out.println("recoverPass");
        String Email = "";
        ComCliente instance = new ComCliente();
        instance.recoverPass(Email);
        assertNotNull(instance);
    }

    /**
     * Test of requestUsers method, of class ComCliente.
     */
    @Test
    public void testRequestUsers() {
        System.out.println("requestUsers");
        ComCliente instance = new ComCliente();
        instance.requestUsers();
        assertNotNull(instance);
    }

    /**
     * Test of requestRooms method, of class ComCliente.
     */
    @Test
    public void testRequestRooms() {
        System.out.println("requestRooms");
        ComCliente instance = new ComCliente();
        instance.requestRooms();
        assertNotNull(instance);
    }

    /**
     * Test of roomChat method, of class ComCliente.
     */
    @Test
    public void testRoomChat() {
        System.out.println("roomChat");
        User player = null;
        String message = "";
        ComCliente instance = new ComCliente();
        instance.roomChat(player, message);
        assertNotNull(instance);
    }

    /**
     * Test of createRoom method, of class ComCliente.
     */
    @Test
    public void testCreateRoom() {
        System.out.println("createRoom");
        GameRoom room = new GameRoom();
        ComCliente instance = new ComCliente();
        instance.createRoom(room);
        assertNotNull(instance);
    }

    /**
     * Test of readMessage method, of class ComCliente.
     */
    @Test
    public void testReadMessage() {
        System.out.println("readMessage");
        ComCliente instance = new ComCliente();
        String result = instance.readMessage();
        assertNotNull(result);
    }

    /**
     * Test of leaveRoom method, of class ComCliente.
     */
    @Test
    public void testLeaveRoom() {
        System.out.println("leaveRoom");
        String roomName = "";
        User player = null;
        ComCliente instance = new ComCliente();
        instance.leaveRoom(roomName, player);
        assertNotNull(instance);
    }

    /**
     * Test of joinRoom method, of class ComCliente.
     */
    @Test
    public void testJoinRoom() {
        System.out.println("joinRoom");
        String roomName = "";
        User player = null;
        ComCliente instance = new ComCliente();
        instance.joinRoom(roomName, player);
        assertNotNull(instance);
    }

    /**
     * Test of invitePlayer method, of class ComCliente.
     */
    @Test
    public void testInvitePlayer() {
        System.out.println("invitePlayer");
        String Roomname = "";
        String UsernamePlayer = "";
        ComCliente instance = new ComCliente();
        instance.invitePlayer(Roomname, UsernamePlayer);
        assertNotNull(instance);
    }
}
