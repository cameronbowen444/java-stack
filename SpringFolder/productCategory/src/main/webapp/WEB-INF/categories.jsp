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
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1><c:out value="${ category.name }"/></h1>
		<a class="link" href="/">Home</a>
		<div class="border"></div>
		
		<div>
			<h3>Categories:</h3>
			<ul>
				<c:forEach items="${ assignedProducts }" var="pro">
					<li><c:out value="${ pro.name }"/></li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="border"></div>
		
		<div>
			<h3>Add Category:</h3>
			<form action="/categories/${ category.id }" method="post">
				<select class="form-select" name="productId" id="productId">
				<c:forEach items="${ unassignedProducts }" var="unpro">
					<option value="${ unpro.id }">${ unpro.name }</option>
				</c:forEach>
				</select>
				<input type="submit" class="btn btn-primary" value="Add" />
			</form>
		</div>
		
	</div>
</body>
</body>
</html>