<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	This is the Search Sales Report page
	This page displays fields to search a sale by month and year 
	This page redirects to the Show Sales Report page
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	<body>
		<h1>Filter</h1>
		<div class="container">
			<div class="container">
				<h3>Options:-</h3>
				<br/>
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">By Age</h5>
								<div class="container">
									<form method="POST" action="byAge">
										<label>Age: </label><br/>
										<input type="text" id="age" name="age">
										<br/>
										<input type="submit" value="Search" class="btn btn-primary btn-bet"/>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">By Weight</h5>
								<div class="container">
									<form method="POST" action="byWeight">
										<label for="weight">Weight:</label>
										<input type="text" class="form-control" id="weight" name="weight">
										<br/>
										<input type="submit" value="Search" class="btn btn-primary btn-bet"/>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">By Height</h5>
								<div class="container">
									<form method="POST" action="byHeight">
										<label for="height">Height:</label>
										<input type="text" class="form-control" id="height" name="height">
										<br/>
										<input type="submit" value="Search" class="btn btn-primary btn-bet"/>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">By Hair Color</h5>
								<div class="container">
									<form method="POST" action="byHairColor">
										<label for="hairColor">Hair Color:</label>
										<input type="text" class="form-control" id="hairColor" name="hairColor">
										<br/>
										<input type="submit" value="Search" class="btn btn-primary btn-bet"/>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		<div class="container pt-1">
			<form action="home.jsp">
				<input type="submit" value="Home" class="btn btn-success"/>
			</form>
		</div>
	
		
		<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</body>
</html>
