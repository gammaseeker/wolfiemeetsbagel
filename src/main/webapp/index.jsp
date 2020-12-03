<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	This is the login page
	This page contains a text field for username and another for password
	This page redirects to the Home page
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/style_main.css" rel="stylesheet" />

        <title>Login | Online Dating Website</title>
	</head>
	<body>
	
		<h2 style="text-align: center;padding: 3%;">Welcome to the Online Dating Website</h2>
		<div class="container indxContainer">
			<h3>Login</h3>
			<%
				String email = (String)session.getAttribute("email");
				String role = (String)session.getAttribute("role");
//				response.sendRedirect("customerRepresentativeHome.jsp");

				//redirect to home page if already logged in
				if(email != null) {
					if(role.equals("manager")) {
						response.sendRedirect("managerHome.jsp");
					}
					else if(role.equals("customerRepresentative")) {
						response.sendRedirect("customerRepresentativeHome.jsp");
					}
					// No redirects if logged in as a customer
				}
				
				String status = request.getParameter("status");
				if(status != null) {
					if(status.equals("false")) {
						out.print("Incorrect Login credentials!");
					}
					else {
						out.print("Some error occurred! Please try again.");
					}
				}
			%>
			<form action="login" style="background: lightgrey; padding: 10%;">
				<div class="form-group">
					<input type="email" class="form-control" name="username" placeholder="Username" required>
				</div>
				<div class="form-group">
	            	<input type="password" class="form-control" name="password" placeholder="Password" required>
	        	</div>
				<input type="submit" value="Login" class="btn btn-success"/>
			</form>
		</div>
		
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.1.3/bootstrap.min.js"></script>
	</body>
</html>
