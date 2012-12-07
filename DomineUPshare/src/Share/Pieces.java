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
    private int number;
    private int posX = 0;
    private int posY = 0;
    private int pieceCode;

    /**
     * Construtor da classe Tile
     */
    public Pieces() {
        this.number = 0;
        this.pieceCode = 0;
    }

    /**
     * Contrutor da classe Pieces com atributos
     * @param number
     * @param tileCode 
     */
    public Pieces(int number, int pieceCode) {
        this.number = number;
        this.pieceCode = pieceCode;
    }

    /**
     * Get genérico
     * @return int PieceCode
     */
    public int getPieceCode() {
        return pieceCode;
    }

    /**
     * Set genérico
     * @param PieceCode 
     */
    public void setPieceCode(int pieceCode) {
        this.pieceCode = pieceCode;
    }

    /**
     * Get genérico
     * @return int posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Set genérico
     * @param posX 
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Get genérico
     * @return int posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Set genérico
     * @param posY 
     */
    public void setPosY(int posY) {
        this.posY = posY;
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
}
