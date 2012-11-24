/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComunicacaoCliente;

import LogicaNegocioCliente.ReaderThread;
import Share.Message;
import Share.User;
import UserInterface.UIWelcomeScreen;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
/**
 * Esta classe processa toda a comunicação entre o servidor e o cliente, todas as   
 * mensagens enviadas para o servidor passam por esta classe. apenas existe uma 
 * instancia relativa a esta classe. 
 * @author Luciano
 */
public class ComCliente {
     
     private Socket clientSocket = null;
     private BufferedReader inFile = null;
     private ObjectOutputStream escritor = null;
     private ObjectInputStream leitor = null;
     private final Object lock = new Object();
     private static ComCliente instance;
    
    /**
    * Cria um novo objeto da classe ComCliente. Garante a existência apenas de uma
    * instancia.
    */
    protected ComCliente() {
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
    
    
    
    /**
    * Este método cria a instancia ComCliente caso ainda não exista, por outro lado
    * retorna a instância já existente.
    * @return Instância da classe
    */
    public static ComCliente getInstance() {
        if (instance == null) {
            
            instance = new ComCliente();
        }
        return instance;
    }
    
     /**
     * Tem como função estabelecer ligação com o servidor, inicialmente
     * lê o ficheiro cfgserver.txt para conhecer o IP e a porta.
     * @return Retorna 1 se a ligação for bem sucessida, caso contrário retorna -1.
     */
    public int connection(){

       
        try {
            FileInputStream fStream = new FileInputStream("cfgserver.txt");
            inFile = new BufferedReader(new InputStreamReader(fStream));
            String serverIP = inFile.readLine();
            System.out.println(serverIP);
            int serverPort = Integer.parseInt(inFile.readLine());

            try {
                InetAddress add = Inet4Address.getByName(serverIP);
                clientSocket = new Socket(add, serverPort);
                escritor = new ObjectOutputStream(clientSocket.getOutputStream());
                escritor.reset();
                escritor.flush();
                leitor = new ObjectInputStream(clientSocket.getInputStream());

            } catch (Exception e) {
                System.err.println("Error in socket/port number.");
                return -1;
            }

        } catch (Exception e) {
            System.err.println("File input error");
            
            return -1;

        }

        return 1;
    }
    
     /**
     * Trata de enviar para o servidor uma mensagem do tipo login, juntamente com
     * o nome do utilizador e a sua palavra chave encriptada.
     * @param username Nome do utilizador.
     * @param passEnc Palavra chave encriptada. 
     */
    public void login(String username, String passEnc) {

        ArrayList<Object> arguments = new ArrayList<>();
        arguments.add(username);
        arguments.add(passEnc);

        Message messageToServer = new Message("login", arguments);
        System.out.println(messageToServer.getTipoMensagem());
        System.out.println(messageToServer.getArguments());
        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.err.println("Comunicacao Login: escritor");
        }

    }
    
    
    public void mudarConfig(String username, String passEnc, String email,String avatar){
       
        ArrayList<Object> arguments = new ArrayList<>();
        arguments.add(username);
        arguments.add(passEnc);
        arguments.add(email);
        arguments.add(avatar);
        
        
        
        Message messageToServer = new Message("mudarConfig", arguments);
        System.out.println(messageToServer.getTipoMensagem());
        System.out.println(messageToServer.getArguments());
        
        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.err.println("Comunicacao Login: escritor");
        }
    }
    
    public void registar(String username, String passEnc, String email) {
        
        ArrayList<Object> vec = new ArrayList<Object>();
        vec.add(username);
        vec.add(passEnc);
        vec.add(email);

        Message messageToServer = new Message("registar", vec);
        
        try{
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();
        } catch (Exception ex) {
            System.out.println("registar: error writing object");
        }
    }
   
     /**
     * Trata de enviar para o servidor uma mensagem do tipo recoverPass, juntamente com
     * o Email.
     * @param Email Email do utilizador. 
     */
    public void  recoverPass(String Email) {

        ArrayList<Object> arguments = new ArrayList<>();
        arguments.add(Email);

        Message messageToServer = new Message("recoverPass", arguments);
        System.out.println(messageToServer.getTipoMensagem());
        System.out.println(messageToServer.getArguments());
        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.err.println("Comunicacao Login: escritor");
        }

    }
    
     /**
     * Estabelece o protocolo da ligação, analisa e trata as respostas vindas do servidor.
     * @return String que retorna o identificador da mensagem recebida.
     */
    public String readMessage() {
        synchronized (lock) {
            Share.Message msg;
            try {

                msg = (Share.Message) leitor.readObject();
                System.out.println("Received: "+msg.getTipoMensagem()+" "+msg.getArguments());
                
                switch (msg.getTipoMensagem()){
                    case "answrLogin:success":
                        System.out.println("answrLogin:success");
                        ReaderThread.player = (User) msg.getArguments().get(0);
                        
                        return "loginsuccess";
                        
                    case "answrLogin:error":
                        System.out.println("answrLogin:error");
                        return "loginError";
                     
                    case "answrLoginGuest:successLoggedAsGuest":
                        //inserir codigo...
                        break;
                    case "answrReg:success":
                        System.out.println("answrReg:success");
                        return "RegSuccess";
                        
                    case "answrReg:emailInUse":
                        System.out.println("answrReg:emailInUs");
                        return "RegEmailInUse";
                        
                    case "answrReg:usernameInUse":
                        System.out.println("answrReg:usernameInUse");
                        return "answrRegUsernameInUse";
                        
                    case "answrRecoverPass:success":
                        System.out.println("answrRecoverPass:success");
                        ReaderThread.password="A sua nova Password é: "+msg.getArguments().get(0).toString();
                        return "RecoverPassSucess";
                        
                    case "answrRecoverPass:error":
                        System.out.println("answrRecoverPass:error");
                        return "RecoverPassError";
                    case "answrMudarConfig:success":
                        System.out.println("answrMudarConfig:success");
                        return "MudarConfigSuccess";
                    case "answrMudarConfig:error":
                        System.out.println("answrMudarConfig:error");
                        return "MudarConfigError";
                    case "answrRequestUsers:success":
                        System.out.println("answrRequestUsers:success");
                        UIWelcomeScreen.usersOnlineList = (ArrayList<User>) msg.getArguments().get(0);
                        System.out.println(msg.getArguments().get(0));
                        return "answrRequestUserSuccess";
                        
                    case "runtimeError:error":
                        System.out.println("runtimeError:error");
                        return "runtimeError";
                        
                }
                System.out.println("Saiu do readMessage");
                return "exitReadMessage";

            } catch (Exception ex) {
                if (ex.toString().equals("java.net.SocketException: socket closed") || ex.toString().equals("java.net.SocketException: Socket closed")) {
                    System.out.println("Terminated Connection.");

                   ReaderThread.run = false;

                } else {
                    System.out.println("Exception Message:" + ex);
                }
                return "exitReadMessage";
            }
        }
    }

    public void requestUsers() {
        ArrayList<Object> arguments = new ArrayList<Object>();

        Message messageToServer = new Message("requestUsers", arguments);

        try {
            escritor.writeObject(messageToServer);
            escritor.reset();
            escritor.flush();
        } catch (Exception ex) {
            System.out.println("requestUsers: error writing object");
            System.out.println("Exception Message:" + ex);
        }
    }

    
}

   