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
	<title>All Shows</title>
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
      			<a href="/shows/new" class="btn1 btn btn-outline-primary" >+ New Show</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" >Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<h3>All Projects</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">TV Show</th>
      				<th scope="col">Network</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allShows}" var="show">
				<tr>
					<th scope="row"><a href="/show/${show.id}">${show.title}</a></th>
      				<td><c:out value="${ show.network }" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>