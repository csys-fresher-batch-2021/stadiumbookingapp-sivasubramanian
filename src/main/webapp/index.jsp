<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.siva.model.Match"%>
<%@page import="in.siva.dto.MatchDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="in.siva.service.MatchManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Available Matches</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>

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
					<th scope="col">Match Date</th>
				</tr>
			</thead>
			<tbody id="match_table">
				<%-- <%
				List<Match> matchList = MatchManager.getMatches();
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
				%> --%>
			</tbody>
		</table>
		<script>

function getAllTasks(){
	let url = "DisplayServlet";
	fetch(url).then(response=> response.json()).then(res=>{
		let matches = res;
		let details = "";
		let i=0;
		for(let match of matches){
			details +="<tr><td>"+(++i)+"</td><td>"+match.team1 +"</td><td>"+match.team2+" </td><td>"+match.matchDate+"</td><td><a href='login.jsp' class='btn btn-primary'>"+"Book"+"</a></td></tr>";
		}
		
		
		document.querySelector("#match_table").innerHTML= details;
		
	})
	
}
getAllTasks();
</script>
	</main>
</body>
</html>