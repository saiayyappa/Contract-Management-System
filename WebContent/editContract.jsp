<%@page import="com.cms.bean.SupplierBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Contract</title>
<style>
body {
	background-color: transparent;
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
	<%
		SupplierBean supplierBean = (SupplierBean) session.getAttribute("supplierBean");
	%>
	<c:if test="${empty supplierBean}">
		<%
			response.sendRedirect("index.jsp");
		%>
	</c:if>
	<div class="container-fluid">
		<div class="row align-items-center" style="padding: 20px;">
			<div class="col-md-2">
				<form:form action="supplier.jsp">
					<button type="submit" class="btn btn-outline-success">Back</button>
				</form:form>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4"></div>
			<div class="col-md-3 text-center">
				Welcome Supplier, <span class="text-uppercase font-weight-bold">${supplierBean.getFirstName()}</span>
				<i class="fa fa-user" aria-hidden="true"></i>
			</div>
			<div class="col-md-1 text-right">
				<a href="logout"><button type="submit"
						class="btn btn-outline-danger">Logout</button></a>
			</div>
		</div>
	</div>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		Calendar cal = Calendar.getInstance();
		String currentDate = sdf.format(cal.getTime());
		//Adding 7 Day to the current date
		cal.add(Calendar.DAY_OF_MONTH, 7);
		//Date after adding one day to the current date
		String newDate = sdf.format(cal.getTime());
	%>
	<br />
	<form:form method="GET" action="updateContract">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Contract Id</label>
			<div class="col-sm-4">
				<input class="form-control" name="contractId" type="number"
					value="${contractBean.contractId}" readonly>
			</div>
		</div>
		<div class="form-group row">

			<label class="col-sm-2 col-form-label">Contract Description </label>
			<div class="col-sm-4">
				<textarea rows="4" cols="50" class="form-control"
					name="contractDesc" minlength="4" maxlength="15" tabindex="1"
					autofocus required>${contractBean.contractDesc}</textarea>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Contract Submission
				Date </label>
			<div class="col-sm-4">
				<input class="form-control" name="contractSubDate" type="text"
					value="<%=currentDate%>" readonly>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Contract Processing
				Date </label>
			<div class="col-sm-4">
				<input class="form-control" name="contractProDate" type="text"
					value="<%=newDate%>" readonly>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-4">
				<input type="hidden" class="form-control" name="contractStatus"
					value="SUBMITTED">
			</div>
		</div>
		<div class="form-group row">

			<label class="col-sm-2 col-form-label">Term 1 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="term1" value="SAFETY"
					readonly>

			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Condition 1 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="condition1"
					value="${contractBean.condition1}" maxlength="45" tabindex="2">

			</div>
		</div>
		<div class="form-group row">

			<label class="col-sm-2 col-form-label">Term 2 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="term2"
					value="MAINTENANCE" readonly>
			</div>
		</div>
		<div class="form-group row">

			<label class="col-sm-2 col-form-label">Condition 2 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="condition2"
					value="${contractBean.condition2}" maxlength="45" tabindex="3">
			</div>
		</div>
		<div class="form-group row">

			<label class="col-sm-2 col-form-label">Term 3 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="term3"
					value="TIMELINE" readonly>
			</div>
		</div>
		<div class="form-group row">

			<label class="col-sm-2 col-form-label">Condition 3 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="condition3"
					value="${contractBean.condition3}" maxlength="45" tabindex="4">
			</div>
		</div>
		<div class="form-group row">

			<label class="col-sm-2 col-form-label">Amenity </label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="amenity1"
					value="${contractBean.amenity1}" maxlength="45" tabindex="5">
			</div>
		</div>
		<div class="form-group row">
			<!-- 

			<label class="col-sm-2 col-form-label">Supplier Id </label> -->
			<div class="col-sm-4">
				<input class="form-control" name="supplierId" type="hidden"
					value="${supplierBean.getSupplierId()}" readonly>
			</div>
		</div>
		<div align="center">
			<button type="submit" class="btn btn-outline-success" tabindex="6">Update</button>
			<button type="reset" class="btn btn-outline-secondary" tabindex="7">Reset</button>
		</div>

	</form:form>
</body>
</html>