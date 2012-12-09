/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Share;

import java.io.Serializable;

/**
 * Esta classe contém um array com os objetos da classe Pieces que foram atribuídos
 * a um dado jogador
 * @author Andre
 */
public class Hand implements Serializable{
    
    static final long serialVersionUID = 126L;
    private Pieces[] pieces;
    
   /**
     * Construtor da classe Hand
     */
    public Hand() {

        this.pieces = new Pieces[28];

        for (int i = 0; i != pieces.length; ++i) {
            pieces[i] = new Pieces();
        }

    }
    
   /**
     * Set genérico
     * @param hand 
     */
    public void setPieces(Pieces[] hand) {
        this.pieces = hand;
    }
    
    /**
     * Este método avalia o array de pieces que compõem a mão do jogador e 
     * retornam o número de objetos que estão inicializados com um tile válido.
     * @return int número de Pieces válidos na Hand
     */
    public int getSize() {
        int size = 0;
        for (int i = 0; i < getPieces().length; i++) {
                size++;
        }
        return size;
    }
    
    /**
     * Este método retorna um Piece, presente na posição index
     * @param index
     * @return Objeto da Piece da posição index
     */
    public Pieces getOnePiece(int index) {

        return this.getPieces()[index];
    }
    
   /**
     * Este método introduz o objeto tile na posicao index
     * @param index
     * @param piece 
     */
    public void setOneTile(int index, Pieces piece) {
        this.pieces[index] = piece;
    }

    /**
     * @return the pieces
     */
    public Pieces[] getPieces() {
        return pieces;
    }
    
}
