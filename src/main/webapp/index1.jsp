<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Available Matches</h3>
		<input class="form-control" id="myInput" type="text"
			placeholder="Search.."> <br>
		<table class="table table-bordered">
			<caption>Matches</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Stadium Name</th>
					<th scope="col">Match Date</th>
					<th scope="col">Team 1</th>
					<th scope="col">Team 2</th>
					<th scope="col">Total seats</th>
					<th scope="col">Upper seat price</th>
					<th scope="col">Lower seat price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody id="match_table">
			</tbody>
		</table>
		<script type="text/javascript">
$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#match_table tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
function getAllTasks(){
	let url = "DisplayMatchServlet";
	fetch(url).then(response=> response.json()).then(res=>{
		let matches = res;
		let details = "";
		let i=0;
		for(let match of matches){
			details +="<tr><td>"+(++i)+"</td><td>"+match.stadiumName +"</td><td>"+match.matchDate+" </td><td>"+match.team1+
			"</td><td>"+match.team2 +"</td><td>"+match.totalSeats+"</td><td>Rs."+match.upperSeatPrice +"</td><td>Rs."+match.lowerSeatPrice +"</td><td><a href='login.jsp' class='btn btn-primary'>"+"Book"+"</a></td></tr>";
		}
		document.querySelector("#match_table").innerHTML= details;
	})
	
}
getAllTasks();

</script>
	</main>
</body>
</html>