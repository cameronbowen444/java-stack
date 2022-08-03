<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Edit Your Expense</h1>
		<form:form action="/edit/${expense.id}" method="post" modelAttribute="expense">
			<input type="hidden" name="_method" value="put" />
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
				<form:textarea type="text" path="description" rows="4" class="form-control"></form:textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="Update Expense" />
		</form:form>
	</div>
</body>
</html>