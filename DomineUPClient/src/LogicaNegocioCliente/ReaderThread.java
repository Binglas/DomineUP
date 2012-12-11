/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;

import ComunicacaoCliente.ComCliente;
import Share.GameRoom;
import Share.Hand;
import Share.Message;
import Share.User;
import UserInterface.UIConfiguracoes;
import UserInterface.UICreateRoom;
import UserInterface.UIError;
import UserInterface.UIGameRoom;
import UserInterface.UIInitial;
import UserInterface.UIRank;
import UserInterface.UIRecoverPass;
import UserInterface.UIRegister;
import UserInterface.UIWaitingRoom;
import UserInterface.UIWelcomeScreen;
import UserInterface.UIWaitingRoom;
import UserInterface.UIinvite;
import UserInterface.UIinvited;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Fica à escuta de mensagens vindas do servidor, e trata das respostas 
 * de acordo com as mensagems descodificadas pelo método ReadMessage ComCliente.
 * @author Luciano
 * @author Andre
 */
public class ReaderThread extends Thread {
    public static boolean run;
    public static User player;
    public static GameRoom room;
    public static UIWelcomeScreen welcomescreen;
    public static UIGameRoom gameRoom;
    public static Hand hand;
    private ComCliente com;
    public UIInitial InitialScreen;
    private UIRegister registerscreen;
    private UIConfiguracoes optionScreen;
    private UIWaitingRoom waitingRoom;
    private UIRecoverPass recoverpass;
    public static String password;
    public String Lang = Language.getInstance().GetLanguage();
    public static String chatMessage;
    public static String GameChatMessage;
   
    
    /**
     * Construtor que cria uma nova instância da classe ReaderThread. 
     */
    public ReaderThread(UIInitial initialScreen, UIRegister registerScreen,UIRecoverPass recoverScreen) {
       run=true;
       this.InitialScreen=initialScreen;
       this.registerscreen=registerScreen;
       this.recoverpass=recoverScreen;
       this.chatMessage = new String();
       this.GameChatMessage = new String();
       
       
    }
    
    @Override
    public void run() {
        try {
                com = ComCliente.getInstance();
                
        } catch (Exception ex) {
            System.out.println("ReadThread: unable to get instance");
        }

        while (run) {
                String answer = com.readMessage();
                //System.out.println("RESPONSE: "+response);
                Lang=this.InitialScreen.Lang;
                
                switch (answer){
                    case "loginsuccess":
                        InitialScreen.dispose();
                        System.out.print("USER LOGGED");
                        //Send user simple data to the WelcomeScreen
                        welcomescreen = new UIWelcomeScreen(player);
                        welcomescreen.setVisible(true); 
                        new UIupdate(welcomescreen).start();
                        break;
                    case "loginError":
                        System.out.println("Login failed");
                        UIError errorFrame = new UIError();
                        errorFrame.setErrorTitleLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorLabel"));
                        errorFrame.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("LoginError"));
                        errorFrame.setVisible(true);
                        InitialScreen.setLoginButton();
                        break;
                    case "loginguestsuccess":
                        InitialScreen.dispose();
                        System.out.print("USER Guest LOGGED");
                        //Send user simple data to the WelcomeScreen
                        welcomescreen = new UIWelcomeScreen(player);
                        welcomescreen.setVisible(true); 
                        //FIXME: welcomescreen.setDisableRoomButton();
                        welcomescreen.setDisableOptionsButton();
                        new UIupdate(welcomescreen).start();
                        break;
                    case "logoutSuccess":
                        try {
                        com.getClientSocket().close();
                        welcomescreen.dispose();
                        player.clearUser();
                        UIupdate.run=false;
                        InitialScreen=ClientStart.recreateUI();
                        break;
                       
                    } catch (Exception ex) {
                        System.out.println("logout: error closing socket");
                        break;
                    }
                         
                        
                    case "RegSuccess":
                        registerscreen.enableConfirmButton();
                        registerscreen.setClearFields();
                        registerscreen.setErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RegisterSucess"));

                        break;
                    case "RegEmailInUse":
                        registerscreen.setErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RegisterEmailInUse"));
                        registerscreen.setxEmail();
                        registerscreen.enableConfirmButton();
                        
                        break;
                    case "answrRegUsernameInUse":
                        registerscreen.setErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RegisterUsernameInUse"));
                        registerscreen.setxName();
                        registerscreen.enableConfirmButton();

                        break;
                    case "RecoverPassSucess":
                        recoverpass.setLabel(password);
                        recoverpass.EnableButton();
                        break;
                    case "RecoverPassError":
                        recoverpass.setLabel("");
                        UIError errorFrame3 = new UIError();
                        errorFrame3.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RecoverPassError"));
                        errorFrame3.setVisible(true);
                        recoverpass.EnableButton();
                        break;
                    case "MudarConfigSuccess":
                        UIWelcomeScreen.optionScreen.SetLabel(java.util.ResourceBundle.getBundle(Lang).getString("MudarConfigSucess"));
                        UIWelcomeScreen.optionScreen.SetConButton();
                        break;
                        
                    case "createRoomSuccess":
                        welcomescreen.waitingRoomScreen = new UIWaitingRoom(room);
                        welcomescreen.waitingRoomScreen.setVisible(true);
                        welcomescreen.createRoomScreen.setVisible(false);
                        
                        break;
                    case "createRoomError":
                        UIError error = new UIError();
                        error.setTextErrorLabel("Room name in use");
                        error.setVisible(true);
                        welcomescreen.createRoomScreen.enableConfirmButton();
                        break;
                        
                    case "runtimeError":
                        System.out.println("Server RunTimeError ");
                        UIError errorFrame1 = new UIError();
                        errorFrame1.setErrorTitleLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorLabel"));
                        errorFrame1.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RuntimeError"));
                        errorFrame1.setVisible(true);
                        welcomescreen.createRoomScreen.enableConfirmButton();
                        break;
                    case "answrRequestUserSuccess":
                        //não faz nada
                        break;
                    case "answrRequestRoomsSuccess":
                        //não faz nada
                        break;
                    case "answrRequestRankerror":
                        System.out.println("error");
                        UIError errorFrame6 = new UIError();
                        errorFrame6.setErrorTitleLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorLabel"));
                        errorFrame6.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RuntimeError"));
                        errorFrame6.setVisible(true);
                        this.run=false;
                        break;
                        
                    case "leaveRoom:success":
                        welcomescreen.waitingRoomScreen.dispose();
                        welcomescreen.setCreateRoomButton();
                        welcomescreen.setRoomButton();
                        break;
                    case "leaveRoom:error":
                        UIError errorFrame4 = new UIError();
                        errorFrame4.setTextErrorLabel("Leave Room Error!");
                        errorFrame4.setVisible(true);
                        break;
                    case "RequestDeck:success":
                        break;
                        
                    case "joinRoom:success":
                        welcomescreen.waitingRoomScreen = new UIWaitingRoom();
                        welcomescreen.waitingRoomScreen.setVisible(true);
                        welcomescreen.waitingRoomScreen.updateScreen();
                        break;
                        
                    case "joinRoom:error":
                       UIError errorFrame5 = new UIError();
                       errorFrame5.setTextErrorLabel("Não é possível juntar à sala.");
                       errorFrame5.setVisible(true); 
                       break; 
                          
                    case "receivedmessage":
                        welcomescreen.updateChat(chatMessage);
                        break;
                    case "answrUpdateGameChat":
                        
                        welcomescreen.uiGameRoom.updateChat(GameChatMessage);
                        break;
                    case "gameStart:success":
                        try {
                            welcomescreen.uiGameRoom = new UIGameRoom(hand,room);
                        } catch (IOException ex) {
                            Logger.getLogger(ReaderThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        welcomescreen.uiGameRoom.setVisible(true);
                        break;
                    case "RequestPiecePlay:success":
                        
                        break;
                    case "RequestPiecePlay:error":
                        UIError errorFrame8 = new UIError();
                        errorFrame8.setTextErrorLabel("Não é possível jogar essa peça.");
                        errorFrame8.setVisible(true); 
                        break;
                    case "answrInvitePlayer":
                       
                        welcomescreen.uiinvited = new UIinvited(ComCliente.msgx.getArguments().get(0).toString(),ComCliente.msgx.getArguments().get(1).toString()); 
                        welcomescreen.uiinvited.setVisible(true);
                        break;
                    case "answrRequestRank:success":
                        
                        for (int j=0;j<ComCliente.msgx.getSizeMensagem();j++){
                            
                            if (ComCliente.msgx.getArguments().get(j).equals(welcomescreen.player.getUsername())){
                                welcomescreen.player.setRank(j+1);
                                welcomescreen.setRankLabel("Rank: "+" "+Integer.toString(j+1));                         
                            }
                        }
                        
                        UIRank.msgr=ComCliente.msgx;
                        break;
                    case "answrRequestPub:success":
                        ReaderThread.welcomescreen.puburl=ComCliente.msgx;
                        
                        break;
                        
                    default: 
                        System.out.println("Non sense Reading");
                        UIError errorFrame2 = new UIError();
                        errorFrame2.setErrorTitleLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorLabel"));
                        errorFrame2.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RuntimeError"));
                        errorFrame2.setVisible(true);
                        this.run=false;
                        break;
                        
                }    
            }
    }
    
    
    
    
    
    
    
}
