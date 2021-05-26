<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Matches</title>
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
		<%
			if ("2021-05-21".equals(request.getParameter("date"))) {
			%>
		<div class="card" style="width: 18rem;">
			<img class="card-img-top" src="MI-vs-CSK.jpg" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">CSK vs MI</h5>
				<p class="card-text">M. A. Chidambaram Stadium</p>
				<a href="booking.jsp" class="btn btn-primary">Book now</a>
			</div>
		</div>
		<%
			}
			%>

		<%
			if ("2021-05-22".equals(request.getParameter("date"))) {
			%>
		<div class="card" style="width: 18rem;">
			<img class="card-img-top" src="RCB-vs-SRH.jpg" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">SRH vs RCB</h5>
				<p class="card-text">M. A. Chidambaram Stadium</p>
				<a href="booking.jsp" class="btn btn-primary">Book now</a>
			</div>
		</div>
		<%
			}
			%>
	</main>
</body>
<script>
	function fun() {
		var value=document.querySelector("#date").value
		document.querySelector("#date").value.innerHTML=value;
	}
</script>
</html>