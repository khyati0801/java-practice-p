package com.jspcrud;

public class User {
	private int id;
	private String name;
	private String Emailid;
	private String Password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", Emailid=" + Emailid + ", Password=" + Password + "]";
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getEmailid() {
		// TODO Auto-generated method stub
		return Emailid;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return Password;
	}
	
}
