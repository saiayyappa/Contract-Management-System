<%@page import="com.cms.bean.ContractBean"%>
<%@page import="com.cms.bean.SupplierBean"%>
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
<title>Supplier</title>
<script>
	$(document).on(
			"click",
			".open-deleteContractDialog",
			function() {
				var contractId = $(this).data('1');
				var supplierId = $(this).data('2');
				var url = "deleteContract?contractId=" + contractId
						+ "&supplierId=" + supplierId;
				$(".modal-footer #deleteItem").attr("href", url);
			});
</script>
<style>
body {
	background-color: transparent;
}
</style>
</head>
<body class="p-5">
	<c:if test="${empty supplierBean}">
		<%
			response.sendRedirect("index.jsp");
		%>
	</c:if>
	<%
		SupplierBean supplierBean = (SupplierBean) session.getAttribute("supplierBean");
	%>

	<div class="container-fluid">
		<div class="row align-items-center" style="padding: 20px;">
			<div class="col-md-2"></div>
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
	<div align="center">
		<form:form method="POST"
			action="createContract.jsp?supplierId=${supplierBean.getSupplierId()}">
			<button type="submit" class="btn btn-outline-success ">Create
				Contract</button>
		</form:form>
	</div>
	<br>
	<br>

	<div align="center">
		<form:form
			action="viewContract?supplierId=${supplierBean.getSupplierId()}">
			<button type="submit" class="btn btn-outline-success">Contract
				List</button>
		</form:form>
	</div>
	<br>
	<br>
	<c:if test="${!empty contractList}">
		<table class="table table-hover table-bordered">
			<thead align="center" class="table-dark">
				<tr>
					<th>ID</th>
					<th>Description</th>
					<th>Submission Date</th>
					<th>Processing Date</th>
					<th>Terms</th>
					<th>Conditions</th>
					<th>Amenity</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${contractList}" var="contract">
					<tr>
						<td><c:out value="${contract.contractId}" /></td>
						<td><c:out value="${contract.contractDesc}" /></td>
						<td><c:out value="${contract.contractSubDate}" /></td>
						<td><c:out value="${contract.contractProDate}" /></td>
						<td><c:out value="${contract.term1}" /> <br /> <c:out
								value="${contract.term2}" /> <br /> <c:out
								value="${contract.term3}" /></td>
						<td><c:out value="${contract.condition1}" /> <br /> <c:out
								value="${contract.condition3}" /> <br /> <c:out
								value="${contract.condition2}" /></td>
						<td><c:out value="${contract.amenity1}" /></td>
						<td><c:out value="${contract.contractStatus}" /></td>
						<td>
							<button type="button" class="btn btn-outline-success btn-sm"
								onclick="window.location.href='fetchContract?contractId=${contract.contractId}&supplierId=${contract.supplierId}'">Edit</button>
							|| <a data-toggle="modal" data-1="${contract.contractId}"
							data-2="${contract.supplierId}" title="Delete this contract"
							class="open-deleteContractDialog btn btn-outline-danger"
							href="#deleteContractDialog">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<p class="h5" align="center">${addMessage}</p>
	<p class="h5" align="center">${editMessage}</p>
	<br>
	<br>
	<br>
	<h6 align="center">${recordMessage}</h6>

	<!-- Delete Modal -->
	<div class="modal hide" id="deleteContractDialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Delete Confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Do you want to delete the contract?</p>
				</div>
				<div class="modal-footer">
					<a id="deleteItem" href="" class="btn btn-outline-danger">Delete</a>
					<button type="button" class="btn btn-outline-dark"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

