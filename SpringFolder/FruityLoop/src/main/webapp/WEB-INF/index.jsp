<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fruity</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Hello Fruity Loop</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Fruit</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fruit" items="${fruits}">
					<tr>
						<td>${fruit.name}</td>
						<td>${fruit.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>