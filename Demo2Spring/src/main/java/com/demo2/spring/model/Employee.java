package com.demo2.spring.model;

public class Employee {
    private int empId;
    private String name;
    private String surname;
    private int salary;
    private int deptId;
    private String deptName;   // tablo da yok ama JSF lerde goruntulemek icin eklendi
    
	public Employee() {
		super();
	}

	public Employee(String name, String surname, int salary, int deptId) {
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

	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void write(){
		if ( this != null ){
			System.out.println("   Employee id     :"+this.getDeptId());
			System.out.println("   Employee name   :"+this.getName());
			System.out.println("   Employee surname:"+this.getSurname());
			System.out.println("   Employee salary :"+this.getSalary());
			System.out.println("   Employee deptId :"+this.getDeptId());
		}
	}    
    	
	
    
    
}
