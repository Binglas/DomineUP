/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecolhaDados;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Classe que escreve no ficheiro apropriado os dados referentes ao servidor do
 * DomineUP
 * @author Andre
 */
public class DataFile {
    
    /**
     * Construtor de objetos da Classe DataWriteFile
     */
    public DataFile(){
    }
    
    /**
     * Este método grava os prints do log, linha a linha, à medida que estas são 
     * enviadas para o Output.
     * @param newLine é a linha a ser gravada.
     * @param log é o Stream para onde se irá gravar.
     * @return Retorna true se for bem sucedido, e false se houver uma exceção.
     */
    public boolean saveLogs(String newLine, FileOutputStream log){
        try {
            log.write( newLine.getBytes() );
            return true;
        } catch (Exception ex) {
            System.out.println("Error saving logs");
            return false;
        }
    }
    
}
