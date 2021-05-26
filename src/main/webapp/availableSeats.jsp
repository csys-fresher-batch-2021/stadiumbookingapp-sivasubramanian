<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.siva.model.Seat"%>
<%@page import="in.siva.dto.MatchDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="in.siva.service.MatchManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Available Matches</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<nav class="navbar navbar-light bg-light">
			<form class="form-inline">
				<input type="date" class="form-control" onselect="fun()" name="date"
					value="<%=request.getParameter("date")%>">&nbsp;
				<button class="btn btn-secondary" type="submit">Search</button>
			</form>
		</nav>
		<h3>Available Matches</h3>
		<table class="table table-bordered">
			<caption>Matches</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Match Date</th>
					<th scope="col">Available Seats</th>
					<th scope="col">Booked Seats</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Seat> matchList = MatchManager.availability(request.getParameter("date"));
				int i = 0;
				for (Seat detail : matchList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=detail.getMatchDate()%></td>
					<td><%=detail.getAvailableSeats()%></td>
					<td><%=detail.getBookedSeats()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>