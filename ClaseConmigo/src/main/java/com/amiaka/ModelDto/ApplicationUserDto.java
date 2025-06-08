package com.amiaka.ModelDto;

import java.util.Set;

import com.amiaka.Models.Role;

public class ApplicationUserDto {

private String firstname;
private String lastname;
private String email;
private String password;
private long id;


public ApplicationUserDto(String firstname, String lastname, String email, String password, long id, Set<Role> roles) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
	this.id = id;
	this.roles = roles;
}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


private Set<Role> roles;
    
    public ApplicationUserDto() {}

	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "ApplicationUserDto [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", roles=" + roles + "]";
	}





	
}
