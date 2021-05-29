<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add matches</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Matches Details</h3>
		<form action="AddMatchServlet" method="post">
			<%
			String errorMessage = request.getParameter("errorMessage");
			String infoMessage = request.getParameter("infoMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			if (infoMessage != null) {
				out.println("<font color='green'>" + infoMessage + "</font>");
			}
			%>
			<br /> <select class="selectpicker" name="stadiumName">
				<option disabled selected>-------------------- select
					stadium --------------------</option>
				<option>Eden Gardens,Kolkata</option>
				<option>M. A. Chidambaram Stadium,Chennai</option>
				<option>Wankhede Stadium,Mumbai</option>
				<option>M. Chinnaswamy Stadium,Bangalore</option>
				<option>Rajiv Gandhi International Cricket Stadium,Dehradun</option>
			</select> <br /> <br /> <label for="dateTime">Set Date and time</label> <br />
			<input type="date" id="datetime" name="dateTime" required> <br />
			<br /> <input type="text" name="team1" placeholder="Enter team1"
				required> <br /> <br /> <input type="text" name="team2"
				placeholder="Enter team2" required> <br /> <br /> <input
				type="number" name="totalSeats" placeholder="Enter total seats"
				id="totalSeats" onchange="setAvailableSeats()" required> <br />
			<br /> <input type="number" name="availableSeats"
				id="availableSeats" placeholder="Enter available seats" required
				readonly> <br /> <br /> <input type="number"
				name="upperSeatPrice" placeholder="Enter upper seat price" required>
			<br /> <br /> <input type="number" name="lowerSeatPrice"
				placeholder="Enter lower seat price" required> <br /> <br />
			<input type="text" name="image" placeholder="Enter image url"
				required> <br /> <br />
			<button type="submit" class="btn btn-primary">Submit</button>
			&nbsp;
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
	<script type="text/javascript">
		function setAvailableSeats() {
			var total = document.querySelector("#totalSeats").value
			document.querySelector("#availableSeats").value = total;
		}
	</script>
</body>
</html>