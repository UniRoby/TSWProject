package model;

import java.io.Serializable;
import java.util.UUID;
import java.util.Date;

public class OrdineBean implements Serializable {
	
	UUID idOrder;
	Date data;
	String email;
	String stato;
	int tot=0;
	

	public OrdineBean() {
		this.idOrder = null;
		this.email = null;
		this.data = null;
		this.stato = null;
		
	}
	

	public OrdineBean(UUID idOrder, Date date, String email,String stato) {
		super();
		this.idOrder = idOrder;
		this.data = date;
		this.email = email;
		this.stato= stato;
	}

	public UUID getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(UUID idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDate() {
		return data;
	}
	public String getStato() {
		return this.stato;
	}
	public void setStato(String s) {
		this.stato=s;
	}
	public void setDate(Date date) {
		this.data = date;
	}

	public String getEmail() {
		return email;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int t) {
		tot=t;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Ordine [idOrder=" + idOrder + ", date=" + data + ", email=" + email + "]";
	}
	
}
