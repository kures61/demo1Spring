package com.demo2.spring.dao;

import java.util.List;
import java.util.Map;

import com.demo2.spring.model.Department;


public interface DepartmentDAO {
	
	public void saveOrUpdate(Department department);
	
	public String delete(int departmentId);
	
	public Department get(int departmentId);
	
	public List<Department> list();
	

}
