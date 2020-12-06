<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width:device-width, initial-scale=1">
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	<title>Help Manage Employees</title>
</head>
<body>
	<div class="container">
		<h1>How to Manage Employees</h1>
		<hr>
		<h2>Adding Employees</h2>
		<div>
			<div>To add an employee, click on the "Add Employee" button. </div>
			<img src="imgs/addEmployee.png" width="50%" height="50%">
			<div>Then enter the appropriate information for your new employee then hit submit.</div>
			<img src="imgs/addEmployeeForm.png" width="60%" height="60%">
		</div>
		<hr>
		<h2>View Employees</h2>
		<div>
			To view employees, click on the "View/Edit/Delete Employee" button and all of your employees will be displayed.
		</div>
		<hr>
		<h2>Edit Employee</h2>
		<div>
			To edit an employee, click on the "View/Edit/Delete Employee" button and all of your employees will be displayed.
			Then click on the "Edit" button and edit the appropriate information for that employee.
		</div>
		<hr>
		<h2>Delete Employee</h2>
		<div>
			To delete an employee, click on the "View/Edit/Delete Employee" button and all of your employees will be displayed.
			Then click on the "Delete" button to delete your selected employee.
		</div>
	</div>
<br/>
	<div class="container pt-1">
		<form action="managerHome.jsp"> 
			<input type="submit" value="Home" class="btn btn-success" style="display: table; margin: auto !important; width: 50% !important;"/>
		</form>
	</div>

	</div>

	
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
</body>
</html>