<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.siva.model.Matches"%>
<%@page import="java.util.Set"%>
<%@page import="in.siva.service.MatchManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Matches</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Available Matches</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Team 1</th>
					<th>Team 2</th>
					<th>Match Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				Set<Matches> matchList = MatchManager.getAvailableMatches();
				int i = 0;
				for (Matches match : matchList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=match.getTeam1()%></td>
					<td><%=match.getTeam2()%></td>
					<td><%=match.getMatchDate()%></td>
					<td><a href="">Book</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>