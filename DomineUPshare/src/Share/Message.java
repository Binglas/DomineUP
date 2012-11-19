/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Share;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta classe é mostra a forma que a transmissão o cliente e o servidor é executada. As mensagens são trocadas 
 * segundo o seguinte padrão: (tipoMensagem,ArrayList<Object>)
 * @author Luciano
 */
public class Message implements Serializable {
    static final long serialVersionUID = 100L; //Unique identifier 
    String tipoMensagem;
    ArrayList<Object> arguments;

    /**
     * Construtor da classe Message inicializa os seguintes argumentos
     * @param tipoMensagem
     * @param arguments 
     */
    public Message(String tipoMensagem, ArrayList<Object> arguments) {
        this.tipoMensagem = tipoMensagem;
        this.arguments = arguments;
    }
    
    /**
     * Set genérico
     * @param tipoMensagem 
     */
    public void setTipoMensagem(String tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }
    
    /**
     * Get genérico
     * @return ArrayList<Object> arguments
     */
    public ArrayList<Object> getArguments() {
        return arguments;
    }

    /**
     * Set genérico
     * @param arguments 
     */
    public void setArguments(ArrayList<Object> arguments) {
        this.arguments = arguments;
    }

    /**
     * Get genérico
     * @return String tipoMensagem
     */
    public String getTipoMensagem() {
        return tipoMensagem;
    }

}
