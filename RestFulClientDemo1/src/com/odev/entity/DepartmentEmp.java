package com.odev.entity;

import java.util.ArrayList;
import java.util.List;

public class DepartmentEmp {
    private int deptId;
    private String name;
    private String description;
    private List<Employee> employeeList;
	
    public DepartmentEmp() {
		super();
		employeeList = new ArrayList<Employee>();
	}
	
    public DepartmentEmp(int deptId, String name, String description) {
		this.deptId = deptId;
		this.name = name;
		this.description = description;
		employeeList = new ArrayList<Employee>();
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
    
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void write(){
		if ( this != null ){
			System.out.println("Dept id  :"+this.getDeptId());
			System.out.println("Dept name:"+this.getName());
			System.out.println("Dept desc:"+this.getDescription());
		}
	}
    

}
