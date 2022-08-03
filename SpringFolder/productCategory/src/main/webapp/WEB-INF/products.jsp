<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Formatting (dates) --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<!-- form:form -->
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- for rendering errors on PUT routes -->
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Product Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1><c:out value="${ products.name }"/></h1>
		<a class="link" href="/">Home</a>
		<div class="border"></div>
		
		<div>
			<h3>Categories:</h3>
			<ul>
				<c:forEach items="${ assignedCategories }" var="cat">
					<li><c:out value="${ cat.name }"/></li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="border"></div>
		
		<div>
			<h3>Add Category:</h3>
			<form action="/products/${ products.id }" method="post">
				<select class="form-select" name="categoryId" id="categoryId">
				<c:forEach items="${ unassignedCategories }" var="uncat">
					<option value="${ uncat.id }">${ uncat.name }</option>
				</c:forEach>
				</select>
				<input type="submit" class="btn btn-primary" value="Add" />
			</form>
		</div>
		
	</div>
</body>
</html>