/*

 * To change this template, choose Tools | Templates

 * and open the template in the editor.

 */
package Share;

import java.io.Serializable;
import java.util.Objects;

/**
 * A classe Piece contém as informações de cada peça, necessárias para a sua
 * apresentação na UI do jogo
 * @author Andre
 */
public class Piece implements Serializable {

    static final long serialVersionUID = 125L;
    private int number = 0;
    private int leftN = 0;
    private int rightN = 0;
    private String pieceCode;
    private boolean alinhamento = false;
    private String img;

    /**
     * Construtor da classe Tile
     */
    public Piece() {
        this.number = 0;
        this.pieceCode = "";
    }

    /**
     * Contrutor da classe Piece com atributos
     * @param number
     * @param pieceCode 
     */
    public Piece(int number, String pieceCode) {
        this.number = number;
        this.pieceCode = pieceCode;
    }
    
    public Piece(int rightN,int leftN,String img){
        this.rightN = rightN;
        this.leftN = leftN;
        this.img = img;
               
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

    public String getImage() {
       return img;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(obj == null) {
            return false;
        }
        else if(obj instanceof Piece) {
            Piece piece = (Piece)obj;
            if(this.leftN == piece.leftN && this.rightN == piece.rightN) {
                return true;
            }
            else {
                return false;
            }
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.number;
        hash = 67 * hash + this.leftN;
        hash = 67 * hash + this.rightN;
        hash = 67 * hash + Objects.hashCode(this.pieceCode);
        return hash;
    }
}
