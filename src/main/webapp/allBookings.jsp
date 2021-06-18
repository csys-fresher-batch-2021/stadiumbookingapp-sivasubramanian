<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Bookings</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />
		<h3>All Bookings</h3>
		<br />
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Count Down
							starts</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p id="ti"></p>
						<p id="t"></p>
						<p id="ti"></p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<table class="table table-bordered table-hover table-dark">
			<caption>Matches</caption>

			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Booking Id</th>
					<th scope="col">User Name</th>
					<th scope="col">Match Id</th>
					<th scope="col">Stadium Name</th>
					<th scope="col">Match Date</th>
					<th scope="col">Team 1</th>
					<th scope="col">Team 2</th>
					<th scope="col">Seat Type</th>
					<th scope="col">Number of tickets</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody id="bookings">
			</tbody>
		</table>

		<script type="text/javascript">
		
		function openModel(time){
			document.querySelector("#ti").innerHTML=time;
		}
		
function getAllBookings(){
	let url = "AllBookingsServlet";
	fetch(url).then(response=> response.json()).then(res=>{
		let allBookings = res;
		console.log(allBookings);
		let details = "";
		let i=0;
		for(let booking of allBookings){
			var matchTime = moment(booking.matchTime).format('HH:mm');
			details +="<tr><td>"+(++i)+"</td><td>"+booking.bookingId +"</td><td>"+booking.username+
			" </td><td><button type='button'class='btn btn-primary' data-toggle='modal' onclick=openModel('"+matchTime+"') data-target='#exampleModal'>"
			+booking.matchId+"</a></td><td><a href='getAvailableLevel.jsp?stadiumName="+booking.stadiumName+"'>"+booking.stadiumName+
			"</a></td><td>"+booking.matchDate +"</td><td>"+booking.teamOne +"</td><td>"+booking.teamTwo+"</td>";
			if(booking.seatType.toLowerCase()=='upper'){
				details+="<td><span class='badge bg-warning'>"+booking.seatType.toUpperCase()+"</span></td>";
				}
				  else{
				details+="<td><span class='badge bg-info'>"+booking.seatType.toUpperCase()+"</span></td>";
				};  
			
			details+="</td><td>"+booking.noOfTickets+"</td>";
			  if(booking.status.toLowerCase()=='booked'){
			details+="<td><span class='badge bg-success'>"+booking.status.toUpperCase()+"</span></td>";
			}
			  else{
			details+="<td><span class='badge bg-danger'>"+booking.status.toUpperCase()+"</span></td>";
			}; 
			details+="</tr>";
			
			
			
		}
		
		document.querySelector("#bookings").innerHTML= details;
	})
	
}

getAllBookings();

</script>
	</main>
</body>
</html>