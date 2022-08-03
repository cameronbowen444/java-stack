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
	<title>Books</title>
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
      			<a href="/books/new" class="btn1 btn btn-outline-primary" type="submit">+ Add Book</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" type="submit">Logout</a>
   			</form>
  		</div>
	</nav>
	<div class="container">
		<h3>Books From everyone's Shelves:</h3>
		<table class="table table-hover">
  			<thead>
    			<tr>
			      	<th scope="col">#</th>
			      	<th scope="col">Author</th>
			      	<th scope="col">Posted By</th>
    			</tr>
  			</thead>
  			<tbody>
  			<c:forEach items="${ allBooks }" var="b">
  				<tr>
      				<th scope="row"><c:out value="${ b.id }"/></th>
      				<td><a href="/books/${b.id}"><c:out value="${ b.title }"/></a></td>
      				<td><c:out value="${ b.user.name }"/></td>
    			</tr>
  			</c:forEach>	
  			</tbody>
		</table>
	</div>
</body>
</html>