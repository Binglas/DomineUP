/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;

import ComunicacaoCliente.ComCliente;
import Share.User;
import UserInterface.UIError;
import UserInterface.UIInitial;
import UserInterface.UIRegister;
import UserInterface.UIWelcomeScreen;
import UserInterface.UIConfiguracoes;

/**
 * Fica à escuta de mensagens vindas do servidor, e trata das respostas 
 * de acordo com as mensagems descodificadas pelo método ReadMessage ComCliente.
 * @author Luciano
 */
public class ReaderThread extends Thread {
    public static boolean run;
    public static User player;
    private ComCliente com;
    public UIInitial InitialScreen;
    private UIWelcomeScreen welcomescreen;
    private UIRegister registerscreen;
    private UIConfiguracoes optionScreen;
    
   
    
    /**
     * Construtor que cria uma nova instância da classe ReaderThread. 
     */
    public ReaderThread(UIInitial initialScreen, UIRegister registerScreen) {
       run=true;
       this.InitialScreen=initialScreen;
       this.registerscreen=registerScreen;
       
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
