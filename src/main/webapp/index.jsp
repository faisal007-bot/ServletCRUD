<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Registeration Form</title>
		<link rel="stylesheet" href="style.css">
	</head>
	
	<body class="main">
		<div class="container">
			<h1 class="heading">Register Here!</h1>
			
			<form class="form" action="Insert" method="POST">
				<label class="label">Enter ID </label> 
				<input class="input" type="number" name="id" placeholder="Enter ID" /><br />
				 
				<label class="label">Enter Name </label> 
				<input class="input" type="text" name="name" placeholder="Enter Name" /><br /> 
				
				<label class="label">Enter City </label> 
				<input class="input" type="text" name="city" placeholder="Enter City" /><br /> 
				
				<input class="input" id="submit"type="submit" value="Register" /><br />
			</form>
		</div>
		
		<h3 class="linkheading">
			<a class="link" href="AllStudents">SEE ALL EMPLOYEES</a>
		</h3>
		
	</body>
</html>