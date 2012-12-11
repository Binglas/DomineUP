/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;
import ComunicacaoCliente.ComCliente;
import UserInterface.UIWelcomeScreen;

/**
 * Executa update à informação do UIWelcomeScreen de x em x segundos.
 * @author Luciano
 */
public class UIupdate extends Thread{
    private UIWelcomeScreen screen;
    public static boolean run;
    
    /**
     * Construtor que cria novos objetos da classe UpdateUI.
     * @param objeto da classe UIWelcomeScreen sobre o qual este método deve atuar.
     */
    public UIupdate(UIWelcomeScreen screen){
        this.screen=screen;
        UIupdate.run= true;
    }
    

    @Override
    public void run() {
        
        //WelcomeScreenUI.roomsList = new ArrayList<GameRoom>();
        //WelcomeScreenUI.usersOnlineList = new ArrayList<User>();
        ComCliente com;
  
        
        while (run){
           
            //update game rooms
            try {

                com = ComCliente.getInstance();

                com.requestUsers();
                com.requestRooms();
                com.requestRank(); 
                com.requestPub();
                screen.updateScreen();
                              
                try {
                      UIupdate.sleep(3000);
                  } catch (Exception ex1) {
                      System.out.println("UpdateUI: sleep");
                  }
                
                
            } catch (Exception ex) {
                System.err.println("updateUI: erro");
                //run=false;
                ComCliente c;
                try {
                    c = ComCliente.getInstance();
                    
                    if(c.getClientSocket()==null){
                        run=false;

                    }
                } catch (Exception ex1) {
                    System.out.println("UpdateUI: unable to get instance");
                }
            }
        }
     }
    
}
