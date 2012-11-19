/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Classe que inicia o Thread principal do Servidor (que está sempre em funcionamento)
 * desde que o Servidor inicia até que se desliga, e que suporta o Multithreading de 
 * clientes, e todas as funcionalidades do Servidor.
 * @author Luciano
 */
public class ServerThread extends Thread {
 
    private ServerSocket serverSocket;
    public static int nrClients; // numero de clientes que estao ligados em cada instante
    public static int clientNr; //numero de clientes que se juntaram desde que o servidor esta ligado
    private int port;
    
    public ServerThread(int port) {
        this.port = port;
        
    }
    
    
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            
            while(true){
                Socket client= serverSocket.accept();
                new ClientThread(client,serverSocket).start();
                
            }
        } catch (Exception ex) {
            System.out.println("EXCEPTION 2!");
        }
    }
    
    
}
