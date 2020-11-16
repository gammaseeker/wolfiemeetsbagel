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
		<title>Customer Home</title>
	</head>
	<body>
	
		<h1>Welcome to the Online Dating System!</h1>
		<label for="help">Help Topics</label>
		<select name="help" id="help">
			<option value="1">Topic 1</option>
			<option value="2">Topic 2</option>
			<option value="3">Topic 3</option>
			<option value="4">Topic 4</option>
		</select>
		<div class="container">
			<h2>Customer Options:</h2>
			<%
			String email = (String)session.getAttribute("email");
			String role = (String)session.getAttribute("role");
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
			out.print("Welcome "+email);

			%>

			<div class="row">
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">Dating Options</h5>
    					<div class="container">
							<form action="dateProfile">
								<input type="submit" value="Browse All Profiles" class="btn btn-success"/>
							</form>
							<br/>
							<form action="cancelDate">
								<input type="submit" value="Comment/Cancel Date" class="btn btn-success"/>
							</form>

						</div>
					  </div>
					</div>
				</div>

				<div class="col">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Profile Info</h5>
							<div class="container">
								<form action="pendingDates">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Pending Dates" class="btn btn-success"/>
								</form>
								<br/>
								<form action="pastDates">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Past Dates" class="btn btn-success"/>
								</form>
								<br/>
								<form action="favoritesList">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Favorites" class="btn btn-success"/>
								</form>
								<br/>
								<form action="searchBasedOn">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Search Based On" class="btn btn-success"/>
								</form>
								<br/>
								<form action="mostActiveProfiles">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Most Active Profiles" class="btn btn-success"/>
								</form>
								<br/>
								<form action="highlyRated">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Highly Rated Profiles" class="btn btn-success"/>
								</form>
								<br/>
								<form action="popularGeoLocation">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Popular Geo Locations" class="btn btn-success"/>
								</form>
								<br/>
								<form action="dateSuggestions">
									<div class="form-group">
										<input type="hidden" class="form-control" name="email" value=${email}>
									</div>
									<input type="submit" value="Suggested Dates" class="btn btn-success"/>
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
