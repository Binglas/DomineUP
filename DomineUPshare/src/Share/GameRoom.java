/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Share;

import Share.User;
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
    private int state; //0= waiting 1=ligado
    private String password;
    private String creator;
    private int numPlayers;
    private ArrayList<User> players;

    /**
     * Construtor genérico com argumentos
     * @param name
     * @param state
     * @param password
     * @param numPlayers
     * @param creator
     * @param players 
     */
    public GameRoom(String name,int state ,String password, int numPlayers,String creator,ArrayList<User> players) {
        this.name = name;
        this.state = state;
        this.password = password;
        this.players = players;
        this.numPlayers = numPlayers;
        this.creator = creator;
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
        return getPlayers().size();
    }
    /*
     * Get Player pelo nome
     * @return User 
     */
    public User getPlayerbyUsername(String Username){
        
        for(User u:players){
            if (u.getUsername().equals(Username)){
                return u;
            }
            
        }
        return null;
    }
    /**
     * Get genérico
     * @return string criador
     */
    public String getCreator() {
        return creator;
    }
    /**
     * Get genérico
     * @return int máximo de players na sala
     */
    public int getNumPlayers() {
        return numPlayers;
    }
     /**
     * Get genérico
     * @return int máximo de players na sala
     */
    public int getState() {
        return state;
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
    public ArrayList<User> getBroadcast(){
        return getPlayers();
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void updatePlayer(int index,User newUser){
        this.getPlayers().set(index, newUser);
    }
    
    public User getPlayer(int index) {
        return getPlayers().get(index);
    }
     
    public int getSize() {
        return getPlayers().size();
    }

    public void setPlayers(ArrayList<User> players) {
        this.setPlayers(players);
    }
    
    public void addPlayers(User player){
        this.getPlayers().add(player);
    }

    public boolean removePlayers(String username){
        for(int i = 0;i<this.getPlayers().size();++i){
            if(this.getPlayers().get(i).getUsername().equals(username)){
                this.getPlayers().remove(i);
                return true;
            }
        }
        return false;
    }
    /*
     * Remover todos os jogadores da sala
     * @return true se remover todos, caso contário retorna false.
     */
    public boolean removeAllPlayers(){
        for(int i = 0;i<this.getPlayers().size();++i){
            
                this.getPlayers().remove(i);     
        }
        return true;
    }
    
    public boolean existsUser(String username){
        for(int i =0;i<getPlayers().size();i++){
            if(getPlayers().get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the players
     */
    public ArrayList<User> getPlayers() {
        return players;
    }
    /*
     * Metodo que permite obter qual o próximo jogador a jogar.
     */
    public int nextPlayer(User u) {
        

       for(int i = 0; i < this.players.size(); i++) {
           if(this.players.get(i).equals(u)) {
               return (i+1)%this.players.size();
           }
       }
      
       return -1;
      
    }
    
}
