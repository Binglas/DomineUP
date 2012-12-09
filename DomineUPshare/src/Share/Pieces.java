/*

 * To change this template, choose Tools | Templates

 * and open the template in the editor.

 */
package Share;

import java.io.Serializable;

/**
 * A classe Pieces contém as informações de cada peça, necessárias para a sua
 * apresentação na UI do jogo
 * @author Andre
 */
public class Pieces implements Serializable {

    static final long serialVersionUID = 125L;
    private int number = 0;
    private int leftN = 0;
    private int rightN = 0;
    private String pieceCode;
    private boolean alinhamento = false;

    /**
     * Construtor da classe Tile
     */
    public Pieces() {
        this.number = 0;
        this.pieceCode = "";
    }

    /**
     * Contrutor da classe Pieces com atributos
     * @param number
     * @param pieceCode 
     */
    public Pieces(int number, String pieceCode) {
        this.number = number;
        this.pieceCode = pieceCode;
    }
    
    public Pieces(int rightN,int leftN){
        this.rightN = rightN;
        this.leftN = leftN;
               
    }

    /**
     * Get genérico
     * @return int PieceCode
     */
    public String getPieceCode() {
        return pieceCode;
    }

    /**
     * Set genérico
     * @param PieceCode 
     */
    public void setPieceCode(String pieceCode) {
        this.pieceCode = pieceCode;
    }

   
    /**
     * Get genérico
     * @return int number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set genérico
     * @param number 
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the leftN
     */
    public int getLeftN() {
        return leftN;
    }

    /**
     * @param leftN the leftN to set
     */
    public void setLeftN(int leftN) {
        this.leftN = leftN;
    }

    /**
     * @return the rightN
     */
    public int getRightN() {
        return rightN;
    }

    /**
     * @param rightN the rightN to set
     */
    public void setRightN(int rightN) {
        this.rightN = rightN;
    }
}
