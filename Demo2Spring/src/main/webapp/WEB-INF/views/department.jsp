<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Department List</h1>
	        <h3><a href="newDepartment">New Department</a></h3>
	        <table border="1">
	        	<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;&nbsp;&nbsp;Dept.Id&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;&nbsp;&nbsp;Dept.Name&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;Description&nbsp;</th>
	        	<th>&nbsp;</th>
	        	
				<c:forEach var="department" items="${listDepartment}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
	        		<td>${department.deptId}</td>
					<td>${department.name}</td>
					<td>${department.description}</td>
					<td>
						<a href="editDepartment?deptId=${department.deptId}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteDepartment?deptId=${department.deptId}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
			</table>
			
			<br><br><center> ${errorDesc}</center><br>
    	</div>
    	
    	<h3><a href="listEmployee">Employee List</a></h3>
    	<h3><a href="listMeeting">Meeting List</a></h3>
    	<h3><a href="listMeetingDetail">Meeting Detail List</a></h3>
    	
    </body>
</html>
