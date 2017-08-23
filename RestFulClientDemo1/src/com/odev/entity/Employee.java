package com.odev.entity;

public class Employee {
    private int empId;
    private String name;
    private String surname;
    private int salary;
    private int deptId;
    
	public Employee() {
		super();
	}
	
	public Employee(int empId, String name, String surname, int salary, int deptId) {
		super();
		this.empId = empId;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.deptId = deptId;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
    
    
    

}
