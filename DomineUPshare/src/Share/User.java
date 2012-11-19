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
    private int id;

    
    /**
     * Contrutor da Classe User
     * @param id - valor a ser atribuito à variável
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
       // this.id = id;
        
    }
  
  /**
     * Get genérico
     * @return String id
     */
    public int getID() {
        return id;
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
}
