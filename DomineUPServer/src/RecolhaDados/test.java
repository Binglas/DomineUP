package RecolhaDados;





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
                         
             String username = "rebelo";
             String email = "rebelo@fe.up.pt";
             String password = "rebelo";
             
                     
             
 
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
                      
                       /* //query de insert e imprimir
                        String QueryString = "INSERT INTO domineup.\"Users\" (username, email, password, avatar, \"configuracoesID\", \"estatisticasID\") \n" +
"	VALUES ('lucdawdisd', 'lucddadisdf2', 'lusssdsci3', NULL, NULL, NULL)\n";
                                               
                        updateQuery = statement.executeUpdate(QueryString);
                        */
                        
                      /** String QueryString = "INSERT INTO domineup.\"Users\" (username, email, password, avatar) \n" +
            "VALUES ('"+username+"', '"+email+"', '"+password+"', NULL)\n";
                                               
                        updateQuery = statement.executeUpdate(QueryString);*/
                        
                        
                        //QUERY DE UPDATE PARA MUDAR A PASS
                        
                        String QueryString = "UPDATE domineup.\"Users\" SET password='kakaka' WHERE username='andre'";
                                               
                        updateQuery = statement.executeUpdate(QueryString);
                        
                       /* if (updateQuery  != 0) {
                        System.out.println("table is created successfully and " + rs + " row is inserted.");
                        }*/
                        
                      //query de select e imprimir
                        //String QueryString2 = "select * from domineup.\"Users\" ";
                         /* String QueryString2 = "select * from domineup.\"Users\" WHERE username = 'chico' "   ;                 
                        rs = statement.executeQuery(QueryString2);
                        
                        while (rs.next()) {
                            System.out.println("iohsduosdf");
                        System.out.println(rs.getString(2) + " " + rs.getString(2) + " " + rs.getString(3) +"\n");
                         }*/
                                         
                        
                        //rs.close();
                        statement.close();
                        connection.close();
		} else {
			System.out.println("Failed to make connection!");
		}
	}
 
}