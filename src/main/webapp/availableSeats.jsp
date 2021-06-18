<%@page import="java.time.LocalDate"%>
<%@page import="in.siva.service.MatchManager"%>
<%@page import="in.siva.service.AdminService"%>
<%@page import="in.siva.model.Seats"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Available Seats</title>
</head>
<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
%>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<nav class="navbar navbar-light bg-light">
			<form class="form-inline">
				<input type="date" class="form-control" name="date"
					value="<%=request.getParameter("date")%>"
					min="<%=LocalDate.now()%>" required autofocus>&nbsp;&nbsp;
				<select name="stadiumName" required>
					<option disabled selected>-------------------- select
						stadium --------------------</option>
					<option value="Eden Gardens,Kolkata">Eden Gardens,Kolkata</option>
					<option>M. A. Chidambaram Stadium,Chennai</option>
					<option>Wankhede Stadium,Mumbai</option>
					<option>M. Chinnaswamy Stadium,Bangalore</option>
					<option>Rajiv Gandhi International Cricket
						Stadium,Dehradun</option>
				</select>&nbsp;
				<button class="btn btn-secondary" type="submit">Search</button>
			</form>
		</nav>
		<h3>Available Seats</h3>
		<table class="table table-bordered">
			<caption>Availability</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col" class="bg-success">Available Seats</th>
					<th scope="col" class="bg-danger">Booked Seats</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (request.getParameter("date") != null && request.getParameter("stadiumName") != null) {
					List<Seats> seatList = MatchManager.getAvailableseats(request.getParameter("stadiumName"),
					request.getParameter("date"));
					if(seatList.isEmpty()){%>
				<tr class="bg-warning">
					<td colspan="2"><span>No matches</span></td>
				</tr>
				<%}
					for (Seats detail : seatList) {
				%>
				<tr class="table-dark">
					<td><span class="badge badge-success"><%=detail.getAvailableSeats()%></span></td>
					<td><span class="badge badge-danger"><%=detail.getBookedSeats()%></span></td>
				</tr>
				<%
				}
				}
				%>

			</tbody>
		</table>
		<%
				if (request.getParameter("date") != null && request.getParameter("stadiumName") != null) {
					List<Seats> seatList = MatchManager.getAvailableseats(request.getParameter("stadiumName"),
					request.getParameter("date"));
					for (Seats detail : seatList) {
				%>
		<div class="progress">
			<div class="progress-bar bg-danger" role="progressbar"
				style="width: <%=detail.getBookedPercentage() %>%"
				aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
				Booked
				<%=detail.getBookedPercentage() %>%
			</div>

			<div class="progress-bar bg-success" role="progressbar"
				style="width:<%=detail.getAvailablePercentage()%>%">
				Available
				<%=detail.getAvailablePercentage()%>%
			</div>

		</div>
		<%}}
		if (loggedInUsername != null) {
		%>
		<a href="matches.jsp">List Matches</a>
		<%
		}
		%>
	</main>
</body>
</html>