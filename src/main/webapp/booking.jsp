<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String infoMessage = request.getParameter("message");
		LocalDate today=LocalDate.now();
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
		<h3>Booking</h3>
		<form action="BookServlet" method="post">
			<input type="date" name="date" min="<%=today%>" max="2021-06-30"
				required autofocus> <br /> <br /> <input type="number"
				name="seats" placeholder="Enter no of seats" required> <br />
			<br />
			<button type="submit" class="btn btn-primary">Book Seats</button>
		</form>
	</main>
</body>
</html>