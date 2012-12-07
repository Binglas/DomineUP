package ComunicacaoCliente;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class test {
 
	public static void main(String[] argv) throws SQLException {
            
            //Connection c = createConnection();

             Statement statement = null;
            // declare a resultset that uses as a table for output data from the table.
  ResultSet rs = null;
  int updateQuery = 0;
  
 
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://gnomo.fe.up.pt:5432/ee08251", "ee08251",
					"PtBfR2D5r");
                        statement = connection.createStatement();
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
                        
                        String QueryString = "select username, gameswon*100/gamesplayed AS Ratio "
                            + "from domineup.\"Users\" ORDER BY Ratio DESC";
                        //String QueryString = "select gameswon*100/gamesplayed from domineup.\"Users\" ";
                        rs = statement.executeQuery(QueryString); 
                            
                    while (rs.next()) {
                    System.out.println(rs.getString(1));
                    }
                                         
                        
                        rs.close();
                        connection.close();
		} else {
			System.out.println("Failed to make connection!");
		}
	}
 
}