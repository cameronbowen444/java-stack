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
	<title>Create A Book</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  		<div class="container-fluid">
    		<a class="navbar-brand">Welcome, <c:out value="${ user.userName }"/></a>
    		<form class="d-flex">
    			<a href="/dashboard" class="btn1 btn btn-outline-primary" type="submit">Home</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" type="submit">Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<h5>Add A Book To Your Shelf!</h5>
		<form:form action="/create" method="post" modelAttribute="book">
			<div class="mb-3">
				<form:errors path="title" class="errors" />
				<form:label for="title" class="form-label" path="title">Title</form:label>
				<form:input class="form-control" type="text" path="title" />
			</div>
			<div class="mb-3">
				<form:errors path="author" class="errors" />
				<form:label for="author" class="form-label" path="author">Author</form:label>
				<form:input class="form-control" type="text" path="author" />
			</div>
			<div class="mb-3">
				<form:errors path="thoughts" class="errors" />
				<form:label for="thoughts" class="form-label" path="thoughts">My Thoughts</form:label>
				<form:input class="form-control" type="text" path="thoughts" />
			</div>
			<div class="mb-3">
				<form:errors path="user" class="errors" />
				<form:input class="form-control" type="hidden" path="user" value="${ user.id }" />
			</div>
			<input type="submit" class="btn btn-primary" value="Add Book" />
		</form:form>
	</div>
</body>
</html>