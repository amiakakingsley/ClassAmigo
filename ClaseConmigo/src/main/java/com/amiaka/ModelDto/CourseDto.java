package com.amiaka.ModelDto;

public class CourseDto {

	private Long id;
	private String name;
    private String courseName;
    private String description;
    private Double price;
	
	public CourseDto(Long id, String name, String courseName, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.courseName = courseName;
		this.description = description;
		this.price = price;
	}
	
	public CourseDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "CourseDto [id=" + id + ", name=" + name + ", courseName=" + courseName + ", description=" + description
				+ ", price=" + price + "]";
	}
	
	
}
