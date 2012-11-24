/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComunicacaoServidor;

import LogicaNegocioServidor.ClientThread;
import LogicaNegocioServidor.GetDate;
import LogicaNegocioServidor.ServerUtils;
import Share.Message;
import Share.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável pela ligação do Servidor com o cliente, processa todas as 
 * mensagens vindas do cliente.
 * @author Luciano
 */
public class ComServer {
    
    private ServerUtils state = null;
    private ObjectInputStream leitor = null;
    private String thisClient = null;
    private Socket clientSocket;
    private ClientThread clientThread;
    
    /**
     * Este é o construtor da classe ComServer.
     * @param clientSocket é o Socket do cliente
     * @param clientThread é o Thread do cliente
     */
    public ComServer(Socket clientSocket, ClientThread clientThread) throws Exception {
        this.clientSocket = clientSocket;
        this.clientThread = clientThread;

        clientThread.escritor = new ObjectOutputStream(clientSocket.getOutputStream());
        clientThread.escritor.flush();
        clientThread.escritor.reset();
        leitor = new ObjectInputStream(clientSocket.getInputStream());

        state = ServerUtils.getInstance();
        
    }
    
     /**
     * Estabelece o protocolo da ligação, analisa e trata as respostas vindas do servidor.
     * @return Retorna true se tiver interpretado a mensagem corretamente, caso 
     * contrário retorna false.
     */
    public boolean readMessage(ClientThread clientThreadInstance) {
        thisClient = clientThreadInstance.printClient;
        try {
            Message msg = (Message) leitor.readObject();
            //RECEBE A MSG!!!!
            System.out.print(msg.getTipoMensagem());
            System.out.println(msg.getArguments());
            switch (msg.getTipoMensagem()){
                case "login":
                   System.out.println(GetDate.now()+": "+thisClient + " is Logging in!");
                   if(login(msg)==true){
                       clientThreadInstance.printClient = (String) msg.getArguments().get(0);
                       thisClient = "User " + clientThreadInstance.printClient;
                       System.out.println(GetDate.now()+": "+thisClient + " Logged in!");
                       return true;
                   }else{
                       System.out.println(GetDate.now()+": "+thisClient + ": Error Login!");
                       return true;
                   }
                case "loginAsGuest":
                    //falta programar....
                    return true;
                case "registar":
                    System.out.println(GetDate.now()+"+"+thisClient +" trying to register");
                    if (registar(msg)==true){
                        System.out.println(GetDate.now()+"+"+thisClient +"registered!! with "+msg.getArguments());
                        return true;
                    }else{
                        System.out.println(GetDate.now()+": "+thisClient +" failed registration with "+msg.getArguments());
                        return true;
                    }
                case "mudarConfig":
                    System.out.println(GetDate.now()+"+"+thisClient +" trying to update personal data");
                    if (updateinfo(msg)==true){
                    
                        return true;
                    }else{
                        System.out.println(GetDate.now()+"+"+thisClient +" failed to update personal data with"+msg.getArguments());
                        return true;
                    }
                case "recoverPass":
                    System.out.println(GetDate.now()+"+"+thisClient +" trying to recover Password");
                    if (RecoverPass(msg)==true){
                        System.out.println(GetDate.now()+"+"+thisClient +" Password recovered!! Email: "+msg.getArguments());
                        return true;
                    }else{
                        System.out.println(GetDate.now()+"+"+thisClient +" failed to recover Password Email: "+msg.getArguments());
                        return true;
                    }
                case "requestUsers":
                    System.out.println(GetDate.now()+"+"+thisClient +" Request looged users");
                    if (UserList(msg)) {
                    return true;
                } else {
                    System.out.println(GetDate.now()+": "+thisClient + ": Erro a enviar a Player List!");
                    return true;
                }
                    

                    
            
            }
        } catch (Exception ex) {
            switch (ex.toString()) {
                case "java.net.SocketException: Connection reset":
                    System.out.println(GetDate.now()+": "+thisClient + ": Closed the application without logging out. Data will not be saved.");
                    clientThread.run = false;
                    return true;
                case "java.io.EOFException":
                    System.out.println(GetDate.now()+": "+thisClient + ": Closed the application without logging out. Data will not be saved.");
                    clientThread.run = false;
                    return true;
                default:
                    System.err.println(GetDate.now()+": "+thisClient + ": EXCEPTION on readMessage()!");
                    System.err.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                    return false;
            }
        }
        System.out.println("mensagem não conhecida");
        //mensagem não reconhecida
        return false;  
    }
     
     /**
     * Este é o metodo responsável por informar o cliente se o login foi realizado
     * ou não com sucesso, sendo enviada para o cliente uma mensagem.
     * @param msg
     * @return true se for bem sucedido, caso contrário false.
     */
    private boolean login(Message msg) throws SQLException {

        ArrayList<Object> arguments = new ArrayList<>();

        String username = (String) msg.getArguments().get(0);
        String password = (String) msg.getArguments().get(1);
        User loggedUser = state.loginUser(username, password, clientThread);
        if (loggedUser != null) {
            arguments.clear();
            arguments.add(loggedUser);
            Message answrMsg = new Message("answrLogin:success", arguments);
            try {
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! ComServer.login(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }

        Message answrMsg = new Message("answrLogin:error", arguments);
        try {
            clientThread.writeMessage(answrMsg);
            return false;
        } catch (Exception ex) {
            System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! ComServer.login(): 2!");
            System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
            return false;
        }
    }
    
     /**
     * Este método recebe a mensagem do utilizador 
     * procede ao inicio do registo do utilizador. É enviada uma mensagem ao cliente
     * com o resultado da operação.
     * @param msg é a mensagem recebida do cliente
     * @return true se for bem sucedido, false se ocorrer algum erro.
     */
    private boolean registar(Message msg) throws SQLException {
        
        ArrayList<Object> vec = new ArrayList<Object>();
        
        String username = (String) msg.getArguments().get(0);
        String password = (String) msg.getArguments().get(1);
        String email = (String) msg.getArguments().get(2);
        String resultreg;
        
        resultreg=state.registarUser(username, password, email);
        
        if (resultreg.equals("success")) {
            Message answrMsg = new Message("answrReg:" + resultreg, vec);
            try {
                //responde ao cliente
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION FUNCTION writeMessage() 1: " + ex);
                return false;
            }
        } else if (resultreg.equals("error")){
                   
                   System.out.println(GetDate.now()+": "+thisClient + ": Server Error..  ");
                   Message answrMsg = new Message("runtimeError:" + resultreg, vec);
                   System.out.println("runtimeError:" + resultreg);
                   try {
                       clientThread.writeMessage(answrMsg);
                       return false;
                   } catch (Exception ex) {
                       System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION writemessage() 2: " + ex);
                       return false;
                   }
               }else{
                   System.out.println(GetDate.now()+": "+thisClient + ": Erro no registo. " + resultreg);
                   Message answrMsg = new Message("answrReg:" + resultreg, vec);
                   System.out.println("answrReg:" + resultreg);
                   try {
                       clientThread.writeMessage(answrMsg);
                       return false;
                   } catch (Exception ex) {
                       System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION writemessage() 2: " + ex);
                       return false;
                   }
               }
    }
     /**
     * Este método recebe a mensagem do utilizador e
     * procede à alteração dos dados pessoais. É enviada uma mensagem ao cliente
     * com o resultado da operação.
     * @param msg é a mensagem recebida do cliente
     * @return true se for bem sucedido, false se ocorrer algum erro.
     */
    private boolean updateinfo(Message msg) throws SQLException {
        
        ArrayList<Object> vec = new ArrayList<Object>();
        
        String username = (String) msg.getArguments().get(0);
        String password = (String) msg.getArguments().get(1);
        String email = (String) msg.getArguments().get(2);
        String avatar = (String) msg.getArguments().get(3);
        String resultreg;
        
        resultreg=state.updateUser(username, password, email,avatar);
        
        if (resultreg.equals("success")) {
            Message answrMsg = new Message("answrMudarConfig:" + resultreg, vec);
            try {
                //responde ao cliente
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION FUNCTION writeMessage() 1: " + ex);
                return false;
            }
        } else if (resultreg.equals("error")){
                   
                   System.out.println(GetDate.now()+": "+thisClient + ": Server Error..  ");
                   Message answrMsg = new Message("runtimeError:" + resultreg, vec);
                   System.out.println("runtimeError:" + resultreg);
                   try {
                       clientThread.writeMessage(answrMsg);
                       return false;
                   } catch (Exception ex) {
                       System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION writemessage() 2: " + ex);
                       return false;
                   }
               }else{
                   System.out.println(GetDate.now()+": "+thisClient + ": Erro no update(). " + resultreg);
                   Message answrMsg = new Message("answrMudarConfig:" + resultreg, vec);
                   System.out.println("answrMudarConfig:" + resultreg);
                   try {
                       clientThread.writeMessage(answrMsg);
                       return false;
                   } catch (Exception ex) {
                       System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION writemessage() 2: " + ex);
                       return false;
                   }
               }
    }

   /**
     * Este método recebe a mensagem do utilizador e
     * procede à recuperação da password. É enviada uma mensagem ao cliente
     * com o resultado da operação juntamente com a password.
     * @param msg é a mensagem recebida do cliente
     * @return true se for bem sucedido, false se ocorrer algum erro.
     */
    private boolean RecoverPass(Message msg) throws SQLException {
        
        ArrayList<Object> vec = new ArrayList<Object>();
        
        String email = (String) msg.getArguments().get(0);
        
        User resultreg;
        
        resultreg=state.RecoverPass(email);
        if (resultreg!=null) { 
            vec.clear();
            vec.add(resultreg.getPassword());
            Message answrMsg = new Message("answrRecoverPass:" + "success", vec);
            try {
                //responde ao cliente
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION FUNCTION writeMessage() 1: " + ex);
                return false;
            }
        } else{
                   System.out.println(GetDate.now()+": "+thisClient + ": Erro em recuperar a pass(). " + resultreg);
                   Message answrMsg = new Message("answrRecoverPass:error" , null);
                   System.out.println("answrRecoverPass:error");
                   try {
                       clientThread.writeMessage(answrMsg);
                       return false;
                   } catch (Exception ex) {
                       System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION writemessage() 2: " + ex);
                       return false;
                   }
               }
    }
    
    /*
    * Este metodo envia para o cliente uma lista de objectos com todos os 
    * utilizadores em jogo.
    * @return True se enviar, False se não enviar.
    * @
    */
    private boolean UserList(Message msg) {
        
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(state.getUsersList());
        Message answrMsg = new Message("answrRequestUsers:success", arguments);
        try {
            clientThread.writeMessage(answrMsg);
            return true;
        } catch (Exception ex) {
            System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! ComServer.UserList(): !");
            System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
            return false;
        }
    }
   
    
}
