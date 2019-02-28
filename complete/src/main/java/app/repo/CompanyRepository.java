package app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.manager.CompanyManagerQuery;
import app.value.Company;

@Service
public class CompanyRepository extends CompanyManagerQuery{
	
	public List<Company> findAll() throws SQLException{
		List<Company> results = new ArrayList<>();
		
		PreparedStatement stmt = null;
		Connection conn = this.connect();
		String sql = this.sqlFindAll();
		stmt = conn.prepareStatement(sql.toString());
		
        ResultSet rst = stmt.executeQuery();

		 while(rst.next()) {
			 Company user = new Company(rst);
			 results.add(user);
		}
		 stmt.close();
		 return results;
	}

	public Company findById(Integer id) throws SQLException {
		Company result = null;
		
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
			 return new Company(rst);
		}
		 stmt.close();
		 return result;
	}
	
	
}
