package com.demo2.spring.model;

public class DepartmentComboBox {
	//JSF de comboBox icin
	
	private int id;
	private String name;
	
	public DepartmentComboBox() {
		super();
	}
	
	public DepartmentComboBox(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
