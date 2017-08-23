package com.demo2.spring.model;

public class Meeting {
    private int mtngId;
    private String name;
    private String description;
    
	public Meeting() {
		super();
	}

	public Meeting(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public int getMtngId() {
		return mtngId;
	}

	public void setMtngId(int mtngId) {
		this.mtngId = mtngId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
	
    
    
	
}
