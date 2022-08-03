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
	<title>New Product</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<a class="link" href="/">Home</a>
		<div class="border"></div>
		<form:form action="/product" method="post" modelAttribute="product">
  			<div class="mb-3">
  				<form:errors path="name" class="errors"/>
    			<form:label path="name" class="form-label">Name</form:label>
    			<form:input type="text" path="name" class="form-control"/>
     		</div>
  			<div class="mb-3">
  				<form:errors path="description" class="errors"/>
    			<form:label path="description" class="form-label">Description</form:label>
    			<form:textarea rows="3" path="description" class="form-control"></form:textarea>
     		</div>
     		<div class="mb-3">
  				<form:errors path="price" class="errors"/>
    			<form:label path="price" class="form-label">Price</form:label>
    			<form:input type="number" step="any" path="price" class="form-control"/>
     		</div>
  			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>