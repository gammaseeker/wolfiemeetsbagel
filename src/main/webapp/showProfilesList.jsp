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
	<title>Profiles</title>
</head>
<body>
	<div>


	<h1>The Profile Details are:</h1>
	<c:if test="${empty profiles}">
		<h3> Profiles details not found! <h3/>
	</c:if>
	<c:if test="${not empty profiles}">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>Profile ID</th>
		      <th>Profile Name</th>
		      <th>Age</th>
		      <th>Address</th>
		      <th>Gender</th>
		      <th>Phy Char</th>
		      <th>Hobbies</th>
			  <th>Photo</th>
			  <th>Geo Range</th>
			  <th>Age Range</th>
			  <th>Refer to</th>
			  <th></th>
			  <th></th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${profiles}" var="cd">
		       <tr>
		         <td>${cd.profileID}</td>
		         <td>${cd.profileName}</td>
		         <td>${cd.age}</td>
		         <td>${cd.address}</td>
		         <td>${cd.gender}</td>
		         <td>${cd.phy_char}</td>
		         <td>${cd.interests}</td>
		         <td>${cd.photo}</td>
		         <td>${cd.geoRange}</td>
		         <td>${cd.ageRange}</td>
				   <td>
					   <form method="POST" action="referProfile">
						   <div class="form-group">
							   <input type="hidden" class="form-control" name="profileA" value=${profileID}>
							   <input type="hidden" class="form-control" name="profileB" value=${cd.profileID}>
						   </div>
						   <div class="form-group">
						   		<input type="text" class="form-control" name="profileC" id="profileC">
						   </div>
						   <br/>
						   <input type="submit" value="Refer" class="btn btn-success"/>
					   </form>
				   </td>
   		         <td>
		         	<form method="POST" action="makeDate">
						<div class="form-group">
							<input type="hidden" class="form-control" name="from" value=${profileID}>
							<input type="hidden" class="form-control" name="to" value=${cd.profileID}>
			        	</div>
						<input type="submit" value="Make a Date" class="btn btn-success"/>
					</form>
		         </td>		         
		         <td>
		         	<form method="POST" action="likeProfile">
						<div class="form-group">
							<input type="hidden" class="form-control" name="from" value=${profileID}>
							<input type="hidden" class="form-control" name="to" value=${cd.profileID}>
			        	</div>
						<input type="submit" value="Like" class="btn btn-success"/>
					</form>
		         </td>

		       </tr>
		     </c:forEach>
		  </tbody>
		</table>
	</c:if>
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
