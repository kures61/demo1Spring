<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Employee List</h1>
	        <h3><a href="newEmployee">New Employee</a></h3>
	        <table border="1">
	        	<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;&nbsp;&nbsp;Emp.Id&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;&nbsp;&nbsp;Name&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;Surname&nbsp;</th>
	        	<th>&nbsp;Salary&nbsp;</th>
	        	<th>&nbsp;Dept.Id&nbsp;</th>
	        	<th>&nbsp;Dept.Name&nbsp;</th>
	        	<th>&nbsp;</th>
	        	
				<c:forEach var="employee" items="${listEmployee}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
	        		<td>${employee.empId}</td>
					<td>${employee.name}</td>
					<td>${employee.surname}</td>
					<td>${employee.salary}</td>
					<td>${employee.deptId}</td>
					<td>${employee.deptName}</td>
					<td>
						<a href="editEmployee?empId=${employee.empId}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteEmployee?empId=${employee.empId}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    	
    	<h3><a href="lstDepartment">Department List</a></h3>
    	<h3><a href="listMeeting">Meeting List</a></h3>
    	<h3><a href="listMeetingDetail">Meeting Detail List</a></h3>
 
    	
    </body>
</html>
