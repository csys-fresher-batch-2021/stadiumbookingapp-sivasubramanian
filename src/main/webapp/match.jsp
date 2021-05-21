<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.siva.model.Match"%>
<%@page import="java.util.Set"%>
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
		<h3>Available Matches</h3>
		<table class="table table-bordered">
			<caption>Matches</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Team 1</th>
					<th scope="col">Team 2</th>
					<th scope="col">Match Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				Set<Match> matchList = MatchManager.getAvailableMatches();
				int i = 0;
				for (Match match : matchList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=match.getTeam1()%></td>
					<td><%=match.getTeam2()%></td>
					<td><%=match.getMatchDate()%></td>
					<td><a href="login.jsp" class="btn btn-primary">Book</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>