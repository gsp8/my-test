package app.manager;

import app.commons.DatabaseUtils;

public class UserManagerQuery extends DatabaseUtils{

	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		String dop = "\"";
		sql.append("insert into users (" + dop + "nome" + dop +", " + dop+ "username" + dop + ", " + dop + "birthDate"+ dop + ") VALUES(?,?,?)");
		 
		return sql.toString();
	}
	
	public String sqlFindAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM users order by id asc");
		 
		return sql.toString();
	}
	
	public String sqlFindById() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM users WHERE id=?");
		 
		return sql.toString();
	}
}
