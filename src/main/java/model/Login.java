package model;

import java.util.ArrayList;
import java.util.List;

public class Login {
	/*
	 * This class is a representation of the login table in the database
	 * Each instance variable has a corresponding getter and setter
	 */
	
	private String username;
	private String password;
	private String role;
	private List<String> profileID = new ArrayList<String>(); // Optional field

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getProfileID() {
		return profileID;
	}
	public void setProfileID(List<String> profileID) {
		this.profileID = new ArrayList<>(profileID) ;
	}
	public void addProfileID(String profileID) {
		this.profileID.add(profileID);
	}
	

}
