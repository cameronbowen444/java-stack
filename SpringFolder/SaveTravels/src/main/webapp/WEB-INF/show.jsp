<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Your Expense</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Expense Details</h1>
		<h3>Expense Name: <c:out value="${expense.name}"/></h3>
		<h3>Expense Description: <c:out value="${expense.description}"/></h3>
		<h3>Vendor: <c:out value="${expense.vendor}"/></h3>
		<h3>Amount Spent: <c:out value="${expense.amount}"/></h3>
		<a class="btn btn-primary" href="/home">Home</a>
	</div>
</body>
</html>