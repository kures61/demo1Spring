package com.demo2.spring.dao;

import java.util.List;

import com.demo2.spring.model.Employee;


public interface EmployeeDAO {

	public void saveOrUpdate(Employee Employee);
	
	public void delete(int EmployeeId);
	
	public Employee get(int EmployeeId);
	
	public List<Employee> list();

}
