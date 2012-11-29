/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package share;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta classe é a Sala de Jogo propriamente dita, tendo todas as informações 
 * necessárias para a criação correcta de uma GameRoom.
 * @author Andre
 */
public class GameRoom implements Serializable{
    static final long serialVersionUID = 121L;
    private String name;
    //private String state;
    private String password;
    private int numPlayers;
    private ArrayList<Object> players;

    /**
     * Construtor genérico com argumentos
     * @param name
     * @param state
     * @param password
     * @param numPlayers
     * @param players 
     */
    public GameRoom(String name, String password, int numPlayers,ArrayList<Object> players) {
        this.name = name;
        //this.state = state;
        this.password = password;
        this.players = players;
        this.numPlayers = numPlayers;
        this.players = new ArrayList<>();
    }

    /**
     * Construtor genérico sem argumentos
     */
    public GameRoom() {
        
    }

    /**
     * Get genérico
     * @return int número atual de players na sala
     */
    public int getCurPlayers(){
        return players.size();
    }
    
    /**
     * Get genérico
     * @return int máximo de players na sala
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Set genérico
     * @param numPlayers 
     */
    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
    
    /**
     * Get genérico
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Set genérico
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get genérico
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get genérico
     * @return ArrayList<User> players
     */
    public ArrayList<Object> getBroadcast(){
        return players;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void updatePlayer(int index,Object newUser){
        this.players.set(index, newUser);
    }
    
    public Object getPlayer(int index) {
        return players.get(index);
    }
    
    public int getSize() {
        return players.size();
    }

    public void setPlayers(ArrayList<Object> players) {
        this.players = players;
    }
    
    public void addPlayers(Object player){
        this.players.add(player);
    }

    /*public boolean removePlayers(String username){
        for(int i = 0;i<this.players.size();++i){
            if(this.players.get(i).getUsername().equals(username)){
                this.players.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean existsUser(String username){
        for(int i =0;i<players.size();i++){
            if(players.get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }*/

  /*  public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }*/
}
