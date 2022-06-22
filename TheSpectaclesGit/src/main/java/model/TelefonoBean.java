package model;

import java.io.Serializable;

public class TelefonoBean implements Serializable {
  
	
	long numPhone;
	String email;
	

	public TelefonoBean() {
		
	}
	
	public TelefonoBean(int numPhone, String email) {
		super();
		this.numPhone = numPhone;
		this.email = email;
	}

	public long getNumPhone() {
		return numPhone;
	}

	public void setNumPhone(long numPhone) {
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
