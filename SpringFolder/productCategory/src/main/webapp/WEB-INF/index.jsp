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
	<title>Home Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Home Page</h1>
		<a class="link" href="/products/new">New Product</a>
		<a class="link" href="/categories/new">New Category</a>
		<div class="border"></div>
		
		<div class="row align-items-start">
			<div class="col">
				<h3>Products</h3>
				<ul>
					<c:forEach items="${ products }" var="p">
    					<li><a href="/products/${ p.id }"><c:out value="${ p.name }"/></a></li>
    				</c:forEach>
				</ul>
			</div>
			<div class="col">
				<h3>Categories</h3>
				<ul>
					<c:forEach items="${ categories }" var="c">
    					<li><a href="/categories/${ c.id }"><c:out value="${ c.name }"/></a></li>
    				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>