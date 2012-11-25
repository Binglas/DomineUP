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
    public String Lang = Language.getInstance().GetLanguage();
   
    
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
                        
                    case "runtimeError":
                        System.out.println("Server RunTimeError ");
                        UIError errorFrame1 = new UIError();
                        errorFrame1.setErrorTitleLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorLabel"));
                        errorFrame1.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("RuntimeError"));
                        errorFrame1.setVisible(true);
                        
                        break;
                    case "answrRequestUserSuccess":
                        //não faz nada
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
