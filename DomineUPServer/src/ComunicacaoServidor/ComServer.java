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
import Share.GameRoom;
import Share.Piece;

/**
 * Classe responsável pela ligação do Servidor com o cliente, processa todas as 
 * mensagens vindas do cliente.
 * @author Luciano
 * @author Andre
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
                 
                case "loginGuest":
                   System.out.println(GetDate.now()+": Guest is Logging in!");
                   if(loginGuest(msg)){
                       clientThreadInstance.printClient = "Guest" + GetDate.time();
                       thisClient = "Guest" + GetDate.now();
                       System.out.println(GetDate.now()+": "+thisClient + " Logged in!");
                       return true;
                   }else{
                       System.out.println(GetDate.now()+": "+thisClient + ": Error Login!");
                       return true;
                   }
                    
                case "logout":
                   System.out.println(GetDate.now()+"+"+thisClient +" trying to logout");
                   System.out.println(GetDate.now()+": "+thisClient + ": Logout request!");
                if (logout(msg)) {
                    System.out.println(GetDate.now()+": "+thisClient + ": Logout efectuado com sucesso!");
                    return true;
                } else {
                    System.out.println(GetDate.now()+": "+thisClient + ": Ocorreu um erro durante o Logout!");
                    return true;
                }
                    
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
                    }
                    
                case "createRoom":
                    if (createRoom(msg)) {
                        GameRoom room = (GameRoom) msg.getArguments().get(0);
                        System.out.println(GetDate.now()+": "+thisClient + " created room '"+room.getName()+"' successfully!");
                        return true;
                    } else {
                        System.out.println(GetDate.now()+": "+thisClient + ": Erro a criar a Sala!");
                        return true;
                    }
                    
                case "joinRoom":
                    if (joinRoom(msg)) {
                    return true;
                    } else {
                    System.out.println(GetDate.now()+": "+thisClient + ": Erro a fazer Join na Room desejada!");
                    return true;
                    }
                    
                case "leaveRoom":
                    if (leaveRoom(msg)) {
                    System.out.println(GetDate.now()+": "+thisClient + ": Leave Room efetuado com sucesso!");
                    return true;
                    } else {
                    System.out.println(GetDate.now()+": "+thisClient + ": Erro a fazer leave Room desejada!");
                    return true;
                    }
                    
                case "roomChat":
                    if (roomChat(msg)) {      
                    return true;
                    } else {
                    System.out.println(GetDate.now()+": "+thisClient + ": Error sending chat message!");
                    return true;
                    }
                    
                case "gameChat":
                    if (gameChat(msg)) {      
                    return true;
                    } else {
                    System.out.println(GetDate.now()+": "+thisClient + ": Error sending chat message!");
                    return true;
                    }
                    
                case "invitePlayer":
                    if (invitePlayer(msg)){
                        return true;
                    }else{
                        System.out.println(GetDate.now()+": "+thisClient + ": Error inviting player!");
                        return true; 
                    }
                    
                case "requestRank":
                    if (requestRank(msg)){
                        return true;
                    }else{
                        System.out.println(GetDate.now()+": "+thisClient + ": Error getting ranks!");
                        return true; 
                    }
                    
                case "requestPub":
                    if (requestPub(msg)){
                        return true;
                    }else{
                        System.out.println(GetDate.now()+": "+thisClient + ": Error getting pubs!");
                        return true; 
                    }
                    
                case "startGame":
                    System.out.println(GetDate.now()+": "+thisClient + ": Requested the Start of the Game!");
                if (startGame(msg)) {
                    System.out.println(GetDate.now()+": "+thisClient + " started the game!");
                    return true;
                } else {
                    System.out.println(GetDate.now()+": "+thisClient + ": Error starting the game!");
                    return true;
                }
                    
                case "RequestPiecePlay":
                    System.out.println(GetDate.now()+": "+thisClient + ": Requested a piece play!");
                    if (startTurn(msg)) {
                        System.out.println(GetDate.now()+": "+thisClient + ": Play a piece accepted");
                        return true;
                    } else {
                        System.out.println(GetDate.now()+": "+thisClient + ": Failed to play a piece!");
                        return true;
                    }
                    
                   
                case "requestRooms":
                        System.out.println(GetDate.now()+"+"+thisClient +" Request looged users");
                    if (RoomList(msg)) {
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
                    ex.printStackTrace(System.err);
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
    
        private boolean loginGuest(Message msg) {
            ArrayList<Object> arguments = new ArrayList<>();
            User loggedGuest = state.loginGuest(clientThread);
            if (loggedGuest != null) {
            arguments.clear();
            arguments.add(loggedGuest);
            Message answrMsg = new Message("answrLoginGuest:success", arguments);
            try {
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! ComServer.login(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }

        Message answrMsg = new Message("answrLoginGuest:error", arguments);
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
     * Este é o metodo responsável por informar o cliente se o logout foi realizado
     * ou não com sucesso, sendo enviada para o cliente uma mensagem.
     * @param msg
     * @return true se for bem sucedido, caso contrário false.
     */

    
    private boolean logout(Message msg) throws SQLException{
        
        User userLoggedOut = (User) msg.getArguments().get(0);
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.clear();
        if (state.userLogout(userLoggedOut, clientThread)) {
            try {
                Message answrMsg = new Message("answerLogout:success", arguments);
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.logout(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        } else {
            Message answrMsg = new Message("answerLogout:error", arguments);
            try {
                clientThread.writeMessage(answrMsg);
                return false;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.logout(): 2!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
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
        int flag = (int) msg.getArguments().get(4);
        String resultreg;
        
        resultreg=state.updateUser(username, password, email,avatar,flag);
        
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
    
    /*
    * Este metodo envia para o cliente uma lista de objectos com todas as
    * salas de jogo disponívies.
    * @return True se enviar, False se não enviar.
    */
    private boolean RoomList(Message msg) {
        
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(state.getRoomList());
        Message answrMsg = new Message("answrRequestRooms:success", arguments);
        try {
            clientThread.writeMessage(answrMsg);
            return true;
        } catch (Exception ex) {
            System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! ComServer.UserList(): !");
            System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
            return false;
        }
    }
    /**
     * Este método descodifica os argumentos enviados pelo cliente e chama o método
     * createRoom da classe ServerState. É enviada uma mensagem ao cliente
     * que depende do decorrer da criação da sala.
     * @param msg é a mensagem recebida do cliente
     * @return return true se for bem sucedido e false se ocorrer um erro ou
     * exceção
     */
    
    private boolean createRoom(Message msg) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        GameRoom newRoom = (GameRoom) msg.getArguments().get(0);
        arguments.add(newRoom);
        if (state.createRoom(newRoom)==true){
            
            try {
                Message answrMsg = new Message("answrCreateRoom:success", arguments);
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.createRoom(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }else{
            try {
                Message answrMsg = new Message("answrCreateRoom:error", arguments);
                clientThread.writeMessage(answrMsg);
                return false;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.createRoom(): 2!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
        }
        }
        
    }

    /**
     * Este método descodifica os argumentos enviados pelo cliente e chama o método
     * roomChat da classe ServerUtils.
     * @param msg é a mensagem recebida do cliente
     * @return Retorna true se for bem sucedido ou false se ocorrer um erro
     */
    private boolean roomChat(Message msg) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.clear();
        User sourceUser = (User) msg.getArguments().get(0);
        String message = (String) msg.getArguments().get(1);
        return state.roomChat(sourceUser, message);
    }
    
    private boolean gameChat(Message msg) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.clear();
        User sourceUser = (User) msg.getArguments().get(0);
        String message = (String) msg.getArguments().get(1);
        return state.gameChat(sourceUser, message);
    }

    /**
     * Este método descodifica os argumentos enviados pelo cliente e chama o método
     * leaveRoom da classe ServerState. É enviada uma mensagem ao cliente
     * que depende do decorrer a saída da sala.
     * @param msg é a mensagem recebida do cliente
     * @return return true se for bem sucedido e false se ocorrer um erro ou
     * exceção
     */
    private boolean leaveRoom(Message msg) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.clear();
        String roomName = (String) msg.getArguments().get(0);
        User remUser = (User) msg.getArguments().get(1);
        if (state.leaveRoom(roomName, remUser)) {
            Message answrMsg = new Message("answerLeaveRoom:success", arguments);
            try {
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.leaveRoom(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        } else {
            Message answrMsg = new Message("answerLeaveRoom:error", arguments);
            try {
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.leaveRoom(): 2!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }
    }

/**
     * Este método descodifica os argumentos enviados pelo cliente e chama o método
     * joinRoom da classe ServerState. É enviada uma mensagem ao cliente
     * que depende de como correr a junção à GameRoom pretendida.
     * @param msg é a mensagem recebida do cliente
     * @return return true se for bem sucedido e false se ocorrer um erro ou
     * exceção
     */
    private boolean joinRoom(Message msg) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.clear();
        String nome_sala = (String) msg.getArguments().get(0);
        User newUser = (User) msg.getArguments().get(1);
        GameRoom roomRequested = state.joinRoom(nome_sala, newUser);
        if (roomRequested != null) {
            arguments.add(roomRequested);
            Message answrMsg = new Message("answerJoinRoom:success", arguments);
            try {
                clientThread.writeMessage(answrMsg);
                System.out.println(GetDate.now()+": "+thisClient + ": joined room '"+roomRequested.getName()+"'.");
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.loginRoom(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        } else {
            Message answrMsg = new Message("answerJoinRoom:error", arguments);
            try {
                clientThread.writeMessage(answrMsg);
                return false;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.loginRoom(): 2!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }
    }

    private boolean invitePlayer(Message msg) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.clear();
        String nome_sala = (String) msg.getArguments().get(0);
        String newUser = (String) msg.getArguments().get(1);
        return state.Invite(nome_sala, newUser);
        }

/**
     * Este método descodifica os argumentos enviados pelo cliente e chama o método
     * startGame da classe ServerState. É enviada uma mensagem ao cliente
     * que depende do decorrer do startGame.
     * @param msg é a mensagem recebida do cliente
     * @return Retorna a String "error" se houver um erro, ou o nome da GameRoom
     * inicializada, se for bem sucedido
     */
    private boolean startGame(Message msg) {
        ArrayList<Object> arguments = new ArrayList<>();
        arguments.clear();
        String roomName = (String) msg.getArguments().get(0);
        return state.startGame(roomName);
    }

    private boolean requestRank(Message msg) throws SQLException {
       
        ArrayList<Object> rank = state.getUserRank();
        
        if (rank != null) {
            try {
                Message answrMsg = new Message("answrRequestRank:success", rank);
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.requestrank(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        } else {
            try {
                Message answrMsg = new Message("answrRequestRank:error", rank);
                clientThread.writeMessage(answrMsg);
                return false;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.requestrank(): 2!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }
        
    }

    private boolean startTurn(Message msg) {
        User user = (User) msg.getArguments().get(0);
        Piece piece=(Piece) msg.getArguments().get(1);
        GameRoom sala = (GameRoom) msg.getArguments().get(2);
        ArrayList<Object> arg = null;
        
        if (!state.tryPlayPiece(user,piece,sala)){
            try {
                Message answrMsg = new Message("RequestPiecePlay:error",arg);
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.requestPub(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }else{
            //mandou broadcast
            return true;
        }
        
    }

    private boolean requestPub(Message msg) throws SQLException {
        
        ArrayList<Object> pub = state.getPub();
        if (pub != null) {
            try {
                Message answrMsg = new Message("answrRequestPub:success", pub);
                clientThread.writeMessage(answrMsg);
                return true;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.requestPub(): 1!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        } else {
            try {
                Message answrMsg = new Message("answrRequestPub:error", pub);
                clientThread.writeMessage(answrMsg);
                return false;
            } catch (Exception ex) {
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION! Comunicacao.requestPub(): 2!");
                System.out.println(GetDate.now()+": "+thisClient + ": EXCEPTION: " + ex);
                return false;
            }
        }
    }


}
