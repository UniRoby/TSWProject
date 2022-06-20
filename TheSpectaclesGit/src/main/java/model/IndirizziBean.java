package model;

import java.io.Serializable;

public class IndirizziBean implements Serializable {
	
	int idIndirizzo;
	String address;
	boolean status;
	String city;
	String province;
	int cap;
	String email;
	
	
	
	public IndirizziBean(int idIndirizzo, String address, boolean status, String city, String province, int cap,
			String email) {
		
		this.idIndirizzo = idIndirizzo;
		this.address = address;
		this.status = status;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Indirizzi [idIndirizzo=" + idIndirizzo + ", address=" + address + ", status=" + status + ", city="
				+ city + ", province=" + province + ", cap=" + cap + ", email=" + email + "]";
	}


	public int getIdIndirizzo() {
		return idIndirizzo;
	}
	public void setIdIndirizzo(int idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
