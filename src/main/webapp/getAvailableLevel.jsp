<%@page import="java.util.List"%>
<%@page import="in.siva.model.Level"%>
<%@page import="in.siva.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Status level</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
	String stadiumName=request.getParameter("stadiumName");
	List<Level> per1=AdminService.getPercentage(stadiumName);
	for (Level detail : per1) {
	%>
		<br />
		<h3>
			Match Date-<%=detail.getMatchDate()%></h3>
		<h4>
			Available (<%=detail.getAvailablePercentage() %>%)
		</h4>
		<div class="progress">
			<div class="progress-bar bg-success" role="progressbar"
				style="width: <%=detail.getAvailablePercentage() %>%"
				aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<h4>
			Booked (<%=detail.getBookedPercentage() %>%)
		</h4>
		<div class="progress">
			<div class="progress-bar bg-danger" role="progressbar"
				style="width: <%=detail.getBookedPercentage() %>%"
				aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<%
}
%>
	</main>
</body>
</html>