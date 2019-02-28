package app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.manager.UserManagerQuery;
import app.value.User;

@Service
public class UserRepository extends UserManagerQuery{

	public User create(User user) throws SQLException{
		if(user==null)
			return null;
		PreparedStatement stmt = null;
		Connection conn = this.connect();
		String sql = this.sqlInsert();
		stmt = conn.prepareStatement(sql.toString());
		///--PARAMETERS
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getUsername());
		stmt.setDate(3, user.getBirthDate());
		System.out.println(stmt.toString());
		//PARAMETERS--\\\
		
		List<User> dbUsers = this.findAll();
		for(User u : dbUsers) {
			if(user.getName().equals(u.getName()))
				return null;
			if(user.getUsername()==u.getUsername())
				return null;
		}
		
        int insertedRow = stmt.executeUpdate();
        
        if(insertedRow>0) {
        	return user;
        }else {
        	return null;
        }
	}
	
	public List<User> findAll() throws SQLException{
		List<User> results = new ArrayList<>();
		
		PreparedStatement stmt = null;
		Connection conn = this.connect();
		String sql = this.sqlFindAll();
		stmt = conn.prepareStatement(sql.toString());
		
        ResultSet rst = stmt.executeQuery();

		 while(rst.next()) {
			 User user = new User(rst);
			 System.out.println(rst.getString("id"));
			 results.add(user);
		}
		 stmt.close();
		 return results;
	}

	public User findById(Integer id) throws SQLException {
		User result = null;
		
		PreparedStatement stmt = null;
		Connection conn = this.connect();
		String sql = this.sqlFindById();
		stmt = conn.prepareStatement(sql.toString());
		///--PARAMETERS
		stmt.setInt(1, id);
		//PARAMETERS--\\\
        ResultSet rst = stmt.executeQuery();

		 while(rst.next()) {
			 System.out.println(rst.getString("id"));
			 return new User(rst);
		}
		 stmt.close();
		 return result;
	}
	
	
}
