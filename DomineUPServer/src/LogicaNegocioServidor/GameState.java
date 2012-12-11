/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;

import Share.GameRoom;
import Share.Hand;
import Share.Piece;
import Share.User;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Classe que suporta todos os estados do jogo.
 * @author Andre,Luciano
 */
class GameState {

    private int DECKSIZE = 28;
    private String name;
    Piece[] deck;
    Hand[] hands;
    
    Random rand;
    private Hashtable<String, Hand> playerHands;
   
    User activePlayer;
    private int leftside;
    private int rightside;

    /**
     * Contrutor da classe GameState. Este inicializa todas as variáveis que vão
     * ser necessárias para o jogo.
     *
     * @param startingRoom é a GameRoom associada a este jogo, e que contém
     * algumas das informações necessárias para a inicialização do jogo.
     */
    public GameState(GameRoom startingRoom) {
       
        deck = new Piece[DECKSIZE];
        playerHands = new Hashtable<String, Hand>();
        hands = new Hand[startingRoom.getCurPlayers()];
   
        rand = new Random();
        
        name = startingRoom.getName();

        for (int j = 0; j < startingRoom.getCurPlayers(); j++) {
            hands[j] = new Hand();
      
        }
        int c = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                deck[c] = new Piece(i, j,"peca"+i+""+j+".png");
                c++;
            }
        }
    }

    /**
     * Get genérico
     *
     * @return String roomName
     */
    public String getName() {
        return name;
    }

    /**
     * Este método retorna o índice do player activo no momento do query
     *
     * @return int activePlayer
     */
    public User getCurPlayer() {
        return activePlayer;
    }

    /**
     * Set genérico
     *
     * @param name - Novo nome para a Sala
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Este método implementa um gerador aleatório de inteiros de 0 a 28, com o
     * objectivo de dar peças aleatóreas aos jogadores. A peça sorteada é então
     * retirada do baralho e o seu valor correspondente (previamente
     * inicializado) é retornado.
     *
     * @return Retorna a Piece que foi sorteado aleatóreamente.
     */
    public Piece DrawPiece() {
        while (true) {
            int seed = rand.nextInt(28);
            if (deck[seed] != null) {
                Piece temp = deck[seed];
                deck[seed] = null;
                return temp;
            }
        }
    }

    /**
     * Este método inicializa todas as mãos dos jogadores duma sala, chamando o
     * método DrawPiece() 7 vezes para as tantas peças com que cada User começa,
     * e inicializando as restantes com valores em branco.
     *
     * @param players é o Array de Users que irão ter as suas mãos sorteadas.
     */
    public void DrawHand(ArrayList<User> players) {
        ArrayList<Piece> tempHand = new ArrayList<Piece>();
        tempHand.clear();
        for(int i = 0; i < players.size(); i++) {
            tempHand.clear();
            for(int j = 0; j < 7; j++) {
                hands[i].setOnePiece(j, this.DrawPiece());
                
            }
                  
            this.playerHands.put(players.get(i).getUsername(), hands[i]);
           
        }
         
    }

    /**
     * Get comum.
     *
     * @return Retorna a Hashtable com <String, Hand>
     */
    public Hashtable<String, Hand> getPlayerHands() {
        return playerHands;
    }
    
    public User getActivePlayer() {
        return this.activePlayer;
    }
    
    public void setActivePlayer(User user) {
        this.activePlayer = user;
    }
    
    public int getLeftSide() {
        return this.leftside;
    }
    
    public int getRightSide() {
        return this.rightside;
    }
    
    public void setLeftSide(int leftSide) {
        this.leftside = leftSide;
    }
    
    public void setRightSide(int rightSide) {
        this.rightside = rightSide;
    }
    
    /* Remove peça da mão de um jogador
     * @param player classe jogador
     * @param piece classe peça
     */
    void removePiece(User player,Piece piece) {
        
       
        playerHands.get(player).removePiece(piece);
        
       
    }
    /* Adiciona peça a mão de um jogador
     * @param player classe jogador
     * @param piece classe peça
     */
    void addPiece(User player,Piece piece){
        
        playerHands.get(player).setOnePiece(playerHands.get(player).getSize(), piece);
    }
}
