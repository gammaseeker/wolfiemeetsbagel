<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	This page lets a customer picks their profile
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/style_main.css" rel="stylesheet" />

        <title>Pick your profile</title>
	</head>
	<body>
	
		<h2 style="text-align: center;padding: 3%;">Pick your profile</h2>
		<div class="container indxContainer">
			<%
				String email = (String)session.getAttribute("email");
				String role = (String)session.getAttribute("role");
//				response.sendRedirect("customerRepresentativeHome.jsp");

				//redirect to appropriate home page if already logged in
				if(email != null) {
					if(role.equals("manager")) {
						response.sendRedirect("managerHome.jsp");
					}
					else if(role.equals("customerRepresentative")) {
						response.sendRedirect("customerRepresentativeHome.jsp");
					}
				}
				else {
					// redirect to log in if not alreaddy logged in
					response.sendRedirect("index.jsp");
				}
			%>

			<c:forEach items="${profileIDs}" var="cd">
				<form method="POST" action="setCustomerProfile">
					<div class="form-group">
						<input type="hidden" class="form-control" name="profileID" value=${cd}> 
					</div>
					<input type="submit" value=${cd} class="btn btn-success"/>
				</form>
		    </c:forEach>
		</div>
		
		<div class="container">
			<form action="logout">
				<input type="submit" value="Logout" class="btn btn-danger"/>
			</form>
		</div>
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.1.3/bootstrap.min.js"></script>
	</body>
</html>