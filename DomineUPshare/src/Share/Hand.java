/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Share;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta classe contém um array com os objetos da classe Piece que foram atribuídos
 * a um dado jogador
 * @author Andre
 */
public class Hand implements Serializable{
    
    static final long serialVersionUID = 126L;
    private ArrayList<Piece> pieces;
    
   /**
     * Construtor da classe Hand
     */
    public Hand() {

        this.pieces = new ArrayList<Piece>();

    }
    
   /**
     * Set genérico
     * @param hand 
     */
    public void setPieces(ArrayList<Piece> hand) {
        this.pieces = hand;
    }
    
    /**
     * Este método avalia o array de pieces que compõem a mão do jogador e 
     * retornam o número de objetos que estão inicializados com um tile válido.
     * @return int número de Piece válidos na Hand
     */
    public int getSize() {
        return this.pieces.size();
    }
    
    /**
     * Este método retorna um Piece, presente na posição index
     * @param index
     * @return Objeto da Piece da posição index
     */
    public Piece getOnePiece(int index) {

        return this.pieces.get(index);
    }
    
   /**
     * Este método introduz o objeto tile na posicao index
     * @param index
     * @param piece 
     */
    public void setOneTile(int index, Piece piece) {
        //this.pieces[index] = piece; //FIXME: ver para que serve
    }

    /**
     * @return the pieces
     */
    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }
    
    public boolean removePiece(Piece piece) {
        
        if(this.pieces.contains(piece)) {
            this.pieces.remove(piece);
            return true;
        }
        
        return false;
    }
    
}
