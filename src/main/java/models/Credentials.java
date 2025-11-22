package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
	
	@JsonProperty("UserName")
	private String userName;
	
	@JsonProperty("Password")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	

}
