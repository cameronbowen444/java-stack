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
	<title>Dojos and Ninjas</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
	  	<div class="container-fluid">
	   		<a class="navbar-brand">Dojos and Ninjas</a>
	    	<form class="d-flex">
	      		<a href="/dojos" class="btn btn-outline-primary" type="submit">Home</a>
	    	</form>
	  	</div>
	</nav>
	<div class="container">
		<div class="row justify-content-center">
			<h1>Dojo: <c:out value="${ dojo.location }"/></h1>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Age</th>
						<th scope="col">Created</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ dojo.ninjas }" var="n">
					<tr>
						<th scope="row"><c:out value="${ n.id }"/></th>
						<td><c:out value="${ n.firstName }"/></td>
						<td><c:out value="${ n.lastName }"/></td>
						<td><c:out value="${ n.age }"/></td>
						<td><fmt:formatDate value="${ n.createdAt }" pattern="YYYY-MM-dd" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>