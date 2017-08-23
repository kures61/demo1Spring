package com.odev.main;

import com.odev.entity.Department;
import com.odev.util.Util;

/*
 * @author Lokman
 */
public class Demo1RestFulTest {

	public static void main(String[] args) {
		
		System.out.println("-------- Rest Full : @GET : getDepartmentName() ---------------");
		String getURL = "http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentName?deptId=25";
		String response = Util.getRestGetMethod(getURL);
		System.out.println("Response : \n"+response);
		
		

		System.out.println("\n-------- Rest Full : @GET : getDepartmentInfo() ---------------");
		getURL = "http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentInfo?deptId=26";
		response = Util.getRestGetMethod(getURL);
		System.out.println("Response : \n"+response);	
		try {
			Department dept = Util.JSon2Department(response);
			dept.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("\n-------- Rest Full : @POST : insertDepartment() ---------------");
		getURL = "http://localhost:8080/RestFulServerDemo1/rest/Demo/insertDepartment?name=rest22&desc=restClient22";
		response = Util.getRestPostMethod(getURL);  // insert TEST edileceði zaman acilmali
		System.out.println("Response : \n"+response);		
		
		System.out.println("\n-------- Rest Full : @POST : getDepartmentList() ---------------");
		getURL = "http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentList";
		response = Util.getRestPostMethod(getURL);
		System.out.println("Response : \n"+response);

		
		
		System.out.println("\n-------- Rest Full : @POST : getDepartmentEmployeeList() ---------------");
		getURL = "http://localhost:8080/RestFulServerDemo1/rest/Demo/getDepartmentEmployeeList";
		response = Util.getRestPostMethod(getURL);
		System.out.println("Response : \n"+response);		
		
	}

}
