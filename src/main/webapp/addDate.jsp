<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Date</title>
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style_main.css" rel="stylesheet" />

	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<br/>
	<h2>Add a new Date</h2>
 
	<form action="addNewDate" method="POST">
		<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="user1ID">User1 ID</label>
				<input type="text" class="form-control" id="user1ID" name="user1ID" placeholder="Enter user1ID" required>
			</div>
			<div class="form-group">
				<label for="user1ID">User2 ID</label>
				<input type="text" class="form-control" id="user2ID" name="user2ID" placeholder="Enter user2ID" required>
			</div>
			<div class="form-group">
				<label for="date">Date/Time</label>
				<input type="text" class="form-control" id="date" name="date" placeholder="Enter date/time" required>
			</div>
			<div class="form-group">
				<label for="location">Location</label>
				<input type="text" class="form-control" id="Location" name="Location" placeholder="Enter Location" required>
			</div>
			<div class="form-group">
				<label for="fee">Booking Fee</label>
				<input type="text" class="form-control" id="fee" name="fee" placeholder="Enter booking fee" required>
			</div>
			<div class="form-group">
				<label for="custRep">Customer Rep</label>
				<input type="text" class="form-control" id="custRep" name="custRep" placeholder="Enter custRep" required>
			</div>
			<div class="form-group">
				<label for="Comments">Comments</label>
				<input type="text" class="form-control" id="Comments" name="Comments" placeholder="Enter Comments" required>
			</div>
			<div class="form-group">
				<label for="user1Rating">User1 Rating</label>
				<input type="text" class="form-control" id="user1Rating" name="user1Rating" placeholder="Enter user1Rating" required>
			</div>
			<div class="form-group">
				<label for="user2Rating">User2 Rating</label>
				<input type="text" class="form-control" id="user2Rating" name="user2Rating" placeholder="Enter user2Rating" required>
			</div>

		</div>
		</div>
		<br/>
	  <button type="submit" class="btn btn-primary" style="display: table; margin: auto !important; width: 20% !important;" >Submit</button>
	</form>
	</div>
	<div class="container pt-1">
		<form action="home.jsp">
			<input type="submit" value="Home" class="btn btn-danger" style="display: table; margin: auto !important; width: 20% !important;"/>
		</form>
	</div>

</body>
</html>
