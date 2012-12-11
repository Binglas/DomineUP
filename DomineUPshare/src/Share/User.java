package Share;


import java.io.Serializable;

/**
 * Esta classe User contém a informação base do Player.
 * @author Luciano
 */
public class User implements Serializable {
    
    static final long serialVersionUID = 250L;
    private String email;
    private String password;
    private String username;
    private String avatar;
    private int gamesplayed;
    private int gameswon;
    private int rank;

    
    /**
     * Contrutor da Classe User
     * @param id - valor a ser atribuito à variável
     * @param email - valor a ser atribuito à variável
     * @param password - valor a ser atribuito à variável
     * @param username - valor a ser atribuito à variável
     * @param avatar - valor a ser atribuito à variável
     * @param gamesplayed - valor a ser atribuido à variável
     * @param gameswon - valor a ser atribuido à variável
     */
    public User(String email, String password, String username, String avatar,int gamesplayed,int gameswon,int rank) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.avatar = avatar;
        this.gameswon=gameswon;
        this.gamesplayed=gamesplayed;
        this.rank=rank; 
    }
     /**
     * Contrutor da Classe User
     * @param email - valor a ser atribuito à variável
     * @param password - valor a ser atribuito à variável
     * @param username - valor a ser atribuito à variável
     * @param avatar - valor a ser atribuito à variável
     * @param gamesplayed - valor a ser atribuido à variável
     * @param gameswon - valor a ser atribuido à variável
     */
    public User(String email, String password, String username, String avatar,int gamesplayed,int gameswon) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.avatar = avatar;
        this.gameswon=gameswon;
        this.gamesplayed=gamesplayed;   
    }
     /**
     * Contrutor da Classe User
     * @param email - valor a ser atribuito à variável
     * @param password - valor a ser atribuito à variável
     * @param username - valor a ser atribuito à variável
     * @param avatar - valor a ser atribuito à variável
     */
    public User(String email, String password, String username, String avatar) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.avatar = avatar;
    }
  
    public void clearUser() {
        this.email = "";
        this.password = "";
        this.username = "";
        this.avatar = "";
        this.gameswon=0;
        this.gamesplayed=0;
        this.rank=0; 
    }
  /**
     * Get genérico
     * @return String gamesplayed
     */
    public int getgamesplayed() {
        return gamesplayed;
    }  
   /**
     * Get genérico
     * @return String gameswon
     */
    public int getgameswon() {
        return gameswon;
    }  
  /**
     * Get genérico
     * @return String rank
     */
    public int getRank() {
        return rank;
    }
    /**
     * Get genérico
     * @return String avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Set genérico
     * @param avatar 
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Get genérico
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set genérico
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get genérico
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set genérico
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get genérico
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set genérico
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Set genérico
     * @param rank 
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof User))
            return false;
        User u = (User)o;
        
        return this.username.equals( u.getUsername());
        
    }
}
