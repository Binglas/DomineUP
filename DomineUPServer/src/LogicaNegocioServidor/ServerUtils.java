/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;
import RecolhaDados.DataRead;
import RecolhaDados.DataWrite;
import Share.User;
import Share.MD5Pwd;
import Share.Message;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import Share.GameRoom;


/**
 * Classe que suporta todas as operações do servidor.
 * @author Luciano
 * @author Andre
 */
public class ServerUtils implements Serializable{
    static final long serialVersionUID = 124L;
    private ArrayList<User> loggedUsers;
    private ArrayList<GameRoom> roomsOnline;
    private static ServerUtils instance;
    private Hashtable<String, ClientThread> userConnections;
    private final Object lockFile = new Object();
    private final Object lockUserList = new Object();
    private final Object lockLoggedUsers = new Object();
    private final Object locktoBroadcastUsers = new Object();
    private final Object lockRoomsOnline = new Object();
    
     /**
     * Este método retorna o nº utilizadores logados.
     * @return int number of loggedUsers.
     */
    public int getLoggedUsers() {
        return loggedUsers.size();
    }
    /**
     * Construtor da classe ServerState. 
     * Inicia todos os Arrays usados no Servidor.
     * @throws Exception 
     */
    protected ServerUtils() throws Exception {
        
        loggedUsers = new ArrayList<User>(); 
        roomsOnline = new ArrayList<GameRoom>();
        userConnections = new Hashtable<String, ClientThread>();
    }
      /**
     * Este método retorna a instance do Servidor.
     * @return Retorna o objecto da classe.
     * @throws Exception 
     */
    public static ServerUtils getInstance() throws Exception {
        if (instance == null) {
            // Se ficheiro do servidor ja existe... carregar o ficheiro e 
            // iniciar construtor do servidor com esse ficheiro
            instance = new ServerUtils();
        }
        return instance;
    }
    
    
    
     /**
     * Método que compara o conjunto utilizador/password que quer efetuar o login
     * e, caso seja bem sucedido, guarda a thread deste.
     * @param username
     * @param password
     * @param clientThread
     * @return o seu próprio User se for bem sucedido, ou null se estiver errado.
     */
    public User loginUser(String username, String password, ClientThread clientThread) throws SQLException {
        
        DataRead DBreader = new DataRead();
        synchronized (lockUserList) {
            
            try {
                 if (DBreader.Testlogin(username,password)){
                    System.out.println("Autenticado");
                    // se já estiver logado retorna null
                    for (int j = 0; j < loggedUsers.size(); ++j) {
                                if (loggedUsers.get(j).getUsername().equals(username)) 
                                {
                                    return null;
                                }
                    }
                    //ir buscar à db info do user
                    loggedUsers.add(DBreader.SelectUser(username));
                    userConnections.put(username, clientThread);
                    return loggedUsers.get(loggedUsers.size()-1);

                }else{
                     System.out.println("Username or password wrong.");
                    //falhou o login
                    return null;
                }   
            }catch (SQLException ex){
                //erro...
                System.out.println("Exception: Login.. " + ex);
                return null;
            }
            
        }
    }
    
    /**
     * Método que compara o utilizador que pretende efetuar logout, com o conjunto de utilizadores 
     * que efetuaram o login anteriormente
     * @param userLoggedOut 
     * @param clientThread
     * @return true, caso exista utilizador no jogo, e false caso nao tenha sucesso.
     */
    public boolean userLogout(User userLoggedOut, ClientThread clientThread) throws SQLException{
        synchronized (lockUserList) {
            for (int i = 0; i < loggedUsers.size(); ++i) {
                if (loggedUsers.get(i).getUsername().equals(userLoggedOut.getUsername())) {
                    loggedUsers.set(i, userLoggedOut);
                }
            }

            for (int j = 0; j < loggedUsers.size(); ++j) {
                if (loggedUsers.get(j).getUsername().equals(userLoggedOut.getUsername())) {
                    loggedUsers.remove(j);
                    clientThread.logout = true;
                    clientThread.run = false;
                    return true;
                }
            }
            return false;
        }
    } 
    
    public void forceLogout(String username) {
        synchronized (lockLoggedUsers) {
            for (int j = 0; j < loggedUsers.size(); ++j) {
                if (loggedUsers.get(j).getUsername().equals(username)) {
                    loggedUsers.remove(j);
                }
            }
        }
    }
    
    
     /*
     * Verifica se o username e a password existem na base de dados, caso não existam
     * efectua o registo na mesma, em caso contrário retorna erro.
     * @param username do user a registar
     * @param password do user a registar
     * @param email do user a registar
     * @return A função retorna uma string com o resultado do registo.
     * success, usernameInUse são as possibilidades.
     */
    public String registarUser(String username, String password, String email) throws SQLException {
        synchronized (lockUserList) {
            DataRead DBreader = new DataRead();
            DataWrite DBwrite = new DataWrite();
            
            User newUser = new User(email, password, username, "avatar5.png",0,0);
            // verificar na DB se o username existe
           
            try{
                if (DBreader.SelectUser(username)!=null) {
                   //username está a ser usado..
                   System.out.println("USERNAME......");    
                   return "usernameInUse";
                }    
            }catch (SQLException ex){
                //erro...
                System.out.println("Exception: DBreader.SelectUser() " + ex);
                return "error";
            }
           // verificar na DB se o email existe
            try{
                if (DBreader.SelectEmail(email)!=null){
                    //emailInUse
                    System.out.println("EMAIL....");    
                    return "emailInUse";
                }  
            }catch (SQLException ex){
                //erro...
                System.out.println("Exception: DBreader.SelectEmail() " + ex);
                return "error";
            }
            
             
            //inserir utilizador na DB (tratar das estatisticas e etc... apenas insere na tabela user)
            
            try{
                DBwrite.InsertUser(newUser);
                return "success";
            }catch (SQLException ex){
                System.out.println("Exception: DBwrite.InsertUser() " + ex);
                return "error";
            }
  
        }
        
    }
    
  /*
     * Verifica se o username e a password existem na base de dados, caso não existam
     * efectua o update aos dados pessoais, em caso contrário retorna erro.
     * @param username do user a fazer update
     * @param password do user a fazer update
     * @param email do user a fazer update
     * @param avatar do user a fazer update
     * @return A função retorna uma string com o resultado do registo.
     * success, usernameInUse são as possibilidades.
     */
   public String updateUser(String username, String password, String email, String avatar, int flag) throws SQLException {
        synchronized (lockUserList) {
            DataRead DBreader = new DataRead();
            DataWrite DBwrite = new DataWrite();
            
            User newUser = new User(email, password, username, avatar);
            
            
            //se email null então n altera email
          
            if (flag != 0){
                // verificar na DB se o email existe
                try{
                    if (DBreader.SelectEmail(email)!=null){
                        //emailInUse

                        return "emailInUse";
                    }  
                }catch (SQLException ex){
                    //erro...
                    System.out.println("Exception: DBreader.SelectEmail() " + ex);
                    return "error";
                }
            }
           
            //inserir utilizador na DB (tratar das estatisticas e etc... apenas insere na tabela user)
            
            try{
                DBwrite.UpdateUser(newUser);
                //actualiza a info do loggedUser
                for (int j = 0; j < loggedUsers.size(); ++j) {
                                if (loggedUsers.get(j).getUsername().equals(username)) 
                                {
                                    loggedUsers.remove(j);
                                    loggedUsers.add(DBreader.SelectUser(username));
                                }
                    }
                    //ir buscar à db info do user
                return "success";
            }catch (SQLException ex){
                System.out.println("Exception: DBwrite.InsertUser() " + ex);
                return "error";
            }
  
        }
    }
    /**
     * Método que permite recuperar a password do utilizador gerando uma nova e 
     * envia através de email para o seu endereço.
     * @param Email
     * @return o seu próprio User se for bem sucedido, ou null se estiver errado.
     */
    public User RecoverPass(String email) throws SQLException {
        
        DataRead DBreader = new DataRead();
        DataWrite DBwrite = new DataWrite();
        User user;
        
        synchronized (lockUserList) {
            System.out.println(email);
            try {
                 
                 user=DBreader.SelectEmail(email);
                 if (user!=null){ //existe o email... logo fazer a alteração
                     
                     SecureRandom random = new SecureRandom();
                     String newpass=new BigInteger(30, random).toString(32);
                     MD5Pwd enc = new MD5Pwd();
                     String encpass=enc.encode(user.getUsername(), newpass);
                     
                     try{
                         System.out.println("antes de update...");
                         DBwrite.UpdatePass(email, encpass);
                         User result = new User(email,newpass , user.getUsername(), user.getAvatar());
                         System.out.println(user.getPassword());
                         System.out.println("depois do update...");
                         return result;
                     }catch (SQLException ex){
                         //erro...
                         System.out.println("Exception: updating pass DBwrite() " + ex);
                         return null;
                     }
                    
                 }else { // não existe o email na db...´~
                      System.out.println("não encontra email...");
                     return null;
                 }
           
            }catch (SQLException ex){
                //erro...
                System.out.println("Exception: reading email.. " + ex);
                return null;
            }
        }
        
    }
    
        /**
    * Get default que retorna a lista de User's online
    * @return lista de objectos User online
    */
    public ArrayList<User> getUsersList() {
        synchronized (lockLoggedUsers) {
            return loggedUsers;
        }
    }
    
        /**
     * Este método, se o nome da sala pretendida já não estiver em uso, é 
     * adicionada ao ArrayList de salas online
     * @param newRoom é a sala a ser adicionada
     * @return true se for bem sucedido e false se o nome já estiver em uso
     */
    public boolean createRoom(GameRoom newRoom) {
        
        if ( findRoom(newRoom.getName()) == true) {
            return false;
        }else{
            synchronized (lockRoomsOnline) {
                newRoom.getPlayer(0);
                roomsOnline.add(newRoom);
               // System.out.println("ADFIJHFDIHFDGHI: " +newRoom.getPlayer(0));
                return true;
            }
        }
       
    }
    
   /**
     * Este método retorna o índice do Array de salas online que tem a sala com 
     * nome roomName.
     * @param roomName é o nome da sala da qual se quer o índice
     * @return Retorna o true se exitir false se não existir
     */
    public boolean findRoom(String roomName) {
        synchronized (lockRoomsOnline) {
            for (int i = 0; i < roomsOnline.size(); i++) {
                if (roomsOnline.get(i).getName().equals(roomName)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    
        /**
    * Get default que retorna a lista de User's online
    * e testa se existem jogadores numa determinada sala
    * @return lista de objectos User online
    */
    public ArrayList<GameRoom> getRoomList() {
        synchronized (lockRoomsOnline) {
            
            //se não existir jogadores apaga a sala
            for (int i=0;i<roomsOnline.size();i++){
                
                if (roomsOnline.get(i).getCurPlayers()==0){
                    roomsOnline.remove(i);
                }
            }
            
            return roomsOnline;
        }
    }

    /**
     * Este método recebe uma mensagem que será broadcasted para todos os 
     * utilizadores.
     * @param sourceUser é o Utilizador de origem
     * @param message é a mensagem que ele quer enviar aos outros jogadores
     * @return true se o broadcast tiver tido sucesso, e false se tiver tido alguma 
     * exceção
     */
    public boolean roomChat(User sourceUser, String message) {
        synchronized (locktoBroadcastUsers) {
            ArrayList<Object> arguments = new ArrayList<>();
            ArrayList<User> toBroadcast = new ArrayList<>();
            System.out.println("SIZE: \n" + loggedUsers.size());
            for (int i = 0; i < loggedUsers.size(); i++) {
                    toBroadcast.add(loggedUsers.get(i));
                    System.out.println("Boradcast to: \n" + toBroadcast.get(i).getUsername());
            }
            arguments.add(sourceUser.getUsername());
            arguments.add(message);
            Message answrMsg = new Message("answrupdateChatsuccess", arguments);
            if (broadcast(answrMsg, toBroadcast)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    
    /**
     * Este método recebe a mensagem a enviar e a lista de users para quem tem 
     * que a enviar. É uma função genérica porque é usada várias vezes a partir
     * do momento em que se inicia o jogo.
     * @param msg a enviar
     * @param users a receber a mensagem
     * @return true se for bem sucedida, false se houver alguma exceção
     */
    private boolean broadcast(Message answrMsg, ArrayList<User> users) {
        for (int i = 0; i < (users.size()); ++i) {
            ClientThread clientThread = userConnections.get(users.get(i).getUsername());
            try {
                clientThread.writeMessage(answrMsg);
            } catch (Exception ex) {
                System.out.println("ERRO NO BROADCAST! Exception: " + ex);
                return false;
            }
        }
        return true;
    }
}
