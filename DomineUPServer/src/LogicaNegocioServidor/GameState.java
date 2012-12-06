/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;

import Share.GameRoom;
import Share.Hand;
import Share.User;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Andre
 */
class GameState {
    
    
    
    public GameState(GameRoom startingRoom){
        
    }

    Hashtable<String, Hand> getPlayerHands() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void DrawHand(ArrayList<User> players) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Hashtable<Integer, String> getPositions() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
