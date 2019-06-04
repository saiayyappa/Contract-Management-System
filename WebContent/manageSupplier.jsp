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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Supplier</title>
<style>
body {
	background-color: transparent;
}
</style>
</head>
<body class="p-5">
	<%
		AdminBean adminBean = (AdminBean) session.getAttribute("adminBean");
	%>
	<c:if test="${empty adminBean}">
		<%
			response.sendRedirect("index.jsp");
		%>
	</c:if>

	<div class="container-fluid">
		<div class="row align-items-center" style="padding: 20px;">
			<div class="col-md-2">
				<form:form action="admin.jsp">
					<button type="submit" class="btn btn-outline-success">Back</button>
				</form:form>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4"></div>
			<div class="col-md-3 text-center">
				Welcome Admin, <span class="text-uppercase font-weight-bold">${adminBean.firstName}</span>
				<i class="fa fa-user" aria-hidden="true"></i>
			</div>
			<div class="col-md-1 text-right">
				<a href="logout"><button type="submit"
						class="btn btn-outline-danger">Logout</button></a>
			</div>
		</div>
	</div>
	<div
		class="container row d-flex justify-content-start d-flex align-items-center">
		<div class="mr-3">Sort By</div>
		<div class="dropdown">
			<a class="btn btn-outline-primary dropdown-toggle" href="#"
				role="button" id="dropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Select </a>

			<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
				<a class="dropdown-item"
					href="fetchSupplier?supplierStatus=SUBMITTED">Submitted</a> <a
					class="dropdown-item" href="fetchSupplier?supplierStatus=APPROVED">Approved</a>
				<a class="dropdown-item"
					href="fetchSupplier?supplierStatus=REJECTED">Rejected</a> <a
					class="dropdown-item" href="fetchAllSuppliers">List All</a>
			</div>
		</div>
	</div>
	<br />
	<c:if test="${!empty supplierList}">
		<table class="table table-hover table-bordered">
			<thead align="center" class="thead-dark">
				<tr>
					<th>Supplier ID</th>
					<th>Supplier Name</th>
					<th>Supplier Status</th>
					<c:if test="${supplier.supplierStatus == 'SUBMITTED' }">
						<th>Action</th>
					</c:if>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${supplierList}" var="supplier">
					<tr>
						<td><c:out value="${supplier.supplierId}" /></td>
						<td><c:out value="${supplier.firstName}" /></td>
						<td><c:out value="${supplier.supplierStatus}" /> <c:if
								test="${supplier.supplierStatus == 'SUBMITTED' }">
								<br>
								<a
									href="updateSupplierStatus?supplierStatus=APPROVED&supplierId=${supplier.supplierId }">Approve</a>
									| <a
									href="updateSupplierStatus?supplierStatus=REJECTED&supplierId=${supplier.supplierId }">Reject</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<h6 align="center">${recordMessage }</h6>
</body>
</html>