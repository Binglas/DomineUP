/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;

import Share.GameRoom;
import Share.Hand;
import Share.Pieces;
import Share.User;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author Andre
 */
class GameState {
        private int BOARDSIZEX = 7, BOARDSIZEY = 20, DECKSIZE = 106;
        private String name;
        Pieces[] deck;
        Pieces[] board;
        Hand[] hands;
        Random rand;
        private Hashtable<String, Hand> playerHands;
        private Hashtable<Integer, String> positions;
        private int activePlayer;
    
   /**
     * Contrutor da classe GameState. Este inicializa todas as variáveis que vão
     * ser necessárias para o jogo.
     * @param startingRoom é a GameRoom associada a este jogo, e que contém algumas 
     * das informações necessárias para a inicialização do jogo.
     */
    public GameState(GameRoom startingRoom){
        board = new Pieces[BOARDSIZEX * BOARDSIZEY];
        deck = new Pieces[DECKSIZE];
        playerHands = new Hashtable<String, Hand>();
        hands = new Hand[startingRoom.getCurPlayers()];
        rand = new Random();
        positions = new Hashtable<Integer, String>();
        name = startingRoom.getName();
        
        for (int j = 0; j < startingRoom.getCurPlayers(); j++) {
            hands[j] = new Hand();
        }
        
        for (int i = 0; i < startingRoom.getCurPlayers(); i++) {
            positions.put(i, startingRoom.getPlayer(i).getUsername());
        }
        
        for(int i=0; i< (BOARDSIZEX * BOARDSIZEY);i++){
            board[i] = new Pieces();
        }
    }
    
    /**
     * Get genérico
     * @return String roomName
     */
    public String getName() {
        return name;
    }

    /**
     * Este método retorna o índice do player activo no momento do query
     * @return int activePlayer
     */
    public int getCurPlayer(){
        return activePlayer;
    }
    
    /**
     * Set genérico
     * @param name - Novo nome para a Sala
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get default.
     * @return Retorna o tabuleiro de jogo.
     */
    public Pieces[] getBoard() {
        return board;
    }

    /**
     * Set comum.
     * @param board é o novo tabuleiro a ser guardado.
     */
    public void setBoard(Pieces[] board) {
        this.board = board;
    }

    /**
     * Este método atribui o índice do próximo jogador, na mudança de turno.
     * @return Retorna o índice do próximo jogador.
     */
    public int nextPlayer() {
        int nrPlayers = playerHands.size() - 1;
        if (activePlayer == nrPlayers ) {
            activePlayer = 0;
        } else {
            activePlayer++;
        }
        return activePlayer;

    }

    /**
     * Get comum.
     * @return Retorna a Hashtable que contém <Índice_do_Jogador,Username_do_Jogador>
     */
    public Hashtable<Integer, String> getPositions() {
        return positions;
    }

    /**
     * Set comum.
     * @param positions é a nova Hashtable com <Índice_do_Jogador,Username_do_Jogador>
     */
    public void setPositions(Hashtable<Integer, String> positions) {
        this.positions = positions;
    }
    
        /**
     * Este método implementa um gerador aleatóreo de inteiros de 0 a 105, com o
     * objectivo de dar peças aleatóreas aos jogadores. A peça sorteada é então
     * retirada do baralho e o seu Tile correspondente (previamente inicializado) 
     * é retornado.
     * @return Retorna o Tile que foi sorteado aleatóreamente.
     */
    public Pieces DrawTile() {
        while (true) {
            int seed = rand.nextInt(106);
            if (deck[seed] != null) {
                Pieces temp = deck[seed];
                deck[seed] = null;
                return temp;
            }
        }
    }

    /**
     * Este método inicializa todas as mãos dos jogadores duma sala, chamando o 
     * método DrawTile() 6 vezes para as tantas peças com que cada User começa, e 
     * inicializando as restantes com valores em branco. 
     * @param players é o Array de Users que irão ter as suas mãos sorteadas.
     */
    public void DrawHand(ArrayList<User> players) {
        Pieces[] tempHand = new Pieces[28];

        for (int i = 0; i < players.size(); i++) {

            for (int number = 0; number < 6; number++) {
                tempHand[number] = this.DrawTile();
            }
            for (int number = 6; number < 28; number++) {
                tempHand[number] = new Pieces();
            }
            hands[i].setTiles(tempHand.clone());
            rand = new Random();
            this.playerHands.put(players.get(i).getUsername(), hands[i]);
        }
    }
    
        /**
     * Este método é chamado no fim de cada turno para que seja gravado numa 
     * Hashtable <Índice_do_Jogador, Nr_de_Peças_na_mão>
     * @return Hashtable com <Índice_do_Jogador, Nr_de_Peças_na_mão>
     */
    public Hashtable<Integer, Integer> getHandsSize() {
        Hashtable<Integer, Integer> sizeHands = new Hashtable<Integer, Integer>();
        for (int i = 0; i < playerHands.size(); i++) {
            sizeHands.put(i, playerHands.get(positions.get(i)).getSize());
        }
        return sizeHands;
    }

    /**
     * Set comum. Faz update no array de Hands, e na Hashtable que também contém
     * uma cópia das mãos, por username.
     * @param playerHand será a nova Hand do player cujo turno acabou.
     */
    public void setHand(Hand playerHand) {
        this.hands[activePlayer] = playerHand;
        this.playerHands.remove(positions.get(activePlayer));
        this.playerHands.put(positions.get(activePlayer), playerHand);
    }

    /**
     * Get comum.
     * @return Retorna a Hashtable com <String, Hand>
     */
    public Hashtable<String, Hand> getPlayerHands() {
        return playerHands;
    }
    
}
