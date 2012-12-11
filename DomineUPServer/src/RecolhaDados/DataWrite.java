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
 * Classe responsável pela escrita na base dados postegres.
 *
 * @author andre
 */
public class DataWrite {

    /**
     * Método que permite teste se o utilizador e password correspondem.
     *
     * @return True se o utilizador for inserido correctamente, caso contrário
     * false.
     * @author andre
     */
    public boolean InsertUser(User user) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        int updateQuery = 0;

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

            String QueryString = "INSERT INTO domineup.\"Users\" (username, email, password, "
                    + "avatar, gameswon ,gamesplayed, ban) \n"
                    + "VALUES ('" + user.getUsername() + "', '" + user.getEmail() + "', '" + user.getPassword() + "','"
                    + user.getAvatar() + "'," + user.getgameswon() + "," + user.getgamesplayed() + ", 0 )\n";

            updateQuery = statement.executeUpdate(QueryString);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }

    }

    /**
     * Método que faz a actualização dos dados do utilizador.
     *
     * @return True se o utilizador for inserido correctamente, caso contrário
     * false.
     * @author andre
     */
    public boolean UpdateUser(User user) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        int updateQuery = 0;

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

            String QueryString = "UPDATE domineup.\"Users\" SET password='" + user.getPassword()
                    + "', " + "avatar='" + user.getAvatar()
                    + "', email='" + user.getEmail() + "' WHERE username='" + user.getUsername() + "'";

            updateQuery = statement.executeUpdate(QueryString);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }

    }

    /**
     * Método que faz a actualização da password do utilizador.
     *
     * @return True se o utilizador for inserido correctamente, caso contrário
     * false.
     * @author andre
     */
    public boolean UpdatePass(String Email, String Password) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        int updateQuery = 0;

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

            String QueryString = "UPDATE domineup.\"Users\" SET password='" + Password
                    + "' WHERE email='" + Email + "'";

            updateQuery = statement.executeUpdate(QueryString);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }

    }

    public Boolean InsertPub(String pubLink, String pubName) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        int updateQuery = 0;

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

            String QueryString = "INSERT INTO domineup.\"pub\" (nome, url) \n"
                    + "VALUES ('" + pubName + "', '" + pubLink + "')\n";

            updateQuery = statement.executeUpdate(QueryString);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }
    }

    public Boolean DeletePub(String pubName) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        int updateQuery = 0;

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

            String QueryString = "DELETE FROM domineup.\"pub\" WHERE nome = '" + pubName + "'";

            updateQuery = statement.executeUpdate(QueryString);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }
    }

    public Boolean BanPlayer(String username) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        int updateQuery = 0;

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

            String QueryString = "UPDATE domineup.\"Users\" SET ban=1 WHERE username='" + username + "'";

            updateQuery = statement.executeUpdate(QueryString);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }
    }

    public Boolean UnbanPlayer(String username) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        int updateQuery = 0;

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

            String QueryString = "UPDATE domineup.\"Users\" SET ban=0 WHERE username='" + username + "'";

            updateQuery = statement.executeUpdate(QueryString);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            throw new SQLException();
        }
    }
}