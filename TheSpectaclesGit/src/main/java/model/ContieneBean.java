package model;

import java.io.Serializable;

public class ContieneBean  implements Serializable{
	
	int idOrder;
	String idGlasses;
	int quantity;
	
	public ContieneBean(int idOrder, String idGlasses, int quantity) {
		super();
		this.idOrder = idOrder;
		this.idGlasses = idGlasses;
		this.quantity = quantity;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getIdGlasses() {
		return idGlasses;
	}

	public void setIdGlasses(String idGlasses) {
		this.idGlasses = idGlasses;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Contiene [idOrder=" + idOrder + ", idGlasses=" + idGlasses + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
