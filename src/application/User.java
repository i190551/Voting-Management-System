package application;

import java.io.IOException;

abstract public class User {
	
	private String username;
	private String cnic;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

		
	abstract public void viewreport() throws IOException;
	abstract public void viewcandidates();
	abstract public void searchcandidates(String ccnic);
	abstract public void signup() throws IOException;
	abstract public void login() throws IOException;
}
