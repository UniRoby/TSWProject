package model;

import java.io.Serializable;
import java.sql.Date;

public class OrdineBean implements Serializable {
	
	int idOrder;
	Date date;
	String email;
	
	public OrdineBean(int idOrder, Date date, String email) {
		super();
		this.idOrder = idOrder;
		this.date = date;
		this.email = email;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ordine [idOrder=" + idOrder + ", date=" + date + ", email=" + email + "]";
	}
	
	
	
}
