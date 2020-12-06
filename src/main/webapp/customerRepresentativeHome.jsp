<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	This is the Home page for Customer Representative
	This page contains various buttons to navigate the online auction house
	This page contains customer representative specific accessible buttons
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
		<title>Customer Representative Home</title>
		
		<script>
			function getHelp(){
				var sel = document.getElementById('help');
				
				switch(sel.value) {
					case "1":
						window.location.href = "helpRecordADate.jsp";
						break;
					case "2":
						window.location.href = "helpManageCustomer.jsp";
						break;
					case "3":
						window.location.href = "helpViewCustomerMailingList.jsp";
						break;
					case "4":
						window.location.href = "helpViewDateSuggestions.jsp";
						break;
					default:
						break;
				}
			}
		</script>
		
	</head>
	<body>
	
		<h1>Welcome to the Online Dating System!</h1>
		<label for="help">Help Topics</label>
		<select name="help" id="help" onchange="getHelp();">
			<option value="">Help... </option>
			<option value="1">Record a Date</option>
			<option value="2">Manage Customer</option>
			<option value="3">View Customer Mailing List</option>
			<option value="4">View Date Suggestions for Customers</option>
		</select>
		<div class="container">
			<h2>Customer Representative Options:</h2>
			<%
				String email = (String)session.getAttribute("email");
				String role = (String)session.getAttribute("role");
				
				//redirect to appropriate home page if already logged in
				if(email != null) {
					if(role.equals("manager")) {
						response.sendRedirect("managerHome.jsp");
					}
					else if(!role.equals("customerRepresentative")) {
						response.sendRedirect("home.jsp");
					}
				}
				else {
					// redirect to log in if not alreaddy logged in
					response.sendRedirect("index.jsp");
				}
			%>
			
			<div class="row">
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">Record a Date</h5>
    					<div class="container">
							<form action="addDate.jsp">
								<input type="submit" value="Record Date" class="btn btn-success"/>
							</form>
						</div>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">Manage Customer</h5>
    					<div class="container">
							<form action="addCustomer.jsp">
								<input type="submit" value="Add Customer" class="btn btn-primary"/>
							</form>
							<form action="modifyCustomers" class="pt-1">
								<input type="submit" value="View / Edit / Delete Customer" class="btn btn-primary"/>
							</form>
							<!-- <form action="searchCustomer.jsp" class="pt-1">
								<input type="submit" value="Search Customer" class="btn btn-primary"/>
							</form> -->
							
						</div>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">View Customer Mailing List</h5>
    					<div class="container">
							<form action="getCustomerMailingList">
								<input type="submit" value="Customer Mailing List" class="btn btn-primary"/>
							</form>
						</div>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">View Date Suggestions for Customers</h5>
    					<div class="container">
							<form action="getCustomerList">
								<input type="submit" value="View Date Suggestions" class="btn btn-success"/>
							</form>
						</div>
					  </div>
					</div>
				</div>			
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
