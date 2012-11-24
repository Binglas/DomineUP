/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;

import ComunicacaoCliente.ComCliente;
import Share.User;
import UserInterface.UIConfiguracoes;
import UserInterface.UIError;
import UserInterface.UIInitial;
import UserInterface.UIRecoverPass;
import UserInterface.UIRegister;
import UserInterface.UIWelcomeScreen;

/**
 * Fica à escuta de mensagens vindas do servidor, e trata das respostas 
 * de acordo com as mensagems descodificadas pelo método ReadMessage ComCliente.
 * @author Luciano
 */
public class ReaderThread extends Thread {
    public static boolean run;
    public static User player;
    public static UIWelcomeScreen welcomescreen;
    private ComCliente com;
    public UIInitial InitialScreen;
    private UIRegister registerscreen;
    private UIConfiguracoes optionScreen;
    private UIRecoverPass recoverpass;
    public static String password;
   
    
    /**
     * Construtor que cria uma nova instância da classe ReaderThread. 
     */
    public ReaderThread(UIInitial initialScreen, UIRegister registerScreen,UIRecoverPass recoverScreen) {
       run=true;
       this.InitialScreen=initialScreen;
       this.registerscreen=registerScreen;
       this.recoverpass=recoverScreen;
       
       
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
                
                switch (answer){
                    case "loginsuccess":
                        InitialScreen.setVisible(false);
                        System.out.print("USER LOGGED");
                        //Send user simple data to the WelcomeScreen
                        welcomescreen = new UIWelcomeScreen(player);
                        welcomescreen.setVisible(true);                                      
                        break;
                    case "loginError":
                        System.out.println("Login failed");
                        UIError errorFrame = new UIError();
                        errorFrame.setTextErrorLabel("Login failed, username or password wrong");
                        errorFrame.setVisible(true);
                        InitialScreen.setLoginButton();
                        break;
                    
                    case "logoutSuccess":
                        try {
                        com.getClientSocket().close();
                        welcomescreen.dispose();
                        //InitialScreen.setLoginButton();
                        new UIInitial().setVisible(true);
                       
                    } catch (Exception ex) {
                        System.out.println("logout: error closing socket");
                    }
                         break;
                        
                    case "RegSuccess":
                        registerscreen.enableConfirmButton();
                        registerscreen.setClearFields();
                        registerscreen.setErrorLabel("Registado com sucesso!");

                        break;
                    case "RegEmailInUse":
                        registerscreen.setErrorLabel("Email já em uso!");
                        registerscreen.setxEmail();
                        registerscreen.enableConfirmButton();
                        
                        break;
                    case "answrRegUsernameInUse":
                        registerscreen.setErrorLabel("Nome Utilizador já em uso!");
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
                        errorFrame3.setTextErrorLabel("Error to recover Password");
                        errorFrame3.setVisible(true);
                        recoverpass.EnableButton();
                        break;
                    case "MudarConfigSuccess":
                        welcomescreen.optionScreen.SetLabel("Alterações Efectuadas com sucesso");
                        welcomescreen.optionScreen.SetConButton();
                        break;
                        
                    case "runtimeError":
                        System.out.println("Server RunTimeError ");
                        UIError errorFrame1 = new UIError();
                        errorFrame1.setTextErrorLabel("Servidor indisponível, tente mais tarde.");
                        errorFrame1.setVisible(true);
                        
                        break;
                        
                    default: 
                        System.out.println("Non sense Reading");
                        
                        break;
                        
                }    
            }
    }
    
    
    
    
    
    
    
}
