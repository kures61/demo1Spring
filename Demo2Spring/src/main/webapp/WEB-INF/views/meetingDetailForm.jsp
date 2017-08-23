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
		<h1>New Meeting Detail</h1>
		<form:form action="saveMeetingDetail" method="post" modelAttribute="meetingDetail">
		<table>
			<form:hidden path="mtngDetailId"/>
			<tr>
				<td>Meeting:</td>
				<td>
				  <form:select path="meetingId">
                    <form:option value="0" label="Select" />
                    <form:options items="${meetsAll}" itemValue="metId" itemLabel="metName" />
                  </form:select>
				</td>
			</tr>
			<tr>
				<td>Department:</td>
				<td>
				  <form:select path="deptId">
                    <form:option value="0" label="Select" />
                    <form:options items="${deptsAll}" itemValue="id" itemLabel="name" />
                  </form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
	
	<br><br><br>
	<h3><a href="lstMeetingDetail">Go Back..</a></h3>
	
</body>
</html>