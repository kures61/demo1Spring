package com.demo2.spring.model;

public class Department {
    private int deptId;
    private String name;
    private String description;
    
	public Department() {
		super();
	}

	public Department(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
    
	public void write(){
		if ( this != null ){
			System.out.println("Dept id  :"+this.getDeptId());
			System.out.println("Dept name:"+this.getName());
			System.out.println("Dept desc:"+this.getDescription());
		}
	}	
    
    
}
