/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;
import UserInterface.UIInitial;
import java.io.IOException;

/**
 * Classe que inicia o Cliente em si. Activando a janela UIInitial.
 * @author Luciano
 */
public class ClientStart {

        public static UIInitial  uiinitial;
 
    public static void main(String[] args) throws IOException{
        // TODO code application logic here  
        uiinitial  = new UIInitial();
        uiinitial.setVisible(true);  
    }
    
    public static UIInitial recreateUI(){
       uiinitial.dispose();
       uiinitial= new UIInitial();
       uiinitial.setVisible(true); 
        return uiinitial;
    }
}
