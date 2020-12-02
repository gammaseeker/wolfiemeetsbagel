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
	<title>Highest Rated Calendar Date</title>
	<!-- Displays any dates where ratings are >= 3 from both parties -->
</head>
<body>
<div>
	<h1>The Dates based on Calendar Date <c:out value = "${date}"/> are:</h1>
	<c:if test="${empty dates}">
	<h3> Dates not found! <h3/>
		</c:if>
		<c:if test="${not empty dates}">
		<table class="table table-striped">
			<thead>
			<tr>
				<th>Date ID</th>
				<th>Date/Time</th>
				<th>User 1 Rating</th>
				<th>User 2 Rating</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${dates}" var="cd">
				<tr>
					<td>${cd.dateID}</td>
					<td>${cd.date}</td>
					<%-- Show over all rating (important)--%>
					<td>${cd.user1Rating}</td>
					<td>${cd.user2Rating}</td>
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
