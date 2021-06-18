<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.siva.service.MatchManager"%>
<%@page import="in.siva.model.MatchDetail"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Matches</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />
		<h2>Matches</h2>
		<%
		List<MatchDetail> matchList = MatchManager.getNextMatches();
		
		%>

		<div class="container">
			<div class="row">
				<%
		for (MatchDetail detail : matchList) {
			String matchDate =detail.getMatchDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		    String matchTime =detail.getMatchTime().format(DateTimeFormatter.ofPattern("HH:mm"));
		%>
				<div class="col-lg-6 mb-4">
					<div class="card" style="width: 20rem">
						<img class="card-img-top" src="images/<%=detail.getImage()%>"
							alt="Card image cap">
						<div class="card-block">
							<h4 class="card-title"><%=detail.getTeamOne().toUpperCase()%>-<%=detail.getTeamTwo().toUpperCase()%></h4>
							<p class="card-text"><%=matchDate%><br /><%=matchTime%><br /><%=detail.getStadiumName()%>
							</p>
							<a
								href="booking.jsp?id=<%=detail.getMatchId()%>&date=<%=detail.getMatchDate()%>&up=<%=detail.getUpperSeatPrice()%>
								&lp=<%=detail.getLowerSeatPrice()%>"
								class="btn btn-primary"> Book Now </a>
						</div>
					</div>

				</div>



				<%
		}
		%>
			</div>
		</div>

	</main>

</body>
</html>