<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css?family=Cookie|Fredericka+the+Great|Julius+Sans+One|Lobster|Monoton|Pacifico|Roboto+Slab|Sacramento|Satisfy|Sniglet&display=swap"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Cabin+Condensed:700'
	rel='stylesheet' type='text/css'>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Login</title>
<style>
fieldset {
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	width: 500px;
}

form#innerPara {
	padding: 20px;
}

legend {
	width: 200px;
	padding: 10px 20px;
}

a, .welcome {
	font-family: 'Fredericka the Great', cursive;
	font-weight: 500;
	color: #000;
	background: -webkit-linear-gradient(#000, #000);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}

body {
	background-color: transparent;
}
</style>


</head>
<body class="p-5">

	<h1 class="welcome" align="center">Welcome!!!</h1>
	<br>
	<div align="center">
		<fieldset class="border">
			<legend class='text-center welcome'>Supplier Login</legend>
			<form:form id="innerPara" method="POST" action="loginSupplier">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">UserId</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="supplierId"
							placeholder="User Id" required>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password"
							placeholder="Password" required>
					</div>
				</div>
				<strong>${message}</strong>
				<strong>${successMessage}</strong>
				<br />
				<button type="submit" class="btn btn-outline-success">Login</button>
				<br>
				<br>

			</form:form>
			<h6>
				<a href="addSupplier.jsp">Don't have an account</a>
			</h6>
		</fieldset>
		<br />
		<h6>
			<a href="about.jsp">Back to Home</a>
		</h6>
		<br>
	</div>
</body>
</html>