/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Classe que permite gerar Passwords
 * @author Luciano
 */
public class GeneratePassword {
     private SecureRandom random = new SecureRandom();

     /**
      * Produz uma nova password.
      * @return password 
      */
     public String nextSessionId()
     {
            return new BigInteger(130, random).toString(32);
     }
}
