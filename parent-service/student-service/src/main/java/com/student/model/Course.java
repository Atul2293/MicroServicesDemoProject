package com.student.model;



public class Course {

	
	
	
	private Long cid;
	
	
	private String name;
	
	
	private String decription;
	
	
	private Long sid;


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


	public Course() {
		
	}
	
	public Course(Long cid, String name, String decription, Long sid) {
		super();
		this.cid = cid;
		this.name = name;
		this.decription = decription;
		this.sid = sid;
	}

	
	
	
}
