package app.value;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	
	private Integer id;
	private String name;
	private String username;
	private Date birthDate;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public User() {
		super();
	}

	public User(ResultSet rst) {
		this.rstToUser(rst);
		}


	public User rstToUser(ResultSet rst) {
		try {
			this.setId(rst.getInt("id"));
			this.setName(rst.getString("nome"));
			this.setUsername(rst.getString("username"));
			this.setBirthDate(rst.getDate("birthDate"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Date date = birthDate;
		return "ID:" + id + "\nNAME:" + name + "\nuser:" + username + "\nbirth:" + date;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
