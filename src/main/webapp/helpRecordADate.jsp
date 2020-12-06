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
	<title>Record A Date Help Page</title>
</head>
<body>
	<h1>Record A Date Help Page</h1>
	<div>
		&emsp;Record Date:<br>
		&emsp;&emsp;Clicking on this button will redirect the user to the add new date page<br>
		<br>
		&emsp;&emsp;User1ID - User1's profile ID<br>
		&emsp;&emsp;User2ID - User2's profile ID<br>
		&emsp;&emsp;Date/Time - Datetime of the Date<br>
		&emsp;&emsp;Location - Location of the Date<br>
		&emsp;&emsp;Booking Fee - The booking fee cost<br>
		&emsp;&emsp;Customer Rep - The customer representative's SSN that is responsible for the date<br>
		&emsp;&emsp;Comments - Comments of the date<br>
		&emsp;&emsp;User1 Rating - User1's rating of the date<br>
		&emsp;&emsp;User2 Rating - User2's rating of the date<br>
		<br>
		&emsp;&emsp;Submit Button to submit once the fields are filled<br>
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