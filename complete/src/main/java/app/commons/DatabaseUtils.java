package app.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.value.User;

@Service
public class DatabaseUtils {
	
	
	public Connection connect() throws SQLException {
		Connection c = null;
	         try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         return c;
}
	
	
   public List<User> start() {
	   Connection c = null;
	      Statement stmt = null;
	      List<User> results = new ArrayList<>();
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/test",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "SELECT * FROM USERS";
	         ResultSet rst = stmt.executeQuery(sql);
	         User user;
	         while(rst.next()) {
	        	 user = new User();
	        	 System.out.println(rst.getString("id"));
	        	 user.rstToUser(rst);
	        	 results.add(user);
	         }
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	   
	      return results;
	   }
}