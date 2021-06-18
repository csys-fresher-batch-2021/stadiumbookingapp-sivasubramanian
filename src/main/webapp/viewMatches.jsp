<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cancel Match</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Available Matches</h3>
		<input class="form-control" id="myInput" type="text"
			placeholder="Search.."> <br>
		<table class="table table-bordered table-striped ">
			<caption>Matches</caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Stadium Name</th>
					<th scope="col">Match Date</th>
					<th scope="col">Team 1</th>
					<th scope="col">Team 2</th>
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
function getAllMatches(){
	let url = "ViewMatchesServlet";
	fetch(url).then(response=> response.json()).then(res=>{
		let matches = res;
		let details = "";
		let i=0;
		for(let match of matches){
			details +="<tr><td>"+(++i)+"</td><td>"+match.stadiumName +"</td><td>"+match.matchDate+" </td><td>"+
			match.teamOne+"</td><td>"+match.teamTwo +"</td>";
			console.log(match);
			
				details+="<td><a href='#' class='btn btn-danger'>"+"Cancel"+"</a></td>";
				
				details+="</tr>";
		
		
		}
		document.querySelector("#match_table").innerHTML= details;
	})
	
}
getAllMatches();

</script>
	</main>
</body>
</html>