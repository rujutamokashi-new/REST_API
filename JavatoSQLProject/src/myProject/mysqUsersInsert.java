package myProject;

import java.sql.*;

public class mysqUsersInsert {
	public static void main(String[] args) {
	      try (
	         // Step 1: Allocate a database 'Connection' object
	         Connection conn = DriverManager.getConnection(
	        		 "jdbc:mysql://localhost:3306/DB?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
	                 "root", "rujuta$$");// for MySQL only
	 
	         // Step 2: Allocate a 'Statement' object in the Connection
	         Statement stmt = conn.createStatement();
	      ) {
	         // Step 3 & 4: Execute a SQL INSERT|DELETE statement via executeUpdate(),
	         //   which returns an int indicating the number of rows affected.
	 
	        // INSERT a record
	         String sqlInsert = "INSERT INTO User VALUES('Tom123','Moosa','Tom','Tom@gmail.com');";
	         System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
	         int countInserted = stmt.executeUpdate(sqlInsert);
	         System.out.println(countInserted + " records inserted.\n");
	 
	         // INSERT multiple records
	         sqlInsert = "insert into User values "
	               + "('Johnny123','Deans','Johnny','Johnny@gmail.com'),"
	               + "('Adam123','Jones','Adam','Adam@gmail.com')";
	         System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
	         countInserted = stmt.executeUpdate(sqlInsert);
	         System.out.println(countInserted + " records inserted.\n");
	 
	         // Issue a SELECT to check the changes
	         String strSelect = "select * from User";
	         System.out.println("The SQL statement is: " + strSelect + "\n");  // Echo For debugging
	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row
	            System.out.println(rset.getString("username") + ", "
	                    + rset.getString("password") + ", "
	                    + rset.getString("name")+ ", "
	                    + rset.getString("email"));
	                   
	         }
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources
	   }
}
