package com.honeywell.homemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User extends Model {
	
	

	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String salt;
	
	private boolean accountEnable;
	
	private String roles;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isAccountEnable() {
		return accountEnable;
	}

	public void setAccountEnable(boolean accountEnable) {
		this.accountEnable = accountEnable;
	}

	/*public long getId() {
		return id;
	}*/

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
