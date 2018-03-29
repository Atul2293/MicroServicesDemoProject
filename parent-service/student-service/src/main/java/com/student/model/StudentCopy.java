package com.student.model;

import java.util.List;

public class StudentCopy {

	
	
	private Long id;
	

	private String name;
	

	private String standard;
	
	private List<Course>  courses;


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


	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	public StudentCopy() {
		
	}
	
	public StudentCopy(Long id, String name, String standard) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
	
}
