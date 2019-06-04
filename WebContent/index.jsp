<%@page import="com.cms.bean.SupplierBean"%>
<%@page import="com.cms.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CMS :: Home Page</title>
</head>
<style>
.bor {
	border: 1px red solid;
}

body, .bg {
	background-image: url("./image/inside1.jfif");
	background-color: #e0f2e9;
	background-repeat: no-repeat;
	background-size: cover;
}
iframe {
	background-image: url("./image/inside1.jfif");
	background-repeat: no-repeat;
	background-size: cover;
}

a, header {
	font-family: 'Fredericka the Great', cursive;
	font-weight: bold;
	color: black;
}
</style>
<body background="./contract.jpg">
	<header class="a container-fluid h2 text-center p-3">CONTRACT
		MANAGEMENT SYSTEM</header>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div style="max-width: 100%">
				<iframe style="border: none;" width="1280" height="726" class=""
					src="about.jsp" name="i"></iframe>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
</body>
</html>