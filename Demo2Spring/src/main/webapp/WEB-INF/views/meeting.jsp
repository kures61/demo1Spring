<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meeting Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Meeting List</h1>
	        <h3><a href="newMeeting">New Meeting</a></h3>
	        <table border="1">
	        	<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;&nbsp;&nbsp;Meeting Id&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;&nbsp;&nbsp;Meeting Name&nbsp;&nbsp;&nbsp;</th>
	        	<th>&nbsp;Meeting Description&nbsp;</th>
	        	<th>&nbsp;</th>
	        	
				<c:forEach var="meeting" items="${listMeeting}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${meeting.mtngId}</td>
					<td>${meeting.name}</td>
					<td>${meeting.description}</td>
					<td>
						<a href="editMeeting?mtngId=${meeting.mtngId}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteMeeting?mtngId=${meeting.mtngId}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    	
    	<br><br><center> ${errorDesc}</center><br>
    	
    	<h3><a href="lstDepartment">Department List</a></h3>
    	<h3><a href="listEmployee">Employee List</a></h3>
    	<h3><a href="listMeetingDetail">Meeting Detail List</a></h3>
    	
    </body>
</html>
