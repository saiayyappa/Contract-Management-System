<%@page import="com.cms.StateDropDown"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="com.cms.bean.SupplierBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Registration</title>
<style>
body {
	background-color: transparent;
}

.welcome {
	font-family: 'Fredericka the Great', cursive;
	font-weight: 500;
	color: black;
}

body::-webkit-scrollbar {
	width: 0.5em;
}

body::-webkit-scrollbar-track {
	
}

body::-webkit-scrollbar-thumb {
	background-color: #FFF;
	background-image: -webkit-linear-gradient(top, #f5aa69 0%, #ffe6d1 25%, #fff 100%);
}
</style>
</head>
<body class="p-5">
	<p class="h2 text-center welcome">Supplier Registration</p>
	<div class="container-fluid">
		<div class="row align-items-center" style="padding: 20px;">
			<div class="col-md-2">
				<form:form action="supplierLogin.jsp">
					<button type="submit" class="btn btn-outline-success">Back</button>
				</form:form>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4"></div>
			<div class="col-md-1"></div>
			<div class="col-md-2 text-center"></div>
			<div class="col-md-1 text-right"></div>
		</div>
	</div>
	<div align="center">
		<p>Please fill the Below Details...</p>
	</div>
	<form:form method="POST" action="addSupplier" class="form-horizontal">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">First Name* </label>
			<div class="col-sm-4">
				<input class="form-control" name="firstName" type="text"
					pattern="[A-Za-z]{3,15}" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Last Name* </label>
			<div class="col-sm-4">
				<input class="form-control" name="lastName" type="text"
					pattern="[A-Za-z]{3,15}" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Age* </label>
			<div class="col-sm-4">
				<input class="form-control" name="age" type="number" min="18"
					max="55" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Gender* </label>
			<div class="col-sm-4">
				<input type="radio" name="gender" value="male" checked>Male
				&nbsp; <input type="radio" name="gender" value="female">Female
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">DOB* </label>
			<div class="col-sm-4">
				<input class="form-control" name="dob" type="date" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Contact Number* </label>
			<div class="col-sm-4">
				<input class="form-control" name="contactNumber" type="tel"
					pattern="[0-9]{10}" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Alternate Contact
				Number </label>
			<div class="col-sm-4">
				<input class="form-control" name="altContactNumber" type="text"
					pattern="[0-9]{10}">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Email Id* </label>
			<div class="col-sm-4">
				<input class="form-control" name="emailId" type="email" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Password* </label>
			<div class="col-sm-4">
				<input class="form-control" name="password" type="password"
					pattern=".{3,}" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">AddressLine 1* </label>
			<div class="col-sm-4">
				<input class="form-control" name="addressLine1" type="text"
					pattern=".{4,20}" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">AddressLine 2 </label>
			<div class="col-sm-4">
				<input class="form-control" name="addressLine2" type="text"
					pattern=".{4,20}">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">City* </label>
			<div class="col-sm-4">
				<input class="form-control" name="city" type="text"
					pattern=".{4,15}" required>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">State* </label>
			<div class="col-sm-4">
				<select class="form-control" name="state" required>
					<option value="">Select State</option>
					<%
						String data = "";
							data = new String(Files.readAllBytes(Paths.get("D:\\ws_new\\ContractMgmt\\src\\state.txt")));
							List<String> list = new ArrayList<String>(Arrays.asList(data.split(",")));

							for (String state : list) {
					%>
					<option value="<%=state%>"><%=state%></option>
					<%
						}
					%>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Zip Code*</label>
			<div class="col-sm-4">
				<input class="form-control" name="zipCode" type="text"
					pattern="[0-9]{6}" required>
			</div>
		</div>
		<div class="form-group row">
			<!-- <label class="col-sm-2 col-form-label">Status</label> -->
			<div class="col-sm-4">
				<input class="form-control" name="supplierStatus" type="hidden"
					value="SUBMITTED">
			</div>
		</div>
		<p style="color: red;">* mandatory fields</p>
		<div align="center">
			<button type="submit" class="btn btn-outline-success">Submit</button>
			<button type="reset" class="btn btn-outline-secondary">Reset</button>
		</div>
	</form:form>
</body>
</html>