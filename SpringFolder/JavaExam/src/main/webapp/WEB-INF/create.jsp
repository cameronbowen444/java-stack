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
	<title>Create Show</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  		<div class="container-fluid">
    		<a class="navbar-brand">Welcome, <c:out value="${ user.name }"/></a>
    		<form class="d-flex">
      			<a href="/shows" class="btn1 btn btn-outline-primary" >Home</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" >Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<h1>Create Show</h1>
		<form:form action="/shows/new" method="post" modelAttribute="show">
			<div class="mb-3">
				<form:errors path="user" class="errors" />
				<form:input type="hidden" path="user" value="${ user.id }" />
			</div>
			<div class="mb-3">
				<form:errors path="title" class="errors" />
				<form:label class="form-label" path="title">Show Title</form:label>
				<form:input class="form-control" type="text" path="title" />
			</div>
			<div class="mb-3">
				<form:errors path="network" class="errors" />
				<form:label class="form-label" path="network">Show Network</form:label>
				<form:input class="form-control" type="text" path="network" />
			</div>
			<div class="mb-3">
				<form:errors path="description" class="errors" />
				<form:label class="form-label" path="description">Description</form:label>
				<form:textarea class="form-control" rows="3" path="description"></form:textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="Add Show" />
		</form:form>
	</div>
</body>
</html>