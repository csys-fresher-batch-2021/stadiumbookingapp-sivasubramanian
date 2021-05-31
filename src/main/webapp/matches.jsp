<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.siva.service.MatchManager"%>
<%@page import="in.siva.model.MatchDetail"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		List<MatchDetail> matchList = MatchManager.getNextMatches();
		for (MatchDetail detail : matchList) {
		%>

		<div class="container">
			<div class="row">
				<div class="col-lg-6 mb-4">
					<div class="card" style="width: 20rem">
						<img class="card-img-top" src="images/<%=detail.getImage()%>"
							alt="Card image cap">
						<div class="card-block">
							<h4 class="card-title"><%=detail.getTeam1().toUpperCase()%>-<%=detail.getTeam2().toUpperCase()%></h4>
							<p class="card-text"><%=detail.getMatchDate()%><br /> <br /><%=detail.getStadiumName()%>
							</p>
							<a
								href="booking.jsp?date=<%=detail.getMatchDate()%>&up=<%=detail.getUpperSeatPrice() %>"
								class="btn btn-primary"> Book Now </a>
						</div>
					</div>

				</div>
			</div>
		</div>

		<%
		}
		%>

	</main>

</body>
</html>