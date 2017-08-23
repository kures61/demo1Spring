<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Meeting</title>
</head>	
<body>
	<div align="center">
		<h1>New/Edit Meeting</h1>
		<form:form action="saveMeeting" method="post" modelAttribute="meeting">
		<table>
			<form:hidden path="mtngId"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
	
	<br><br><br>
	<h3><a href="lstMeeting">Go Back..</a></h3>
	
</body>
</html>