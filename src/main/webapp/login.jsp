<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}

		if (loggedInUsername == null) {
		%>
		<h3>Login</h3>
		<form action="LoginServlet" method="post">
			<input type="text" name="username" placeholder="Enter user name"
				required autofocus> <br /> <br /> <input type="password"
				name="password" placeholder="Enter password"
				pattern="(?=.*\d)(?=.*[a-z])(?=.*[@#$%^&+=])(?=.*[A-Z]).{8,}"
				title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				required> <br /> <br />
			<button type="submit" class="btn btn-primary">Login</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
		<br /> <a href="register.jsp" class="btn btn-secondary">New
			Registration</a>
		<%
		} else {
		%><br /> <br />
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="alert alert-success">
					<strong>Welcome!</strong> Click here to <a href="matches.jsp"
						class="alert-link">Book Your Tickets</a>.
				</div>
			</div>
		</div>

		<%
		}
		%>
	</main>

</body>
</html>