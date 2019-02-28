package app.value;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Company {
	
	private Integer id;
	private String name;
	private String comune;
	private String indirizzo;
	private String telefono;
	private String email;
	private String web;
	private String note;


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
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Company() {
		super();
	}

	public Company(ResultSet rst) {
		this.rstToCompany(rst);
		}


	public Company rstToCompany(ResultSet rst) {
		try {
			this.setId(rst.getInt("ID"));
			this.setName(rst.getString("Azienda"));
			this.setComune(rst.getString("Comune"));
			this.setEmail(rst.getString("Email"));
			this.setIndirizzo(rst.getString("Indirizzo"));
			this.setTelefono(rst.getString("Telefono"));
			this.setWeb(rst.getString("Web"));
			this.setNote(rst.getString("Note"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
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
	
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
