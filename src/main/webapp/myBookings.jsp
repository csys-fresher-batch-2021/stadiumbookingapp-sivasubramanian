<%@page import="java.time.LocalDate"%>
<%@page import="in.siva.model.MyBookings"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>My bookings</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	Integer loggedInUserId = (Integer) session.getAttribute("LOGGED_IN_USER_ID");
	%>

	<main class="container-fluid">
		<br />
		<h3>My Bookings</h3>
		<br />
		<table class="table table-bordered table-hover table-dark">
			<caption>Matches</caption>

			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Stadium Name</th>
					<th scope="col">Match Date</th>
					<th scope="col">Team 1</th>
					<th scope="col">Team 2</th>
					<th scope="col">Seat Type</th>
					<th scope="col">Number of tickets</th>
					<th scope="col">Booking Date</th>
					<th scope="col">Total Amount</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody id="bookings">
			</tbody>
		</table>
		<a href="matches.jsp">Book Again</a>
		<script type="text/javascript">
function getMyBookings(){
	let url = "DisplayMyBookingsServlet?userId=<%=loggedInUserId%>";
	fetch(url).then(response=> response.json()).then(res=>{
		let myBookings = res;
		let details = "";
		let i=0;
		for(let booking of myBookings){
			console.log(booking);
			//var matchDate = moment(booking.matchDate).format('DD-MM-YYYY');
			//var bookingDate = moment(booking.bookingDate).format('DD-MM-YYYY');
			details +="<tr><td>"+(++i)+"</td><td>"+booking.stadiumName +"</td><td>"+booking.matchDate+" </td><td>"+booking.teamOne+
			"</td><td>"+booking.teamTwo +"</td><td>"+booking.seatType+"</td><td>"+booking.noOfTickets +"</td><td>"+booking.bookingDate+
			"</td><td>Rs."+booking.totalAmount+"</td>";
			if(booking.cancellable && booking.status.toLowerCase()=='booked'){
				let params = "bookingId="+booking.bookingId+"&tickets="+ booking.noOfTickets+"&matchId="+booking.matchId;
			details+="<td><span class='badge bg-success'>"+booking.status.toUpperCase()+"</span></td>"+
			"<td><a href='CancellBookingServlet?" + params +"' class='btn btn-danger'  >"+
					"Cancel"+"</a></td>";
			}
		else if(!booking.cancellable ||booking.status.toLowerCase()=='cancelled'){
			details+="<td><span class='badge bg-danger'>"+booking.status.toUpperCase()+"</span></td>"+
			"<td><button class='btn btn-danger' disabled>"+
					"Cancel"+"</button></td>";
			};
			
			details+="</tr>";
		}
		document.querySelector("#bookings").innerHTML= details;
	})
	
}
getMyBookings();

</script>
	</main>
</body>
</html>