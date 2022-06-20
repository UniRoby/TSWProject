package model;

import java.io.Serializable;

public class TelefonoBean implements Serializable {
  
	
	int numPhone;
	String email;
	
	public TelefonoBean(int numPhone, String email) {
		super();
		this.numPhone = numPhone;
		this.email = email;
	}

	public int getNumPhone() {
		return numPhone;
	}

	public void setNumPhone(int numPhone) {
		this.numPhone = numPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Telefono [numPhone=" + numPhone + ", email=" + email + "]";
	}
	
	
}
