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
	<title>Help Manage Users</title>
</head>
<body>
	<div class="container">
		<h1>How to Manage Users</h1>
		<hr>
		<h2>Adding Users</h2>
		<div>
			To add a user, click on the "Add Users" button.
			Then enter the appropriate information for the user then hit submit.
		</div>
		<hr>
		<h2>View Users</h2>
		<div>
			To view users, click on the "View/Edit/Delete Users" button and all of your users will be displayed.
		</div>
		<hr>
		<h2>Edit Users</h2>
		<div>
			To edit a user, click on the "View/Edit/Delete User" button and all of your users will be displayed.
			Then click on the "Edit" button and edit the appropriate information for that user.
		</div>
		<hr>
		<h2>Delete User</h2>
		<div>
			To delete a user, click on the "View/Edit/Delete User" button and all of your users will be displayed.
			Then click on the "Delete" button to delete your selected user.
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