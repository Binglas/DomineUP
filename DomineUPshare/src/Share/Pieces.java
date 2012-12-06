/*

 * To change this template, choose Tools | Templates

 * and open the template in the editor.

 */
package Share;

import java.io.Serializable;

/**
 * A classe Piece contém as informações de cada peça, necessárias para a sua
 * apresentação na UI do jogo
 * @author Andre
 */
public class Pieces implements Serializable {

    static final long serialVersionUID = 125L;
    private String color;
    private int number;
    private int posX = 0;
    private int posY = 0;
    private int tileCode;

    /**
     * Construtor da classe Tile
     */
    public Pieces() {
        this.color = "";
        this.number = 0;
        this.tileCode = 0;
    }

    /**
     * Contrutor da classe Tile com atributos
     * @param color
     * @param number
     * @param tileCode 
     */
    public Pieces(String color, int number, int tileCode) {
        this.color = color;
        this.number = number;
        this.tileCode = tileCode;
    }

    /**
     * Get genérico
     * @return int tileCode
     */
    public int getTileCode() {
        return tileCode;
    }

    /**
     * Set genérico
     * @param tileCode 
     */
    public void setTileCode(int tileCode) {
        this.tileCode = tileCode;
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
     * @return String color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set genérico
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
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
     * Este método avalia se o objeto está com algum tile verdadeiro, ou com
     * os valores vazios com que foi inicializado
     * @return true se estiver vazio e false se tiver um Tile jogável
     */
    public boolean isEmpty() {
        if (color.equals("preto") || color.equals("vermelho") || color.equals("amarelo") || color.equals("azul") || color.equals("joker")) {
            return false;
        } else {
            return true;
        }
    }
}
