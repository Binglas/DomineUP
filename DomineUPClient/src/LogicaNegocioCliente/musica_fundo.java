/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Classe relativa a implementação  do som no jogo.
 * @author vasco
 */
public class musica_fundo {
    public static Clip clip; 
    
     public static void music() throws IOException, LineUnavailableException
    {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            new File("folk.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(1000);
            
            }
        catch (UnsupportedAudioFileException ex)
            {
           System.out.println(ex);
            }
    };
     
     /*
      * Set genérico que permite para a música.
      */
      public static void music_stop()
     {
            clip.stop();
     };
      /*
      * Set genérico que permite alterar o volume da música.
      */
     public static void musica_control(float n)
     {        
            FloatControl gainControl =  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(n); // Reduce volume by n decibels. Minimum -80 Maximum 80
     };
}
