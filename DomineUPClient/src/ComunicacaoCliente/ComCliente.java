/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComunicacaoCliente;

import LogicaNegocioCliente.ReaderThread;
import Share.GameRoom;
import Share.Hand;
import Share.Message;
import Share.Piece;
import Share.User;
import UserInterface.UIGameRoom;
import UserInterface.UIWaitingRoom;
import UserInterface.UIWelcomeScreen;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * Esta classe processa toda a comunicação entre o servidor e o cliente, todas
 * as mensagens enviadas para o servidor passam por esta classe. apenas existe
 * uma instancia relativa a esta classe.
 *
 * @author Luciano
 * @author Andre
 */
public class ComCliente {

    private Socket clientSocket = null;
    private BufferedReader inFile = null;
    private ObjectOutputStream escritor = null;
    private ObjectInputStream leitor = null;
    private final Object lock = new Object();
    private static ComCliente instance;
    public static Message msgx;

    /**
     * Cria um novo objeto da classe ComCliente. Garante a existência apenas de
     * uma instancia.
     */
    protected ComCliente() {
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    /**
     * Este método cria a instancia ComCliente caso ainda não exista, por outro
     * lado retorna a instância já existente.
     *
     * @return Instância da classe
     */
    public static ComCliente getInstance() {
        if (instance == null) {

            instance = new ComCliente();
        }
        return instance;
    }

    /**
     * Tem como função estabelecer ligação com o servidor, inicialmente lê o
     * ficheiro cfgserver.txt para conhecer o IP e a porta.
     *
     * @return Retorna 1 se a ligação for bem sucessida, caso contrário retorna
     * -1.
     */
    public int connection() {


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
     * Trata de enviar para o servidor uma mensagem do tipo login, juntamente
     * com o nome do utilizador e a sua palavra chave encriptada.
     *
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

    /**
     * Trata de enviar para o servidor uma mensagem do tipo logout, juntamente
     * com uma classe User.
     *
     * @param player Utilizador que pretende efetuar o logout.
     */
    public void logout(User player) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(player);
        Message messageToServer = new Message("logout", arguments);
        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.out.println("requestPlayers: error writing object");
        }

    }

    /**
     * Trata de enviar para o servidor uma mensagem do tipo mudarConfig,
     * juntamente com o Username, a palavra pass encriptada, passEnc, o avatar,
     * o E-mail e uma flag.
     *
     * @param username nome do utilizador
     * @param passEnc palavra passe do utilizador encriptada
     * @param email Email do utilizador.
     * @param avatar Avatar a ser utilizado pelo cliente
     * @param flag valor que indica uma mudança no email do utilizador
     */
    public void mudarConfig(String username, String passEnc, String email, String avatar, int flag) {

        ArrayList<Object> arguments = new ArrayList<>();
        arguments.add(username);
        arguments.add(passEnc);
        arguments.add(email);
        arguments.add(avatar);
        arguments.add(flag);



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

    /**
     * Trata de enviar para o servidor uma mensagem do tipo registar, juntamente
     * com o Username, a palavra pass encriptada, passEnc, e o E-mail.
     *
     * @param username nome do utilizador
     * @param passEnc palavra passe do utilizador encriptada
     * @param email Email do utilizador.
     */
    public void registar(String username, String passEnc, String email) {

        ArrayList<Object> vec = new ArrayList<Object>();
        vec.add(username);
        vec.add(passEnc);
        vec.add(email);

        Message messageToServer = new Message("registar", vec);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();
        } catch (Exception ex) {
            System.out.println("registar: error writing object");
        }
    }

    /**
     * Trata de enviar para o servidor uma mensagem do tipo recoverPass,
     * juntamente com o Email.
     *
     * @param Email Email do utilizador.
     */
    public void recoverPass(String Email) {

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
     * Envia para o servidor mensagem do tipo requestUser, solicitanto os
     * jogadores que estao online
     *
     * @param
     */
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

    /**
     * Envia para o servidor mensagem do tipo requestRoom, solicitanto as salas
     * disponíveis.
     *
     * @param
     */
    public void requestRooms() {
        ArrayList<Object> arguments = new ArrayList<Object>();

        Message messageToServer = new Message("requestRooms", arguments);

        try {
            escritor.writeObject(messageToServer);
            escritor.reset();
            escritor.flush();
        } catch (Exception ex) {
            System.out.println("requestUsers: error writing object");
            System.out.println("Exception Message:" + ex);
        }
    }

    /**
     * Envia para o servidor mensagem do tipo requestRank, solicitanto os ranks
     * dos jogadores.
     *
     * @param
     */
    public void requestRank() {
        ArrayList<Object> arguments = new ArrayList<Object>();

        Message messageToServer = new Message("requestRank", arguments);

        try {
            escritor.writeObject(messageToServer);
            escritor.reset();
            escritor.flush();
        } catch (Exception ex) {
            System.out.println("requestUsers: error writing object");
            System.out.println("Exception Message:" + ex);
        }
    }

    /**
     * Envia uma mensagem para o servidor com a mensagem introduzida pelo
     * jogador no chat da welcome room e que deve ficar visivel para todos os
     * outros jogadores.
     *
     * @param player objeto da classe User com as informações do jogador que
     * introduziu a mensagem
     */
    public void roomChat(User player, String message) {

        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(player);
        arguments.add(message);

        Message messageToServer = new Message("roomChat", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.err.println("chatRoom: error writing object");
        }

    }

    /**
     * Envia uma mensagem para o servidor a solicitar a criação de uma nova sala
     * de jogo.
     *
     * @param room objeto da classe GameRoom com as informações da nova sala a
     * criar.
     */
    public void createRoom(GameRoom room) {

        ArrayList<Object> arguments = new ArrayList<>();
        arguments.add(room);

        Message messageToServer = new Message("createRoom", arguments);
        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();
        } catch (IOException ex) {
            System.out.println("requestPlayers: error writing object");
        }

    }

    /**
     * Estabelece o protocolo da ligação, analisa e trata as respostas vindas do
     * servidor.
     *
     * @return String que retorna o identificador da mensagem recebida.
     */
    public String readMessage() {
        synchronized (lock) {
            Share.Message msg;

            try {

                msg = (Share.Message) leitor.readObject();
                msgx = msg;
                System.out.println("Received: " + msg.getTipoMensagem() + " " + msg.getArguments());

                switch (msg.getTipoMensagem()) {
                    case "answrLogin:success":
                        System.out.println("answrLogin:success");
                        ReaderThread.player = (User) msg.getArguments().get(0);
                        return "loginsuccess";

                    case "answrLogin:error":
                        System.out.println("answrLogin:error");
                        return "loginError";

                    case "answrLoginGuest:success":
                        ReaderThread.player = (User) msg.getArguments().get(0);
                        return "loginguestsuccess";

                    case "answerLogout:success":
                        System.out.println("Logout Success!!!");
                        return "logoutSuccess";

                    case "answerLogout:error":
                        System.out.println("Logout Error!!!");
                        return "logoutError";

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
                        ReaderThread.password = msg.getArguments().get(0).toString();
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
                        return "answrRequestUserSuccess";
                    case "answrRequestRooms:success":
                        System.out.println("answrRequestRooms:success");
                        UIWelcomeScreen.roomsOnlineList = (ArrayList<GameRoom>) msg.getArguments().get(0);

                        return "answrRequestRoomsSuccess";

                    case "answrCreateRoom:success":
                        ReaderThread.room = (GameRoom) msg.getArguments().get(0);
                        System.out.println("Create Room Success!");

                        return "createRoomSuccess";

                    case "answrCreateRoom:error":
                        System.out.println("Create Room Error!");
                        return "createRoomError";

                    case "answerLeaveRoom:success":
                        System.out.println("answerLeaveRoom:success");
                        return "leaveRoom:success";

                    case "answerLeaveRoom:error":
                        System.out.println("answerLeaveRoom:error");
                        return "leaveRoom:error";

                    case "answerJoinRoom:success":
                        System.out.println("answerJoinRoom:success");
                        UIWaitingRoom.roomJoined = (GameRoom) msg.getArguments().get(0);
                        ReaderThread.room = (GameRoom) msg.getArguments().get(0);
                        return "joinRoom:success";
                    case "answerJoinRoom:error":
                        System.out.println("answerJoinRoom:error");
                        return "joinRoom:error";

                    case "answrupdateChatsuccess":
                        ReaderThread.chatMessage = (msg.getArguments().get(0) + ": " + msg.getArguments().get(1));
                        return "receivedmessage";
                    case "answrUpdateGameChat:success":

                        ReaderThread.GameChatMessage = (msg.getArguments().get(0).toString());

                        return "answrUpdateGameChat";
                    case "answrInvitePlayer:success":
                        System.out.println("answrInvitePlayer:success");
                        return "answrInvitePlayer";

                    case "answrRequestRank:error":

                        return "answrRequestRankerror";

                    case "answrRequestRank:success":

                        return "answrRequestRank:success";
                    case "answrRequestPub:success":

                        return "answrRequestPub:success";

                    case "startGame:success":
                        ReaderThread.hand = (Hand) msg.getArguments().get(0);
                        return "gameStart:success";
                    case "RequestPiecePlay:success":
                        ReaderThread.welcomescreen.uiGameRoom.PlayerTime = (User) msg.getArguments().get(1);
                        Piece pecaremovida = (Piece) msg.getArguments().get(0);
                        ReaderThread.hand.removePiece(pecaremovida);
                        ReaderThread.welcomescreen.uiGameRoom.newleftSide = pecaremovida.getRightN();
                        ReaderThread.welcomescreen.uiGameRoom.newrightSide = pecaremovida.getLeftN();
                        if (ReaderThread.welcomescreen.uiGameRoom.addPeca(pecaremovida) == true) {
                            return "RequestPiecePlay:success";
                        } else {
                            return "RequestPiecePlay:error";
                        }
                    case "RequestPiecePlay:error":
                        return "RequestPiecePlay:error";
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

    /**
     * Envia uma mensagem ao servidor a solicitar a saída da sala de jogo em que
     * o jogador se encontra.
     *
     * @param roomName nome da sala de jogo da qual o jogador pretende sair.
     * @param player objeto da classe User com as informações do jogador que
     * pretende abandonar a sala.
     */
    public void leaveRoom(String roomName, User player) {

        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(roomName);
        arguments.add(player);

        Message messageToServer = new Message("leaveRoom", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();


        } catch (Exception ex) {
            System.err.println("leaveRoom: error writing object");
        }
    }

    /**
     * Envia para o servidor uma mensagem a solicitar a entrada numa determianda
     * sala de jogo.
     *
     * @param roomName nome da sala de jogo a que o jogador se pretende juntar.
     * @param player objeto da classe User com as informações do jogador que
     * solicita a junção à sala.
     */
    public void joinRoom(String roomName, User player) {

        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(roomName);
        arguments.add(player);
        System.out.println("player username: " + player.getUsername());

        Message messageToServer = new Message("joinRoom", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();


        } catch (Exception ex) {
            System.err.println("joinRoom: error writing object");
        }

    }

    /**
     * Envia para o servidor uma mensagem a solicitar um convite a um jogador.
     *
     * @param roomName nome da sala de jogo a que o jogador se pretende juntar.
     * @param player objeto da classe User com as informações do jogador que
     * solicita a junção à sala.
     */
    public void invitePlayer(String Roomname, String UsernamePlayer) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(Roomname);
        arguments.add(UsernamePlayer);

        Message messageToServer = new Message("invitePlayer", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();


        } catch (Exception ex) {
            System.err.println("joinRoom: error writing object");
        }
    }

    /**
     * Envia para o servidor uma mensagem a solicitar a entrada de um visitante.
     *
     */
    public void loginguest() {
        ArrayList<Object> arguments = new ArrayList<Object>();

        Message messageToServer = new Message("loginGuest", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();


        } catch (Exception ex) {
            System.err.println("joinRoom: error writing object");
        }
    }

    /**
     * Envia uma mensagem para o servidor com a mensagem introduzida pelo
     * jogador no chat da sala de jogo e que deve ficar visivel para todos os
     * outros jogadores da sala.
     *
     * @param player objeto da classe User com as informações do jogador que
     * introduziu a mensagem
     */
    public void GameChat(User player, String message) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(player);
        arguments.add(message);

        Message messageToServer = new Message("gameChat", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.err.println("chatGame: error writing object");
        }
    }
    /*
     *Envia uma mensagem para o servidor a solicitar uma jogada de uma peça
     * @param player jogador que faz a jogada
     * @param piece peça a ser jogada
     */

    public void TryPlayPiece(User player, Piece piece, GameRoom sala) {
        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(player);
        arguments.add(piece);
        arguments.add(sala);


        Message messageToServer = new Message("RequestPiecePlay", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.err.println("RequestPiecePlay: error writing object");
        }
    }

    /**
     * Envia uma mensagem para o servidor com a mensagem para iniciar um jogo.
     *
     * @param roomJoined objeto da classe GameRoom
     */
    public void StartGame(GameRoom roomJoined) {


        ArrayList<Object> arguments = new ArrayList<Object>();
        arguments.add(roomJoined.getName());


        Message messageToServer = new Message("startGame", arguments);

        try {
            escritor.reset();
            escritor.writeObject(messageToServer);
            escritor.flush();

        } catch (Exception ex) {
            System.err.println("StartGame: error writing object");
        }
    }

    public void requestPub() {
        ArrayList<Object> arguments = new ArrayList<Object>();

        Message messageToServer = new Message("requestPub", arguments);

        try {
            escritor.writeObject(messageToServer);
            escritor.reset();
            escritor.flush();
        } catch (Exception ex) {
            System.out.println("requestPub: error writing object");
            System.out.println("Exception Message:" + ex);
        }
    }
}
