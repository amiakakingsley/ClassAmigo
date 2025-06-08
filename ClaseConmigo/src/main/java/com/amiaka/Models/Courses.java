package com.amiaka.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
    private String courseName;
    private String description;
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "application_user_id")  // Foreign key in the Courses table
    private ApplicationUser applicationUser;
 
    public Courses() {}
    
	public Courses(Long id,String name, String courseName, String description, Double price, ApplicationUser applicationUser) {
		super();
		this.name = name;
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.price = price;
		this.applicationUser = applicationUser;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApplicationUser getApplicationUser() {
		return applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", courseName=" + courseName + ", description=" + description
				+ ", price=" + price + ", applicationUser=" + applicationUser + "]";
	}
    
}
