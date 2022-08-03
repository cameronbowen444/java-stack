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
	<title>Update Book</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  		<div class="container-fluid">
    		<a class="navbar-brand">Welcome, <c:out value="${ user.name }" /></a>
    		<form class="d-flex">
      			<a href="/books" class="btn1 btn btn-outline-primary" type="submit">Home</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" type="submit">Logout</a>
   			</form>
  		</div>
	</nav>
	<div class="container">
		<h1>Update Your Book: ${book.title}</h1>
		<form:form action="/books/${book.id}/edit" method="put" modelAttribute="book">
			<form:input type="hidden" path="id" value="${ book.id }" />
			<div class="mb-3">
				<form:errors path="user" class="errors" />
				<form:input type="hidden" path="user" value="${ user.id }" />
			</div>
			<div class="mb-3">
				<form:errors path="title" class="errors" />
				<form:label class="form-label" path="title">Book Title</form:label>
				<form:input class="form-control" type="text" path="title" value="${ book.title }" />
			</div>
			<div class="mb-3">
				<form:errors path="author" class="errors" />
				<form:label class="form-label" path="author">Book Author</form:label>
				<form:input class="form-control" type="text" path="author" value="${ book.author }" />
			</div>
			<div class="mb-3">
				<form:errors path="myThoughts" class="errors" />
				<form:label class="form-label" path="myThoughts">My Thoughts</form:label>
				<form:textarea class="form-control" rows="3" path="myThoughts"></form:textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="Update Book" />
		</form:form>
	</div>
</body>
</html>