package com.odev.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.odev.DAO.Demo1DAO;
import com.odev.entity.Department;
import com.odev.entity.DepartmentEmp;
import com.odev.util.Util;

/*
 * @author Lokman
 */

@Path("/Demo")
public class Demo1Info {
	
	// URL : http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentEmployeeList
	@POST
	@Path("/getDepartmentEmployeeList")
	@Produces(MediaType.TEXT_PLAIN)	
	public static String getDepartmentEmployeeList(){
		String jSon = "";
		List<DepartmentEmp> deptEmpList = Demo1DAO.getDepartmentEmpList();
		try {
			jSon = Util.Object2JSon(deptEmpList);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return jSon;
	}		// getDepartmentEmployeeList	
	
	// URL : http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentList
	@POST
	@Path("/getDepartmentList")
	@Produces(MediaType.TEXT_PLAIN)	
	public static String getDepartmentList(){
		String jSon = "";
		List<Department> deptList = Demo1DAO.getDepartmentList();
		try {
			jSon = Util.Object2JSon(deptList);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return jSon;
	}		
	
	// URL : http://localhost:8080/RestFulServerDemo1/rest/Demo/insertDepartment?name=depo&desc=depolama
	@POST
	@Path("/insertDepartment")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public static String insertDepartment(@QueryParam("name") String name
			                             , @QueryParam("desc") String desc){
		String jSon = "";
		int deptId = Demo1DAO.insertDepartment(0, name, desc);
		Department dept = Demo1DAO.getDepartment(deptId);
		dept.write();
		try {
			jSon = Util.Object2JSon(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return jSon;
	}		

	// URL : http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentInfo?deptId=26
	@GET
	@Path("/getDepartmentInfo")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public static String getDepartmentInfo(@QueryParam("deptId") int deptId){
		String jSon = "";
		Department dept = Demo1DAO.getDepartment(deptId);
		try {
			jSon = Util.Object2JSon(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return jSon;
	}	
	
	// URL : http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentName?deptId=25
	@GET
	@Path("/getDepartmentName")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public static String getDepartmentName(@QueryParam("deptId") int deptId){
		Department dept = Demo1DAO.getDepartment(deptId);
		return "DeptName : "+dept.getName();
	}	
	
	// URL : http://localhost:8080/RestFulServerDemo1/rest/Demo/getHelloMesaj2?name=Ali
	@GET
	@Path("/getHelloMesaj2")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public static String getHelloMesaj2(@QueryParam("name") String name){
		return "Hello "+name;
	}	


}
