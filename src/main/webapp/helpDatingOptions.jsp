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
	<title>Dating Options Help Page</title>
</head>
<body>
	<h1>Dating Options Help Page</h1>
	<p>
		&emsp;Browse All Profiles:<br>
			&emsp;&emsp;Redirects to date profile page and shows all profile<br>
			<br>
			&emsp;&emsp;Refer Button:<br>
			&emsp;&emsp;&emsp;Refer the selected profile to another user's profile<br>
			&emsp;&emsp;Make a date Button:<br> 
			&emsp;&emsp;&emsp;&emsp;make a date with the selected profile<br>
			&emsp;&emsp;Like Button:<br> 
			&emsp;&emsp;&emsp;&emsp;likes the selected profile<br>
			<br>
			
		&emsp;Cancel Date:<br>
			&emsp;&emsp;Redirects to cancel date page<br>
			<br>
			&emsp;&emsp;Shows all pending dates for the current user<br>
			&emsp;&emsp;Cancel Date Button:<br>
			&emsp;&emsp;&emsp;cancels the pending date selected by the current user<br>
			<br>
			
		&emsp;Comment Date:<br>
			&emsp;&emsp;Redirects to comment date page<br>
			<br>
			&emsp;&emsp;Comment Button:<br>
			&emsp;&emsp;&emsp;submits the comments in the text box<br>
			<br>
		
		&emsp;Home Button returns to customer home page<br>
	</p>

<br/>
	<div class="container pt-1">
		<form action="home.jsp"> <!-- TODO CHANGE THIS TO APPROPRIATE HOME PAGE BASED ON ROLE -->
			<input type="submit" value="Home" class="btn btn-success" style="display: table; margin: auto !important; width: 50% !important;"/>
		</form>
	</div>

	
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
</body>
</html>