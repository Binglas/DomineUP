/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;

import ComunicacaoServidor.ComServer;
import Share.Message;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta classe é automaticamente criada mal um cliente se liga o servidor.
 * @author Luciano
 */
public class ClientThread extends Thread{

    public boolean run;
    Socket client;
    ServerSocket serverSocket;
    private ComServer com;
    public String printClient;
    final static Object lockSend = new Object();
    public ObjectOutputStream escritor = null;
    private ServerUtils state;
    public boolean logout;
    
    /**
     * Este é o construtor da classe ClientThread, é atribuído
     * um socket ao utilizador.
     * @param client é a Socket atribuída ao utilizador
     * @param serverSocket é o socket do Servidor
     */
    public ClientThread(Socket client,ServerSocket serverSocket) {
        this.client=client;
        this.serverSocket = serverSocket;
        this.run=true;
        this.logout=false;
        
        
        try {
            state = ServerUtils.getInstance();
        } catch (Exception ex) {
            System.out.println(GetDate.now()+": Erro a inicializar Server State no Client Thread "+Thread.currentThread()+". Exception: "+ex);
        }
    }

    @Override
    public void run() {
        ServerThread.nrClients++;
        ServerThread.clientNr++;         
        try {
            com = new ComServer(client,this);
        } catch (Exception ex) {
            System.out.println(GetDate.now()+": Impossivel criar Comunicacao.");
        }
        printClient = "Client "+ServerThread.clientNr;
        System.out.println(GetDate.now()+": "+printClient+" connected.");
        while(run){
            if(!com.readMessage(this)){ 
                System.out.println(GetDate.now()+": "+printClient+": ERRO em readMessage()!");
                System.out.println(GetDate.now()+": Terminating "+printClient+"...");
                run=false;
            }
        }
        ServerThread.nrClients--;
        if(!logout){ // se não tiver sido feito o logout, faz agora
            state.forceLogout(printClient);
        }
    }
    
    /**
     * Este método envia os objectos da classe mensagem para o cliente.
     * @param msg é a mensagem a enviar
     * @throws Exception se houver algum erro no envio
     */
    public final void writeMessage(Message msg) throws Exception{
        synchronized(lockSend){
            System.out.println("Sending message to the server: "+msg.getTipoMensagem());
            escritor.reset();
            escritor.writeObject(msg);
            escritor.flush();
        }
    }
}
