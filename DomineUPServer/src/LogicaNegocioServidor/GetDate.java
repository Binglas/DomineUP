/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta classe converte para String a data e hora atuais nas mensagens imprimidas no Servidor.
 * 
 * @author Luciano
 */
public class GetDate {
  /**
   * Esta função retorna a data e hora atual no seguinte formato ex: (21/05/1990 00:05:23 fica 21051990_000523) 
   * @return Retorna uma string.
   */
    public static String now() {
      
        SimpleDateFormat sdfDate = new SimpleDateFormat("ddMMyyyy_HHmmss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
