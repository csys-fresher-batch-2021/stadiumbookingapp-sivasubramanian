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
		<h3>Login</h3>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<form action="LoginServlet" method="post">
			<input type="text" name="username" placeholder="Enter user name"
				required autofocus> <br /> <br /> <input type="password"
				name="password" placeholder="Enter password"
				pattern="(?=.*\d)(?=.*[a-z])(?=.*[@#$%^&+=])(?=.*[A-Z]).{8,}"
				title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				required> <br /> <br />
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br />
		<a href="register.jsp" class="btn btn-secondary">New Registration</a>
	</main>
</body>
</html>