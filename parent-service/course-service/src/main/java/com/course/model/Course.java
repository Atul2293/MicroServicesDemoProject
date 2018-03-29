package com.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	
	
	private String name;
	
	
	private String decription;
	
	
	private Long sid;


	public Course() {
		
	}
	

	public Course(String name, String decription, Long sid) {
		super();
		this.name = name;
		this.decription = decription;
		this.sid = sid;
	}


	public Long getCid() {
		return cid;
	}


	public void setCid(Long cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDecription() {
		return decription;
	}


	public void setDecription(String decription) {
		this.decription = decription;
	}


	public Long getSid() {
		return sid;
	}


	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	
	
}
