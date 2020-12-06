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
	<title>Manage Customer Help Page</title>
</head>
<body>
	<h1>Manage Customer Help Page</h1>
	<div>
		&emsp;Add Customer:<br>
		&emsp;&emsp;Redirects to add customer page<br>
		<br>
		&emsp;&emsp;SSN - Customer's SSN<br>
		&emsp;&emsp;Email Address - Customer's email used for login<br>
		&emsp;&emsp;Password - Customer's password<br>
		&emsp;&emsp;First Name - Customer's First Name<br>
		&emsp;&emsp;Last Name - Customer's Last Name<br>
		&emsp;&emsp;Address - Customer's street Address<br>
		&emsp;&emsp;City - Customer's city<br>
		&emsp;&emsp;State - Customer's state<br>
		&emsp;&emsp;Zipcode - Customer's zipcode<br>
		&emsp;&emsp;Telephone - Customer's Telephone (917) 919-1070<br>
		&emsp;&emsp;Account Number - Customer's Account Number<br>
		&emsp;&emsp;Account Creation Date - Customer's account creation date<br>
		&emsp;&emsp;Credit Card Number - Customer's credit card number<br>
		&emsp;&emsp;Profile Placement Priority - Super - 100/yr, Good - 50/yr, User - 0/yr<br>
		&emsp;&emsp;Rating - Customer's rating<br>
		&emsp;&emsp;Last Active - Customer's last active datetime<br>
		<br>
		&emsp;&emsp;Submit Button to submit once fields are filled<br>
		&emsp;&emsp;Home Button to return back to customer rep. home page<br>
		<br>
		&emsp;View / Edit / Delete Customer:<br>
		&emsp;&emsp;Redirects to modify customer page<br>
		<br>
		&emsp;&emsp;Edit Button to edit customer:<br>
		&emsp;&emsp;&emsp;Redirects to edit customer page with similar fields as to add customer.<br>
		<br>
		&emsp;&emsp;Delete Button to delete customer<br>
		<br>
		&emsp;&emsp;Home Button to return back to customer rep. home page<br>
	</div>

<br/>
	<div class="container pt-1">
		<form action="customerRepresentativeHome.jsp"> <!-- TODO CHANGE THIS TO APPROPRIATE HOME PAGE BASED ON ROLE -->
			<input type="submit" value="Home" class="btn btn-success" style="display: table; margin: auto !important; width: 50% !important;"/>
		</form>
	</div>

	
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
</body>
</html>