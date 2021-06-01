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
		<div class="booking-form">
			<div class="form-header">
				<h1>Book your Seats</h1>
			</div>
		</div>
		<%
		
		String errorMessage = request.getParameter("errorMessage");
		String infoMessage = request.getParameter("infoMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		
		String matchId = request.getParameter("id");
		%>
		<form action="BookingServlet?matchId=<%=matchId%>" method="post">
			<label for="matchDate">Match Date</label><br /> <input type="date"
				name="matchDate" value="<%=request.getParameter("date")%>"><br />
			<br /> <label for="type">Seat Type</label><br /> <select id="type"
				name="type" onchange="calculateTotal()">
				<option disabled selected>--select seat type--</option>
				<option value="upper">Upper</option>
				<option value="lower">Lower</option>
			</select><br /> <br /> <label for="noOfTickets">Number of tickets</label><br />
			<input type="number" min="1" placeholder="Enter Number of tickets"
				id="no" name="noOfTickets" onchange="calculateTotal()" required><br />
			<br /> <label for="total">Amount(Rs)</label><br /> <input
				type="number" id="total" name="amount" value=0 readonly><br />
			<br />
			<button type="submit" class="btn btn-primary">Book</button>

		</form>
	</main>
	<script type="text/javascript">
		function calculateTotal() {
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);
			const UpperPrice = urlParams.get('up');
			const LowerPrice = urlParams.get('lp');
			var type = document.querySelector("#type").value;
			var numberOfSeats = document.querySelector("#no").value;
			if (type == 'upper' && numberOfSeats > 0) {
				var price = UpperPrice * numberOfSeats;
			}
			if (type == 'lower' && numberOfSeats > 0) {
				var price = LowerPrice * numberOfSeats;
			}
			document.querySelector("#total").value = price;
		}
	</script>

</body>
</html>