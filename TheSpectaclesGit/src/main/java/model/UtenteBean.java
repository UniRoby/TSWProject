package model;

import java.io.Serializable;
import java.sql.Date;

public class UtenteBean implements Serializable, Cloneable {

	private static final long serialVersionUID = -850475236728288737L;
	private String pass;
	private int role;
	private String email;
	private String firstName;
	private String lastName;
	private Date birthday;

	
	public UtenteBean() {
	}

	public UtenteBean(String email, String pass,String firstName,String lastName,Date birthday,int role) {
		this.firstName = firstName;
		this.email = email;
		this.pass= pass;
		this.lastName=lastName;
		this.birthday=birthday;
		this.role=role;
	}
	
	public String getPass() {
		return pass;
	}

	public int getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toString() {
		return "UtenteBean [pass=" + pass + ", role=" + role + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthday=" + birthday+ "]";
	}
}
