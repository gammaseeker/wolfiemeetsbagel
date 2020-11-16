<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!--
	This is the Add Employee page
	This page displays fields to add an Employee 
	The details are sent to the AddEmployeeController class in resources package
-->
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Employee</title>
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style_main.css" rel="stylesheet" />

	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<br/>
	<h2>Add a new Employee</h2>
 
	<form action="addEmployee" method="POST">
		<div class="row">
		<div class="col-md-6">
	  <div class="form-group">
	    <label for="employeeEmail">Email address</label>
	    <input type="email" class="form-control" id="employeeEmail" name="employeeEmail" placeholder="Enter email" required>
	  </div>
	  <div class="form-group">
	    <label for="employeePassword">Password</label>
	    <input type="password" class="form-control" id="employeePassword" name="employeePassword" placeholder="Password" required>
	  </div>
  	  <div class="form-group">
	    <label for="employeeFirstName">First Name</label>
	    <input type="text" class="form-control" id="employeeFirstName" name="employeeFirstName" placeholder="First Name" required>
	  </div>
  	  <div class="form-group">
	    <label for="employeeLastName">Last Name</label>
	    <input type="text" class="form-control" id="employeeLastName" name="employeeLastName" placeholder="Last Name" required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeAddress">Address</label>
	    <input type="text" class="form-control" id="employeeAddress" name="employeeAddress" placeholder="Address" required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeCity">City</label>
	    <input type="text" class="form-control" id="employeeCity" name="employeeCity" placeholder="City" required>
	  </div>
		<div class="form-group">
			<label for="employeeRole">Role</label>
			<select name="employeeRole" id="employeeRole" class="form-control">
				<option value="manager">Manager</option>
				<option value="custRep">Customer Representative</option>
			</select>
		</div>
		</div>

		<div class="col-md-6">

		<div class="form-group">
	    <label for="employeeState">State</label>
	    <input type="text" class="form-control" id="employeeState" name="employeeState" placeholder="State" required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeZipcode">Zipcode</label>
	    <input type="text" class="form-control" id="employeeZipcode" name="employeeZipcode" placeholder="Zipcode" required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeTelephone">Telephone</label>
	    <input type="text" class="form-control" id="employeeTelephone" name="employeeTelephone" placeholder="Telephone number" required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeSSN">SSN</label>
	    <input type="text" class="form-control" id="employeeSSN" name="employeeSSN" placeholder="XXX-XX-XXXX" required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeStartDate">Start Date</label>
	    <input type="text" class="form-control" id="employeeStartDate" name="employeeStartDate" placeholder="YYYY-MM-DD" required>
	  </div>
   	  <div class="form-group">
	    <label for="employeeHourlyRate">Hourly Rate</label>
	    <input type="text" class="form-control" id="employeeHourlyRate" name="employeeHourlyRate" placeholder="Hourly Rate" required>
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
