<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	This is the Home page for Manager
	This page contains various buttons to navigate the online auction house
	This page contains manager specific accessible buttons
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/style_main.css" rel="stylesheet" />
		<title>Manager Home</title>
	</head>
	<body>
	
		<h2 style="text-align: center; padding: 3%">Welcome to the Online Dating System!</h2>
		<label for="help">Help Topics</label>
		<select name="help" id="help">
			<option value="1">Topic 1</option>
			<option value="2">Topic 2</option>
			<option value="3">Topic 3</option>
			<option value="4">Topic 4</option>
		</select>
		<div class="container">
			<h3>Manager Options:</h3>
			<%
				String email = (String)session.getAttribute("email");
				String role = (String)session.getAttribute("role");
				
				//redirect to appropriate home page if already logged in
				if(email != null) {
					if(role.equals("customerRepresentative")) {
						response.sendRedirect("customerRepresentativeHome.jsp");
					}
					else if(!role.equals("manager")){
						response.sendRedirect("home.jsp");	
					}
				}
				else {
					// redirect to log in if not alreaddy logged in
					response.sendRedirect("index.jsp");
				}

			%>
			
			<div class="row">
				<%--Employees--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">Manage Employee</h5>
    					<div class="container">
							<form action="addEmployee.jsp">
								<input type="submit" value="Add Employee" class="btn btn-primary"/>
							</form>
							<form action="getEmployees" class="pt-1">
								<input type="submit" value="View / Edit / Delete Employee" class="btn btn-primary"/>
							</form>
							
						</div>
					  </div>
					</div>
				</div>


					<div class="col-md-4" style="margin-bottom: 3%;">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Manage Users</h5>
								<div class="container">
									<form action="addCustomer.jsp">
										<input type="submit" value="Add Users" class="btn btn-primary"/>
									</form>
									<form action="modifyCustomers" class="pt-1">
										<input type="submit" value="View / Edit / Delete Users" class="btn btn-primary"/>
									</form>

								</div>
							</div>
						</div>
					</div>

				<%--Sales--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Sales Report</h5>
							<div class="container">
								<form action="searchSales">
									<input type="submit" value="Sales Report" class="btn btn-primary"/>
								</form>
							</div>
						</div>
					</div>
				</div>

				<%--All Users--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">View All Users</h5>
							<div class="container">
								<form action="getCustomers">
									<input type="submit" value="View All Users" class="btn btn-primary"/>
								</form>
							</div>
						</div>
					</div>
				</div>


				<%--Dates--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Dates</h5>
							<div class="container">
								<form action="searchDates.jsp">
									<input type="submit" value="View Dates" class="btn btn-primary"/>
								</form>
								<form action="calculateRevenueOfDates.jsp">
									<input type="submit" value="View Summary Listing of Revenue" class="btn btn-primary"/>
								</form>
							</div>
						</div>
					</div>
				</div>

				<%--Highest Revenue Gen--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">View Highest Revenue Generators</h5>
							<div class="container">
								<form action="showMaxRevenueByEmployee">
									<input type="submit" value="Customer Representative" class="btn btn-primary"/>
								</form>
								<form action="showMaxRevenueByCustomer" class="pt-1">
									<input type="submit" value="Customer" class="btn btn-primary"/>
								</form>

							</div>
						</div>
					</div>
				</div>


				<%--Active Users--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">View Most Active User</h5>
							<div class="container">
								<form action="showMostActiveCustomer">
									<input type="submit" value="View Most Active User" class="btn btn-primary"/>
								</form>
							</div>
						</div>
					</div>
				</div>


				<%--User dated a given user--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">View Dated Users</h5>
							<div class="container">
								<form action="searchDatedUsers.jsp">
									<input type="submit" value="View Dated Users" class="btn btn-primary"/>
								</form>
							</div>
						</div>
					</div>
				</div>


				<%--Higest Ratings--%>
				<div class="col-md-4" style="margin-bottom: 3%;">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">View Highest Rated</h5>
							<div class="container">
								<form action="getHighestRatedCustomer">
									<input type="submit" value="Customers" class="btn btn-primary"/>
								</form>
								<form action="getHighestRatedCalendar">
									<input type="submit" value="Calendar Dates" class="btn btn-primary"/>
								</form>
							</div>
						</div>
					</div>
				</div>

					<div class="col-md-4" style="margin-bottom: 3%;">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Backup</h5>
								<div class="container">
									<form action="backupDB.jsp">
										<input type="submit" value="Backup Database" class="btn btn-primary"/>
									</form>
								</div>
							</div>
						</div>
					</div>


			</div>
			
			
		</div>
		<div class="container" style="margin-bottom: 2em;">
			<form action="logout" style="width: 10%;display: table;margin: auto;">
				<input type="submit" value="Logout" class="btn btn-danger"/>
			</form>
		</div>
		
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.1.3/bootstrap.min.js"></script>
	</body>
</html>
