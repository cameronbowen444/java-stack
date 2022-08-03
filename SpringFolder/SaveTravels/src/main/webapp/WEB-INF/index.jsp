<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Save Travels</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${expenses}" var="e">
				<tr>
					<td><c:out value="${ e.id }"/></td>
					<td><a href="/home/${e.id}"><c:out value="${ e.name }"/></a></td>
					<td><c:out value="${ e.vendor }"/></td>
					<td><c:out value="${ e.amount }"/></td>
					<td><a class="btn btn-primary" href="/edit/${e.id}">Edit</a>
					<form action="/delete/${e.id}" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input class="btn btn-primary" type="submit" value="Delete" />
					</form></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="add">
			<h1>Add an Expense:</h1>
			<form:form action="/home" method="post" modelAttribute="expense">
				<div class="mb-3">
					<form:label path="name" class="form-label">Expense</form:label>
					<form:errors path="name"/>
					<form:input type="text" path="name" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="vendor" class="form-label">Vendor</form:label>
					<form:errors path="vendor"/>
					<form:input type="text" path="vendor" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="amount" class="form-label">Amount</form:label>
					<form:errors path="amount"/>
					<form:input type="double" path="amount" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="description" class="form-label">Description</form:label>
					<form:errors path="description"/>
					<form:textarea type="text" path="description" class="form-control"></form:textarea>
				</div>
				<input type="submit" class="btn btn-primary" value="Create Expense" />
			</form:form>
		</div>
	</div>
	
</body>
</html>