package com.amiaka.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ApplicationUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String firstname;
    private String lastname;
    private String email;
    private String password;
   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "USER_ID",
    referencedColumnName ="ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",
    referencedColumnName ="ID")})
    private Set<Role> roles = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "tutor_course", joinColumns = {@JoinColumn(name = "Tutor_id",
    referencedColumnName ="ID")}, inverseJoinColumns = {@JoinColumn(name = "Course_Id",
    referencedColumnName ="ID")})
    private Set<Courses> courses = new HashSet<>();

    public ApplicationUser(Long id, String firstname, String lastname, String email, String password, Set<Role> roles,
			Set<Courses> courses) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.courses = courses;
	}

	public ApplicationUser() {}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

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

	public void setId(Long id) {
		this.id = id;
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
	
	public String getFullName() {
		return this.firstname + " " + this.lastname;
	}
	

	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", roles=" + roles + ", courses=" + courses + "]";
	}
	
	
	
	
	

}
