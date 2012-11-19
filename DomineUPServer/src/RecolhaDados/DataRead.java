/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RecolhaDados;

import Share.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 * Classe responsável pela leitura na base dados postegres.
 * @author andre,Luciano
 */

public class DataRead {
    
    /**
    * Método que permite teste se o utilizador e password correspondem.
    * @return True se forem correctos, caso contrário false.
    * @author andre
    */
    public boolean Testlogin(String username,String password) throws SQLException {
        
       
        // declare a resultset that uses as a table for output data from the table.
        ResultSet rs = null;
        Statement statement = null;
        
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            e.printStackTrace();
            return false;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");
        Connection connection = null;
        
        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://gnomo.fe.up.pt:5432/ee08251", "ee08251", "PtBfR2D5r");
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return false;
        }

        if (connection != null) {
            System.out.println("Connected to database!");
            //query de select e imprimir
            String QueryString2 = "select Username,Password from domineup.\"Users\" where Username='"+username+"' and Password='"+password+"'";
            rs = statement.executeQuery(QueryString2);
            
            //TESTA SE EXISTE OU NÃO UTILIZADOR
            if (!rs.next() ) {
                statement.close();
                connection.close();
                rs.close();
                return false;       
            }else {
                statement.close();
                connection.close();
                rs.close();
                return true;
            }
            
        } else {
            System.out.println("Failed to make connection!");
        }
        return false;
        
    }
    
    /**
    * Método que permite buscar informações básicas do utilizador.
    * @return Um objecto do tipo User, caso contrário null.
    * @author andre
    */
    public User SelectUser(String username) throws SQLException {
        
        Statement statement = null;
        ResultSet rs = null;
        
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            e.printStackTrace();
            throw new SQLException();
            
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://gnomo.fe.up.pt:5432/ee08251", "ee08251", "PtBfR2D5r");
            statement = connection.createStatement();
        } catch (SQLException e) {
            
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            throw new SQLException();

        }
        
        if (connection != null) {
            System.out.println("Connected to database!");

            //query de select e imprimir
            String QueryString2 = "select * from domineup.\"Users\" where Username='"+username+"'";
            rs = statement.executeQuery(QueryString2);
            
            if (rs.next()!=false){
                User userdata = new User(rs.getString(3), rs.getString(7), rs.getString(2),rs.getString(4));
                //User userdata = new User(rs.getString(3), rs.getString(7), rs.getString(2),rs.getString(4), rs.getInt(1));
                return userdata;
            }else{
                //received 0....
                return null;
            }
  
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }
        
    }
    
/**
    * Método que permite buscar informações básicas do utilizador.
    * @return Um objecto do tipo User, caso contrário null.
    * @author andre
    */
    public User SelectEmail(String email) throws SQLException {
        
        Statement statement = null;
        ResultSet rs = null;
        
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            e.printStackTrace();
            throw new SQLException();
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://gnomo.fe.up.pt:5432/ee08251", "ee08251", "PtBfR2D5r");
            statement = connection.createStatement();
        } catch (SQLException e) {
            
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            throw new SQLException();

        }
        
        if (connection != null) {
            System.out.println("Connected to database!");

            //query de select e imprimir
            String QueryString2 = "select * from domineup.\"Users\" where Email='"+email+"'";
            rs = statement.executeQuery(QueryString2); 
            
            if (rs.next()!=false){
                User userdata = new User(rs.getString(3), rs.getString(7), rs.getString(2),rs.getString(4));
                //User userdata = new User(rs.getString(3), rs.getString(7), rs.getString(2),rs.getString(4), rs.getInt(1));
                return userdata;
            }else{
                //received 0....
                return null;
            }
            
            
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }
         
    }
}


