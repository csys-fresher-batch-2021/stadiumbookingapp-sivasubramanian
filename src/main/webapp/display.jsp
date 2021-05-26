<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>matches</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body>
	<h2>List Tasks</h2>

	<table>
		<caption>Matches</caption>
		<thead>
			<tr>
				<th scope="col">S.No</th>
				<th scope="col">Team1</th>
				<th scope="col">Team2</th>
				<th scope="col">Match Date</th>
			</tr>
		</thead>
		<tbody id="task-tbl">

		</tbody>
	</table>
	<script>

function getAllTasks(){
	console.log("Fetching all tasks ");
	let url = "DisplayServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		let tasks = res;
		console.log("Got response from servlet");
		console.log(tasks);
		let content = "";
		let i=0;
		for(let task of tasks){
			content +="<tr><td>"+(++i)+"</td><td>"+task.team1 +"</td><td>"+task.team2+" </td><td>"+task.matchDate+"</td></tr>";
		}
		console.log(content);
		
		document.querySelector("#task-tbl").innerHTML= content;
		
	})
	
}

getAllTasks();
</script>
</body>
</html>